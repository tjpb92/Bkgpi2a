package bkgpi2a;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Jeux de tests pour tester toutes les classes du projet
 *
 * @author Thierry Baribaud
 * @version 1.36
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CivilNameTest.class, ContextualCommentTest.class,
    ContextualCommentDisplayedOnTicketTest.class,
    CriterionChoiceTest.class, CriterionChoiceListTest.class, CriterionValueTest.class,
    DataGouvAPIIdCheckerTest.class,
    DissociateProviderContactFromPatrimonyTest.class,
    DocumentAttachedTest.class,
    EventTypeTest.class,
    GooglePlaceIdCheckerTest.class, ItemAbstractTest.class,
    InstructionsForAssigneeDefinedTest.class, ItemAbstractWithRefTest.class, 
    NotificationForInterventionAcceptedRequestedTest.class,
    OtpCategoryTest.class, 
    PatrimonyAbstractTest.class, PoorNameTest.class,
    ProviderCompanyInContactTest.class, ProviderContactActivityTest.class,
    ProviderContactDissociatedFromPatrimonyTest.class,
    ProviderContactQueryViewTest.class, ProviderContactResultViewTest.class,
    ProviderContactTest.class, 
    ReferencedContactCallerTest.class,
    SimplifiedRequestResultViewTest.class, SimplifiedRequestSearchViewTest.class,
    TicketOpenedTest.class, TicketOpenedFromSimplifiedRequestTest.class,
    TicketQualifiedByCriteriaTest.class,
    WorkflowAppliedToTicketTest.class
})
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
