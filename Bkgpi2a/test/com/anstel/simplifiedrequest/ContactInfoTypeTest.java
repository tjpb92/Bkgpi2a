package com.anstel.simplifiedrequest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Programme de test de la classe ContactInfoType
 *
 * @author Thierry Baribaud
 * @version 1.42.15
 */
public class ContactInfoTypeTest {

    public ContactInfoTypeTest() {
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
     * Test of values method, of class ContactInfoType.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        ContactInfoType[] expResult = {ContactInfoType.PHONE, ContactInfoType.MAIL};
        ContactInfoType[] result = ContactInfoType.values();
        assertEquals(expResult.length, result.length);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class ContactInfoType.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");

        String name = "PHONE";
        ContactInfoType expResult = ContactInfoType.PHONE;
        ContactInfoType result = ContactInfoType.valueOf(name);
        assertEquals(expResult, result);

        name = "MAIL";
        expResult = ContactInfoType.MAIL;
        result = ContactInfoType.valueOf(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class ContactInfoType.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        ContactInfoType instance = ContactInfoType.PHONE;
        String expResult = "Phone";
        String result = instance.getName();
        assertEquals(expResult, result);

        instance = ContactInfoType.MAIL;
        expResult = "Mail";
        result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ContactInfoType.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        ContactInfoType instance = ContactInfoType.PHONE;
        String expResult = "Phone";
        String result = instance.toString();
        assertEquals(expResult, result);

        instance = ContactInfoType.MAIL;
        expResult = "Mail";
        result = instance.toString();
        assertEquals(expResult, result);
    }

}
