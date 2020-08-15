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
 * Programme de test de la classe TicketQualifiedByCriteria
 *
 * @author Thierry Baribaud
 * @version 1.35
 */
public class TicketQualifiedByCriteriaTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketQualifiedByCriteriaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketQualifiedByCriteria.
     */
    @Test
    public void testTicketQualifiedByCriteriaJsonSerialization() {
        System.out.println("TicketQualifiedByCriteriaJsonSerialization");

        String filename = "TicketQualifiedByCriteria.json";
        String testFilename = "testTicketQualifiedByCriteria.json";
        TicketQualifiedByCriteria ticketQualifiedByCriteria = null;
        TicketQualifiedByCriteria expTicketQualifiedByCriteria = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketQualifiedByCriteria = objectMapper.readValue(new File(filename), TicketQualifiedByCriteria.class);
            System.out.println("ticketQualifiedByCriteria:" + ticketQualifiedByCriteria);
            objectMapper.writeValue(new File(testFilename), ticketQualifiedByCriteria);
            expTicketQualifiedByCriteria = objectMapper.readValue(new File(filename), TicketQualifiedByCriteria.class);
            System.out.println("expTicketQualifiedByCriteria:" + expTicketQualifiedByCriteria);
        } catch (IOException ex) {
            Logger.getLogger(TicketQualifiedByCriteria.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(ticketQualifiedByCriteria);
        assertNotNull(expTicketQualifiedByCriteria);
        assertEquals(ticketQualifiedByCriteria.toString(), expTicketQualifiedByCriteria.toString());
    }

}
