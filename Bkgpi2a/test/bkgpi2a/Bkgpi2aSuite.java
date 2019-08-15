package bkgpi2a;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Jeux de tests pour tester toute les classes du projet
 *
 * @author Thierry Baribaud
 * @version 1.13
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DataGouvAPIIdCheckerTest.class, EventTypeTest.class,
    GooglePlaceIdCheckerTest.class, ProviderContactActivityTest.class,
    ProviderCompanyInContactTest.class, ProviderContactQueryViewTest.class})
public class Bkgpi2aSuite {

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
