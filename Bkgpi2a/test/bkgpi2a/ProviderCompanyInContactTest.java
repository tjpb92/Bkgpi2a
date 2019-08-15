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
 * Programme de test de la classe ProviderCompanyInContact
 * @author Thierry Baribaud
 * @version 1.13
 */
public class ProviderCompanyInContactTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderCompanyInContactTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class ProviderCompanyInContact.
     */
    @Test
    public void testProviderCompanyInContactJsonSerialization() {
        System.out.println("ProviderCompanyInContactJsonSerialization");

        String filename = "ProviderCompanyInContact.json";
        String testFilename = "testProviderCompanyInContact.json";
        ProviderCompanyInContact providerCompanyInContact = null;
        ProviderCompanyInContact expProviderCompanyInContact = null;

        try {
            providerCompanyInContact = objectMapper.readValue(new File(filename), ProviderCompanyInContact.class);
            System.out.println("providerCompanyInContact:"+providerCompanyInContact);
            objectMapper.writeValue(new File(testFilename), providerCompanyInContact);
            expProviderCompanyInContact = objectMapper.readValue(new File(filename), ProviderCompanyInContact.class);
            System.out.println("expProviderCompanyInContact:"+expProviderCompanyInContact);
        } catch (IOException ex) {
            Logger.getLogger(ProviderCompanyInContactTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(providerCompanyInContact);
        assertNotNull(expProviderCompanyInContact);
        assertEquals(providerCompanyInContact.toString(), expProviderCompanyInContact.toString());
    }
   
}
