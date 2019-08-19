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
 * Programme de test de la classe ItemAbstractWithRef
 * @author Thierry Baribaud
 * @version 1.16
 */
public class ItemAbstractWithRefTest {
    
    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ItemAbstractWithRefTest() {
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
     * Test of serialization from and to a file in Json format, of class ItemAbstractWithRef.
     */
    @Test
    public void testItemAbstractWithRefJsonSerialization() {
        System.out.println("ItemAbstractWithRefJsonSerialization");

        String filename = "ItemAbstractWithRef.json";
        String testFilename = "testItemAbstractWithRef.json";
        ItemAbstractWithRef itemAbstractWithRef = null;
        ItemAbstractWithRef expItemAbstractWithRef = null;

        try {
            itemAbstractWithRef = objectMapper.readValue(new File(filename), ItemAbstractWithRef.class);
            System.out.println("itemAbstractWithRef:"+itemAbstractWithRef);
            objectMapper.writeValue(new File(testFilename), itemAbstractWithRef);
            expItemAbstractWithRef = objectMapper.readValue(new File(filename), ItemAbstractWithRef.class);
            System.out.println("expItemAbstractWithRef:"+expItemAbstractWithRef);
        } catch (IOException ex) {
            Logger.getLogger(ItemAbstractWithRefTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
        assertNotNull(itemAbstractWithRef);
        assertNotNull(expItemAbstractWithRef);
        assertEquals(itemAbstractWithRef.toString(), expItemAbstractWithRef.toString());
    }
    
}
