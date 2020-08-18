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
 * Programme de test de la classe CriterionValue
 *
 * @author Thierry Baribaud
 * @version 1.36
 */
public class CriterionValueTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CriterionValueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * CriterionValue.
     */
    @Test
    public void testCriterionValueJsonSerialization() {
        System.out.println("CriterionValueJsonSerialization");

        String filename = "CriterionValue.json";
        String testFilename = "testCriterionValue.json";
        CriterionValue criterionValue = null;
        CriterionValue expCriterionValue = null;

        try {
            criterionValue = objectMapper.readValue(new File(filename), CriterionValue.class);
            System.out.println("criterionValue:" + criterionValue);
            objectMapper.writeValue(new File(testFilename), criterionValue);
            expCriterionValue = objectMapper.readValue(new File(filename), CriterionValue.class);
            System.out.println("expCriterionValue:" + expCriterionValue);
        } catch (IOException ex) {
            Logger.getLogger(CriterionValue.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(criterionValue);
        assertNotNull(expCriterionValue);
        assertEquals(criterionValue.toString(), expCriterionValue.toString());
    }

}
