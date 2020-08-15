package bkgpi2a;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Jeux de tests pour tester l'enum EventType
 * @author Thierry Baribaud
 * @version 1.35
 */
public class EventTypeTest {

    private final Map<Integer, EventType> lookupByUid;
  
    public EventTypeTest() {
        
        lookupByUid = new HashMap<>();
        for (EventType eventType:EventType.values()) {
            lookupByUid.put(eventType.getUid(), eventType);
        }
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
     * Test of values method, of class EventType.
     */
    @Test
    public void testValues() {
        System.out.println("EventType.values()");
    
        System.out.println(EventType.values().length + " values in EventType");
//        for(EventType eventType:EventType.values()) {
//            System.out.println("  name:"+eventType.getName() + ", uid:" + eventType.getUid());
//        }
        
        int expResult = 47;
        int result = EventType.values().length;
        
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class EventType.
     */
    @Test
    public void testValueOf() {
        System.out.println("EventType.valueOf()");
        
        EventType expResult = EventType.TICKET_OPENED;
        EventType result = EventType.valueOf("TICKET_OPENED");
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class EventType.
     */
    @Test
    public void testGetName() {
        System.out.println("EventType.getName()");

        String expResult = "TicketOpened";
        String result = EventType.TICKET_OPENED.getName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getUid method, of class EventType.
     */
    @Test
    public void testGetUid() {
        System.out.println("EventType.getUid");
        
        int expResult = 500;
        int result = EventType.TICKET_OPENED.getUid();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of reverse Uid lookup
     */
    @Test
    public void testReverseUidLookup() {
//        Map<Integer, EventType> lookupByUid;
        
        System.out.println("Reverse Uid Lookup");

//        lookupByUid = new HashMap<>();
//        for (EventType eventType:EventType.values()) {
//            lookupByUid.put(eventType.getUid(), eventType);
//        }
        
        EventType expResult = EventType.TICKET_OPENED;
        EventType result = lookupByUid.get(new Integer(500));
        
        assertEquals(expResult, result);
    }

    /**
     * Test of out of bound Uid lookup
     */
    @Test
    public void testOutOfBoundUidLookup() {
        
        System.out.println("outOfBound Uid Lookup");

        EventType expResult = lookupByUid.get(new Integer(666));
        
        assertNull(expResult);
    }
    
}
