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
 * Programme de test de la classe TicketOpened par rapport au bug du 10/09/2020
 * touchant la déserialisation.
 *
 * @author Thierry Baribaud
 * @version 1.39
 */
public class Bug200910TOTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Bug200910TOTest() {
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
        System.out.println("Bug200910TOJsonSerialization");

        String filename = "Bug200910TO.json";
        String testFilename = "testBug200910TO.json";
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
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(ticketOpened);
        assertNotNull(expTicketOpened);
        assertEquals(ticketOpened.toString(), expTicketOpened.toString());
    }

}
