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
 * Programme de test de la classe TicketReopened
 *
 * @author Thierry Baribaud
 * @version 1.42.21
 */
public class TicketReopenedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketReopenedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketReopened.
     */
    @Test
    public void testTicketReopenedJsonSerialization() {
        System.out.println("TicketReopenedJsonSerialization");

        String filename = "TicketReopened.json";
        String testFilename = "testTicketReopened.json";
        TicketReopened ticketReopened = null;
        TicketReopened expTicketReopened = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketReopened = objectMapper.readValue(new File(filename), TicketReopened.class);
            System.out.println("ticketReopened:" + ticketReopened);
            objectMapper.writeValue(new File(testFilename), ticketReopened);
            expTicketReopened = objectMapper.readValue(new File(filename), TicketReopened.class);
            System.out.println("expTicketReopened:" + expTicketReopened);
            assertNotNull(ticketReopened);
            assertNotNull(expTicketReopened);
            assertEquals(ticketReopened.toString(), expTicketReopened.toString());
            assertNotNull(ticketReopened.getDate());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
