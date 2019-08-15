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
 * Programme de test de la classe ProviderContactQueryView
 * @author Thierry Baribaud
 * @version 1.13
 */
public class ProviderContactQueryViewTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderContactQueryViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class ProviderContactQueryView.
     */
    @Test
    public void testProviderContactQueryViewJsonSerialization() {
        System.out.println("ProviderContactQueryViewJsonSerialization");

        String filename = "ProviderContactQueryView.json";
        String testFilename = "testProviderContactQueryView.json";
        ProviderContactQueryView providerContactQueryView = null;
        ProviderContactQueryView expProviderContactQueryView = null;

        try {
            providerContactQueryView = objectMapper.readValue(new File(filename), ProviderContactQueryView.class);
            System.out.println("providerContactQueryView:"+providerContactQueryView);
            objectMapper.writeValue(new File(testFilename), providerContactQueryView);
            expProviderContactQueryView = objectMapper.readValue(new File(filename), ProviderContactQueryView.class);
            System.out.println("expProviderContactQueryView:"+expProviderContactQueryView);
        } catch (IOException ex) {
            Logger.getLogger(ProviderContactQueryViewTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(providerContactQueryView);
        assertNotNull(expProviderContactQueryView);
        assertEquals(providerContactQueryView.toString(), expProviderContactQueryView.toString());
    }
    
}
