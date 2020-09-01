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
 * Programme de test de la classe AccessRestrictedToTicket
 *
 * @author Thierry Baribaud
 * @version 1.38
 */
public class AccessRestrictedToTicketTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public AccessRestrictedToTicketTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * AccessRestrictedToTicket.
     */
    @Test
    public void testAccessRestrictedToTicketJsonSerialization() {
        System.out.println("AccessRestrictedToTicketJsonSerialization");

        String filename = "AccessRestrictedToTicket.json";
        String testFilename = "testAccessRestrictedToTicket.json";
        AccessRestrictedToTicket accessRestrictedToTicket = null;
        AccessRestrictedToTicket expAccessRestrictedToTicket = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            accessRestrictedToTicket = objectMapper.readValue(new File(filename), AccessRestrictedToTicket.class);
            System.out.println("accessRestrictedToTicket:" + accessRestrictedToTicket);
            objectMapper.writeValue(new File(testFilename), accessRestrictedToTicket);
            expAccessRestrictedToTicket = objectMapper.readValue(new File(filename), AccessRestrictedToTicket.class);
            System.out.println("expAccessRestrictedToTicket:" + expAccessRestrictedToTicket);
        } catch (IOException ex) {
            Logger.getLogger(AccessRestrictedToTicket.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(accessRestrictedToTicket);
        assertNotNull(expAccessRestrictedToTicket);
        assertEquals(accessRestrictedToTicket.toString(), expAccessRestrictedToTicket.toString());
    }

}
