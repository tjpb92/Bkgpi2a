package com.anstel.simplifiedrequest;

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
 * Programme de test de la classe SimplifiedRequestSearchView
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 */
public class SimplifiedRequestSearchViewTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public SimplifiedRequestSearchViewTest() {
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
     * SimplifiedRequestSearchView.
     */
    @Test
    public void testSimplifiedRequestSearchViewJsonSerialization() {
        System.out.println("SimplifiedRequestSearchViewJsonSerialization");

        String filename = "SimplifiedRequestSearchView.json";
        String testFilename = "testSimplifiedRequestSearchView.json";
        SimplifiedRequestSearchView simplifiedRequestSearchView = null;
        SimplifiedRequestSearchView expSimplifiedRequestSearchView = null;

        try {
            simplifiedRequestSearchView = objectMapper.readValue(new File(filename), SimplifiedRequestSearchView.class);
            System.out.println("simplifiedRequestSearchView:" + simplifiedRequestSearchView);
            objectMapper.writeValue(new File(testFilename), simplifiedRequestSearchView);
            expSimplifiedRequestSearchView = objectMapper.readValue(new File(filename), SimplifiedRequestSearchView.class);
            System.out.println("expSimplifiedRequestSearchView:" + expSimplifiedRequestSearchView);
            assertNotNull(simplifiedRequestSearchView);
            assertNotNull(expSimplifiedRequestSearchView);
            assertEquals(simplifiedRequestSearchView.toString(), expSimplifiedRequestSearchView.toString());
        } catch (IOException ex) {
            Logger.getLogger(SimplifiedRequestSearchViewTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
