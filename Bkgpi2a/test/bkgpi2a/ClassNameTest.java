package bkgpi2a;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme de test de la méthode pour lire la classe d'un objet
 *
 * @author Thierry Baribaud
 * @version 1.42.19
 */
public class ClassNameTest {

    public ClassNameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test de la méthode pour lire la classe d'un objet. On prendra ici l'objet
     * ClosedBeyondCallCenterScope.
     */
    @Test
    public void testClassName() {
        ClosedBeyondCallCenterScope closedBeyondCallCenterScope;
        String className;
        System.out.println("ClassName");

        closedBeyondCallCenterScope = new ClosedBeyondCallCenterScope();
        className = closedBeyondCallCenterScope.getClass().getSimpleName();
        System.out.println("closedBeyondCallCenterScope.getClass().getSimpleName():" + className);
        assertEquals(className, "ClosedBeyondCallCenterScope");
        
        className = this.getClass().getSimpleName();
        System.out.println("this.getClass().getSimpleName():" + className);
        assertEquals(className, "ClassNameTest");
        
    }

    /**
     * Test pour retrouver le nom de la classe d'un objet à partir de la classe mère
     */
    @Test
    public void testClassNameFromMotherClass() {
        ClosedBeyondCallCenterScope closedBeyondCallCenterScope;
        String className;
        Event event;
        System.out.println("ClassNameFromMotherClass");
        
        closedBeyondCallCenterScope = new ClosedBeyondCallCenterScope();
        event = closedBeyondCallCenterScope;
        className = event.getClass().getSimpleName();
        System.out.println("closedBeyondCallCenterScope.getClass().getSimpleName():" + className);
        assertEquals(className, "ClosedBeyondCallCenterScope");
    }
}
