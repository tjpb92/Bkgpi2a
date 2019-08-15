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
 * @version 1.13
 */
public class ProviderContactResultViewTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderContactResultViewTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class ProviderContactResultView.
     */
    @Test
    public void testProviderContactResultViewJsonSerialization() {
        System.out.println("ProviderContactResultViewJsonSerialization");

        String filename = "ProviderContactResultView.json";
        String testFilename = "testProviderContactResultView.json";
        ProviderContactResultView providerContactResultView = null;
        ProviderContactResultView expProviderContactResultView = null;
        ProviderContact providerContact;

        try {
            providerContactResultView = objectMapper.readValue(new File(filename), ProviderContactResultView.class);
            System.out.println("providerContactResultView:"+providerContactResultView);
            for (ProviderContactQueryView providerContactQueryView : providerContactResultView.getProviderContactQueryViewList()) {
                System.out.println("  " + providerContactQueryView);
                providerContact = providerContactQueryView;
                System.out.println("    " + providerContact);
            }
//            for (ProviderContact providerContact: providerContactResultView.getProviderContactQueryViewList()) {
//                System.out.println("  " + providerContact);
//            }

            objectMapper.writeValue(new File(testFilename), providerContactResultView);
            expProviderContactResultView = objectMapper.readValue(new File(filename), ProviderContactResultView.class);
            System.out.println("expProviderContactResultView:"+expProviderContactResultView);
        } catch (IOException ex) {
            Logger.getLogger(ProviderContactResultViewTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(providerContactResultView);
        assertNotNull(expProviderContactResultView);
        assertEquals(providerContactResultView.toString(), expProviderContactResultView.toString());
    }
   
}
