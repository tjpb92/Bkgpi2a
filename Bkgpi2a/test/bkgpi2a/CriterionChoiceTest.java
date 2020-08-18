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
 * Programme de test de la classe CriterionChoice
 *
 * @author Thierry Baribaud
 * @version 1.36
 */
public class CriterionChoiceTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CriterionChoiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * CriterionChoice.
     */
    @Test
    public void testCriterionChoiceJsonSerialization() {
        System.out.println("CriterionChoiceJsonSerialization");

        String filename = "CriterionChoice.json";
        String testFilename = "testCriterionChoice.json";
        CriterionChoice criterionChoice = null;
        CriterionChoice expCriterionChoice = null;

        try {
            criterionChoice = objectMapper.readValue(new File(filename), CriterionChoice.class);
            System.out.println("criterionChoice:" + criterionChoice);
            objectMapper.writeValue(new File(testFilename), criterionChoice);
            expCriterionChoice = objectMapper.readValue(new File(filename), CriterionChoice.class);
            System.out.println("expCriterionChoice:" + expCriterionChoice);
        } catch (IOException ex) {
            Logger.getLogger(CriterionChoice.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(criterionChoice);
        assertNotNull(expCriterionChoice);
        assertEquals(criterionChoice.toString(), expCriterionChoice.toString());
    }

}
