package lltgh.rsd2g2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author TG
 */
public class CustomerMaintenanceAndInvoicePaymentTest {

    public CustomerMaintenanceAndInvoicePaymentTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testInitializeInv() {
        System.out.println("InitializeInv");
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        InvListInterface<Invoice> invoice = new InvLinkedList<>();
        instance.InitializeInv(invoice);
    }

    @Test
    public void testGenInvID() {
        System.out.println("genInvID");
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        String expResult = "INV0005";
        String result = instance.genInvID();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrintInv() {
        System.out.println("printInv");
        InvListInterface<Invoice> invoice = new InvLinkedList<>();
        // expected result
        String invoiceNo = "INV0005";
        String date = "27 Nov 2018";
        String custID = "C1";
        String custName = "Timothy";
        String custContact = "0165769856";
        String custCorp = "ABC Co.";
        String corpAddr = "IDK the place";
        String itemName = "Rose";
        double itemPrice = 5.0;
        int itemQty = 5;
        double subtotal = 25.0;
        double grandTotal = 25.0;
        String invoiceStatus = "Unpaid";
//        Invoice inv = new Invoice();
//        inv.setInvoiceNo(invoiceNo);
//        inv.setCorpAddr(corpAddr);
//        inv.setCustID(custID);
//        inv.setCustContact(custContact);
//        inv.setCustCorp(custCorp);
//        inv.setCustName(custName);
//        inv.setDate(date);
//        inv.setGrandTotal(grandTotal);
//        inv.setInvoiceStatus(invoiceStatus);
//        inv.setItemName(itemName);
//        inv.setItemPrice(itemPrice);
//        inv.setItemQty(itemQty);
//        inv.setSubtotal(subtotal);
//        invoice.add(inv);  
        
        // compare
        CustomerMaintenanceAndInvoicePayment instance = new CustomerMaintenanceAndInvoicePayment();
        instance.printInv(invoice);
        assertEquals(invoiceNo, invoice.get(0).getInvoiceNo());
        assertEquals(date, invoice.get(0).getDate());
        assertEquals(custID, invoice.get(0).getCustID());
        assertEquals(custName, invoice.get(0).getCustName());
        assertEquals(custContact, invoice.get(0).getCustContact());
        assertEquals(custCorp, invoice.get(0).getCustCorp());
        assertEquals(corpAddr, invoice.get(0).getCorpAddr());
        assertEquals(itemName, invoice.get(0).getItemName());
        assertEquals(itemPrice, invoice.get(0).getItemPrice(), 0.0);
        assertEquals(itemQty, invoice.get(0).getQty());
        assertEquals(subtotal, invoice.get(0).getSubtotal(), 0.0);
        assertEquals(grandTotal, invoice.get(0).getGrandTotal(), 0.0);
        assertEquals(invoiceStatus, invoice.get(0).getInvoiceStatus());
    }
}
