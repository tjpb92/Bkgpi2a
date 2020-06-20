package bkgpi2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme de test de la classe NotificationForInterventionAcceptedRequested
 *
 * @author Thierry Baribaud
 * @version 1.34
 */
public class NotificationForInterventionAcceptedRequestedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public NotificationForInterventionAcceptedRequestedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * NotificationForInterventionAcceptedRequestedTest.
     */
    @Test
    public void testNotificationForInterventionAcceptedRequestedJsonSerialization() {
        System.out.println("NotificationForInterventionAcceptedRequestedJsonSerialization");

        String filename = "NotificationForInterventionAcceptedRequested.json";
        String testFilename = "testNotificationForInterventionAcceptedRequested.json";
        NotificationForInterventionAcceptedRequested notificationForInterventionAcceptedRequested = null;
        NotificationForInterventionAcceptedRequested expNotificationForInterventionAcceptedRequested = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            notificationForInterventionAcceptedRequested = objectMapper.readValue(new File(filename), NotificationForInterventionAcceptedRequested.class);
            System.out.println("notificationForInterventionAcceptedRequested:" + notificationForInterventionAcceptedRequested);
            objectMapper.writeValue(new File(testFilename), notificationForInterventionAcceptedRequested);
            expNotificationForInterventionAcceptedRequested = objectMapper.readValue(new File(filename), NotificationForInterventionAcceptedRequested.class);
            System.out.println("expNotificationForInterventionAcceptedRequestedt:" + expNotificationForInterventionAcceptedRequested);
        } catch (IOException ex) {
            Logger.getLogger(NotificationForInterventionAcceptedRequested.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(notificationForInterventionAcceptedRequested);
        assertNotNull(expNotificationForInterventionAcceptedRequested);
        assertEquals(notificationForInterventionAcceptedRequested.toString(), expNotificationForInterventionAcceptedRequested.toString());
    }

}
