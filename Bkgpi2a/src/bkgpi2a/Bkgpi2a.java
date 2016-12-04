package bkgpi2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import utils.ApplicationProperties;
import utils.DBManager;
import utils.DBServer;
import utils.DBServerException;

/**
 * Bkgpi2a, Programme Java permettant de synchroniser les collections d'une base
 * de données MongoDB par rapport à une base de données Informix
 *
 * @author Thierry Baribaud.
 * @version 0.37
 */
public class Bkgpi2a {

    /**
     * Classe interne pour stocker les résultats d'une requête SQL
     */
    private static class SqlResults {

        private static int nbTrials = 0;
        private static int errno = 0;
        private static int isam = 0;
        private static String errmsg = null;
        private static int retcode = 0;

        /**
         * Constructeur principal de la classe SqlResults
         *
         * @param resultSet les résultats d'exécution d'une requête
         */
        public SqlResults(ResultSet resultSet) {

            try {
                errno = resultSet.getInt(3);
                retcode = (errno == -243) ? -2 : resultSet.getInt(1);
                nbTrials = resultSet.getInt(2);
                isam = resultSet.getInt(4);
                errmsg = resultSet.getString(5);
            } catch (SQLException exception) {
//                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR : erreur dans la récupération des résultats de la requête SQL " + exception);
            }
        }

        /**
         * Ajoute les résultats d'exécution d'une requête à des résultats
         * existants
         *
         * @param resultSet les résultats d'exécution d'une requête
         */
        public void add(ResultSet resultSet) {
            try {
                errno = resultSet.getInt(3);
                retcode = (errno == -243) ? -2 : resultSet.getInt(1);
                nbTrials += resultSet.getInt(2);
                isam = resultSet.getInt(4);
                errmsg = resultSet.getString(5);
            } catch (SQLException exception) {
//                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ERROR : erreur dans la récupération des résultats de la requête SQL " + exception);
            }

        }

        /**
         * Retourne le code d'erreur associé à l'exécution d'une requête SQL
         *
         * @return retourne le code d'erreur associé à l'exécution d'une requête
         * SQL
         */
        public int getRetcode() {
            return retcode;
        }

        /**
         * Retourne le nombre d'essais injectés
         *
         * @return retourne le nombre d'essais injectés
         */
        public int getNbTrials() {
            return nbTrials;
        }
    }

    /**
     * Pour convertir les datetimes du format texte au format DateTime
     */
    private static final DateTimeFormatter isoDateTimeFormat = ISODateTimeFormat.dateTimeParser();
//    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    private static final DateTimeFormatter hhmmFormat = DateTimeFormat.forPattern("HH:mm");

    /**
     * Référence de l'utilisateur Extranet
     */
    private static final int onum = 805;

    /**
     * mongoDbServerType : prod pour le serveur de production, pre-prod pour le
     * serveur de pré-production. Valeur par défaut : pre-prod.
     */
    private String mongoDbServerType = "pre-prod";

    /**
     * informixDbServerType : prod pour le serveur de production, pre-prod pour
     * le serveur de pré-production. Valeur par défaut : pre-prod.
     */
    private String informixDbServerType = "pre-prod";

    /**
     * mongoDbId : identifiants pour se connecter au serveur MongoDb courant.
     * Pas de valeur par défaut, ils doivent Ãªtre fournis dans le fichier
     * MyDatabases.prop.
     */
    private Identifiants mongoDbId;

    /**
     * informixDbId : identifiants pour se connecter au serveur Informix
     * courant. Pas de valeur par défaut, ils doivent Ãªtre fournis dans le
     * fichier MyDatabases.prop.
     */
    private Identifiants informixDbId;

    /**
     * debugMode : fonctionnement du programme en mode debug (true/false).
     * Valeur par défaut : false.
     */
    private static boolean debugMode = false;

    /**
     * testMode : fonctionnement du programme en mode test (true/false). Valeur
     * par défaut : false.
     */
    private static boolean testMode = false;

    /**
     * Constructeur de la classe SyncCollections
     * <p>
     * Les arguments en ligne de commande permettent de changer le mode de
     * fonctionnement.</p><ul>
     * <li>-mgodb mongodb : référence à la base de données MongoDB, par défaut
     * désigne la base de données de développement. Voir fichier
     * myDatabases.prop (optionnel).</li>
     * <li>-ifxdb informixdb : référence à la base de données Informix, par
     * défaut désigne la base de données de développement. Voir fichier
     * myDatabases.prop (optionnel).</li>
     * <li>-d : le programme fonctionne en mode débug le rendant plus verbeux,
     * désactivé par défaut (optionnel).</li>
     * <li>-t : le programme fonctionne en mode de test, les transactions en
     * base de données ne sont pas exécutées, désactivé par défaut
     * (optionnel).</li>
     * </ul>
     *
     * @param args arguments de la ligne de commande.
     * @throws java.io.IOException en cas d'erreur d'entrée/sortie.
     * @throws utils.DBServerException en cas d'erreur avec le serveur de base
     * de données.
     * @throws GetArgsException en cas d'erreur avec les paramètres en ligne de
     * commande
     */
    public Bkgpi2a(String[] args) throws IOException,
            DBServerException, GetArgsException, Exception {
        ApplicationProperties applicationProperties;
        DBServer mongoServer;
        DBServer informixServer;
        GetArgs getArgs;
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        DBManager informixDbManager;
        Connection informixConnection;

        System.out.println("Création d'une instance de Bkgpi2a ...");

        System.out.println("Analyse des arguments de la ligne de commande ...");
        getArgs = new GetArgs(args);
        setMongoDbServerType(getArgs.getMongoDbServerType());
        setInformixDbServerType(getArgs.getInformixDbServerType());
        setDebugMode(getArgs.getDebugMode());
        setTestMode(getArgs.getTestMode());

        System.out.println("Lecture des paramètres d'exécution ...");
        applicationProperties = new ApplicationProperties("Bkgpi2a.prop");

        System.out.println("Lecture des paramètres du serveur MongoDb ...");
        mongoServer = new DBServer(getMongoDbServerType(), "mgodb", applicationProperties);
        if (debugMode) {
            System.out.println(mongoServer);
        }
//        setMongoDbId(applicationProperties);
//        System.out.println(getMongoDbId());

        System.out.println("Lecture des paramètres du serveur Informix ...");
        informixServer = new DBServer(getInformixDbServerType(), "ifxdb", applicationProperties);
        if (debugMode) {
            System.out.println(informixServer);
        }
//        setInformixDbId(applicationProperties);
//        System.out.println(getInformixDbId());

        System.out.println("Ouverture de la connexion au serveur MongoDb : " + mongoServer.getName());
        mongoClient = new MongoClient(mongoServer.getIpAddress(), (int) mongoServer.getPortNumber());

        System.out.println("Connexion à la base de données : " + mongoServer.getDbName());
        mongoDatabase = mongoClient.getDatabase(mongoServer.getDbName());

        System.out.println("Ouverture de la connexion au serveur Informix : " + informixServer.getName());
        informixDbManager = new DBManager(informixServer);

        System.out.println("Connexion à la base de données : " + informixServer.getDbName());
        informixConnection = informixDbManager.getConnection();

        System.out.println("Synchronisation des événements ...");
        syncEvents(mongoDatabase, informixConnection);
    }

    /**
     * Méthode pour synchroniser les événements par rapport à la base de données
     * Informix.
     */
    private void syncEvents(MongoDatabase mongoDatabase, Connection informixConnection) {
        MongoCollection<Document> collection;
        MongoCursor<Document> cursor;
        ObjectMapper objectMapper;
        Event event;
        int nbEvent;
        BasicDBObject filter1;
        BasicDBObject filter2;
        BasicDBObject orderBy;
        UpdateResult updateResult;
        int retcode = 0;
        int nbError = 0;
        int status = 0;

        objectMapper = new ObjectMapper();

        collection = mongoDatabase.getCollection("events");
        System.out.println(collection.count() + " événément(s) dans la base MongoDb");

        nbEvent = 0;
        try {
            filter1 = new BasicDBObject("status", 0);
            orderBy = new BasicDBObject("aggregateUid", 1).append("sentDate", 1);
            cursor = collection.find(filter1).sort(orderBy).iterator();
            while (cursor.hasNext()) {
                nbEvent++;
                event = objectMapper.readValue(cursor.next().toJson(), Event.class);
                System.out.println("  événement #" + nbEvent + " : "
                        + event.getEventType()
                        + ", processUid:" + event.getProcessUid()
                        + ", aggregateUid:" + event.getAggregateUid());
                nbError = event.getNbError();

                retcode = -1;   // Tout va mal par défaut :-(
                if (event instanceof ProviderAssigned) {
                    retcode = processProviderAssigned(informixConnection, (ProviderAssigned) event);
                } else if (event instanceof MessageAdded) {
                    retcode = processMessageAdded(informixConnection, (MessageAdded) event);
                } else if (event instanceof MissionAccepted) {
                    retcode = processMissionAccepted(informixConnection, (MissionAccepted) event);
                } else if (event instanceof MissionScheduled) {
                    retcode = processMissionScheduled(informixConnection, (MissionScheduled) event);
                } else if (event instanceof SendingServiceOrderReported) {
                    retcode = processSendingServiceOrderReported(informixConnection, (SendingServiceOrderReported) event);
                } else if (event instanceof InterventionStarted) {
                    retcode = processInterventionStarted(informixConnection, (InterventionStarted) event);
                } else if (event instanceof InterventionFinished) {
                    retcode = processInterventionFinished(informixConnection, (InterventionFinished) event);
                } else if (event instanceof PermanentlyFixed) {
                    retcode = processPermanentlyFixed(informixConnection, (PermanentlyFixed) event);
                } else if (event instanceof PartiallyFixed) {
                    retcode = processPartiallyFixed(informixConnection, (PartiallyFixed) event);
                } else if (event instanceof TicketClosedImpossibleRepair) {
                    retcode = processTicketClosedImpossibleRepair(informixConnection, (TicketClosedImpossibleRepair) event);
                } else if (event instanceof PostponedFix) {
                    retcode = processPostponedFix(informixConnection, (PostponedFix) event);
                } else if (event instanceof FormalNoticeForProviderReported) {
                    retcode = processFormalNoticeForProviderReported(informixConnection, (FormalNoticeForProviderReported) event);
                } else if (event instanceof InterventionDeadlineDefined) {
                    retcode = processInterventionDeadlineDefined(informixConnection, (InterventionDeadlineDefined) event);
//                } else if (event instanceof LogTrialAdded) {
//                    retcode = processLogTrialAdded(informixConnection, (LogTrialAdded) event);
//                } else if (event instanceof TicketOpened) {
//                    retcode = processTicketOpened(informixConnection, (TicketOpened) event);
//                } else if (event instanceof TicketArchived) {
//                    retcode = processTicketArchived(informixConnection, (TicketArchived) event);
//                } else if (event instanceof TicketCancelled) {
//                    retcode = processTicketCancelled(informixConnection, (TicketCancelled) event);
//                } else if (event instanceof ClosedAfterSeveralUnsuccessfulRecalls) {
//                    retcode = processClosedAfterSeveralUnsuccessfulRecalls(informixConnection, (ClosedAfterSeveralUnsuccessfulRecalls) event);
//                } else if (event instanceof ClosedBeyondCallCenterScope) {
//                    retcode = processClosedBeyondCallCenterScope(informixConnection, (ClosedBeyondCallCenterScope) event);
//                } else if (event instanceof CallAnsweredByProvider) {
//                    retcode = processCallAnsweredByProvider(informixConnection, (CallAnsweredByProvider) event);
//                } else if (event instanceof CallNotAnsweredByProvider) {
//                    retcode = processCallNotAnsweredByProvider(informixConnection, (CallNotAnsweredByProvider) event);
//                } else if (event instanceof CallReceived) {
//                    retcode = processCallReceived(informixConnection, (CallReceived) event);
//                } else if (event instanceof CallEmittedTo) {
//                    retcode = processCallEmittedTo(informixConnection, (CallEmittedTo) event);
//                } else if (event instanceof TicketUpdated) {
//                    retcode = processTicketUpdated(informixConnection, (TicketUpdated) event);
                } else {
                    System.out.println("ERROR : Unknown/unprocessed event:" + event + ", class:" + event.getClass().getSimpleName());
                }
                System.out.println("  retcode:" + retcode);

                switch (retcode) {
                    case 1:         // Succès
                        status = 1;
                        break;
                    case -2:        // Conflit d'accès
                        status = 0;
                        nbError++;
                        break;
                    default:        // Erreur
                        status = -1;
                        nbError++;
                        break;
                }

                filter2 = new BasicDBObject("processUid", event.getProcessUid());
                updateResult = collection.updateOne(filter2, new BasicDBObject("$set", new BasicDBObject("status", status).append("nbError", nbError)));
                if (updateResult.getMatchedCount() > 0) {
                    System.out.println("  updateResult:" + updateResult);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Traite l'événement CallReceived sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processCallReceived(Connection informixConnection, CallReceived callReceived) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      CallReceived:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement CallEmittedTo sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processCallEmittedTo(Connection informixConnection, CallEmittedTo callEmittedTo) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      CallEmittedTo:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement CallAnsweredByProvider sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processCallAnsweredByProvider(Connection informixConnection, CallAnsweredByProvider callAnsweredByProvider) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      CallAnsweredByProvider:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement CallNotAnsweredByProvider sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processCallNotAnsweredByProvider(Connection informixConnection, CallNotAnsweredByProvider callNotAnsweredByProvider) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      CallNotAnsweredByProvider:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement ClosedAfterSeveralUnsuccessfulRecalls sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processClosedAfterSeveralUnsuccessfulRecalls(Connection informixConnection, ClosedAfterSeveralUnsuccessfulRecalls closedAfterSeveralUnsuccessfulRecalls) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      ClosedAfterSeveralUnsuccessfulRecalls:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement ClosedBeyondCallCenterScope sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processClosedBeyondCallCenterScope(Connection informixConnection, ClosedBeyondCallCenterScope closedBeyondCallCenterScope) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      ClosedBeyondCallCenterScope:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement TicketArchived sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processTicketArchived(Connection informixConnection, TicketArchived ticketArchived) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      TicketArchived:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement TicketCancelled sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processTicketCancelled(Connection informixConnection, TicketCancelled ticketCancelled) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      TicketCancelled:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement TicketOpened sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processTicketOpened(Connection informixConnection, TicketOpened ticketOpened) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      TicketOpened:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement InterventionStarted sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processInterventionStarted(Connection informixConnection, InterventionStarted interventionStarted) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            dateTime = isoDateTimeFormat.parseDateTime(interventionStarted.getStartedDate());

            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, interventionStarted.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, 69);
            preparedStatement.setString(4, dateTime.toString(hhmmFormat));
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();

            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      InterventionStarted:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement FormalNoticeForProviderReported sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processFormalNoticeForProviderReported(Connection informixConnection, FormalNoticeForProviderReported formalNoticeForProviderReported) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        DateTimeFormatter ddmmyy = DateTimeFormat.forPattern("dd/MM/YY");
        StringBuffer comment;
        String ref;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, formalNoticeForProviderReported.getAggregateUid());
            provider = formalNoticeForProviderReported.getProvider();
            if (provider instanceof ReferencedProvider) {
                preparedStatement.setString(2, ((ReferencedProvider) provider).getProviderUid());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(3, 300);
            dateTime = isoDateTimeFormat.parseDateTime(formalNoticeForProviderReported.getDeadline());
            comment = new StringBuffer("Mise en demeure");
            if ((ref = formalNoticeForProviderReported.getRef()) != null) {
                comment.append(" no ").append(ref);
            }
            comment.append(" du ").append(dateTime.toString(ddmmyy));
            preparedStatement.setString(4, comment.toString());
            dateTime = isoDateTimeFormat.parseDateTime(formalNoticeForProviderReported.getReportDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      FormalNoticeForProviderReported:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement InterventionDeadlineDefined sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processInterventionDeadlineDefined(Connection informixConnection, InterventionDeadlineDefined interventionDeadlineDefined) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        DateTimeFormatter ddmmyy = DateTimeFormat.forPattern("dd/MM/YY");
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, interventionDeadlineDefined.getAggregateUid());
            provider = interventionDeadlineDefined.getProvider();
            if (provider instanceof ReferencedProvider) {
                preparedStatement.setString(2, ((ReferencedProvider) provider).getProviderUid());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(3, 305);
            dateTime = isoDateTimeFormat.parseDateTime(interventionDeadlineDefined.getDeadline());
            preparedStatement.setString(4, dateTime.toString(ddmmyy));
            dateTime = isoDateTimeFormat.parseDateTime(interventionDeadlineDefined.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      InterventionDeadlineDefined:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement SendingServiceOrderReported sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processSendingServiceOrderReported(Connection informixConnection, SendingServiceOrderReported sendingServiceOrderReported) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        DateTimeFormatter ddmmyy = DateTimeFormat.forPattern("dd/MM/YY");
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, sendingServiceOrderReported.getAggregateUid());
            provider = sendingServiceOrderReported.getProvider();
            if (provider instanceof ReferencedProvider) {
                preparedStatement.setString(2, ((ReferencedProvider) provider).getProviderUid());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(3, 300);
            dateTime = isoDateTimeFormat.parseDateTime(sendingServiceOrderReported.getSendingDate());
            preparedStatement.setString(4, "OE no " + sendingServiceOrderReported.getRef()
                    + " du " + dateTime.toString(ddmmyy));
            dateTime = isoDateTimeFormat.parseDateTime(sendingServiceOrderReported.getReportDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      SendingServiceOrderReported:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement InterventionFinished sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processInterventionFinished(Connection informixConnection, InterventionFinished interventionFinished) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            dateTime = isoDateTimeFormat.parseDateTime(interventionFinished.getFinishedDate());

            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, interventionFinished.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, 70);
            preparedStatement.setString(4, dateTime.toString(hhmmFormat));
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();

            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      InterventionFinished:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement LogTrialAdded sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processLogTrialAdded(Connection informixConnection, LogTrialAdded logTrialAdded) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      LogTrialAdded:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement TicketUpdated sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
//    private int processTicketUpdated(Connection informixConnection, TicketUpdated ticketUpdated) {
//        int nbTrials = 0;
//        int errno = 0;
//        int isam = 0;
//        String errmsg = null;
//
//        int retcode = -1;
//
//        System.out.println("      TicketUpdated:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");
//
//        return retcode;
//    }
    /**
     * Traite l'événement PermanentlyFixed sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processPermanentlyFixed(Connection informixConnection, PermanentlyFixed permanentlyFixed) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String message;
        String stillOnSite;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults = null;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, permanentlyFixed.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, 71);
            preparedStatement.setString(4, "Réparation définitive");
            dateTime = isoDateTimeFormat.parseDateTime(permanentlyFixed.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();

            if (retcode == 1) {
                if ((message = permanentlyFixed.getReport()) != null) {
                    preparedStatement.setInt(3, 72);
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            if (retcode == 1) {
                if ((stillOnSite = permanentlyFixed.getStillOnSite()) != null) {
                    preparedStatement.setInt(3, 73);
                    if ("Yes".equals(stillOnSite)) {
                        message = "Oui";
                    } else if ("No".equals(stillOnSite)) {
                        message = "Non";
                    } else if ("NotAsked".equals(stillOnSite)) {
                        message = "Non demandée";
                    } else if ("ProviderRefuseToReply".equals(stillOnSite)) {
                        message = "Refus";
                    } else {
                        message = "Non disponible";
                    }
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      PermanentlyFixed:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement PartiallyFixed sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processPartiallyFixed(Connection informixConnection, PartiallyFixed partiallyFixed) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String message;
        String stillOnSite;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults = null;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, partiallyFixed.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, 71);
            preparedStatement.setString(4, "Réparation partielle");
            dateTime = isoDateTimeFormat.parseDateTime(partiallyFixed.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials += resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();

            if (retcode == 1) {
                if ((message = partiallyFixed.getReport()) != null) {
                    preparedStatement.setInt(3, 72);
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            if (retcode == 1) {
                if ((stillOnSite = partiallyFixed.getStillOnSite()) != null) {
                    preparedStatement.setInt(3, 73);
                    if ("Yes".equals(stillOnSite)) {
                        message = "Oui";
                    } else if ("No".equals(stillOnSite)) {
                        message = "Non";
                    } else if ("NotAsked".equals(stillOnSite)) {
                        message = "Non demandée";
                    } else if ("ProviderRefuseToReply".equals(stillOnSite)) {
                        message = "Refus";
                    } else {
                        message = "Non disponible";
                    }
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      PartiallyFixed:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement TicketClosedImpossibleRepair sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processTicketClosedImpossibleRepair(Connection informixConnection, TicketClosedImpossibleRepair ticketClosedImpossibleRepair) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String message;
        String stillOnSite;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults = null;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, ticketClosedImpossibleRepair.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, 71);
            preparedStatement.setString(4, "Réparation impossible");
            dateTime = isoDateTimeFormat.parseDateTime(ticketClosedImpossibleRepair.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials += resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();

            if (retcode == 1) {
                if ((message = ticketClosedImpossibleRepair.getReport()) != null) {
                    preparedStatement.setInt(3, 72);
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            if (retcode == 1) {
                if ((stillOnSite = ticketClosedImpossibleRepair.getStillOnSite()) != null) {
                    preparedStatement.setInt(3, 73);
                    if ("Yes".equals(stillOnSite)) {
                        message = "Oui";
                    } else if ("No".equals(stillOnSite)) {
                        message = "Non";
                    } else if ("NotAsked".equals(stillOnSite)) {
                        message = "Non demandée";
                    } else if ("ProviderRefuseToReply".equals(stillOnSite)) {
                        message = "Refus";
                    } else {
                        message = "Non disponible";
                    }
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      TicketClosedImpossibleRepair:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement PostponedFix sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processPostponedFix(Connection informixConnection, PostponedFix postponedFix) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String message;
        String stillOnSite;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults = null;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, postponedFix.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, 71);
            preparedStatement.setString(4, "Réparation reportée en heure ouvrée");
            dateTime = isoDateTimeFormat.parseDateTime(postponedFix.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 1);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials += resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();

            if (retcode == 1) {
                if ((message = postponedFix.getReport()) != null) {
                    preparedStatement.setInt(3, 72);
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            if (retcode == 1) {
                if ((stillOnSite = postponedFix.getStillOnSite()) != null) {
                    preparedStatement.setInt(3, 73);
                    if ("Yes".equals(stillOnSite)) {
                        message = "Oui";
                    } else if ("No".equals(stillOnSite)) {
                        message = "Non";
                    } else if ("NotAsked".equals(stillOnSite)) {
                        message = "Non demandée";
                    } else if ("ProviderRefuseToReply".equals(stillOnSite)) {
                        message = "Refus";
                    } else {
                        message = "Non disponible";
                    }
                    preparedStatement.setString(4, message);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults.add(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials = sqlResults.getNbTrials();
//                        retcode = resultSet.getInt(1);
//                        nbTrials += resultSet.getInt(2);
//                        errno = resultSet.getInt(3);
//                        isam = resultSet.getInt(4);
//                        errmsg = resultSet.getString(5);
                    }
                    resultSet.close();
                }
            }

            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      PostponedFix:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement MissionScheduled sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processMissionScheduled(Connection informixConnection, MissionScheduled missionScheduled) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        DateTime startDate;
        DateTime endDate;
        String message;
        DateTimeFormatter ddmmyy_hhmm = DateTimeFormat.forPattern("dd/MM/YY HH:mm");
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            startDate = isoDateTimeFormat.parseDateTime(missionScheduled.getStartDate());
            endDate = isoDateTimeFormat.parseDateTime(missionScheduled.getEndDate());
            message = String.format("%-40s%s et le %s", "Intervention prévue entre le :",
                    startDate.toString(ddmmyy_hhmm), endDate.toString(ddmmyy_hhmm));
            System.out.println("    message:" + message);
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, missionScheduled.getAggregateUid());
            preparedStatement.setNull(2, java.sql.Types.INTEGER);
            preparedStatement.setInt(3, -1);
            preparedStatement.setString(4, message);
            dateTime = isoDateTimeFormat.parseDateTime(missionScheduled.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      MissionScheduled:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement MissionAccepted sur un ticket
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param ProviderAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processMissionAccepted(Connection informixConnection, MissionAccepted missionAccepted) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        try {
            preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, missionAccepted.getAggregateUid());
            provider = missionAccepted.getProvider();
            if (provider instanceof ReferencedProvider) {
                preparedStatement.setString(2, ((ReferencedProvider) provider).getProviderUid());
            } else {
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(3, 77);
            preparedStatement.setString(4, missionAccepted.getComment());
            dateTime = isoDateTimeFormat.parseDateTime(missionAccepted.getDate());
            preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
            preparedStatement.setInt(6, onum);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sqlResults = new SqlResults(resultSet);
                retcode = sqlResults.getRetcode();
                nbTrials = sqlResults.getNbTrials();
//                retcode = resultSet.getInt(1);
//                nbTrials = resultSet.getInt(2);
//                errno = resultSet.getInt(3);
//                isam = resultSet.getInt(4);
//                errmsg = resultSet.getString(5);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        System.out.println("      MissionAccepted:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement MessageAdded
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param messageAdded événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processMessageAdded(Connection informixConnection, MessageAdded messageAdded) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        SqlResults sqlResults;

        int retcode = 0;

        if (messageAdded.getOperator() instanceof ReferencedUser) {
//            if ((retcode = processMessageAdded_00(informixConnection, messageAdded)) == 0) {
//                retcode = processMessageAdded_99(informixConnection, messageAdded);
//            }

            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, messageAdded.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, -1);
                preparedStatement.setString(4, messageAdded.getMessage());
                dateTime = isoDateTimeFormat.parseDateTime(messageAdded.getMessageAddedDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
//                    retcode = resultSet.getInt(1);
//                    nbTrials = resultSet.getInt(2);
//                    errno = resultSet.getInt(3);
//                    isam = resultSet.getInt(4);
//                    errmsg = resultSet.getString(5);
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : événement rejeté, raison : généré par Anstel");
            retcode = -1;
        }

        System.out.println("      MessageAdded:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'événement ProviderAssigned
     *
     * @param informixConnection connection à la base de données Informix locale
     * @param providerAssigned événement à traiter
     * @return code de retour : 1=Succès, 0=ne rien faire, -1=erreur
     */
    private int processProviderAssigned(Connection informixConnection, ProviderAssigned providerAssigned) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        int errno = 0;
        int isam = 0;
        String errmsg = null;
        Provider provider;
        ProviderAssignationPurpose providerAssignationPurpose;
        String comment;

        int retcode = 0;
        SqlResults sqlResults;

        if (providerAssigned.getOperator() instanceof ReferencedUser) {
//            if ((retcode = processProviderAssigned_00(informixConnection, providerAssigned)) == 0) {
//                retcode = processProviderAssigned_99(informixConnection, providerAssigned);
//            }

            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, providerAssigned.getAggregateUid());
                provider = providerAssigned.getProvider();
                if (provider instanceof ReferencedProvider) {
                    preparedStatement.setString(2, ((ReferencedProvider) provider).getProviderUid());
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(3, 22);
                providerAssignationPurpose = providerAssigned.getProviderAssignationPurpose();
                if (providerAssignationPurpose instanceof RecourseChanged) {
                    comment = ((RecourseChanged) providerAssignationPurpose).getComment();
                } else if (providerAssignationPurpose instanceof Purpose) {
                    comment = ((Purpose) providerAssignationPurpose).getPurpose();
                } else {
                    comment = null;
                }
                if (comment == null) {
                    preparedStatement.setNull(4, java.sql.Types.CHAR);
                } else if ("comment".equals(comment)) {
                    preparedStatement.setNull(4, java.sql.Types.CHAR);
                } else {
                    preparedStatement.setString(4, comment);
                }
                dateTime = isoDateTimeFormat.parseDateTime(providerAssigned.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
//                    retcode = resultSet.getInt(1);
//                    nbTrials = resultSet.getInt(2);
//                    errno = resultSet.getInt(3);
//                    isam = resultSet.getInt(4);
//                    errmsg = resultSet.getString(5);
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : événement rejeté, raison : généré par Anstel");
            retcode = -1;
        }

        System.out.println("      ProviderAssigned:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * @param mongoDbServerType définit le serveur Web
     */
    private void setMongoDbServerType(String mongoDbServerType) {
        this.mongoDbServerType = mongoDbServerType;
    }

    /**
     * @param informixDbServerType définit le serveur de base de données
     */
    private void setInformixDbServerType(String informixDbServerType) {
        this.informixDbServerType = informixDbServerType;
    }

    /**
     * @return mongoDbServerType le serveur web
     */
    private String getMongoDbServerType() {
        return (mongoDbServerType);
    }

    /**
     * @return informixDbServerType le serveur de base de données
     */
    private String getInformixDbServerType() {
        return (informixDbServerType);
    }

    /**
     * Retourne le contenu de Bkgpi2a
     *
     * @return retourne le contenu de Bkgpi2a
     */
    @Override
    public String toString() {
        return "Bkgpi2a:{webServer=" + getMongoDbServerType()
                + ", dbServer=" + getInformixDbServerType() + "}";
    }

    /**
     * Programme principal pour lancer Bkgpi2a.
     *
     * @param args paramètre de ligne de commande (cf. constructeur).
     */
    public static void main(String[] args) {

        Bkgpi2a syncCollections;

        System.out.println("Lancement de Bkgpi2a ...");

        try {
            syncCollections = new Bkgpi2a(args);
            if (debugMode) {
                System.out.println(syncCollections);
            }
        } catch (Exception exception) {
            System.out.println("Problème lors de l'instanciation de Bkgpi2a");
            exception.printStackTrace();
        }

        System.out.println("Fin de Bkgpi2a");
    }

    /**
     * @return les identifiants pour accéder au serveur Web
     */
    public Identifiants getMongoDbId() {
        return mongoDbId;
    }

    /**
     * @param mongoDbId définit les identifiants pour accéder au serveur Web
     */
    public void setMongoDbId(Identifiants mongoDbId) {
        this.mongoDbId = mongoDbId;
    }

    /**
     * @param applicationProperties définit les identifiants pour accéder au
     * serveur Web
     * @throws WebServerException en cas d'erreur sur la lecteur des
     * identifiants
     */
//    public void setMongoDbId(ApplicationProperties applicationProperties) throws WebServerException {
//        String value;
//        Identifiants identifiants = new Identifiants();
//
//        value = applicationProperties.getProperty(getMongoDbServerType() + ".webserver.login");
//        if (value != null) {
//            identifiants.setLogin(value);
//        } else {
//            throw new WebServerException("Nom utilisateur pour l'accès Web non défini");
//        }
//
//        value = applicationProperties.getProperty(getMongoDbServerType() + ".webserver.passwd");
//        if (value != null) {
//            identifiants.setPassword(value);
//        } else {
//            throw new WebServerException("Mot de passe pour l'accès Web non défini");
//        }
//        Bkgpi2a.this.setMongoDbId(identifiants);
//    }
    /**
     * @return les identifiants pour accéder à la base de données
     */
    public Identifiants getInformixDbId() {
        return informixDbId;
    }

    /**
     * @param informixDbId définit les identifiants pour accéder à la base de
     * données
     */
    public void setInformixDbId(Identifiants informixDbId) {
        this.informixDbId = informixDbId;
    }

    /**
     * @param applicationProperties définit les identifiants pour accéder au
     * serveur Web
     * @throws WebServerException en cas d'erreur sur la lecteur des
     * identifiants
     */
//    public void setInformixDbId(ApplicationProperties applicationProperties) throws WebServerException {
//        String value;
//        Identifiants identifiants = new Identifiants();
//
//        value = applicationProperties.getProperty(getInformixDbServerType() + ".dbserver.login");
//        if (value != null) {
//            identifiants.setLogin(value);
//        } else {
//            throw new WebServerException("Nom utilisateur pour l'accès base de données non défini");
//        }
//
//        value = applicationProperties.getProperty(getInformixDbServerType() + ".dbserver.passwd");
//        if (value != null) {
//            identifiants.setPassword(value);
//        } else {
//            throw new WebServerException("Mot de passe pour l'accès base de données non défini");
//        }
//        Bkgpi2a.this.setInformixDbId(identifiants);
//    }
    /**
     * @param debugMode : fonctionnement du programme en mode debug
     * (true/false).
     */
    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    /**
     * @param testMode : fonctionnement du programme en mode test (true/false).
     */
    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    /**
     * @return debugMode : retourne le mode de fonctionnement debug.
     */
    public boolean getDebugMode() {
        return (debugMode);
    }

    /**
     * @return testMode : retourne le mode de fonctionnement test.
     */
    public boolean getTestMode() {
        return (testMode);
    }
}
