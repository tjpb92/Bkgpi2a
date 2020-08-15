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
 * Programme de test de la classe TicketOpenedFromSimplifiedRequestTest
 *
 * @author Thierry Baribaud
 * @version 1.35
 */
public class TicketOpenedFromSimplifiedRequestTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketOpenedFromSimplifiedRequestTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketOpenedFromSimplifiedRequest.
     */
    @Test
    public void testTicketOpenedFromSimplifiedRequestJsonSerialization() {
        System.out.println("TicketOpenedFromSimplifiedRequestJsonSerialization");

        String filename = "TicketOpenedFromSimplifiedRequest.json";
        String testFilename = "testTicketOpenedFromSimplifiedRequest.json";
        TicketOpenedFromSimplifiedRequest ticketOpenedFromSimplifiedRequest = null;
        TicketOpenedFromSimplifiedRequest expTicketOpenedFromSimplifiedRequest = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketOpenedFromSimplifiedRequest = objectMapper.readValue(new File(filename), TicketOpenedFromSimplifiedRequest.class);
            System.out.println("ticketOpenedFromSimplifiedRequest:" + ticketOpenedFromSimplifiedRequest);
            objectMapper.writeValue(new File(testFilename), ticketOpenedFromSimplifiedRequest);
            expTicketOpenedFromSimplifiedRequest = objectMapper.readValue(new File(filename), TicketOpenedFromSimplifiedRequest.class);
            System.out.println("expTicketOpenedFromSimplifiedRequest:" + expTicketOpenedFromSimplifiedRequest);
        } catch (IOException ex) {
            Logger.getLogger(DocumentAttached.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(ticketOpenedFromSimplifiedRequest);
        assertNotNull(expTicketOpenedFromSimplifiedRequest);
        assertEquals(ticketOpenedFromSimplifiedRequest.toString(), expTicketOpenedFromSimplifiedRequest.toString());
    }

}
