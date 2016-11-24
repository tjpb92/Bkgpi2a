package bkgpi2a;

import bdd.EtatTicket;
import bdd.Fcalls;
import bdd.FcallsDAO;
import bdd.Furgent;
import bdd.FurgentDAO;
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
 * @version 0.291
 */
public class Bkgpi2a {

    /**
     * Pour convertir les datetimes du format texte au format DateTime
     */
    private static final DateTimeFormatter format = ISODateTimeFormat.dateTimeParser();
//    private static final DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    
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

        System.out.println("Lecture des param�tres d'ex�cution ...");
        applicationProperties = new ApplicationProperties("MyDatabases.prop");

        System.out.println("Lecture des param�tres du serveur MongoDb ...");
        mongoServer = new DBServer(getMongoDbServerType(), "mgodb", applicationProperties);
        System.out.println(mongoServer);
//        setMongoDbId(applicationProperties);
//        System.out.println(getMongoDbId());

        System.out.println("Lecture des param�tres du serveur Informix ...");
        informixServer = new DBServer(getInformixDbServerType(), "ifxdb", applicationProperties);
        System.out.println(informixServer);
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

//        System.out.println("Synchronisation des soci�t�s ...");
//        splTester(informixConnection);
    }

    /**
     * M�thode pour tester l'utilisation de proc�dures stock�es depuis Java
     *
     * @param informixConnection connexion � la base de donn�es Informix
     */
    public void splTester(Connection informixConnection) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Timestamp timestamp;

        timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("timestamp:" + timestamp);
        try {
//            preparedStatement = informixConnection.prepareStatement("{call addMessage(?, ?, ?)}");
//            preparedStatement.setInt(1, 4828941);
//            preparedStatement.setString(2, "Les sanglots longs Des violons De l'automne Blessent mon coeur D'une langueur Monotone. Tout suffocant Et blême, quand Sonne l'heure, Je me souviens Des jours anciens Et je pleure Et je m'en vais Au vent mauvais Qui m'emporte Deç�, del�, Pareil � la Feuille morte.");
//            preparedStatement.setTimestamp(3, timestamp);
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                System.out.println("retcode:" + resultSet.getInt(1));
//            }
//            resultSet.close();
//            preparedStatement.close();
            preparedStatement = informixConnection.prepareStatement("{call findCall(?, ?)}");
            preparedStatement.setString(1, "49");
            preparedStatement.setInt(2, 635);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("retcode:" + resultSet.getInt(1)
                        + ", table:" + resultSet.getInt(2)
                        + ", cnum:" + resultSet.getInt(3));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * M�thode pour synchroniser les �v�nements par rapport � la base de donn�es
     * Informix.
     */
    private void syncEvents(MongoDatabase mongoDatabase, Connection informixConnection) {
        Furgent emergencyService;
        FurgentDAO furgentDAO;
        int i;
        String aggregateUid;
        MongoCollection<Document> collection;
        MongoCursor<Document> cursor;
        int n;
        ObjectMapper objectMapper;
        Event event;
        int nbEvent;
        BasicDBObject filter;
        UpdateResult updateResult;
        int retcode;
        
        objectMapper = new ObjectMapper();

        collection = mongoDatabase.getCollection("events");
        System.out.println(collection.count() + " �v�n�ment(s) dans la base MongoDb");

        try {
            nbEvent = 0;
            filter = new BasicDBObject("status", 0);
            cursor = collection.find(filter).iterator();
            while (cursor.hasNext()) {
                nbEvent++;
                event = objectMapper.readValue(cursor.next().toJson(), Event.class);
                System.out.println("  �v�nement trouv� : " + event.getEventType()
                        + ", aggregateUid:" + event.getAggregateUid()
                        + ", processUid:" + event.getProcessUid());
                if (event instanceof MessageAdded) {
                    retcode = processMessageAdded(informixConnection, (MessageAdded) event);
                    }
                else if (event instanceof ProviderAssigned) {
                    retcode = processProviderAssigned(informixConnection, (ProviderAssigned) event);
                    }
                }
        } catch (IOException ex) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//            furgentDAO = new FurgentDAO(informixConnection);
//            furgentDAO.orderBy("unum");
//            System.out.println("  SelectStatement=" + furgentDAO.getSelectStatement());
//            furgentDAO.setSelectPreparedStatement();
//            i = 0;
//            nbEvent = 0;
//            while ((emergencyService = furgentDAO.select()) != null) {
//                i++;
//                System.out.println("Client(" + i + ")=" + emergencyService);
//                aggregateUid = Md5.encode("u:" + emergencyService.getUnum());
////                System.out.println("  aggregateUid:" + aggregateUid);
//                filter = new BasicDBObject("uid", aggregateUid);
////                cursor = collection.find(filter).iterator();
////                if (cursor.hasNext()) {
////                    nbCompany++;
////                    company = objectMapper.readValue(cursor.next().toJson(), Company.class);
////                    updateResult = collection.updateOne(filter, new BasicDBObject("$set", new BasicDBObject("id", emergencyService.getUnum())));
////                    System.out.println("  trouv� : " + company.getLabel() + ", uid:" + company.getUid() + ", updateResult:" + updateResult);
////                }
//                updateResult = collection.updateOne(filter, new BasicDBObject("$set", new BasicDBObject("id", emergencyService.getUnum())));
//                if (updateResult.getMatchedCount() > 0) {
//                    nbEvent++;
//                    System.out.println("  trouv� : updateResult:" + updateResult);
//                }
//            }
//            furgentDAO.closeSelectPreparedStatement();
//            System.out.println(i + " client(s) lu(s), " + nbEvent + " soci�t�(s) trouv�e(s)");
//
//        } catch (ClassNotFoundException exception) {
//            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
//        } catch (SQLException exception) {
//            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
//        }

    /**
     * Traite l'�v�nement MessageAdded
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param messageAdded �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processMessageAdded(Connection informixConnection, MessageAdded messageAdded) {
        int retcode = 0;

        if ((retcode = processMessageAdded_00(informixConnection, messageAdded)) == 0) {
            retcode = processMessageAdded_99(informixConnection, messageAdded);
        }

        return retcode;
    }

    /**
     * Traite l'�v�nement MessageAdded sur les tickets en cours
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param messageAdded �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processMessageAdded_00(Connection informixConnection, MessageAdded messageAdded) {
        Fcalls fcalls;
        FcallsDAO fcallsDAO;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;

        int retcode = 0;

        try {
            fcallsDAO = new FcallsDAO(informixConnection, EtatTicket.EN_COURS);
            fcallsDAO.filterByUuid(messageAdded.getAggregateUid());
//                    System.out.println("    " + fcallsDAO.getSelectStatement());
            fcallsDAO.setSelectPreparedStatement();
            fcalls = fcallsDAO.select();
            fcallsDAO.closeSelectPreparedStatement();
            if (fcalls != null) {
                System.out.println("    ticket en cours associ� : " + fcalls);
                System.out.println("    message : " + messageAdded.getMessage());
                
                preparedStatement = informixConnection.prepareStatement("{call addMessage(?, ?, ?, ?, ?)}");
                preparedStatement.setInt(1, fcalls.getCnum());
                preparedStatement.setString(2, new String (messageAdded.getMessage().getBytes(), "ISO-8859-15" ));
                dateTime = format.parseDateTime(messageAdded.getMessageAddedDate());
                preparedStatement.setTimestamp(3, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(4, onum);
                preparedStatement.setInt(5, fcalls.getCunum());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    retcode = resultSet.getInt(1);
                    System.out.println("      AddMessage:{retcode:" + retcode + ", nbTrials:" + resultSet.getInt(2) + "}");
                }
                resultSet.close();
                preparedStatement.close();
            
//                retcode = 1;
            }
        } catch (ClassNotFoundException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        } catch (UnsupportedEncodingException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        return retcode;
    }

    /**
     * Traite l'�v�nement MessageAdded sur les tickets archiv�s
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param messageAdded �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processMessageAdded_99(Connection informixConnection, MessageAdded messageAdded) {
        Fcalls fcalls;
        FcallsDAO fcallsDAO;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        DateTime dateTime;

        int retcode = 0;

        try {
            fcallsDAO = new FcallsDAO(informixConnection, EtatTicket.ARCHIVE);
            fcallsDAO.filterByUuid(messageAdded.getAggregateUid());
//                    System.out.println("    " + fcallsDAO.getSelectStatement());
            fcallsDAO.setSelectPreparedStatement();
            fcalls = fcallsDAO.select();
            fcallsDAO.closeSelectPreparedStatement();
            if (fcalls != null) {
                System.out.println("    ticket archiv� associ� : " + fcalls);
                
                preparedStatement = informixConnection.prepareStatement("{call add99Message(?, ?, ?, ?, ?)}");
                preparedStatement.setInt(1, fcalls.getCnum());
                preparedStatement.setString(2, new String (messageAdded.getMessage().getBytes(), "ISO-8859-15" ));
                dateTime = format.parseDateTime(messageAdded.getMessageAddedDate());
                preparedStatement.setTimestamp(3, new Timestamp(dateTime.getMillis()));
                preparedStatement.setInt(4, onum);
                preparedStatement.setInt(5, fcalls.getCunum());
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    retcode = resultSet.getInt(1);
                    System.out.println("      Add99Message:{retcode:" + retcode + ", nbTrials:" + resultSet.getInt(2) + "}");
                }
                resultSet.close();
                preparedStatement.close();
            
//                retcode = 1;
            }
        } catch (ClassNotFoundException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, ex);
            retcode = -1;
        }

        return retcode;
    }

    /**
     * Traite l'�v�nement ProviderAssigned
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ProviderAssigned �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processProviderAssigned(Connection informixConnection, ProviderAssigned ProviderAssigned) {
        int retcode = 0;

        if ((retcode = processProviderAssigned_00(informixConnection, ProviderAssigned)) == 0) {
            retcode = processProviderAssigned_99(informixConnection, ProviderAssigned);
        }

        return retcode;
    }

    /**
     * Traite l'�v�nement ProviderAssigned sur les tickets en cours
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ProviderAssigned �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processProviderAssigned_00(Connection informixConnection, ProviderAssigned ProviderAssigned) {
        Fcalls fcalls;
        FcallsDAO fcallsDAO;
        int retcode = 0;

        try {
            fcallsDAO = new FcallsDAO(informixConnection, EtatTicket.EN_COURS);
            fcallsDAO.filterByUuid(ProviderAssigned.getAggregateUid());
//                    System.out.println("    " + fcallsDAO.getSelectStatement());
            fcallsDAO.setSelectPreparedStatement();
            fcalls = fcallsDAO.select();
            fcallsDAO.closeSelectPreparedStatement();
            if (fcalls != null) {
                System.out.println("    ticket en cours associ� : " + fcalls);
                retcode = 1;
            }
        } catch (ClassNotFoundException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

        return retcode;
    }

    /**
     * Traite l'�v�nement ProviderAssigned sur les tickets archiv�s
     *
     * @param informixConnection connection � la base de donn�es Informix locale
     * @param ProviderAssigned �v�nement � traiter
     * @return code de retour : 1=Succ�s, 0=ne rien faire, -1=erreur
     */
    private int processProviderAssigned_99(Connection informixConnection, ProviderAssigned ProviderAssigned) {
        Fcalls fcalls;
        FcallsDAO fcallsDAO;
        int retcode = 0;

        try {
            fcallsDAO = new FcallsDAO(informixConnection, EtatTicket.ARCHIVE);
            fcallsDAO.filterByUuid(ProviderAssigned.getAggregateUid());
//                    System.out.println("    " + fcallsDAO.getSelectStatement());
            fcallsDAO.setSelectPreparedStatement();
            fcalls = fcallsDAO.select();
            fcallsDAO.closeSelectPreparedStatement();
            if (fcalls != null) {
                System.out.println("    ticket archiv� associ� : " + fcalls);
                retcode = 1;
            }
        } catch (ClassNotFoundException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        } catch (SQLException exception) {
            Logger.getLogger(Bkgpi2a.class.getName()).log(Level.SEVERE, null, exception);
            retcode = -1;
        }

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
     * Retourne le contenu de Bkgpi2a
     *
     * @return retourne le contenu de Bkgpi2a
     */
    @Override
    public String toString() {
        return "SyncCollections:{webServer=" + getMongoDbServerType()
                + ", dbServer=" + getInformixDbServerType() + "}";
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
            System.out.println(syncCollections);
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
}
