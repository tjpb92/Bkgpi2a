package bkgpi2a;

import com.anstel.simplifiedrequest.ContactInfoTypeTest;
import com.anstel.simplifiedrequest.ContactToCallbackTest;
import com.anstel.simplifiedrequest.MailInfoTest;
import com.anstel.simplifiedrequest.PhoneInfoTest;
import com.anstel.simplifiedrequest.SimplifiedRequestDetailedView_bug230321Test;
import com.anstel.simplifiedrequest.SimplifiedRequestResultViewTest;
import com.anstel.simplifiedrequest.SimplifiedRequestSearchViewTest;
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
 * @version 1.42.3
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    AccessRestrictedToTicketTest.class,
    AgencyAbstractV1Test.class,
    AgencyAbstractV2Test.class,
    Bug200910TOTest.class,
    CivilNameTest.class, 
    bkgpi2a.ContactToCallbackTest.class, 
    com.anstel.simplifiedrequest.ContactToCallbackTest.class, 
    ContextualCommentTest.class,
    ContactInfoTypeTest.class,
    ContextualCommentDisplayedOnTicketTest.class,
    CriterionChoiceTest.class, CriterionChoiceListTest.class, CriterionValueTest.class,
    DataGouvAPIIdCheckerTest.class,
    DissociateProviderContactFromPatrimonyTest.class,
    DocumentAttachedTest.class,
    EventTypeTest.class,
    GooglePlaceIdCheckerTest.class, ItemAbstractTest.class,
    InstructionsForAssigneeDefinedTest.class, ItemAbstractWithRefTest.class,
    MailInfoTest.class,
    NotificationForInterventionAcceptedRequestedTest.class,
    OtpCategoryTest.class,
    PatrimonyAbstractTest.class, PoorNameTest.class,
    PhoneInfoTest.class,
    ProviderCompanyInContactTest.class, ProviderContactActivityTest.class,
    ProviderContactDissociatedFromPatrimonyTest.class,
    ProviderContactQueryViewTest.class, ProviderContactResultViewTest.class,
    ProviderContactTest.class,
    ReferencedContactCallerTest.class,
    ReferencedUserCallerTest.class,
    SimplifiedRequestDetailedView_bug230321Test.class,
    SimplifiedRequestResultViewTest.class, 
    SimplifiedRequestSearchViewTest.class,
    TicketOpenedTest.class, 
    TicketOpenedV1Test.class, 
    TicketOpenedV2Test.class,
    TicketOpenedFromSimplifiedRequestTest.class,
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
