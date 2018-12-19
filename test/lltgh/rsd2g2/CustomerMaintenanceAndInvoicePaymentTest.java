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
public class CustomerMaintenanceAndInvoicePaymentTest {

    public CustomerMaintenanceAndInvoicePaymentTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of InitializeInv method, of class
     * CustomerMaintenanceAndInvoicePayment.
     */
    @Test
    public void testInitializeInv() {
        System.out.println("InitializeInv");
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        InvListInterface<Invoice> invoice = new InvLinkedList<>();
        instance.InitializeInv(invoice);
        Invoice inv1 = new Invoice();
        inv1.setInvoiceNo("INV0009");
        inv1.setDate("27 Nov 2018");
        inv1.setCustID("C1");
        inv1.setCustName("Timothy");
        inv1.setCustContact("0165769856");
        inv1.setCustCorp("ABC Co.");
        inv1.setCorpAddr("IDK the place");
        inv1.setItemName("Rose");
        inv1.setItemPrice(5.0);
        inv1.setItemQty(5);
        inv1.setSubtotal(25.0);
        inv1.setGrandTotal(25.0);
        inv1.setInvoiceStatus("Unpaid");

        instance.InitializeInv(invoice);
        

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of genInvID method, of class CustomerMaintenanceAndInvoicePayment.
     */
    @Test
    public void testGenInvID() {
        System.out.println("genInvID");
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        String expResult = "INV0009";
        String result = instance.genInvID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUnpaidInvNo method, of class
     * CustomerMaintenanceAndInvoicePayment.
     */
    @Test
    public void testGetUnpaidInvNo() {
        System.out.println("getUnpaidInvNo");
        InvListInterface<Invoice> invoice = new InvLinkedList<>();
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        instance.getUnpaidInvNo(invoice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of printInv method, of class CustomerMaintenanceAndInvoicePayment.
     */
    @Test
    public void testPrintInv() {
        System.out.println("printInv");
        InvListInterface<Invoice> invoice = new InvLinkedList<>();
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        instance.printInv(invoice);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of genFile method, of class CustomerMaintenanceAndInvoicePayment.
     */
//    @Test
//    public void testGenFile() {
//        System.out.println("genFile");
//        String custID = "";
//        String invNo = "";
//        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
//        instance.genFile(custID, invNo);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    /**
     * Test of printTest method, of class CustomerMaintenanceAndInvoicePayment.
     */
//    @Test
//    public void testPrintTest() throws Exception {
//        System.out.println("printTest");
//        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
//        instance.printTest();
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
}
