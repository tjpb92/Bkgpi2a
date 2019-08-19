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
 * Programme de test de la classe ItemAbstract
 * @author Thierry Baribaud
 * @version 1.16
 */
public class ItemAbstractTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ItemAbstractTest() {
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
        System.out.println("ItemAbstractJsonSerialization");

        String filename = "ItemAbstract.json";
        String testFilename = "testItemAbstract.json";
        ItemAbstract itemAbstract = null;
        ItemAbstract expItemAbstract = null;

        try {
            itemAbstract = objectMapper.readValue(new File(filename), ItemAbstract.class);
            System.out.println("itemAbstract:"+itemAbstract);
            objectMapper.writeValue(new File(testFilename), itemAbstract);
            expItemAbstract = objectMapper.readValue(new File(filename), ItemAbstract.class);
            System.out.println("expItemAbstract:"+expItemAbstract);
        } catch (IOException ex) {
            Logger.getLogger(ItemAbstractTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(itemAbstract);
        assertNotNull(expItemAbstract);
        assertEquals(itemAbstract.toString(), expItemAbstract.toString());
    }
    
}
