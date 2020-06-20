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
 * Programme de test de la classe InstructionsForAssigneeDefined
 *
 * @author Thierry Baribaud
 * @version 1.34
 */
public class InstructionsForAssigneeDefinedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public InstructionsForAssigneeDefinedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * InstructionsForAssigneeDefined.
     */
    @Test
    public void testInstructionsForAssigneeDefinedJsonSerialization() {
        System.out.println("InstructionsForAssigneeDefinedJsonSerialization");

        String filename = "InstructionsForAssigneeDefined.json";
        String testFilename = "testInstructionsForAssigneeDefined.json";
        InstructionsForAssigneeDefined instructionsForAssigneeDefined = null;
        InstructionsForAssigneeDefined expInstructionsForAssigneeDefined = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            instructionsForAssigneeDefined = objectMapper.readValue(new File(filename), InstructionsForAssigneeDefined.class);
            System.out.println("instructionsForAssigneeDefined:" + instructionsForAssigneeDefined);
            objectMapper.writeValue(new File(testFilename), instructionsForAssigneeDefined);
            expInstructionsForAssigneeDefined = objectMapper.readValue(new File(filename), InstructionsForAssigneeDefined.class);
            System.out.println("expInstructionsForAssigneeDefined:" + expInstructionsForAssigneeDefined);
        } catch (IOException ex) {
            Logger.getLogger(InstructionsForAssigneeDefined.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(instructionsForAssigneeDefined);
        assertNotNull(expInstructionsForAssigneeDefined);
        assertEquals(instructionsForAssigneeDefined.toString(), expInstructionsForAssigneeDefined.toString());
    }

}
