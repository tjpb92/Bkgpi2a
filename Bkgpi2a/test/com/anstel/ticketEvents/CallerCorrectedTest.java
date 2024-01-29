package com.anstel.ticketEvents;

import bkgpi2a.Event;
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
 * Programme de test de la classe CallerCorrected
 *
 * @author Thierry Baribaud
 * @version 1.42.7
 */
public class CallerCorrectedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CallerCorrectedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketOpened.
     */
    @Test
    public void testCallerCorrectedJsonSerialization() {
        System.out.println("CallerCorrectedJsonSerialization");

        String filename = "CallerCorrected.json";
        String testFilename = "testCallerCorrected.json";
        CallerCorrected callerCorrected = null;
        CallerCorrected expCallerCorrected = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            callerCorrected = objectMapper.readValue(new File(filename), CallerCorrected.class);
            System.out.println("callerCorrected:" + callerCorrected);
            objectMapper.writeValue(new File(testFilename), callerCorrected);
            expCallerCorrected = objectMapper.readValue(new File(filename), CallerCorrected.class);
            System.out.println("expCallerCorrected:" + expCallerCorrected);
            assertNotNull(callerCorrected);
            assertNotNull(expCallerCorrected);
            assertEquals(callerCorrected.toString(), expCallerCorrected.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
