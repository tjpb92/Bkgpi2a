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
 * Programme de test de la classe ReferencedUserCaller
 *
 * @author Thierry Baribaud
 * @version 1.42.1
 */
public class ReferencedUserCallerTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ReferencedUserCallerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ReferencedUserCaller.
     */
    @Test
    public void testReferencedUserCallerJsonSerialization() {
        System.out.println("ReferencedUserCallerJsonSerialization");

        String filename = "ReferencedUserCaller.json";
        String testFilename = "testReferencedUserCaller.json";
        ReferencedUserCaller referencedUserCaller = null;
        ReferencedUserCaller expReferencedUserCaller = null;
        Caller caller;

        try {
            caller = objectMapper.readValue(new File(filename), Caller.class);
            System.out.println("caller:" + caller);

            referencedUserCaller = objectMapper.readValue(new File(filename), ReferencedUserCaller.class);
            System.out.println("referencedUserCaller:" + referencedUserCaller);
            objectMapper.writeValue(new File(testFilename), referencedUserCaller);
            expReferencedUserCaller = objectMapper.readValue(new File(filename), ReferencedUserCaller.class);
            System.out.println("expReferencedUserCaller:" + expReferencedUserCaller);
            assertNotNull(referencedUserCaller);
            assertNotNull(expReferencedUserCaller);
            assertEquals(referencedUserCaller.toString(), expReferencedUserCaller.toString());
        } catch (IOException ex) {
            Logger.getLogger(ReferencedUserCaller.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
