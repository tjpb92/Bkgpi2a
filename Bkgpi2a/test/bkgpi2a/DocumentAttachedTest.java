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
 * Programme de test de la classe DocumentAttached
 *
 * @author Thierry Baribaud
 * @version 1.34
 */
public class DocumentAttachedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public DocumentAttachedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * DocumentAttached.
     */
    @Test
    public void testDocumentAttachedJsonSerialization() {
        System.out.println("DocumentAttachedJsonSerialization");

        String filename = "DocumentAttached.json";
        String testFilename = "testDocumentAttached.json";
        DocumentAttached documentAttached = null;
        DocumentAttached expDocumentAttached = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            documentAttached = objectMapper.readValue(new File(filename), DocumentAttached.class);
            System.out.println("documentAttached:" + documentAttached);
            objectMapper.writeValue(new File(testFilename), documentAttached);
            expDocumentAttached = objectMapper.readValue(new File(filename), DocumentAttached.class);
            System.out.println("expDocumentAttached:" + expDocumentAttached);
        } catch (IOException ex) {
            Logger.getLogger(DocumentAttached.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(documentAttached);
        assertNotNull(expDocumentAttached);
        assertEquals(documentAttached.toString(), expDocumentAttached.toString());
    }

}
