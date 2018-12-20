/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ACER
 */
public class CustomerRegistrationTest {
    
    public CustomerRegistrationTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of custReg method, of class CustomerRegistration.
     */
    @Test
    public void testCustReg() throws Exception {
        System.out.println("custReg");
        CustomerRegistration instance = new CustomerRegistration();
        instance.custReg();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of selectType method, of class CustomerRegistration.
     */
    @Test
    public void testSelectType() {
        System.out.println("selectType");
        CustomerRegistration instance = new CustomerRegistration();
        String expResult = "2";
        String result = instance.selectType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateCustID method, of class CustomerRegistration.
     */
    @Test
    public void testGenerateCustID() {
        System.out.println("generateCustID");
        String type = "";
        CustomerRegistration instance = new CustomerRegistration();
        String expResult = "C1";
        String result = instance.generateCustID(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
