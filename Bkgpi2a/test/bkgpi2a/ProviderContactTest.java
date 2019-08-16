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
 * @author Thierry Baribaud
 * @version 1.15
 */
public class ProviderContactTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class ProviderContact.
     */
    @Test
    public void testProviderContactJsonSerialization() {
        System.out.println("ProviderContactJsonSerialization");

        String filename = "ProviderContact.json";
        String testFilename = "testProviderContact.json";
        ProviderContact providerContact = null;
        ProviderContact expProviderContact = null;

        try {
            providerContact = objectMapper.readValue(new File(filename), ProviderContact.class);
            System.out.println("providerContact:"+providerContact);
            objectMapper.writeValue(new File(testFilename), providerContact);
            expProviderContact = objectMapper.readValue(new File(filename), ProviderContact.class);
            System.out.println("expProviderContact:"+expProviderContact);
        } catch (IOException ex) {
            Logger.getLogger(ProviderContactResultViewTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(providerContact);
        assertNotNull(expProviderContact);
        assertEquals(providerContact.toString(), expProviderContact.toString());
    }
   
}
