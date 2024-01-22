package com.anstel.ticketEvents;

import bkgpi2a.Event;
import bkgpi2a.TicketOpened;
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
 * Programme de test de la classe CallEmittedTo
 *
 * @author Thierry Baribaud
 * @version 1.42.16
 */
public class CallEmittedToTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public CallEmittedToTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * CallEmittedTo.
     */
    @Test
    public void testCallEmittedToJsonSerialization() {
        System.out.println("CallEmittedToJsonSerialization");

        String filename = "CallEmittedTo.json";
        String testFilename = "testCallEmittedTo.json";
        CallEmittedTo callEmittedTo = null;
        CallEmittedTo expCallEmittedTo = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            callEmittedTo = objectMapper.readValue(new File(filename), CallEmittedTo.class);
            System.out.println("callEmittedTo:" + callEmittedTo);
            objectMapper.writeValue(new File(testFilename), callEmittedTo);
            expCallEmittedTo = objectMapper.readValue(new File(filename), CallEmittedTo.class);
            System.out.println("expCallEmittedTo:" + expCallEmittedTo);
            assertNotNull(callEmittedTo);
            assertNotNull(expCallEmittedTo);
            assertEquals(callEmittedTo.toString(), expCallEmittedTo.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
