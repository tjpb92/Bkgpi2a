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
 * Programme de test de la classe PhoneInfo
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 */
public class PhoneInfoTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public PhoneInfoTest() {
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
     * PhoneInfo.
     */
    @Test
    public void testPhoneInfoJsonSerialization() {
        System.out.println("PhoneInfoJsonSerialization");

        String filename = "PhoneInfo.json";
        String testFilename = "testPhoneInfo.json";
        PhoneInfo phoneInfo = null;
        PhoneInfo expPhoneInfo = null;

        try {
            phoneInfo = objectMapper.readValue(new File(filename), PhoneInfo.class);
            System.out.println("phoneInfo:" + phoneInfo);
            objectMapper.writeValue(new File(testFilename), phoneInfo);
            expPhoneInfo = objectMapper.readValue(new File(filename), PhoneInfo.class);
            System.out.println("expPhoneInfo:" + expPhoneInfo);
            assertNotNull(phoneInfo);
            assertNotNull(expPhoneInfo);
            assertEquals(phoneInfo.toString(), expPhoneInfo.toString());
        } catch (IOException ex) {
            Logger.getLogger(PhoneInfoTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
