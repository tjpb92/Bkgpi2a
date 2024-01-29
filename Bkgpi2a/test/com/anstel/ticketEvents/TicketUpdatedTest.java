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
 * Programme de test de la classe TicketUpdated
 *
 * @author Thierry Baribaud
 * @version 1.42.20
 */
public class TicketUpdatedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public TicketUpdatedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * TicketUpdated.
     */
    @Test
    public void testTicketUpdatedJsonSerialization() {
        System.out.println("TicketUpdatedJsonSerialization");

//        String filename = "TicketUpdated.json";
        String filename = "TicketUpdated_3.json";
        String testFilename = "testTicketUpdated.json";
        TicketUpdated ticketUpdated = null;
        TicketUpdated expTicketUpdated = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            ticketUpdated = objectMapper.readValue(new File(filename), TicketUpdated.class);
            System.out.println("ticketUpdated:" + ticketUpdated);
            objectMapper.writeValue(new File(testFilename), ticketUpdated);
            expTicketUpdated = objectMapper.readValue(new File(filename), TicketUpdated.class);
            System.out.println("expTicketUpdated:" + expTicketUpdated);
            assertNotNull(ticketUpdated);
            assertNotNull(expTicketUpdated);
            assertEquals(ticketUpdated.toString(), expTicketUpdated.toString());
            assertNotNull(ticketUpdated.getDate());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
