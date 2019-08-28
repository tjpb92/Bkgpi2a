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
 * @version 1.20
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CivilName.class, DataGouvAPIIdCheckerTest.class,
    DissociateProviderContactFromPatrimonyTest.class,
    EventTypeTest.class,
    GooglePlaceIdCheckerTest.class, ItemAbstractTest.class,
    ItemAbstractWithRefTest.class, PoorName.class,
    ProviderCompanyInContactTest.class, ProviderContactActivityTest.class,
    ProviderContactQueryViewTest.class, ProviderContactResultViewTest.class,
    ProviderContactTest.class})
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
