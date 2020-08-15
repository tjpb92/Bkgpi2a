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
 * Programme de test de la classe ContextualCommentDisplayedOnTicket
 *
 * @author Thierry Baribaud
 * @version 1.35
 */
public class ContextualCommentDisplayedOnTicketTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ContextualCommentDisplayedOnTicketTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ContextualCommentDisplayedOnTicket.
     */
    @Test
    public void testContextualCommentDisplayedOnTicketJsonSerialization() {
        System.out.println("ContextualCommentDisplayedOnTicketJsonSerialization");

        String filename = "ContextualCommentDisplayedOnTicket.json";
        String testFilename = "testContextualCommentDisplayedOnTicket.json";
        ContextualCommentDisplayedOnTicket contextualCommentDisplayedOnTicket = null;
        ContextualCommentDisplayedOnTicket expContextualCommentDisplayedOnTicket = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            contextualCommentDisplayedOnTicket = objectMapper.readValue(new File(filename), ContextualCommentDisplayedOnTicket.class);
            System.out.println("contextualCommentDisplayedOnTicket:" + contextualCommentDisplayedOnTicket);
            objectMapper.writeValue(new File(testFilename), contextualCommentDisplayedOnTicket);
            expContextualCommentDisplayedOnTicket = objectMapper.readValue(new File(filename), ContextualCommentDisplayedOnTicket.class);
            System.out.println("expContextualCommentDisplayedOnTicket:" + expContextualCommentDisplayedOnTicket);
        } catch (IOException ex) {
            Logger.getLogger(ContextualCommentDisplayedOnTicket.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(contextualCommentDisplayedOnTicket);
        assertNotNull(expContextualCommentDisplayedOnTicket);
        assertEquals(contextualCommentDisplayedOnTicket.toString(), expContextualCommentDisplayedOnTicket.toString());
    }

}
