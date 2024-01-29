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
 * Programme de test de la classe AssigneeIdentified
 *
 * @author Thierry Baribaud
 * @version 1.42.16
 */
public class AssigneeIdentifiedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public AssigneeIdentifiedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * AssigneeIdentified.
     */
    @Test
    public void testAssigneeIdentifiedJsonSerialization() {
        System.out.println("AssigneeIdentifiedJsonSerialization");

        String filename = "AssigneeIdentified.json";
        String testFilename = "testAssigneeIdentified.json";
        AssigneeIdentified assigneeIdentified = null;
        AssigneeIdentified expAssigneeIdentified = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            assigneeIdentified = objectMapper.readValue(new File(filename), AssigneeIdentified.class);
            System.out.println("assigneeIdentified:" + assigneeIdentified);
            objectMapper.writeValue(new File(testFilename), assigneeIdentified);
            expAssigneeIdentified = objectMapper.readValue(new File(filename), AssigneeIdentified.class);
            System.out.println("expAssigneeIdentified:" + expAssigneeIdentified);
            assertNotNull(assigneeIdentified);
            assertNotNull(expAssigneeIdentified);
            assertEquals(assigneeIdentified.toString(), expAssigneeIdentified.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
