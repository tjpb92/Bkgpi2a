package bkgpi2a;

import com.anstel.ticketEvents.TicketOpened;
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
 * Programme de test de la classe TicketOpened
 *
 * @author Thierry Baribaud
 * @version 1.42.22
 */
public class TicketOpenedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketOpenedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketOpened.
     */
    @Test
    public void testTicketOpenedJsonSerialization() {
        System.out.println("TicketOpenedJsonSerialization");

        String filename = "TicketOpened.json";
        String testFilename = "testTicketOpened.json";
        TicketOpened ticketOpened = null;
        TicketOpened expTicketOpened = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketOpened = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("ticketOpened:" + ticketOpened);
            objectMapper.writeValue(new File(testFilename), ticketOpened);
            expTicketOpened = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("expTicketOpened:" + expTicketOpened);
            assertNotNull(ticketOpened);
            assertNotNull(expTicketOpened);
            
            assertNotNull(expTicketOpened.getOpenedDate());
            assertNull(expTicketOpened.getDate());
            
            assertEquals(ticketOpened.toString(), expTicketOpened.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
