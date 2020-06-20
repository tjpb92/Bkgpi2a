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
 * Programme de test de la classe ReferencedContactCaller
 *
 * @author Thierry Baribaud
 * @version 1.34
 */
public class ReferencedContactCallerTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ReferencedContactCallerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ReferencedContactCaller.
     */
    @Test
    public void testReferencedContactCallerJsonSerialization() {
        System.out.println("ReferencedContactCallerJsonSerialization");

        String filename = "ReferencedContactCaller.json";
        String testFilename = "testReferencedContactCaller.json";
        ReferencedContactCaller referencedContactCaller = null;
        ReferencedContactCaller expReferencedContactCaller = null;
        Caller caller;

        try {
            caller = objectMapper.readValue(new File(filename), Caller.class);
            System.out.println("caller:" + caller);

            referencedContactCaller = objectMapper.readValue(new File(filename), ReferencedContactCaller.class);
            System.out.println("referencedContactCaller:" + referencedContactCaller);
            objectMapper.writeValue(new File(testFilename), referencedContactCaller);
            expReferencedContactCaller = objectMapper.readValue(new File(filename), ReferencedContactCaller.class);
            System.out.println("expReferencedContactCaller:" + expReferencedContactCaller);
        } catch (IOException ex) {
            Logger.getLogger(ReferencedContactCaller.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(referencedContactCaller);
        assertNotNull(expReferencedContactCaller);
        assertEquals(referencedContactCaller.toString(), expReferencedContactCaller.toString());
    }

}
