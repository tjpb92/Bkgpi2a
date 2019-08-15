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
 * Programme de test de la classe ProviderContactActivity
 * @author Thierry Baribaud
 * @version 1.13
 */
public class ProviderContactActivityTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderContactActivityTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class ProviderContactActivity.
     */
    @Test
    public void testProviderContactActivityJsonSerialization() {
        System.out.println("ProviderContactActivityJsonSerialization");

        String filename = "ProviderContactActivity.json";
        String testFilename = "testProviderContactActivity.json";
        ProviderContactActivity providerContactActivity = null;
        ProviderContactActivity expProviderContactActivity = null;

        try {
            providerContactActivity = objectMapper.readValue(new File(filename), ProviderContactActivity.class);
            System.out.println("providerContactActivity:"+providerContactActivity);
            objectMapper.writeValue(new File(testFilename), providerContactActivity);
            expProviderContactActivity = objectMapper.readValue(new File(filename), ProviderContactActivity.class);
            System.out.println("expProviderContactActivity:"+expProviderContactActivity);
        } catch (IOException ex) {
            Logger.getLogger(ProviderContactActivityTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(providerContactActivity);
        assertNotNull(expProviderContactActivity);
        assertEquals(providerContactActivity.toString(), expProviderContactActivity.toString());
    }

}
