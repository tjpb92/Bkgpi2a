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
 * Programme de test de la classe CriterionChoiceList
 *
 * @author Thierry Baribaud
 * @version 1.36
 */
public class CriterionChoiceListTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CriterionChoiceListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * CriterionChoiceList.
     */
    @Test
    public void testCriterionChoiceListJsonSerialization() {
        System.out.println("CriterionChoiceListJsonSerialization");

        String filename = "CriterionChoiceList.json";
        String testFilename = "testCriterionChoiceList.json";
        CriterionChoiceList criterionChoiceList = null;
        CriterionChoiceList expCriterionChoiceList = null;

        try {
            criterionChoiceList = objectMapper.readValue(new File(filename), CriterionChoiceList.class);
            System.out.println("criterionChoiceList:" + criterionChoiceList);
            objectMapper.writeValue(new File(testFilename), criterionChoiceList);
            expCriterionChoiceList = objectMapper.readValue(new File(filename), CriterionChoiceList.class);
            System.out.println("expCriterionChoiceList:" + expCriterionChoiceList);
        } catch (IOException ex) {
            Logger.getLogger(CriterionChoiceList.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(criterionChoiceList);
        assertNotNull(expCriterionChoiceList);
        assertEquals(criterionChoiceList.toString(), expCriterionChoiceList.toString());
    }

}
