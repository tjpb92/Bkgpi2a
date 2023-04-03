package com.anstel.simplifiedrequest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Jeux de tests pour tester toutes les classes du projet de mobilité
 *
 * @author Thierry Baribaud
 * @version 1.42.3
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    ContactInfoTypeTest.class,
    ContactToCallbackTest.class,
    MailInfoTest.class,
    PhoneInfoTest.class,
    SimplifiedRequestDetailedView_bug230321Test.class,
    SimplifiedRequestResultViewTest.class, 
    SimplifiedRequestSearchViewTest.class
})
public class SimplifiedRequestSuite {

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
