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
 * Programme de test de la classe GooglePlaceIdChecker
 * @author Thierry Baribaud
 * @version 1.11
 */
public class GooglePlaceIdCheckerTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public GooglePlaceIdCheckerTest() {
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
     * Test of serialization from and to a file in Json format, of class GooglePlaceIdChecker.
     */
    @Test
    public void testGooglePlaceIdCheckerJsonSerialization() {
        System.out.println("GooglePlaceIdCheckerJsonSerialization");

        String filename = "GooglePlaceIdChecker.json";
        String testFilename = "testGooglePlaceIdChecker.json";
        GooglePlaceIdChecker googlePlaceIdChecker = null;
        GooglePlaceIdChecker expGooglePlaceIdChecker = null;

        try {
            googlePlaceIdChecker = objectMapper.readValue(new File(filename), GooglePlaceIdChecker.class);
            System.out.println("googlePlaceIdChecker:"+googlePlaceIdChecker);
            objectMapper.writeValue(new File(testFilename), googlePlaceIdChecker);
            expGooglePlaceIdChecker = objectMapper.readValue(new File(filename), GooglePlaceIdChecker.class);
            System.out.println("expGooglePlaceIdChecker:"+expGooglePlaceIdChecker);
        } catch (IOException ex) {
            Logger.getLogger(GooglePlaceIdCheckerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(googlePlaceIdChecker);
        assertNotNull(expGooglePlaceIdChecker);
        assertEquals(googlePlaceIdChecker.toString(), expGooglePlaceIdChecker.toString());
    }
    
}
