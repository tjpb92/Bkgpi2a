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
 * Programme de test de la classe TicketOpened version V1 before issue#42
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 */
public class TicketOpenedV1Test {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketOpenedV1Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketOpened.Works only with TicketOpened V1 version (before
     * issue#42).
     */
    @Test
    public void testTicketOpenedV1JsonSerialization() {
        System.out.println("TicketOpenedV1JsonSerialization");

        String filename = "TicketOpened.json";
        String testFilename = "testTicketOpened_V1.json";
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
            assertEquals(ticketOpened.toString(), expTicketOpened.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketOpened.Works only with TicketOpened V1 version with V2 json file 
     * (before issue#42).
     */
    @Test
    public void testTicketOpenedV1vsV2JsonSerialization() {
        System.out.println("TicketOpenedV1vsV2JsonSerialization");

        String filename = "TicketOpened_bug230321.json";
        String testFilename = "testTicketOpened_V1vsV2.json";
        TicketOpened ticketOpened = null;
        TicketOpened expTicketOpened = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketOpened = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("ticketOpened:" + ticketOpened);
            fail("Une exception était attendue");
            objectMapper.writeValue(new File(testFilename), ticketOpened);
            expTicketOpened = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("expTicketOpened:" + expTicketOpened);
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            assertNotNull(ex);
        }
    }
}
