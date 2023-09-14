package com.anstel.tickets.models;

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
 * Programme de test de la classe UnClassifiedPersona
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 */
public class UnClassifiedPersonaTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public UnClassifiedPersonaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * UnClassifiedPersona.
     */
    @Test
    public void testUnClassifiedPersonaJsonSerialization() {
        System.out.println("UnClassifiedPersonaJsonSerialization");

        String filename = "UnClassifiedPersona.json";
        String testFilename = "testUnClassifiedPersona.json";
        UnClassifiedPersona unClassifiedPersona = null;
        UnClassifiedPersona expUnClassifiedPersona = null;
        Persona persona;

        try {
            persona = objectMapper.readValue(new File(filename), Persona.class);
            System.out.println("persona:" + persona);

            unClassifiedPersona = objectMapper.readValue(new File(filename), UnClassifiedPersona.class);
            System.out.println("unClassifiedPersona:" + unClassifiedPersona);
            objectMapper.writeValue(new File(testFilename), unClassifiedPersona);
            expUnClassifiedPersona = objectMapper.readValue(new File(filename), UnClassifiedPersona.class);
            System.out.println("expUnClassifiedPersona:" + expUnClassifiedPersona);
            assertNotNull(unClassifiedPersona);
            assertNotNull(expUnClassifiedPersona);
            assertEquals(unClassifiedPersona.toString(), expUnClassifiedPersona.toString());
        } catch (IOException ex) {
            Logger.getLogger(UnClassifiedPersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
