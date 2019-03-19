package bkgpi2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
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
 * de donn�es MongoDB par rapport � une base de donn�es Informix
 *
 * @author Thierry Baribaud.
 * @version 1.09
 */
public class Bkgpi2a {

    /**
     * Classe interne pour stocker les r�sultats d'une requ�te SQL
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
         * @param resultSet les r�sultats d'ex�cution d'une requ�te
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
                System.out.println("ERROR : erreur dans la r�cup�ration des r�sultats de la requ�te SQL " + exception);
            }
        }

        /**
         * Ajoute les r�sultats d'ex�cution d'une requ�te � des r�sultats
         * existants
         *
         * @param resultSet les r�sultats d'ex�cution d'une requ�te
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
                System.out.println("ERROR : erreur dans la r�cup�ration des r�sultats de la requ�te SQL " + exception);
            }

        }

        /**
         * Retourne le code d'erreur associ� � l'ex�cution d'une requ�te SQL
         *
         * @return retourne le code d'erreur associ� � l'ex�cution d'une requ�te
         * SQL
         */
        public int getRetcode() {
            return retcode;
        }

        /**
         * Retourne le nombre d'essais inject�s
         *
         * @return retourne le nombre d'essais inject�s
         */
        public int getNbTrials() {
            return nbTrials;
        }
    }

    /**
     * Pour convertir les datetimes du format texte au format DateTime et vice
     * versa
     */
    private static final DateTimeFormatter isoDateTimeFormat1 = ISODateTimeFormat.dateTimeParser();
    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final DateTimeFormatter hhmmFormat = DateTimeFormat.forPattern("HH:mm");

    /**
     * R�f�rence de l'utilisateur Extranet
     */
    private static final int onum = 805;

    /**
     * mongoDbServerType : prod pour le serveur de production, pre-prod pour le
     * serveur de pr�-production. Valeur par d�faut : pre-prod.
     */
    private String mongoDbServerType = "pre-prod";

    /**
     * informixDbServerType : prod pour le serveur de production, pre-prod pour
     * le serveur de pr�-production. Valeur par d�faut : pre-prod.
     */
    private String informixDbServerType = "pre-prod";

    /**
     * mongoDbId : identifiants pour se connecter au serveur MongoDb courant.
     * Pas de valeur par d�faut, ils doivent être fournis dans le fichier
     * MyDatabases.prop.
     */
    private Identifiants mongoDbId;

    /**
     * informixDbId : identifiants pour se connecter au serveur Informix
     * courant. Pas de valeur par d�faut, ils doivent être fournis dans le
     * fichier MyDatabases.prop.
     */
    private Identifiants informixDbId;

    /**
     * retention : dur�e de r�tention, exprim�e en jours, des �v�nements en base
     * de donn�es. Valeur par d�faut : 7 jours.
     */
    private int retention = 7;

    /**
     * debugMode : fonctionnement du programme en mode debug (true/false).
     * Valeur par d�faut : false.
     */
    private static boolean debugMode = false;

    /**
     * testMode : fonctionnement du programme en mode test (true/false). Valeur
     * par d�faut : false.
     */
    private static boolean testMode = false;

    /**
     * Constructeur de la classe SyncCollections
     * <p>
     * Les arguments en ligne de commande permettent de changer le mode de
     * fonctionnement.</p><ul>
     * <li>-mgodb mongodb : r�f�rence � la base de donn�es MongoDB, par d�faut
     * d�signe la base de donn�es de d�veloppement. Voir fichier
     * myDatabases.prop (optionnel).</li>
     * <li>-ifxdb informixdb : r�f�rence � la base de donn�es Informix, par
     * d�faut d�signe la base de donn�es de d�veloppement. Voir fichier
     * myDatabases.prop (optionnel).</li>
     * <li>-d : le programme fonctionne en mode d�bug le rendant plus verbeux,
     * d�sactiv� par d�faut (optionnel).</li>
     * <li>-t : le programme fonctionne en mode de test, les transactions en
     * base de donn�es ne sont pas ex�cut�es, d�sactiv� par d�faut
     * (optionnel).</li>
     * </ul>
     *
     * @param args arguments de la ligne de commande.
     * @throws java.io.IOException en cas d'erreur d'entr�e/sortie.
     * @throws utils.DBServerException en cas d'erreur avec le serveur de base
     * de donn�es.
     * @throws GetArgsException en cas d'erreur avec les param�tres en ligne de
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

        System.out.println("Cr�ation d'une instance de Bkgpi2a ...");

        System.out.println("Analyse des arguments de la ligne de commande ...");
        getArgs = new GetArgs(args);
        setMongoDbServerType(getArgs.getMongoDbServerType());
        setInformixDbServerType(getArgs.getInformixDbServerType());
        setDebugMode(getArgs.getDebugMode());
        setTestMode(getArgs.getTestMode());

        System.out.println("Lecture des param�tres d'ex�cution ...");
        applicationProperties = new ApplicationProperties("Bkgpi2a.prop");
        setRetention(getMongoDbServerType(), "mgodb", applicationProperties);

        System.out.println("Lecture des param�tres du serveur MongoDb ...");
        mongoServer = new DBServer(getMongoDbServerType(), "mgodb", applicationProperties);
        if (debugMode) {
            System.out.println(mongoServer);
        }
//        setMongoDbId(applicationProperties);
//        System.out.println(getMongoDbId());

        System.out.println("Lecture des param�tres du serveur Informix ...");
        informixServer = new DBServer(getInformixDbServerType(), "ifxdb", applicationProperties);
        if (debugMode) {
            System.out.println(informixServer);
        }
//        setInformixDbId(applicationProperties);
//        System.out.println(getInformixDbId());

        System.out.println("Ouverture de la connexion au serveur MongoDb : " + mongoServer.getName());
        mongoClient = new MongoClient(mongoServer.getIpAddress(), (int) mongoServer.getPortNumber());

        System.out.println("Connexion � la base de donn�es : " + mongoServer.getDbName());
        mongoDatabase = mongoClient.getDatabase(mongoServer.getDbName());

        System.out.println("Ouverture de la connexion au serveur Informix : " + informixServer.getName());
        informixDbManager = new DBManager(informixServer);

        System.out.println("Connexion � la base de donn�es : " + informixServer.getDbName());
        informixConnection = informixDbManager.getConnection();

        System.out.println("Synchronisation des �v�nements ...");
        syncEvents(mongoDatabase, informixConnection);
    }

    /**
     * M�thode pour synchroniser les �v�nements par rapport � la base de donn�es
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
        System.out.println(collection.count() + " �v�n�ment(s) dans la base MongoDb");

        nbEvent = 0;
        try {
            filter1 = new BasicDBObject("status", 0);
            orderBy = new BasicDBObject("aggregateUid", 1).append("sentDate", 1);
            cursor = collection.find(filter1).sort(orderBy).iterator();
            while (cursor.hasNext()) {
                nbEvent++;
                event = objectMapper.readValue(cursor.next().toJson(), Event.class);
                System.out.println("  �v�nement #" + nbEvent + " : "
                        + event.getEventType()
                        + ", processUid:" + event.getProcessUid()
                        + ", aggregateUid:" + event.getAggregateUid());
                nbError = event.getNbError();

                retcode = -4;   // Non g�r� par d�faut.
                if (event instanceof ProviderAssigned) {
                    retcode = processProviderAssigned(informixConnection, (ProviderAssigned) event);
                } else if (event instanceof AssigneeIdentified) {
                    retcode = processAssigneeIdentified(informixConnection, (AssigneeIdentified) event);
                } else if (event instanceof MessageAdded) {
                    retcode = processMessageAdded(informixConnection, (MessageAdded) event);
                } else if (event instanceof MissionAccepted) {
                    retcode = processMissionAccepted(informixConnection, (MissionAccepted) event);
                } else if (event instanceof InterventionAccepted) {
                    retcode = processInterventionAccepted(informixConnection, (InterventionAccepted) event);    
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
                } else if (event instanceof ClosedBeyondCallCenterScope) {
                    retcode = processClosedBeyondCallCenterScope(informixConnection, (ClosedBeyondCallCenterScope) event);
//                } else if (event instanceof LogTrialAdded) {
//                    retcode = processLogTrialAdded(informixConnection, (LogTrialAdded) event);
//                } else if (event instanceof TicketOpened) {
//                    retcode = processTicketOpened(informixConnection, (TicketOpened) event);
//                } else if (event instanceof TicketArchived) {
//                    retcode = processTicketArchived(informixConnection, (TicketArchived) event);
                } else if (event instanceof TicketCancelled) {
                    retcode = processTicketCancelled(informixConnection, (TicketCancelled) event);
//                } else if (event instanceof ClosedAfterSeveralUnsuccessfulRecalls) {
//                    retcode = processClosedAfterSeveralUnsuccessfulRecalls(informixConnection, (ClosedAfterSeveralUnsuccessfulRecalls) event);
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
                    case 1:         // Succ�s
                        status = 1;
                        break;
                    case -2:        // Conflit d'acc�s
                        status = 0;
                        nbError++;
                        break;
                    case -3:        // rejet car origine d'Anstel
                        status = retcode;
                        nbError++;
                        break;
                    case -4:        // rejet car non reconnu
                        status = retcode;
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
            purgeEvents(collection);
        } catch (IOException ex) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * M�thode pour purger les �v�nements plus anciens que retention jours
     *
     * @param collection dans laquelle r�aliser la purge
     */
    private void purgeEvents(MongoCollection<Document> collection) {
        DateTime dateTime;
        BasicDBObject filter;
        DeleteResult deleteResult;

        dateTime = new DateTime().minusDays(retention);
        System.out.println("  purge des �v�nements ant�rieurs � " + retention + " jour(s), soit ant�rieurs � " + dateTime);
        filter = new BasicDBObject("sentDate", new BasicDBObject("$lt", dateTime.toString(isoDateTimeFormat2)));
        if (debugMode) {
            System.out.println("  filter:" + filter);
        }
        deleteResult = collection.deleteMany(filter);
        System.out.println("  deleteResult:" + deleteResult);
    }

    /**
     * Traite l'�v�nement CallReceived sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param CallReceived �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement CallEmittedTo sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param callEmittedTo �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement CallAnsweredByProvider sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param callAnsweredByProvider �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement CallNotAnsweredByProvider sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param callNotAnsweredByProvider �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement ClosedAfterSeveralUnsuccessfulRecalls sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param closedAfterSeveralUnsuccessfulRecalls �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement ClosedBeyondCallCenterScope sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param closedBeyondCallCenterScope �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    /**
     * Traite l'�v�nement PermanentlyFixed sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param permanentlyFixed �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processClosedBeyondCallCenterScope(Connection informixConnection, ClosedBeyondCallCenterScope closedBeyondCallCenterScope) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        StringBuffer message;
        String comment;
        int nbTrials = 0;
        SqlResults sqlResults = null;

        int retcode = 0;

        if (closedBeyondCallCenterScope.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, closedBeyondCallCenterScope.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, ClosedBeyondCallCenterScope.code);
                message = new StringBuffer(ClosedBeyondCallCenterScope.label);
                comment = closedBeyondCallCenterScope.getComment();
                if (comment.length() > 0) {
                    message.append(" ").append(comment);
                }
                preparedStatement.setString(4, message.toString());
                dateTime = isoDateTimeFormat1.parseDateTime(closedBeyondCallCenterScope.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 1);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      ClosedBeyondCallCenterScope:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement TicketArchived sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ticketArchived �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement TicketCancelled sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param TicketCancelled �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
//    private int processTicketCancelled(Connection informixConnection, TicketCancelled TicketCancelled) {
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
     * Traite l'�v�nement TicketOpened sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ticketOpened �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement InterventionStarted sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param interventionStarted �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processInterventionStarted(Connection informixConnection, InterventionStarted interventionStarted) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (interventionStarted.getOperator() instanceof ReferencedUser) {
            try {
                dateTime = isoDateTimeFormat1.parseDateTime(interventionStarted.getStartedDate());
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
                }
                resultSet.close();

                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      InterventionStarted:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement FormalNoticeForProviderReported sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param formalNoticeForProviderReported �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processFormalNoticeForProviderReported(Connection informixConnection, FormalNoticeForProviderReported formalNoticeForProviderReported) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        TicketAssignee ticketAssignee;
        DateTimeFormatter ddmmyy = DateTimeFormat.forPattern("dd/MM/YY");
        StringBuffer comment;
        String ref;
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (formalNoticeForProviderReported.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, formalNoticeForProviderReported.getAggregateUid());
                ticketAssignee = formalNoticeForProviderReported.getAssignee();
                if (ticketAssignee instanceof ReferencedProviderContact) {
                    preparedStatement.setString(2, ((ReferencedProviderContact) ticketAssignee).getProviderContactUid());
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(3, 303);
                dateTime = isoDateTimeFormat1.parseDateTime(formalNoticeForProviderReported.getDeadline());
                comment = new StringBuffer("Mise en demeure");
                if ((ref = formalNoticeForProviderReported.getRef()) != null) {
                    comment.append(" no ").append(ref);
                }
                comment.append(" du ").append(dateTime.toString(ddmmyy));
                preparedStatement.setString(4, comment.toString());
                dateTime = isoDateTimeFormat1.parseDateTime(formalNoticeForProviderReported.getReportDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      FormalNoticeForProviderReported:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement InterventionDeadlineDefined sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param interventionDeadlineDefined �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processInterventionDeadlineDefined(Connection informixConnection, InterventionDeadlineDefined interventionDeadlineDefined) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        TicketAssignee ticketAssignee;
        DateTimeFormatter ddmmyy = DateTimeFormat.forPattern("dd/MM/YY");
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (interventionDeadlineDefined.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, interventionDeadlineDefined.getAggregateUid());
                ticketAssignee = interventionDeadlineDefined.getAssignee();
                if (ticketAssignee instanceof ReferencedProviderContact) {
                    preparedStatement.setString(2, ((ReferencedProviderContact) ticketAssignee).getProviderContactUid());
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(3, 305);
                dateTime = isoDateTimeFormat1.parseDateTime(interventionDeadlineDefined.getDeadline());
                preparedStatement.setString(4, dateTime.toString(ddmmyy));
                dateTime = isoDateTimeFormat1.parseDateTime(interventionDeadlineDefined.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      InterventionDeadlineDefined:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement SendingServiceOrderReported sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param sendingServiceOrderReported �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processSendingServiceOrderReported(Connection informixConnection, SendingServiceOrderReported sendingServiceOrderReported) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        TicketAssignee ticketAssignee;
        DateTimeFormatter ddmmyy = DateTimeFormat.forPattern("dd/MM/YY");
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (sendingServiceOrderReported.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, sendingServiceOrderReported.getAggregateUid());
                ticketAssignee = sendingServiceOrderReported.getAssignee();
                if (ticketAssignee instanceof ReferencedProviderContact) {
                    preparedStatement.setString(2, ((ReferencedProviderContact) ticketAssignee).getProviderContactUid());
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(3, 300);
                dateTime = isoDateTimeFormat1.parseDateTime(sendingServiceOrderReported.getSendingDate());
                preparedStatement.setString(4, "OE no " + sendingServiceOrderReported.getRef()
                        + " du " + dateTime.toString(ddmmyy));
                dateTime = isoDateTimeFormat1.parseDateTime(sendingServiceOrderReported.getReportDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      SendingServiceOrderReported:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement InterventionFinished sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param interventionFinished �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processInterventionFinished(Connection informixConnection, InterventionFinished interventionFinished) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (interventionFinished.getOperator() instanceof ReferencedUser) {
            try {
                dateTime = isoDateTimeFormat1.parseDateTime(interventionFinished.getFinishedDate());

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
                }
                resultSet.close();

                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      InterventionFinished:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement LogTrialAdded sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param logTrialAdded �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement TicketUpdated sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ticketUpdated �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
     * Traite l'�v�nement PermanentlyFixed sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param permanentlyFixed �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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

        if (permanentlyFixed.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, permanentlyFixed.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, PermanentlyFixed.code);
                preparedStatement.setString(4, PermanentlyFixed.label);
                dateTime = isoDateTimeFormat1.parseDateTime(permanentlyFixed.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 1);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
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
                            message = "Non demand�e";
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
                        }
                        resultSet.close();
                    }
                }

                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      PermanentlyFixed:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement PartiallyFixed sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param partiallyFixed �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processPartiallyFixed(Connection informixConnection, PartiallyFixed partiallyFixed) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String report;
        String stillOnSite;
        String brakedownNature;
        int nbTrials = 0;
        SqlResults sqlResults = null;
        EndOfMission endOfMission;

        int retcode = 0;

        if (partiallyFixed.getOperator() instanceof ReferencedUser) {
            try {
                endOfMission = new EndOfMission(partiallyFixed);

                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, endOfMission.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, endOfMission.getCode());
                preparedStatement.setString(4, endOfMission.getLabel());
                dateTime = isoDateTimeFormat1.parseDateTime(endOfMission.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 1);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();

                if (retcode == 1) {
                    if ((report = endOfMission.getReport()) != null) {
                        preparedStatement.setInt(3, EndOfMission.reportCode);
                        preparedStatement.setString(4, report);
                        resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            sqlResults.add(resultSet);
                            retcode = sqlResults.getRetcode();
                            nbTrials = sqlResults.getNbTrials();
                        }
                        resultSet.close();
                    }
                }

                if (retcode == 1) {
                    if ((stillOnSite = endOfMission.translateStillOnSite()) != null) {
                        preparedStatement.setInt(3, EndOfMission.stillOnSiteCode);
                        preparedStatement.setString(4, stillOnSite);
                        resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            sqlResults.add(resultSet);
                            retcode = sqlResults.getRetcode();
                            nbTrials = sqlResults.getNbTrials();
                        }
                        resultSet.close();
                    }
                }

                if (retcode == 1) {
                    if ((brakedownNature = endOfMission.getBrakedownNature()) != null) {
                        preparedStatement.setInt(3, EndOfMission.brakedownNatureCode);
                        preparedStatement.setString(4, brakedownNature);
                        resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            sqlResults.add(resultSet);
                            retcode = sqlResults.getRetcode();
                            nbTrials = sqlResults.getNbTrials();
                        }
                        resultSet.close();
                    }
                }

                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      PartiallyFixed:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement TicketClosedImpossibleRepair sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ticketClosedImpossibleRepair �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processTicketClosedImpossibleRepair(Connection informixConnection, TicketClosedImpossibleRepair ticketClosedImpossibleRepair) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String message;
        String stillOnSite;
        int nbTrials = 0;
        SqlResults sqlResults = null;

        int retcode = 0;

        if (ticketClosedImpossibleRepair.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, ticketClosedImpossibleRepair.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, TicketClosedImpossibleRepair.code);
                preparedStatement.setString(4, TicketClosedImpossibleRepair.label);
                dateTime = isoDateTimeFormat1.parseDateTime(ticketClosedImpossibleRepair.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 1);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
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
                            message = "Non demand�e";
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
                        }
                        resultSet.close();
                    }
                }

                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      TicketClosedImpossibleRepair:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement PostponedFix sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param postponedFix �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processPostponedFix(Connection informixConnection, PostponedFix postponedFix) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        String message;
        String stillOnSite;
        int nbTrials = 0;
        SqlResults sqlResults = null;

        int retcode = 0;

        if (postponedFix.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, postponedFix.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, PostponedFix.code);
                preparedStatement.setString(4, PostponedFix.label);
                dateTime = isoDateTimeFormat1.parseDateTime(postponedFix.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 1);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
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
                            message = "Non demand�e";
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
                        }
                        resultSet.close();
                    }
                }

                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      PostponedFix:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement MissionScheduled sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param missionScheduled �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
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
        SqlResults sqlResults;

        int retcode = 0;

        if (missionScheduled.getOperator() instanceof ReferencedUser) {
            try {
                startDate = isoDateTimeFormat1.parseDateTime(missionScheduled.getStartDate());
                endDate = isoDateTimeFormat1.parseDateTime(missionScheduled.getEndDate());
                message = String.format("%-40s%s et le %s", "Intervention pr�vue entre le :",
                        startDate.toString(ddmmyy_hhmm), endDate.toString(ddmmyy_hhmm));
                System.out.println("    message:" + message);
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, missionScheduled.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, -1);
                preparedStatement.setString(4, message);
                dateTime = isoDateTimeFormat1.parseDateTime(missionScheduled.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      MissionScheduled:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement MissionAccepted sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param missionAccepted �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processMissionAccepted(Connection informixConnection, MissionAccepted missionAccepted) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        Provider provider;
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (missionAccepted.getOperator() instanceof ReferencedUser) {
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
                dateTime = isoDateTimeFormat1.parseDateTime(missionAccepted.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      MissionAccepted:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement InterventionAccepted sur un ticket
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param interventionAccepted �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processInterventionAccepted(Connection informixConnection, InterventionAccepted interventionAccepted) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        ReferencedProviderContact referencedProviderContact;
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (interventionAccepted.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, interventionAccepted.getAggregateUid());
                if (interventionAccepted.getAssignee() instanceof ReferencedProviderContact) {
                    referencedProviderContact = (ReferencedProviderContact)interventionAccepted.getAssignee();
                    preparedStatement.setString(2, referencedProviderContact.getProviderContactUid());
                }else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(3, 77);
                preparedStatement.setString(4, interventionAccepted.getComment());
                dateTime = isoDateTimeFormat1.parseDateTime(interventionAccepted.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      InterventionAccepted:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }
    
    /**
     * Traite l'�v�nement MessageAdded
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param messageAdded �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processMessageAdded(Connection informixConnection, MessageAdded messageAdded) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        SqlResults sqlResults;

        int retcode = 0;

        if (messageAdded.getOperator() instanceof ReferencedUser) {
            try {
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, messageAdded.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, -1);
                preparedStatement.setString(4, messageAdded.getMessage());
                dateTime = isoDateTimeFormat1.parseDateTime(messageAdded.getMessageAddedDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      MessageAdded:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement ProviderAssigned
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param providerAssigned �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processProviderAssigned(Connection informixConnection, ProviderAssigned providerAssigned) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        Provider provider;
        ProviderAssignationPurpose providerAssignationPurpose;
        String comment;

        int retcode = 0;
        SqlResults sqlResults;

        if (providerAssigned.getOperator() instanceof ReferencedUser) {
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
                dateTime = isoDateTimeFormat1.parseDateTime(providerAssigned.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      ProviderAssigned:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }


    /**
     * Traite l'�v�nement AssigneeIdentified
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param assigneeIdentified �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processAssigneeIdentified(Connection informixConnection, AssigneeIdentified assigneeIdentified) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        TicketAssignee ticketAssignee;
        ProviderAssignationPurpose providerAssignationPurpose;
        String comment;
        SqlResults sqlResults;

        int retcode;
        
        resultSet = null;
        preparedStatement = null;
        retcode = 0;
        
        if (assigneeIdentified.getOperator() instanceof ReferencedUser) {
            try {
                informixConnection.setAutoCommit(false);
                
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, assigneeIdentified.getAggregateUid());
                ticketAssignee = assigneeIdentified.getTicketAssignee();
                if (ticketAssignee instanceof ReferencedProviderContact) {
                    preparedStatement.setString(2, ((ReferencedProviderContact) ticketAssignee).getProviderContactUid());
                } else {
                    preparedStatement.setNull(2, java.sql.Types.INTEGER);
                }
                preparedStatement.setInt(3, 22);
                comment = assigneeIdentified.getComment();
                if (comment == null) {
                    preparedStatement.setNull(4, java.sql.Types.CHAR);
                } else if ("comment".equals(comment)) {
                    preparedStatement.setNull(4, java.sql.Types.CHAR);
                } else {
                    preparedStatement.setString(4, comment);
                }
                dateTime = isoDateTimeFormat1.parseDateTime(assigneeIdentified.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
                
                if (retcode == 1) {
                    preparedStatement = informixConnection.prepareStatement("{call restCall(?, ?, ?, ?)}");
                    preparedStatement.setString(1, assigneeIdentified.getAggregateUid());
                    dateTime = isoDateTimeFormat1.parseDateTime(assigneeIdentified.getDate());
                    preparedStatement.setTimestamp(2, new Timestamp(dateTime.getMillis()));
                    preparedStatement.setInt(3, onum);
                    preparedStatement.setInt(4, 0);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults = new SqlResults(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials += sqlResults.getNbTrials();
                    }
//                    resultSet.close();
//                    preparedStatement.close();
                }
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
            finally {
                try {
                    if (retcode == 1) {
                        informixConnection.commit();
                    }
                    else {
                        informixConnection.rollback();
                    }
                    
                    if (resultSet != null) {
                        resultSet.close();
                    }

                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    
                    informixConnection.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      AssigneeIdentified:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * Traite l'�v�nement TicketCanceled
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ticketCancelled �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processTicketCancelled(Connection informixConnection, TicketCancelled ticketCancelled) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;
        int nbTrials = 0;
        ProviderAssignationPurpose providerAssignationPurpose;
        String comment;
        SqlResults sqlResults;

        int retcode;
        
        resultSet = null;
        preparedStatement = null;
        retcode = 0;
        
        if (ticketCancelled.getOperator() instanceof ReferencedUser) {
            try {
                informixConnection.setAutoCommit(false);
                
                preparedStatement = informixConnection.prepareStatement("{call addLogTrial(?, ?, ?, ?, ?, ?, ?, ?)}");
                preparedStatement.setString(1, ticketCancelled.getAggregateUid());
                preparedStatement.setNull(2, java.sql.Types.INTEGER);
                preparedStatement.setInt(3, 10);
                comment = ticketCancelled.getComment();
                if (comment == null) {
                    preparedStatement.setNull(4, java.sql.Types.CHAR);
                } else if ("comment".equals(comment)) {
                    preparedStatement.setNull(4, java.sql.Types.CHAR);
                } else {
                    preparedStatement.setString(4, comment);
                }
                dateTime = isoDateTimeFormat1.parseDateTime(ticketCancelled.getDate());
                preparedStatement.setTimestamp(5, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(6, onum);
                preparedStatement.setInt(7, 0);
                preparedStatement.setInt(8, 0);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    sqlResults = new SqlResults(resultSet);
                    retcode = sqlResults.getRetcode();
                    nbTrials = sqlResults.getNbTrials();
                }
                resultSet.close();
                preparedStatement.close();
                
                if (retcode == 1) {
                    preparedStatement = informixConnection.prepareStatement("{call archCall(?, ?, ?, ?, ?)}");
                    preparedStatement.setString(1, ticketCancelled.getAggregateUid());
                    dateTime = isoDateTimeFormat1.parseDateTime(ticketCancelled.getDate());
                    preparedStatement.setTimestamp(2, new Timestamp(dateTime.getMillis()));
                    preparedStatement.setInt(3, onum);
                    preparedStatement.setInt(4, 0);
                    preparedStatement.setInt(5, 1);
                    resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        sqlResults = new SqlResults(resultSet);
                        retcode = sqlResults.getRetcode();
                        nbTrials += sqlResults.getNbTrials();
                    }
//                    resultSet.close();
//                    preparedStatement.close();
                }
            } catch (SQLException exception) {
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
                retcode = -1;
            }
            finally {
                try {
                    if (retcode == 1) {
                        informixConnection.commit();
                    }
                    else {
                        informixConnection.rollback();
                    }
                    
                    if (resultSet != null) {
                        resultSet.close();
                    }

                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    
                    informixConnection.setAutoCommit(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            System.out.println("    ERREUR : �v�nement rejet�, raison : g�n�r� par Anstel");
            retcode = -3;
        }

        System.out.println("      TicketCanceled:{retcode:" + retcode + ", nbTrials:" + nbTrials + "}");

        return retcode;
    }

    /**
     * @param mongoDbServerType d�finit le serveur Web
     */
    private void setMongoDbServerType(String mongoDbServerType) {
        this.mongoDbServerType = mongoDbServerType;
    }

    /**
     * @param informixDbServerType d�finit le serveur de base de donn�es
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
     * @return informixDbServerType le serveur de base de donn�es
     */
    private String getInformixDbServerType() {
        return (informixDbServerType);
    }

    /**
     * @return la dur�e de r�tention, exprim�e en jours, des �v�nements en base
     * de donn�es.
     */
    public int getRetention() {
        return retention;
    }

    /**
     * @param retention d�finit la dur�e de r�tention, exprim�e en jours, des
     * �v�nements en base de donn�es.
     */
    public void setRetention(int retention) {
        this.retention = retention;
    }

    /**
     * D�finit la dur�e de r�tention, exprim�e en jours, des �v�nements en base
     * de donn�es � partir des propri�t�s du programme.
     *
     * @param ServerType type of server : dev/pre-prod/prod.
     * @param service service on server.
     * @param applicationProperties Application properties.
     */
    public void setRetention(String ServerType, String service, ApplicationProperties applicationProperties) {
        String value;
        String errmsg;

        value = applicationProperties.getProperty(ServerType + "." + service + ".retention");
        if (value != null) {
            try {
                setRetention(Integer.parseInt(value));
            } catch (Exception MyException) {
                errmsg = "Mauvaise valeur du param�tre de retention:" + value
                        + ", conservation de la valeur par d�faut:"
                        + retention + " jour(s), " + MyException;
                Logger.getLogger(Bkgpi2a.class.getName()).log(Level.WARNING, errmsg);
            }
        } else {
            errmsg = "Retention non d�finie dans le fichier des propri�t�s"
                    + ", conservation de la valeur par d�faut:" + retention + " jour(s)";
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.WARNING, errmsg);
        }
    }

    /**
     * Retourne le contenu de Bkgpi2a
     *
     * @return retourne le contenu de Bkgpi2a
     */
    @Override
    public String toString() {
        return "Bkgpi2a:{webServer=" + getMongoDbServerType()
                + ", dbServer=" + getInformixDbServerType()
                + "}";
    }

    /**
     * Programme principal pour lancer Bkgpi2a.
     *
     * @param args param�tre de ligne de commande (cf. constructeur).
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
            System.out.println("Probl�me lors de l'instanciation de Bkgpi2a");
            exception.printStackTrace();
        }

        System.out.println("Fin de Bkgpi2a");
    }

    /**
     * @return les identifiants pour acc�der au serveur Web
     */
    public Identifiants getMongoDbId() {
        return mongoDbId;
    }

    /**
     * @param mongoDbId d�finit les identifiants pour acc�der au serveur Web
     */
    public void setMongoDbId(Identifiants mongoDbId) {
        this.mongoDbId = mongoDbId;
    }

    /**
     * @param applicationProperties d�finit les identifiants pour acc�der au
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
//            throw new WebServerException("Nom utilisateur pour l'acc�s Web non d�fini");
//        }
//
//        value = applicationProperties.getProperty(getMongoDbServerType() + ".webserver.passwd");
//        if (value != null) {
//            identifiants.setPassword(value);
//        } else {
//            throw new WebServerException("Mot de passe pour l'acc�s Web non d�fini");
//        }
//        Bkgpi2a.this.setMongoDbId(identifiants);
//    }
    /**
     * @return les identifiants pour acc�der � la base de donn�es
     */
    public Identifiants getInformixDbId() {
        return informixDbId;
    }

    /**
     * @param informixDbId d�finit les identifiants pour acc�der � la base de
     * donn�es
     */
    public void setInformixDbId(Identifiants informixDbId) {
        this.informixDbId = informixDbId;
    }

    /**
     * @param applicationProperties d�finit les identifiants pour acc�der au
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
//            throw new WebServerException("Nom utilisateur pour l'acc�s base de donn�es non d�fini");
//        }
//
//        value = applicationProperties.getProperty(getInformixDbServerType() + ".dbserver.passwd");
//        if (value != null) {
//            identifiants.setPassword(value);
//        } else {
//            throw new WebServerException("Mot de passe pour l'acc�s base de donn�es non d�fini");
//        }
//        Bkgpi2a.this.setInformixDbId(identifiants);
//    }
    /**
     * @param debugMode : fonctionnement du programme en mode debug
     * (true/false).
     */
    public void setDebugMode(boolean debugMode) {
        Bkgpi2a.debugMode = debugMode;
    }

    /**
     * @param testMode : fonctionnement du programme en mode test (true/false).
     */
    public void setTestMode(boolean testMode) {
        Bkgpi2a.testMode = testMode;
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
