package com.anstel.simplifiedrequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme de test de la classe ContactToCallback in the SimplifiedRequest 
 * context. It is different from the one from TicketInfos context.
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 */
public class ContactToCallbackTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ContactToCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ContactToCallback.
     */
    @Test
    public void testContactToCallbackFromSimplifiedRequestJsonSerialization() {
        System.out.println("ContactToCallbackFromSimplifiedJsonSerialization");

        String filename = "ContactToCallbackFromSimplifiedRequest.json";
        String testFilename = "testContactToCallbackFromSimplifiedRequest.json";
        ContactToCallback contactToCallback = null;
        ContactToCallback expContactToCallback = null;

        try {
            contactToCallback = objectMapper.readValue(new File(filename), ContactToCallback.class);
            System.out.println("contactToCallback:" + contactToCallback);
            objectMapper.writeValue(new File(testFilename), contactToCallback);
            expContactToCallback = objectMapper.readValue(new File(filename), ContactToCallback.class);
            System.out.println("expContactToCallback:" + expContactToCallback);
            assertNotNull(contactToCallback);
            assertNotNull(expContactToCallback);
            assertEquals(contactToCallback.toString(), expContactToCallback.toString());
        } catch (IOException ex) {
            Logger.getLogger(ContactToCallback.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
