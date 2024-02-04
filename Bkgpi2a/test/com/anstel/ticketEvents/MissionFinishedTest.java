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
 * Programme de test de la classe MissionFinished
 *
 * @author Thierry Baribaud
 * @version 1.42.23
 */
public class MissionFinishedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public MissionFinishedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * MissionFinished.
     */
    @Test
    public void testMissionFinishedJsonSerialization() {
        System.out.println("MissionFinishedJsonSerialization");

        String filename = "MissionFinished.json";
        String testFilename = "testMissionFinished.json";
        MissionFinished missionFinished = null;
        MissionFinished expMissionFinished = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            missionFinished = objectMapper.readValue(new File(filename), MissionFinished.class);
            System.out.println("backupAssigneeIdentified:" + missionFinished);
            objectMapper.writeValue(new File(testFilename), missionFinished);
            expMissionFinished = objectMapper.readValue(new File(filename), MissionFinished.class);
            System.out.println("expMissionFinished:" + expMissionFinished);
            assertNotNull(missionFinished);
            assertNotNull(expMissionFinished);
            
            assertNull(missionFinished.getDate());
            assertNotNull(missionFinished.getEndMissionDate());

            assertEquals(missionFinished.toString(), expMissionFinished.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
