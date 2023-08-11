package com.anstel.ticketEvents;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Jeux de tests pour tester toutes les classes des événements relatifs aux tickets
 *
 * @author Thierry Baribaud
 * @version 1.42.7
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    CallerCorrected.class,
    OpeningTicketPurposeCorrectedTest.class, 
    TicketEventInformationsCorrectedTest.class
})
public class TicketEventsSuite {

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
