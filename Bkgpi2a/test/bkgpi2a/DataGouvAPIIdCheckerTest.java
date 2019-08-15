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
 * Programme de test de la classe DataGouvAPIIdChecker
 *
 * @author Thierry Baribaud
 * @version 1.11
 */
public class DataGouvAPIIdCheckerTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public DataGouvAPIIdCheckerTest() {
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
     * DataGouvAPIIdChecker.
     */
    @Test
    public void testDataGouvAPIIdCheckerJsonSerialization() {
        System.out.println("DataGouvAPIIdCheckerJsonSerialization");

        String filename = "DataGouvAPIIdChecker.json";
        String testFilename = "testDataGouvAPIIdChecker.json";
        DataGouvAPIIdChecker dataGouvAPIIdChecker = null;
        DataGouvAPIIdChecker expDataGouvAPIIdChecker = null;

        try {
            dataGouvAPIIdChecker = objectMapper.readValue(new File(filename), DataGouvAPIIdChecker.class);
            System.out.println("dataGouvAPIIdChecker:" + dataGouvAPIIdChecker);
            objectMapper.writeValue(new File(testFilename), dataGouvAPIIdChecker);
            expDataGouvAPIIdChecker = objectMapper.readValue(new File(filename), DataGouvAPIIdChecker.class);
            System.out.println("expDataGouvAPIIdChecker:" + expDataGouvAPIIdChecker);
        } catch (IOException ex) {
            Logger.getLogger(DataGouvAPIIdCheckerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(dataGouvAPIIdChecker);
        assertNotNull(expDataGouvAPIIdChecker);
        assertEquals(dataGouvAPIIdChecker.toString(), expDataGouvAPIIdChecker.toString());
    }

}
