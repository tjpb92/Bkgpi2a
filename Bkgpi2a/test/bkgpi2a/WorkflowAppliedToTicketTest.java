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
 * Programme de test de la classe WorkflowAppliedToTicket
 *
 * @author Thierry Baribaud
 * @version 1.35
 */
public class WorkflowAppliedToTicketTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public WorkflowAppliedToTicketTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * WorkflowAppliedToTicket.
     */
    @Test
    public void testWorkflowAppliedToTicketJsonSerialization() {
        System.out.println("WorkflowAppliedToTicketJsonSerialization");

        String filename = "WorkflowAppliedToTicket.json";
        String testFilename = "testWorkflowAppliedToTicket.json";
        WorkflowAppliedToTicket workflowAppliedToTicket = null;
        WorkflowAppliedToTicket expWorkflowAppliedToTicket = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            workflowAppliedToTicket = objectMapper.readValue(new File(filename), WorkflowAppliedToTicket.class);
            System.out.println("workflowAppliedToTicket:" + workflowAppliedToTicket);
            objectMapper.writeValue(new File(testFilename), workflowAppliedToTicket);
            expWorkflowAppliedToTicket = objectMapper.readValue(new File(filename), WorkflowAppliedToTicket.class);
            System.out.println("expWorkflowAppliedToTicket:" + expWorkflowAppliedToTicket);
        } catch (IOException ex) {
            Logger.getLogger(WorkflowAppliedToTicket.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(workflowAppliedToTicket);
        assertNotNull(expWorkflowAppliedToTicket);
        assertEquals(workflowAppliedToTicket.toString(), expWorkflowAppliedToTicket.toString());
    }

}
