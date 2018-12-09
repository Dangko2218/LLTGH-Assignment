package lltgh.rsd2g2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerMaintenanceAndInvoicePayment {

    Scanner scan = new Scanner(System.in);
    String addMore = null;
    String cmipSelection = null;

    //testing?
    public void printTest() {
        do {
            System.out.println("==========================================");
            System.out.println(" Customer Maintenance And Invoice Payment");
            System.out.println("==========================================");
            System.out.println("These are the options you can choose:");
            System.out.println("1) Customer Registration");
            System.out.println("2) View Customer List");
            System.out.println("3) Modify credit limit");
            System.out.println("4) Customer Payment Status");
            System.out.println("5) Print Monthly Invoice");
            System.out.println("6) Back to main menu");
            System.out.print("Please enter your option > ");

            cmipSelection = scan.nextLine();
            switch (cmipSelection) {
                case "1":
                    CustomerRegistration regCust = new CustomerRegistration();
                    regCust.custReg();
                    break;
                case "2":
                    DisplayCustomerList displayList = new DisplayCustomerList();
                    displayList.displayMenu();
                    break;
                case "3":
                    EditCustDetails editCustDetail = new EditCustDetails();
                    editCustDetail.modCreditLimit();
                    break;
                case "4":
                    break;
                case "5":
                    printInv();
                    break;
                case "6":
                    break;
                default:
                    System.out.print("Invalid input. Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!cmipSelection.equals("6"));
    }

    public void printInv() {
        // hard code inv 1
        Invoice inv1 = new Invoice();
        inv1.setInvoiceNo(genInvID());
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

        // hard code inv 2
        Invoice inv2 = new Invoice();
        inv2.setInvoiceNo(genInvID());
        inv2.setCustID("C1");
        inv2.setCustName("Timothy");
        inv2.setCustContact("0165769856");
        inv2.setCustCorp("ABC Co.");
        inv2.setCorpAddr("IDK the place");
        inv2.setItemName("Jasmine");
        inv2.setItemPrice(3.0);
        inv2.setItemQty(5);
        inv2.setSubtotal(15.0);
        inv2.setGrandTotal(15.0);
        inv2.setInvoiceStatus("Unpaid");

        // hard code inv 3
        Invoice inv3 = new Invoice();
        inv3.setInvoiceNo(genInvID());
        inv3.setCustID("C2");
        inv3.setCustName("Mou mou ren");
        inv3.setCustContact("0123456789");
        inv3.setCustCorp("mmr");
        inv3.setCorpAddr("parallel world");
        inv3.setItemName("Rose");
        inv3.setItemPrice(5.0);
        inv3.setItemQty(5);
        inv3.setSubtotal(25.0);
        inv3.setGrandTotal(25.0);
        inv3.setInvoiceStatus("Unpaid");

        InvListInterface<Invoice> invoice = new InvLinkedList<>();
        invoice.add(inv1);
        invoice.add(inv2);
        invoice.add(inv3);

        System.out.println(invoice.toString());//get all items detail from all the linkedList's nodes
        //-------------------------------------------------------------

        //System.out.println(invoice.get(0).getCustID());
        //System.out.println(invoice.get(1).getItemName());
        //System.out.println(invoice.get(2).getInvoiceNo());
        //System.out.println(invoice.get(0).getGrandTotal());
    }

    public String genInvID() {
        String prefix = "INV";
        int index = 1;
        String invNo = prefix + String.format("%04d", index);
        index++;

        return invNo;
    }
}
