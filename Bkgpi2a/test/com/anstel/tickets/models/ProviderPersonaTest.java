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
 * Programme de test de la classe ProviderPersona
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 */
public class ProviderPersonaTest {

    /**
     * Common Jackson object mapper
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public ProviderPersonaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of serialization from and to a file in Json format, of class
     * ProviderPersona.
     */
    @Test
    public void testProviderPersonaJsonSerialization() {
        System.out.println("ProviderPersonaJsonSerialization");

        String filename = "ProviderPersona.json";
        String testFilename = "testProviderPersona.json";
        ProviderPersona providerPersona = null;
        ProviderPersona expProviderPersona = null;
        Persona persona;

        try {
            persona = objectMapper.readValue(new File(filename), Persona.class);
            System.out.println("persona:" + persona);

            providerPersona = objectMapper.readValue(new File(filename), ProviderPersona.class);
            System.out.println("providerPersona:" + providerPersona);
            objectMapper.writeValue(new File(testFilename), providerPersona);
            expProviderPersona = objectMapper.readValue(new File(filename), ProviderPersona.class);
            System.out.println("expProviderPersona:" + expProviderPersona);
            assertNotNull(providerPersona);
            assertNotNull(expProviderPersona);
            assertEquals(providerPersona.toString(), expProviderPersona.toString());
        } catch (IOException ex) {
            Logger.getLogger(ProviderPersonaTest.class.getName()).log(Level.SEVERE, null, ex);
            fail(ex.getMessage());
        }
    }

}
