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
 * Programme de test de la classe ProviderContactResultView
 *
 * @author Thierry Baribaud
 * @version 1.23
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

        try {
            dissociateProviderContactFromPatrimony = objectMapper.readValue(new File(filename), DissociateProviderContactFromPatrimony.class);
            System.out.println("dissociateProviderContactFromPatrimony:" + dissociateProviderContactFromPatrimony.getPatrimonyUid());
            objectMapper.writeValue(new File(testFilename), dissociateProviderContactFromPatrimony);
            expDissociateProviderContactFromPatrimony = objectMapper.readValue(new File(filename), DissociateProviderContactFromPatrimony.class);
            System.out.println("expDissociateProviderContactFromPatrimony:" + expDissociateProviderContactFromPatrimony.getPatrimonyUid());
        } catch (IOException ex) {
            Logger.getLogger(DissociateProviderContactFromPatrimonyTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(dissociateProviderContactFromPatrimony);
        assertNotNull(expDissociateProviderContactFromPatrimony);
        assertEquals(dissociateProviderContactFromPatrimony.toString(), expDissociateProviderContactFromPatrimony.toString());
    }

}
