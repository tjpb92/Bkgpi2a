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
 * Programme de test de la classe PoorName
 * @author Thierry Baribaud
 * @version 1.18
 */
public class PoorNameTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public PoorNameTest() {
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
     * Test of serialization from and to a file in Json format, of class ItemAbstract.
     */
    @Test
    public void testItemAbstractJsonSerialization() {
        System.out.println("PoorNameJsonSerialization");

        String filename = "PoorName.json";
        String testFilename = "testPoorName.json";
        PoorName poorName = null;
        PoorName expPoorName = null;

        try {
            poorName = objectMapper.readValue(new File(filename), PoorName.class);
            System.out.println("poorName:"+poorName);
            objectMapper.writeValue(new File(testFilename), poorName);
            expPoorName = objectMapper.readValue(new File(filename), PoorName.class);
            System.out.println("expPoorName:"+expPoorName);
        } catch (IOException ex) {
            Logger.getLogger(PoorNameTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(poorName);
        assertNotNull(expPoorName);
        assertEquals(poorName.toString(), expPoorName.toString());
    }
    
}
