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
 * Programme de test de la classe ProviderContactDissociatedtFromPatrimony
 *
 * @author Thierry Baribaud
 * @version 1.23
 */
public class ProviderContactDissociatedFromPatrimonyTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderContactDissociatedFromPatrimonyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ProviderContactDissociatedtFromPatrimony.
     */
    @Test
    public void testProviderContactDissociatedtFromPatrimonyJsonSerialization() {
        System.out.println("ProviderContactDissociatedtFromPatrimonyJsonSerialization");

        String filename = "ProviderContactDissociatedFromPatrimony.json";
        String testFilename = "testProviderContactDissociatedFromPatrimony.json";
        ProviderContactDissociatedFromPatrimony providerContactDissociatedFromPatrimony = null;
        ProviderContactDissociatedFromPatrimony expProviderContactDissociatedFromPatrimony = null;

        try {
            providerContactDissociatedFromPatrimony = objectMapper.readValue(new File(filename), ProviderContactDissociatedFromPatrimony.class);
            System.out.println("providerContactDissociatedFromPatrimony:" + providerContactDissociatedFromPatrimony.getPatrimonyUid());
            objectMapper.writeValue(new File(testFilename), providerContactDissociatedFromPatrimony);
            expProviderContactDissociatedFromPatrimony = objectMapper.readValue(new File(filename), ProviderContactDissociatedFromPatrimony.class);
            System.out.println("expProviderContactDissociatedFromPatrimony:" + expProviderContactDissociatedFromPatrimony.getPatrimonyUid());
        } catch (IOException ex) {
            Logger.getLogger(ProviderContactDissociatedFromPatrimonyTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(providerContactDissociatedFromPatrimony);
        assertNotNull(expProviderContactDissociatedFromPatrimony);
        assertEquals(providerContactDissociatedFromPatrimony.toString(), expProviderContactDissociatedFromPatrimony.toString());
    }

}
