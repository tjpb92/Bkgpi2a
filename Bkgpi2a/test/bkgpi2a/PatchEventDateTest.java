package bkgpi2a;

import com.anstel.ticketEvents.BackupAssigneeIdentifiedTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.ApplicationProperties;
import utils.DBServer;

/**
 * Programme de test de la méthode patchEventDate() de Bkgpi2a.
 *
 * @author Thierry Baribaud
 * @version 1.42.19
 */
public class PatchEventDateTest {

    private static final DateTimeFormatter isoDateTimeFormat2 = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private final static DateTime NOW = new DateTime();
    private final static String EXP_DATE = NOW.toString(isoDateTimeFormat2);
    private final static String EXP_SENTDATE = NOW.plusMinutes(5).plusSeconds(25).toString(isoDateTimeFormat2);

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public PatchEventDateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Méthode retournant la meilleure result_date pour un événement. Le choix
     * se fait entre result_date et sentDate qui peuvent être définis ou pas,
     * initialisé ou pas, existant ou pas. Le choix de prendre la date courante
     * UTC dans le cas ou aucune des dates n'est connue est discutable. Il
     * faudra monitorer ce cas de figure dans dailyMonitor.
     */
    @Test
    public void testPatchEventDate() {
        ClosedBeyondCallCenterScope closedBeyondCallCenterScope;
        String expDate;
        String expSentDate;
        String result_date;

        System.out.println("PatchEventDate");

        System.out.println("NOW:" + NOW.toString());
        System.out.println("EXP_DATE:" + EXP_DATE);
        System.out.println("EXP_SENTDATE:" + EXP_SENTDATE);

        expDate = EXP_DATE;
        expSentDate = EXP_SENTDATE;

        closedBeyondCallCenterScope = new ClosedBeyondCallCenterScope();
        closedBeyondCallCenterScope.setDate(expDate);
        closedBeyondCallCenterScope.setSentDate(expSentDate);
        result_date = Bkgpi2a.patchEventDate(closedBeyondCallCenterScope);
        System.out.println("result_date(defined, defined):" + result_date);
        assertEquals(expDate, result_date);

        closedBeyondCallCenterScope.setDate(null);
        closedBeyondCallCenterScope.setSentDate(expSentDate);
        result_date = Bkgpi2a.patchEventDate(closedBeyondCallCenterScope);
        System.out.println("result_date(null, defined):" + result_date);
        assertEquals(expSentDate, result_date);

        closedBeyondCallCenterScope.setDate(null);
        closedBeyondCallCenterScope.setSentDate(null);
        result_date = Bkgpi2a.patchEventDate(closedBeyondCallCenterScope);
        System.out.println("result_date(null, null):" + result_date);
        assertNotNull(result_date);
    }

    /**
     * Test avec quelques données réelles
     */
    @Test
    public void testWithRealData() {
        String[] args = {"-mgodb", "prod2", "-d"};
        GetArgs getArgs;
        DBServer mongoServer;
        MongoClient mongoClient;
        MongoDatabase mongoDatabase;
        ApplicationProperties applicationProperties;
        boolean debugMode;
        MongoCollection<Document> collection;
        MongoCursor<Document> cursor;
        Event event;
        int nbEvent;
//        BasicDBObject filter1;
//        BasicDBObject filter2;
        BasicDBObject orderBy;
//        UpdateResult updateResult;
//        int retcode = 0;
//        int nbError = 0;
//        int status = 0;
        String patchedDate;

        System.out.println("Test with real data");

        try {
            System.out.println("Analyse des arguments de la ligne de commande ...");
            getArgs = new GetArgs(args);
            System.out.println(getArgs);
            assertNotNull(getArgs);
            debugMode = getArgs.getDebugMode();

            System.out.println("Lecture des paramètres d'exécution ...");
            applicationProperties = new ApplicationProperties("Bkgpi2a.prop");

            System.out.println("Lecture des paramètres du serveur MongoDb ...");
            mongoServer = new DBServer(getArgs.getMongoDbServerType(), "mgodb", applicationProperties);
            if (debugMode) {
                System.out.println(mongoServer);
            }
            System.out.println("Ouverture de la connexion au serveur MongoDb : " + mongoServer.getName());
            mongoClient = new MongoClient(mongoServer.getIpAddress(), (int) mongoServer.getPortNumber());

            System.out.println("Connexion à la base de données : " + mongoServer.getDbName());
            mongoDatabase = mongoClient.getDatabase(mongoServer.getDbName());

            collection = mongoDatabase.getCollection("events");
            System.out.println(collection.count() + " événément(s) dans la base MongoDb");

            nbEvent = 0;
//            filter1 = new BasicDBObject("sentDate", "/2024-01-26/");
            orderBy = new BasicDBObject("aggregateUid", 1).append("sentDate", 1);
//            cursor = collection.find(filter1).sort(orderBy).iterator();
            cursor = collection.find().sort(orderBy).iterator();
            while (cursor.hasNext() && nbEvent < 2000) {
                nbEvent++;
                event = objectMapper.readValue(cursor.next().toJson(), Event.class);
                patchedDate = Bkgpi2a.patchEventDate(event);
                System.out.println("événement #" + nbEvent + " : "
                        + event.getEventType()
                        + ", processUid:" + event.getProcessUid()
                        + ", date:" + event.getDate()
                        + ", sentDate:" + event.getSentDate()
                        + ", patchedDate:" + patchedDate);
                }
        } catch (Exception ex) {
            Logger.getLogger(BackupAssigneeIdentifiedTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
