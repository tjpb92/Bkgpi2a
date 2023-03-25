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
 * Programme de test de la classe SimplifiedRequestDetailedView vis à vis du bug
 * du 21 lars 2023 avec l'objet AgencyAbstract, issue#41.
 *
 * @author Thierry Baribaud
 * @version 1.41
 */
public class SimplifiedRequestDetailedView_bug230321Test {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public SimplifiedRequestDetailedView_bug230321Test() {
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
     * SimplifiedRequestDetailedView.
     */
    @Test
    public void testSimplifiedRequestDetailedView_bug230321JsonSerialization() {
        System.out.println("SimplifiedRequestDetailedView_bug230321JsonSerialization");

        String filename = "SimplifiedRequestDetailedView_bug230321.json";
        String testFilename = "testSimplifiedRequestDetailedView_bug230321.json";
        SimplifiedRequestDetailedView simplifiedRequestDetailedView = null;
        SimplifiedRequestDetailedView expSimplifiedRequestDetailedView = null;

        try {
            simplifiedRequestDetailedView = objectMapper.readValue(new File(filename), SimplifiedRequestDetailedView.class);
            System.out.println("simplifiedRequestDetailedView:" + simplifiedRequestDetailedView);
            objectMapper.writeValue(new File(testFilename), simplifiedRequestDetailedView);
            expSimplifiedRequestDetailedView = objectMapper.readValue(new File(filename), SimplifiedRequestDetailedView.class);
            System.out.println("expSimplifiedRequestDetailedView:" + expSimplifiedRequestDetailedView);
            assertNotNull(simplifiedRequestDetailedView);
            assertNotNull(expSimplifiedRequestDetailedView);
            assertEquals(simplifiedRequestDetailedView.toString(), expSimplifiedRequestDetailedView.toString());
        } catch (IOException ex) {
            Logger.getLogger(SimplifiedRequestDetailedView_bug230321Test.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
