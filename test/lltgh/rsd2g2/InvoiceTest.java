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
public class InvoiceTest {
    
    Invoice instance = new Invoice("PINV0004", "12/12/2018", "C3", "Merlin", "0103472369", "Line Corp", "idk where's line corp", "Rose are red", 5.5, 99, 544.5, 544.5, "Paid");
    
    public InvoiceTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of setInvoiceNo method, of class Invoice.
     */
    @Test
    public void testSetInvoiceNo() {
        System.out.println("setInvoiceNo");
        String invoiceNo = "PINV0004";
        //Invoice instance = new Invoice();
        instance.setInvoiceNo(invoiceNo);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getInvoiceNo method, of class Invoice.
     */
    @Test
    public void testGetInvoiceNo() {
        System.out.println("getInvoiceNo");
        //Invoice instance = new Invoice();
        String expResult = "PINV0004";
        String result = instance.getInvoiceNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    // /**
    //  * Test of setDate method, of class Invoice.
    //  */
    // @Test
    // public void testSetDate() {
    //     System.out.println("setDate");
    //     String date = "12/12/2018";
    //     instance.setDate(date);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getDate method, of class Invoice.
    //  */
    // @Test
    // public void testGetDate() {
    //     System.out.println("getDate");
    //     String expResult = "12/12/2018";
    //     String result = instance.getDate();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setCustID method, of class Invoice.
    //  */
    // @Test
    // public void testSetCustID() {
    //     System.out.println("setCustID");
    //     String custID = "C3";
    //     instance.setCustID(custID);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getCustID method, of class Invoice.
    //  */
    // @Test
    // public void testGetCustID() {
    //     System.out.println("getCustID");
    //     String expResult = "C3";
    //     String result = instance.getCustID();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setCustName method, of class Invoice.
    //  */
    // @Test
    // public void testSetCustName() {
    //     System.out.println("setCustName");
    //     String custName = "Merlin";
    //     instance.setCustName(custName);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getCustName method, of class Invoice.
    //  */
    // @Test
    // public void testGetCustName() {
    //     System.out.println("getCustName");
    //     String expResult = "Merlin";
    //     String result = instance.getCustName();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setCustContact method, of class Invoice.
    //  */
    // @Test
    // public void testSetCustContact() {
    //     System.out.println("setCustContact");
    //     String custContact = "0102883211";
    //     instance.setCustContact(custContact);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getCustContact method, of class Invoice.
    //  */
    // @Test
    // public void testGetCustContact() {
    //     System.out.println("getCustContact");
    //     String expResult = "0102883211";
    //     String result = instance.getCustContact();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setCustCorp method, of class Invoice.
    //  */
    // @Test
    // public void testSetCustCorp() {
    //     System.out.println("setCustCorp");
    //     String custCorp = "Line Corp";
    //     instance.setCustCorp(custCorp);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getCustCorp method, of class Invoice.
    //  */
    // @Test
    // public void testGetCustCorp() {
    //     System.out.println("getCustCorp");
    //     String expResult = "Line Corp";
    //     String result = instance.getCustCorp();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setCorpAddr method, of class Invoice.
    //  */
    // @Test
    // public void testSetCorpAddr() {
    //     System.out.println("setCorpAddr");
    //     String corpAddr = "idk where's line corp";
    //     instance.setCorpAddr(corpAddr);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getCorpAddr method, of class Invoice.
    //  */
    // @Test
    // public void testGetCorpAddr() {
    //     System.out.println("getCorpAddr");
    //     String expResult = "idk where's line corp";
    //     String result = instance.getCorpAddr();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setItemName method, of class Invoice.
    //  */
    // @Test
    // public void testSetItemName() {
    //     System.out.println("setItemName");
    //     String itemName = "Rose are red";
    //     instance.setItemName(itemName);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getItemName method, of class Invoice.
    //  */
    // @Test
    // public void testGetItemName() {
    //     System.out.println("getItemName()");
    //     String expResult = "Rose are red";
    //     String result = instance.getItemName();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setItemPrice method, of class Invoice.
    //  */
    // @Test
    // public void testSetItemPrice() {
    //     System.out.println("setItemPrice()");
    //     double itemPrice = 5.5;
    //     instance.setItemPrice(itemPrice);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getItemPrice method, of class Invoice.
    //  */
    // @Test
    // public void testGetItemPrice() {
    //     System.out.println("getItemPrice()");
    //     double expResult = 5.5;
    //     double result = instance.getItemPrice();
    //     assertEquals(expResult, result, 0.00);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setItemQty method, of class Invoice.
    //  */
    // @Test
    // public void testSetItemQty() {
    //     System.out.println("setItemQty()");
    //     int qty = 99;
    //     instance.setItemQty(qty);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getQty method, of class Invoice.
    //  */
    // @Test
    // public void testGetQty() {
    //     System.out.println("getQty()");
    //     int expResult = 99;
    //     int result = instance.getQty();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setSubtotal method, of class Invoice.
    //  */
    // @Test
    // public void testSetSubtotal() {
    //     System.out.println("setSubtotal()");
    //     double subtotal = 544.5;
    //     instance.setSubtotal(subtotal);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getSubtotal method, of class Invoice.
    //  */
    // @Test
    // public void testGetSubtotal() {
    //     System.out.println("getSubtotal()");
    //     double expResult = 544.5;
    //     double result = instance.getSubtotal();
    //     assertEquals(expResult, result, 0.00);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setGrandTotal method, of class Invoice.
    //  */
    // @Test
    // public void testSetGrandTotal() {
    //     System.out.println("setGrandTotal()");
    //     double grandTotal = 544.5;
    //     instance.setGrandTotal(grandTotal);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getGrandTotal method, of class Invoice.
    //  */
    // @Test
    // public void testGetGrandTotal() {
    //     System.out.println("getGrandTotal()");
    //     double expResult = 544.5;
    //     double result = instance.getGrandTotal();
    //     assertEquals(expResult, result, 0.00);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of setInvoiceStatus method, of class Invoice.
    //  */
    // @Test
    // public void testSetInvoiceStatus() {
    //     System.out.println("setInvoiceStatus()");
    //     String invoiceStatus = "Paid";
    //     instance.setInvoiceStatus(invoiceStatus);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of getInvoiceStatus method, of class Invoice.
    //  */
    // @Test
    // public void testGetInvoiceStatus() {
    //     System.out.println("getInvoiceStatus()");
    //     String expResult = "Paid";
    //     String result = instance.getInvoiceStatus();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }

    // /**
    //  * Test of toString method, of class Invoice.
    //  */
    // @Test
    // public void testToString() {
    //     System.out.println("toString()");
    //     String expResult = "Invoice Printed";
    //     String result = instance.toString();
    //     assertEquals(expResult, result);
    //     // TODO review the generated test code and remove the default call to fail.
    //     //fail("The test case is a prototype.");
    // }
    
}
