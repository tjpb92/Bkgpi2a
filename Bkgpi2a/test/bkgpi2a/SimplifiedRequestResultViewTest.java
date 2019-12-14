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
 * Programme de test de la classe SimplifiedRequestResultView
 *
 * @author Thierry Baribaud
 * @version 1.28
 */
public class SimplifiedRequestResultViewTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public SimplifiedRequestResultViewTest() {
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
     * SimplifiedRequestResultView.
     */
    @Test
    public void testSimplifiedRequestResultViewJsonSerialization() {
        System.out.println("SimplifiedRequestResultViewJsonSerialization");

        String filename = "SimplifiedRequestResultView.json";
        String testFilename = "testSimplifiedRequestResultView.json";
        SimplifiedRequestResultView simplifiedRequestResultView = null;
        SimplifiedRequestResultView expSimplifiedRequestResultView = null;

        try {
            simplifiedRequestResultView = objectMapper.readValue(new File(filename), SimplifiedRequestResultView.class);
            System.out.println("simplifiedRequestResultView:" + simplifiedRequestResultView);
            objectMapper.writeValue(new File(testFilename), simplifiedRequestResultView);
            expSimplifiedRequestResultView = objectMapper.readValue(new File(filename), SimplifiedRequestResultView.class);
            System.out.println("expSimplifiedRequestResultView:" + expSimplifiedRequestResultView);
        } catch (IOException ex) {
            Logger.getLogger(SimplifiedRequestResultViewTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(simplifiedRequestResultView);
        assertNotNull(expSimplifiedRequestResultView);
        assertEquals(simplifiedRequestResultView.toString(), expSimplifiedRequestResultView.toString());
    }

}
