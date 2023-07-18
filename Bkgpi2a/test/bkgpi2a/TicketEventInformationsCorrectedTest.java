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
 * Programme de test de la classe TicketOpened
 *
 * @author Thierry Baribaud
 * @version 1.42.5
 */
public class TicketEventInformationsCorrectedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketEventInformationsCorrectedTest() {
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
    public void testTicketEventInformationsCorrectedJsonSerialization() {
        System.out.println("TicketEventInformationsCorrectedJsonSerialization");

        String filename = "TicketEventInformationsCorrected.json";
        String testFilename = "testTicketEventInformationsCorrected.json";
        TicketEventInformationsCorrected ticketEventInformationsCorrected = null;
        TicketEventInformationsCorrected expTicketEventInformationsCorrected = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketEventInformationsCorrected = objectMapper.readValue(new File(filename), TicketEventInformationsCorrected.class);
            System.out.println("ticketEventInformationsCorrected:" + ticketEventInformationsCorrected);
            objectMapper.writeValue(new File(testFilename), ticketEventInformationsCorrected);
            expTicketEventInformationsCorrected = objectMapper.readValue(new File(filename), TicketEventInformationsCorrected.class);
            System.out.println("expTicketEventInformationsCorrected:" + expTicketEventInformationsCorrected);
            assertNotNull(ticketEventInformationsCorrected);
            assertNotNull(expTicketEventInformationsCorrected);
            assertEquals(ticketEventInformationsCorrected.toString(), expTicketEventInformationsCorrected.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
