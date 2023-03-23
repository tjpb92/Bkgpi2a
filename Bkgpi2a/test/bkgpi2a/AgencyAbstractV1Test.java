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
 * Programme de test de la classe AgencyAbstract version V1 before issue#41
 *
 * @author Thierry Baribaud
 * @version 1.40
 */
public class AgencyAbstractV1Test {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public AgencyAbstractV1Test() {
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
     * AgencyAbstract. Works only with AgencyAbstract V1 version (before
     * issue#41).
     */
    @Test
    public void testAgencyAbstractV1tJsonSerialization() {
        System.out.println("AgencyAbstractV1JsonSerialization");

        String filename = "AgencyAbstract_V1.json";
        String testFilename = "testAgencyAbstract_v1.json";
        AgencyAbstract agencyAbstract = null;
        AgencyAbstract expAgencyAbstract = null;

        try {
            agencyAbstract = objectMapper.readValue(new File(filename), AgencyAbstract.class);
            System.out.println("agencyAbstract:" + agencyAbstract);
            objectMapper.writeValue(new File(testFilename), agencyAbstract);
            expAgencyAbstract = objectMapper.readValue(new File(filename), AgencyAbstract.class);
            System.out.println("expAgencyAbstract:" + expAgencyAbstract);
            assertNotNull(agencyAbstract);
            assertNotNull(expAgencyAbstract);
            assertEquals(agencyAbstract.toString(), expAgencyAbstract.toString());
        } catch (IOException ex) {
            Logger.getLogger(AgencyAbstractV1Test.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * AgencyAbstract. Works only with AgencyAbstract V1 version with V2 json
     * file (issue#41).
     */
    @Test
    public void testAgencyAbstractV1vsV2tJsonSerialization() {
        System.out.println("AgencyAbstractV1vsV2JsonSerialization");

        String filename = "AgencyAbstract_V2.json";
        String testFilename = "testAgencyAbstract_V1vsV2.json";
        AgencyAbstract agencyAbstract = null;
        AgencyAbstract expAgencyAbstract = null;

        try {
            agencyAbstract = objectMapper.readValue(new File(filename), AgencyAbstract.class);
            System.out.println("agencyAbstract:" + agencyAbstract);
            fail("Une exception était attendue");
            objectMapper.writeValue(new File(testFilename), agencyAbstract);
            expAgencyAbstract = objectMapper.readValue(new File(filename), AgencyAbstract.class);
            System.out.println("expAgencyAbstract:" + expAgencyAbstract);
        } catch (IOException ex) {
            Logger.getLogger(AgencyAbstractV1Test.class.getName()).log(Level.SEVERE, null, ex);
            assertNotNull(ex);
        }
    }
}
