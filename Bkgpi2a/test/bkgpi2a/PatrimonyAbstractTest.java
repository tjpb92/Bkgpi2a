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
 * Programme de test de la classe PatrimonyAbstract
 *
 * @author Thierry Baribaud
 * @version 1.28
 */
public class PatrimonyAbstractTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public PatrimonyAbstractTest() {
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
     * PatrimonyAbstract.
     */
    @Test
    public void testPatrimonyAbstractJsonSerialization() {
        System.out.println("PatrimonyAbstractJsonSerialization");

        String filename = "PatrimonyAbstract.json";
        String testFilename = "testPatrimonyAbstract.json";
        PatrimonyAbstract patrimonyAbstract = null;
        PatrimonyAbstract expPatrimonyAbstract = null;

        try {
            patrimonyAbstract = objectMapper.readValue(new File(filename), PatrimonyAbstract.class);
            System.out.println("patrimonyAbstract:" + patrimonyAbstract);
            objectMapper.writeValue(new File(testFilename), patrimonyAbstract);
            expPatrimonyAbstract = objectMapper.readValue(new File(filename), PatrimonyAbstract.class);
            System.out.println("expPatrimonyAbstract:" + expPatrimonyAbstract);
        } catch (IOException ex) {
            Logger.getLogger(PatrimonyAbstractTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(patrimonyAbstract);
        assertNotNull(expPatrimonyAbstract);
        assertEquals(patrimonyAbstract.toString(), expPatrimonyAbstract.toString());
    }

}
