package lltgh.rsd2g2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerMaintenanceAndInvoicePayment {

    Scanner scan = new Scanner(System.in);
    String addMore = null, cmipSelection = null;
    static int index = 1;
    boolean paid;
    InvListInterface<Invoice> invoice = new InvLinkedList();
    static List<String> unpaidInvNo = new ArrayList<>();

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
            System.out.println("4) Print Monthly Invoice");
            System.out.println("5) Back to main menu");
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
                    if (invoice.size() == 0) {
                        InitializeInv(invoice);
                    }
                    getUnpaidInvNo(invoice);
                    break;
                case "5":
                    break;
                default:
                    System.err.print("Invalid input. Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!cmipSelection.equals("5"));
    }

    // just for initialization
    public void InitializeInv(InvListInterface<Invoice> invoice) {
        //if (invoice.size() == 0) {
        // hard code inv 1
        Invoice inv1 = new Invoice(genInvID(), "27 Nov 2018", "C1", "Timothy", "0165769856", "ABC", "IDK the place", "Rose", 5.0, 5, 25.0, 25.0, "Unpaid");

        // hard code inv 2
        Invoice inv2 = new Invoice(genInvID(), "27 Nov 2018", "C1", "Timothy", "0165769856", "ABC", "IDK the place", "Jasmine", 5.0, 5, 25.0, 25.0, "Unpaid");

        // hard code inv 3
        Invoice inv3 = new Invoice(genInvID(), "25 Nov 2018", "C2", "Joshua Mok", "0165769856", "ABC", "IDK the place", "Carnation", 5.0, 5, 25.0, 25.0, "Paid");

        // hard code inv 4
        Invoice inv4 = new Invoice(genInvID(), "29 Nov 2018", "C2", "Joshua Mok", "0165769856", "ABC", "IDK the place", "Rose", 5.0, 5, 25.0, 25.0, "Unpaid");

        invoice.add(inv1);
        invoice.add(inv2);
        invoice.add(inv3);
        invoice.add(inv4);
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
        String searchbyID = scan.nextLine();
        for (int i = 0; i < invoice.size(); i++) {
            if (invoice.get(i).getCustID().toUpperCase().compareTo(searchbyID) == 0) {
                if (invoice.get(i).getInvoiceStatus().equals("Unpaid")) {
                    System.out.printf("Unpaid invoice of customer: %s\n", invoice.get(i).getInvoiceNo());
                    unpaidInvNo.add(invoice.get(i).getInvoiceNo());
                    printInv(invoice);
                } else {
                    System.err.println("This customer has no unpaid invoice for now.");
                }
            }
        }
    }

    // get unpaid invoice details
    public void printInv(InvListInterface<Invoice> invoice) {
        String conf = "";
        while (((!conf.toUpperCase().equals("Y")) && (!conf.toUpperCase().equals("YES"))) && ((!conf.toUpperCase().equals("N")) && (!conf.toUpperCase().equals("NO")))) {
            System.out.print("Print invoice? > ");
            conf = scan.nextLine();
        }

        if (conf.toUpperCase().equals("Y") || conf.toUpperCase().equals("YES")) {
            for (int i = 0; i < unpaidInvNo.size(); i++) {
                for (int j = 0; j < invoice.size(); j++) {
                    if (unpaidInvNo.get(i).equals(invoice.get(j).getInvoiceNo())) {
                        // invoice display format
                        System.out.printf("------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("|%53s%48s\n", "INVOICE", "|");
                        System.out.printf("|                                                                                     ---------------|\n");
                        System.out.printf("| To: %-20s%-60s|%13s||\n", invoice.get(j).getCustName(), " ", invoice.get(j).getInvoiceNo());
                        System.out.printf("|     %-20s%-60s|%13s||\n", invoice.get(j).getCustCorp(), " ", invoice.get(j).getDate());
                        System.out.printf("|     %-20s%-60s-%13s-|\n", invoice.get(j).getCorpAddr(), " ", "-------------");
                        System.out.printf("|----------------------------------------------------------------------------------------------------|\n");
                        System.out.printf("|%-3s|%-20s|%-12s|%-5s|%-10s|%-45s|\n", "No.", "Item", "Unit Price", "Qty", "Subtotal", "Description");
                        System.out.printf("|----------------------------------------------------------------------------------------------------|\n");
                        System.out.printf("|%-3d|%-20s|RM%10.2f|%5d|RM%8.2f|%-45s|\n", index, invoice.get(j).getItemName(), invoice.get(j).getItemPrice(),
                            invoice.get(j).getQty(), invoice.get(j).getSubtotal(), " ");
                        System.out.printf("|----------------------------------------------------------------------------------------------------|\n");
                        System.out.printf("|%89s RM%8.2f|\n", "Grand Total: ", invoice.get(j).getGrandTotal());
                        System.out.printf("|%89s ==========|\n", " ");
                        System.out.printf("|                                                                                                    |\n");
                        System.out.printf("|  %-5s%77s  |\n", "Customer Signature:", "Staff Signature:");
                        System.out.printf("|                                                                                                    |\n");
                        System.out.printf("|  %-5s%77s  |\n", "___________________", "________________");
                        System.out.printf("------------------------------------------------------------------------------------------------------\n");
                        genFile(invoice.get(j).getInvoiceNo(), invoice.get(j).getDate(), invoice.get(j).getCustID(), invoice.get(j).getCustName(),
                            invoice.get(j).getCustCorp(), invoice.get(j).getCorpAddr(), invoice.get(j).getItemName(), invoice.get(j).getItemPrice(),
                            invoice.get(j).getQty(), invoice.get(j).getSubtotal(), invoice.get(j).getGrandTotal());
                    }
                }
            }
        }
        unpaidInvNo.clear();
    }

    public void genFile(String invNo, String date, String custID, String name, String corp, String addr, String item, double price,
        int qty, double subtotal, double grandTotal) {
        // every invoice are store into different file
        String filename = custID + "_" + invNo + ".dat";
        try {
            // to store invoice with layout format
            FileWriter fwrt = new FileWriter("../LLTGH-Assignment/src/lltgh/rsd2g2/Invoice/" + filename);
            BufferedWriter bwrt = new BufferedWriter(fwrt);
            // to store invoice data
            FileWriter fw = new FileWriter("../LLTGH-Assignment/src/lltgh/rsd2g2/Invoice/Invoice.dat");
            BufferedWriter bw = new BufferedWriter(fw);
        } catch (FileNotFoundException ex) {

        } catch (IOException e) {

        }

    }

    public InvLinkedList<Invoice> readInvoiceFile() {
        InvListInterface<Invoice> invDat = new InvLinkedList<>();
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader("../LLTGH-Assignment/src/lltgh/rsd2g2/Invoice/Invoice.dat");
            br = new BufferedReader(fr);

            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                String[] s = currentLine.split("\\|");
                Invoice getInvDat = new Invoice(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], Double.parseDouble(s[8]),
                    Integer.parseInt(s[9]), Double.parseDouble(s[10]), Double.parseDouble(s[11]), s[12]);
                invDat.add(getInvDat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return (InvLinkedList<Invoice>) invDat;
    }
}
