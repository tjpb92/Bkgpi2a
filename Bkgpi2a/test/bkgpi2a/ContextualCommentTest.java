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
 * Programme de test de la classe ContextualComment
 *
 * @author Thierry Baribaud
 * @version 1.36
 */
public class ContextualCommentTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ContextualCommentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ContextualComment.
     */
    @Test
    public void testContextualCommentJsonSerialization() {
        System.out.println("ContextualCommentJsonSerialization");

        String filename = "ContextualComment.json";
        String testFilename = "testContextualComment.json";
        ContextualComment contextualComment = null;
        ContextualComment expContextualComment = null;

        try {
           contextualComment = objectMapper.readValue(new File(filename), ContextualComment.class);
            System.out.println("contextualComment:" + contextualComment);
            objectMapper.writeValue(new File(testFilename), contextualComment);
            expContextualComment = objectMapper.readValue(new File(filename), ContextualComment.class);
            System.out.println("expContextualComment:" + expContextualComment);
        } catch (IOException ex) {
            Logger.getLogger(ContextualComment.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(contextualComment);
        assertNotNull(expContextualComment);
        assertEquals(contextualComment.toString(), expContextualComment.toString());
    }

}
