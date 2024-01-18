package com.anstel.httpsclient;

import bkgpi2a.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme permettant de tester l'objet Range
 *
 * @author Thierry Baribaud
 * @version 1.42.14
 */
public class RangeTest {

    public RangeTest() {
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
     * Test creation de l'objet Range.
     */
    @Test
    public void testRangeCreation() {
        System.out.println("RangeCreation");
        Range range = new Range("0-29/30", "100");

        assertEquals(range.getPage(), 100);
        assertEquals(range.getOffset(), 0);
        assertEquals(range.getLimit(), 29);
        assertEquals(range.getCount(), 30);
        assertFalse(range.hasNext());
    }

    /**
     * Test de l'objet Range avec les valeurs 0-99/100.
     */
    @Test
    public void testRange_0_99_100() {
        System.out.println("Range_0_99_100");
        Range range = new Range("0-99/100", "100");

        assertEquals(range.getPage(), 100);
        assertEquals(range.getOffset(), 0);
        assertEquals(range.getLimit(), 99);
        assertEquals(range.getCount(), 100);
        assertFalse(range.hasNext());
    }

    /**
     * Test de l'objet Range avec les valeurs 0-99/101.
     */
    @Test
    public void testRange_0_99_101() {
        System.out.println("Range_0_99_101");
        Range range = new Range("0-99/101", "100");

        assertEquals(range.getPage(), 100);
        assertEquals(range.getOffset(), 0);
        assertEquals(range.getLimit(), 99);
        assertEquals(range.getCount(), 101);

        assertTrue(range.hasNext());
//        System.out.println("hasNext:" + range.hasNext());
        System.out.println("offset:" + range.getOffset());
        System.out.println("limit:" + range.getLimit());
        System.out.println("count:" + range.getCount());
        assertEquals(range.getOffset(), 100);
        assertEquals(range.getLimit(), 101);

        assertFalse(range.hasNext());
    }

    /**
     * Test de l'objet Range avec les valeurs 0-99/215.
     */
    @Test
    public void testRange_0_99_215() {
        System.out.println("Range_0_99_215");
        Range range = new Range("0-99/215", "100");

        assertEquals(range.getPage(), 100);
        assertEquals(range.getOffset(), 0);
        assertEquals(range.getLimit(), 99);
        assertEquals(range.getCount(), 215);

        assertTrue(range.hasNext());
//        System.out.println("hasNext:" + range.hasNext());
        System.out.println("offset:" + range.getOffset());
        System.out.println("limit:" + range.getLimit());
        System.out.println("count:" + range.getCount());
        assertEquals(range.getOffset(), 100);
        assertEquals(range.getLimit(), 199);

        assertTrue(range.hasNext());
//        System.out.println("hasNext:" + range.hasNext());
        System.out.println("offset:" + range.getOffset());
        System.out.println("limit:" + range.getLimit());
        System.out.println("count:" + range.getCount());
        assertEquals(range.getOffset(), 200);
        assertEquals(range.getLimit(), 215);

        assertFalse(range.hasNext());
    }

}
