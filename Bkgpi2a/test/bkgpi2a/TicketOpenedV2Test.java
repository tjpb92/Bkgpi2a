package bkgpi2a;

import com.anstel.ticketEvents.TicketOpened;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme de test de la classe TicketOpened version V2 after issue#42
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 */
public class TicketOpenedV2Test {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketOpenedV2Test() {
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
     * Test of serialization from and to a file in Json format, of class
     * TicketOpened. Works with TicketOpened V1 version and version V1 json
     * file (after issue#42).
     */
    @Test
    public void testTicketOpenedV2vsV1JsonSerialization() {
        System.out.println("TicketOpenedV2vsV1JsonSerialization");

        String filename = "TicketOpened.json";
        String testFilename = "testTicketOpened_v2vsv1.json";
        TicketOpened agencyAbstract = null;
        TicketOpened expTicketOpened = null;

        try {
            agencyAbstract = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("agencyAbstract:" + agencyAbstract);
            objectMapper.writeValue(new File(testFilename), agencyAbstract);
            expTicketOpened = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("expTicketOpened:" + expTicketOpened);
            assertNotNull(agencyAbstract);
            assertNotNull(expTicketOpened);
            assertEquals(agencyAbstract.toString(), expTicketOpened.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpenedV2Test.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketOpened. Works with TicketOpened version V2 with V2 json file
     * (issue#42).
     */
    @Test
    public void testTicketOpenedV2tJsonSerialization() {
        System.out.println("TicketOpenedV2JsonSerialization");

        String filename = "TicketOpened_bug230321.json";
        String testFilename = "testTicketOpened_V2.json";
        TicketOpened agencyAbstract = null;
        TicketOpened expTicketOpened = null;

        try {
            agencyAbstract = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("agencyAbstract:" + agencyAbstract);
            objectMapper.writeValue(new File(testFilename), agencyAbstract);
            expTicketOpened = objectMapper.readValue(new File(filename), TicketOpened.class);
            System.out.println("expTicketOpened:" + expTicketOpened);
            assertNotNull(agencyAbstract);
            assertNotNull(expTicketOpened);
            assertEquals(agencyAbstract.toString(), expTicketOpened.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpenedV2Test.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }
}
