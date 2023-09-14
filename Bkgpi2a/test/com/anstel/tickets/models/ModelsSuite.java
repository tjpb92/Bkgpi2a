package com.anstel.tickets.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Jeux de tests pour tester toutes les classes relatives auw modèles utilisés dans le projet
 *
 * @author Thierry Baribaud
 * @version 1.42.11
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    ProviderPersonaTest.class,
    UnClassifiedPersonaTest.class
})
public class ModelsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
