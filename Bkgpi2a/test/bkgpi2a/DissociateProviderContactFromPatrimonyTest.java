package bkgpi2a;

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
 * Programme de test de la classe DissociateProviderContactFromPatrimony
 *
 * @author Thierry Baribaud
 * @version 1.20
 */
public class DissociateProviderContactFromPatrimonyTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public DissociateProviderContactFromPatrimonyTest() {
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
     * DissociateProviderContactFromPatrimony.
     */
    @Test
    public void testDissociateProviderContactFromPatrimonyJsonSerialization() {
        System.out.println("DissociateProviderContactFromPatrimonyJsonSerialization");

        String filename = "DissociateProviderContactFromPatrimony.json";
        String testFilename = "testDissociateProviderContactFromPatrimony.json";
        DissociateProviderContactFromPatrimony dissociateProviderContactFromPatrimony = null;
        DissociateProviderContactFromPatrimony expDissociateProviderContactFromPatrimony = null;
        String json;

        try {
            dissociateProviderContactFromPatrimony = objectMapper.readValue(new File(filename), DissociateProviderContactFromPatrimony.class);
            System.out.println("dissociateProviderContactFromPatrimony:" + dissociateProviderContactFromPatrimony);
            objectMapper.writeValue(new File(testFilename), dissociateProviderContactFromPatrimony);

            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dissociateProviderContactFromPatrimony);
            System.out.println("    json(dissociateProviderContactFromPatrimony):" + json);

            expDissociateProviderContactFromPatrimony = objectMapper.readValue(new File(filename), DissociateProviderContactFromPatrimony.class);
            System.out.println("expDissociateProviderContactFromPatrimony:" + expDissociateProviderContactFromPatrimony);
        } catch (IOException ex) {
            Logger.getLogger(DissociateProviderContactFromPatrimonyTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(dissociateProviderContactFromPatrimony);
        assertNotNull(expDissociateProviderContactFromPatrimony);
        assertEquals(dissociateProviderContactFromPatrimony.toString(), expDissociateProviderContactFromPatrimony.toString());
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * DissociateProviderContactFromPatrimony.
     */
    @Test
    public void testDissociateProviderContact() {
        String[] args = {"-d"};
        GetArgs getArgs;
        WebServer webServer;

        System.out.println("DissociateProviderContact");

        System.out.println("Analyse des arguments de la ligne de commande ...");
        try {
            getArgs = new GetArgs(args);
            System.out.println(getArgs);
            assertNotNull(getArgs);
            
        } catch (GetArgsException ex) {
            Logger.getLogger(DissociateProviderContactFromPatrimonyTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }

    }
}
