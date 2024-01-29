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
 * Programme de test de la classe BackupAssigneeIdentified
 *
 * @author Thierry Baribaud
 * @version 1.42.16
 */
public class BackupAssigneeIdentifiedTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public BackupAssigneeIdentifiedTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * BackupAssigneeIdentified.
     */
    @Test
    public void testBackupAssigneeIdentifiedJsonSerialization() {
        System.out.println("BackupAssigneeIdentifiedJsonSerialization");

        String filename = "BackupAssigneeIdentified.json";
        String testFilename = "testBackupAssigneeIdentified.json";
        BackupAssigneeIdentified backupAssigneeIdentified = null;
        BackupAssigneeIdentified expBackupAssigneeIdentified = null;
        Event event;

        try {
            event = objectMapper.readValue(new File(filename), Event.class);
            System.out.println("event:" + event);

            backupAssigneeIdentified = objectMapper.readValue(new File(filename), BackupAssigneeIdentified.class);
            System.out.println("backupAssigneeIdentified:" + backupAssigneeIdentified);
            objectMapper.writeValue(new File(testFilename), backupAssigneeIdentified);
            expBackupAssigneeIdentified = objectMapper.readValue(new File(filename), BackupAssigneeIdentified.class);
            System.out.println("expBackupAssigneeIdentified:" + expBackupAssigneeIdentified);
            assertNotNull(backupAssigneeIdentified);
            assertNotNull(expBackupAssigneeIdentified);
            assertEquals(backupAssigneeIdentified.toString(), expBackupAssigneeIdentified.toString());
        } catch (IOException ex) {
            Logger.getLogger(TicketOpened.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
