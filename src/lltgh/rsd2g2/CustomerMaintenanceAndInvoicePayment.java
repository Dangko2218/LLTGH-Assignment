package lltgh.rsd2g2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerMaintenanceAndInvoicePayment {

    Scanner scan = new Scanner(System.in);
    String addMore = null, cmipSelection = null;
    static int index = 1;
    boolean paid;
    InvListInterface<Invoice> invoice = new InvLinkedList();
    List<String> unpaidInvNo = new ArrayList<>();

    //testing?  // need all method do?
    public void printTest() throws IOException {
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
                    InitializeInv(invoice);
                    getUnpaidInvNo(invoice);
                    printInv(invoice);
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

    // just for initialization
    public void InitializeInv(InvListInterface<Invoice> invoice) {
        //if (invoice.size() == 0) {
            // hard code inv 1
            Invoice inv1 = new Invoice();
            inv1.setInvoiceNo(genInvID());
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

            // hard code inv 2
            Invoice inv2 = new Invoice();
            inv2.setInvoiceNo(genInvID());
            inv2.setDate("27 Nov 2018");
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
            inv3.setDate("29 Nov 2018");
            inv3.setCustID("C2");
            inv3.setCustName("Mou mou ren");
            inv3.setCustContact("0123456789");
            inv3.setCustCorp("mmr");
            inv3.setCorpAddr("Mars");
            inv3.setItemName("Rose");
            inv3.setItemPrice(5.0);
            inv3.setItemQty(5);
            inv3.setSubtotal(25.0);
            inv3.setGrandTotal(25.0);
            inv3.setInvoiceStatus("Unpaid");

            // hard code inv 4
            Invoice inv4 = new Invoice();
            inv4.setInvoiceNo(genInvID());
            inv4.setDate("29 Nov 2018");
            inv4.setCustID("C2");
            inv4.setCustName("Mou mou ren");
            inv4.setCustContact("0123456789");
            inv4.setCustCorp("mmr");
            inv4.setCorpAddr("Mars");
            inv4.setItemName("Carnation");
            inv4.setItemPrice(5.0);
            inv4.setItemQty(5);
            inv4.setSubtotal(25.0);
            inv4.setGrandTotal(25.0);
            inv4.setInvoiceStatus("Paid");

            //invoice.add(inv1);
            //invoice.add(inv2);
            //invoice.add(inv3);
            //invoice.add(inv4);
        //}

        //System.out.print(invoice.toString());
    }

    // generate invoice no
    public String genInvID() {
        String prefix = "INV";
        String invNo = prefix + String.format("%04d", index);
        index++;
        return invNo;
    }

    //get the unpaid invoice no
    public void getUnpaidInvNo(InvListInterface<Invoice> invoice) {
        System.out.print("Customer ID > ");
        String searchbyID = "C1";//scan.nextLine();
        for (int i = 0; i < invoice.size(); i++) {
            if (invoice.get(i).getCustID().compareTo(searchbyID) == 0) {
                System.out.printf("Unpaid invoice of customer: %s", invoice.get(i).getInvoiceNo());
                if (invoice.get(i).getInvoiceStatus().equals("Unpaid")) {
                    System.out.printf("Unpaid invoice: %s", invoice.get(i).getInvoiceNo());
                    unpaidInvNo.add(invoice.get(i).getInvoiceNo());
                }
            }
        }
    }

    // get unpaid invoice details
    public void printInv(InvListInterface<Invoice> invoice) {
        System.out.print("Print invoice? > ");
        String conf = "Y";//scan.nextLine();
        for (int i = 0; i < unpaidInvNo.size(); i++) {
            for (int j = 0; j < invoice.size(); j++) {
                if (invoice.get(j).getInvoiceNo().equals(unpaidInvNo.get(i))) {
                    System.out.println(invoice.get(j).getInvoiceNo());
                    //genFile(invoice.get(j).getCustID(), invoice.get(j).getInvoiceNo());

                }
            }
            unpaidInvNo.set(i, null);
        }
    }

//    public void genFile(String custID, String invNo){
//        // every invoice are store into different file
//        String filename = custID + "_" + invNo;
//        try {
//            FileWriter fwrt = new FileWriter(filename);
//            BufferedWriter bwrt = new BufferedWriter(fwrt);
//        } catch(FileNotFoundException ex) {
//            
//        } catch (IOException e) {
//
//        }
//
//    }
}
