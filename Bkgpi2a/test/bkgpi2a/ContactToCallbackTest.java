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
 * Programme de test de la classe ContactToCallback
 *
 * @author Thierry Baribaud
 * @version 1.39
 */
public class ContactToCallbackTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ContactToCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ContactToCallback.
     */
    @Test
    public void testContactToCallbackJsonSerialization() {
        System.out.println("ContactToCallbackJsonSerialization");

        String filename = "ContactToCallback.json";
        String testFilename = "testContactToCallback.json";
        ContactToCallback contactToCallback = null;
        ContactToCallback expContactToCallback = null;

        try {
            contactToCallback = objectMapper.readValue(new File(filename), ContactToCallback.class);
            System.out.println("contactToCallback:" + contactToCallback);
            objectMapper.writeValue(new File(testFilename), contactToCallback);
            expContactToCallback = objectMapper.readValue(new File(filename), ContactToCallback.class);
            System.out.println("expContactToCallback:" + expContactToCallback);
        } catch (IOException ex) {
            Logger.getLogger(ContactToCallback.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(contactToCallback);
        assertNotNull(expContactToCallback);
        assertEquals(contactToCallback.toString(), expContactToCallback.toString());
    }

}
