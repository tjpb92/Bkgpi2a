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
 * Programme de test de la classe CivilName
 * @author Thierry Baribaud
 * @version 1.20
 */
public class CivilNameTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CivilNameTest() {
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
     * Test of serialization from and to a file in Json format, of class CivilName.
     */
    @Test
    public void testCivilNameJsonSerialization() {
        System.out.println("CivilNameJsonSerialization");

        String filename = "CivilName.json";
        String testFilename = "testCivilName.json";
        CivilName civilName = null;
        CivilName expCivilName = null;

        try {
            civilName = objectMapper.readValue(new File(filename), CivilName.class);
            System.out.println("civilName:"+civilName);
            objectMapper.writeValue(new File(testFilename), civilName);
            expCivilName = objectMapper.readValue(new File(filename), CivilName.class);
            System.out.println("expCivilName:"+expCivilName);
        } catch (IOException ex) {
            Logger.getLogger(CivilNameTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(civilName);
        assertNotNull(expCivilName);
        assertEquals(civilName.toString(), expCivilName.toString());
    }
    
}
