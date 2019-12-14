package bkgpi2a;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme de test de la classe OtpCategory
 *
 * @author Thierry Baribaud
 * @version 1.28
 */
public class OtpCategoryTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public OtpCategoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * OtpCategory.
     */
    @Test
    public void testOtpCategoryJsonSerialization() {
        System.out.println("OtpCategoryJsonSerialization");

        String filename = "OtpCategory.json";
        String testFilename = "testOtpCategory.json";
        OtpCategory otpCategory = null;
        OtpCategory expOtpCategory = null;

        try {
            otpCategory = objectMapper.readValue(new File(filename), OtpCategory.class);
            System.out.println("otpCategory:" + otpCategory);
            objectMapper.writeValue(new File(testFilename), otpCategory);
            expOtpCategory = objectMapper.readValue(new File(filename), OtpCategory.class);
            System.out.println("expOtpCategory:" + expOtpCategory);
        } catch (IOException ex) {
            Logger.getLogger(OtpCategoryTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(otpCategory);
        assertNotNull(expOtpCategory);
        assertEquals(otpCategory.toString(), expOtpCategory.toString());
    }

}
