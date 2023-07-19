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
 * Programme de test de la classe OpeningTicketPurposeCorrected
 *
 * @author Thierry Baribaud
 * @version 1.42.6
 */
public class OpeningTicketPurposeCorrectedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public OpeningTicketPurposeCorrectedTest() {
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
    public void testOpeningTicketPurposeCorrectedJsonSerialization() {
        System.out.println("OpeningTicketPurposeCorrectedJsonSerialization");

        String filename = "OpeningTicketPurposeCorrected.json";
        String testFilename = "testOpeningTicketPurposeCorrected.json";
        OpeningTicketPurposeCorrected openingTicketPurposeCorrected = null;
        OpeningTicketPurposeCorrected expOpeningTicketPurposeCorrected = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            openingTicketPurposeCorrected = objectMapper.readValue(new File(filename), OpeningTicketPurposeCorrected.class);
            System.out.println("openingTicketPurposeCorrected:" + openingTicketPurposeCorrected);
            objectMapper.writeValue(new File(testFilename), openingTicketPurposeCorrected);
            expOpeningTicketPurposeCorrected = objectMapper.readValue(new File(filename), OpeningTicketPurposeCorrected.class);
            System.out.println("expOpeningTicketPurposeCorrected:" + expOpeningTicketPurposeCorrected);
            assertNotNull(openingTicketPurposeCorrected);
            assertNotNull(expOpeningTicketPurposeCorrected);
            assertEquals(openingTicketPurposeCorrected.toString(), expOpeningTicketPurposeCorrected.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
