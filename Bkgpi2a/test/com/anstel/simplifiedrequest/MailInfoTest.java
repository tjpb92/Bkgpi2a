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
 * Programme de test de la classe MailInfo
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 */
public class MailInfoTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public MailInfoTest() {
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
     * MailInfo.
     */
    @Test
    public void testMailInfoJsonSerialization() {
        System.out.println("MailInfoJsonSerialization");

        String filename = "MailInfo.json";
        String testFilename = "testMailInfo.json";
        MailInfo mailInfo = null;
        MailInfo expMailInfo = null;

        try {
            mailInfo = objectMapper.readValue(new File(filename), MailInfo.class);
            System.out.println("mailInfo:" + mailInfo);
            objectMapper.writeValue(new File(testFilename), mailInfo);
            expMailInfo = objectMapper.readValue(new File(filename), MailInfo.class);
            System.out.println("expMailInfo:" + expMailInfo);
            assertNotNull(mailInfo);
            assertNotNull(expMailInfo);
            assertEquals(mailInfo.toString(), expMailInfo.toString());
        } catch (IOException ex) {
            Logger.getLogger(MailInfoTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
