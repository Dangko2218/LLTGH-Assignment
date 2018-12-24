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
import java.util.Date;
import java.util.Calendar;

public class CustomerMaintenanceAndInvoicePayment {

    Scanner scan = new Scanner(System.in);
    String addMore = null, cmipSelection = null, custName = null, custCorp = null, custAddr = null;
    boolean paid;
    static int index;
    CatalogOrders readOrder = new CatalogOrders();
    CatalogMaintenance readCatalog = new CatalogMaintenance();
    CustomerRegistration readCust = new CustomerRegistration();
    InvListInterface<Order> order = new InvLinkedList();
    InvListInterface<Invoice> invoice = new InvLinkedList();
    InvListInterface<Customer> cust = new InvLinkedList();
    static List<String> unpaidOrder = new ArrayList<>();

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
                    getUnpaidOrder(order);
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

    // generate invoice no
    public String genInvID() {
        index = invoice.size();
        String invNo = "INV" + String.format("%04d", ++index);
        return invNo;
    }

    //get the unpaid invoice no
    public void getUnpaidOrder(InvListInterface<Order> order) {
        order = readOrder.readOrderDatList();
        cust = readCust.readCustFile();
        System.out.print("Customer ID > ");
        String searchbyID = scan.nextLine();
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i).getCustId().toUpperCase().compareTo(searchbyID) == 0) {
                if (!order.get(i).getPayment().equals("Done")) {
                    System.out.printf("Unpaid order of customer: %s\n", order.get(i).getOrderId());
                    unpaidOrder.add(order.get(i).getOrderId());
                    printInv(order);
                } else {
                    System.err.println("This customer has no unpaid invoice for now.");
                }
            }
        }
    }

    // get unpaid invoice details
    public void printInv(InvListInterface<Order> order) {
        String conf = "";
        while (((!conf.toUpperCase().equals("Y")) && (!conf.toUpperCase().equals("YES"))) && ((!conf.toUpperCase().equals("N")) && (!conf.toUpperCase().equals("NO")))) {
            System.out.print("Print invoice? > ");
            conf = scan.nextLine();
        }

        if (conf.toUpperCase().equals("Y") || conf.toUpperCase().equals("YES")) {
            for (int i = 0; i < unpaidOrder.size(); i++) {
                for (int j = 0; j < order.size(); j++) {
                    if (unpaidOrder.get(i).equals(order.get(j).getOrderId())) {

                        for (int k = 0; k < cust.size(); k++){
                            if (order.get(j).getCustId().equals(cust.get(k).getCustID())){
                                custName = cust.get(k).getName();
                                custCorp = cust.get(k).getCustCorp();
                                custAddr = cust.get(k).getCorpAddr();
                            }
                        }

                        Calendar cal = Calendar.getInstance();
                        int day = cal.get(cal.DATE), intMonth = cal.get(cal.MONTH + 1), year = cal.get(cal.YEAR);
                        String month = "";
                        switch(intMonth){
                            case 1: month = "Jan"; break;
                            case 2: month = "Feb"; break;
                            case 3: month = "Mar"; break;
                            case 4: month = "Apr"; break;
                            case 5: month = "May"; break;
                            case 6: month = "Jun"; break;
                            case 7: month = "Jul"; break;
                            case 8: month = "Aug"; break;
                            case 9: month = "Sep"; break;
                            case 10: month = "Oct"; break;
                            case 11: month = "Nov"; break;
                            case 12: month = "Dec"; break;
                        }
                        String date = day + " "  + month + " "  + year;
                        String invNo = genInvID();

                        // invoice display format
                        System.out.printf("------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("|%53s%48s\n", "INVOICE", "|");
                        System.out.printf("|                                                                                     ---------------|\n");
                        System.out.printf("| To: %-20s%-60s|%13s||\n", custName, " ", invNo);
                        System.out.printf("|     %-20s%-60s|%13s||\n", custCorp, " ", date);
                        System.out.printf("|     %-20s%-60s-%13s-|\n", custAddr, " ", "-------------");
                        System.out.printf("|----------------------------------------------------------------------------------------------------|\n");
                        System.out.printf("|%-3s|%-20s|%-12s|%-5s|%-10s|%-45s|\n", "No.", "Item", "Unit Price", "Qty", "Subtotal", "Description");
                        System.out.printf("|----------------------------------------------------------------------------------------------------|\n");
                        for (int l = 0; l < order.get(j).getOrderItem().size(); l++){
                            int a = l + 1;
                            System.out.printf("|%-3d|%-20s|RM%10.2f|%5d|RM%8.2f|%-45s|\n", a, order.get(j).getOrderItem().get(l).toString(), order.get(j).getPrice().get(l),
                            order.get(j).getQuantity().get(l), order.get(j).getSubtotal().get(l), order.get(j).getDesc().get(l).toString());
                        }
                        System.out.printf("|----------------------------------------------------------------------------------------------------|\n");
                        System.out.printf("|%89s RM%8.2f|\n", "Grand Total: ", order.get(j).getTotal());
                        System.out.printf("|%89s ==========|\n", " ");
                        System.out.printf("|                                                                                                    |\n");
                        System.out.printf("|  %-5s%77s  |\n", "Customer Signature:", "Staff Signature:");
                        System.out.printf("|                                                                                                    |\n");
                        System.out.printf("|  %-5s%77s  |\n", "___________________", "________________");
                        System.out.printf("------------------------------------------------------------------------------------------------------\n");
                        genFile(order.get(j).getOrderId(), date, order.get(j).getCustId(), custName,
                            custCorp, custAddr, order.get(j).getOrderItem(), order.get(j).getPrice(),
                            order.get(j).getQuantity(), order.get(j).getSubtotal(), order.get(j).getTotal());
                    }
                }
            }
        }
        unpaidOrder.clear();
    }

    public void genFile(String invNo, String date, String custID, String name, String corp, String addr, List item, List price,
        List qty, List subtotal, double grandTotal) {
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

    // public InvLinkedList<Invoice> readInvoiceFile() {
    //     InvListInterface<Invoice> invDat = new InvLinkedList<>();
    //     BufferedReader br = null;
    //     FileReader fr = null;

    //     try {
    //         fr = new FileReader("../LLTGH-Assignment/src/lltgh/rsd2g2/Invoice/Invoice.dat");
    //         br = new BufferedReader(fr);

    //         String currentLine;

    //         while ((currentLine = br.readLine()) != null) {
    //             String[] s = currentLine.split("\\|");
    //             Invoice getInvDat = new Invoice(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], Double.parseDouble(s[8]),
    //                 Integer.parseInt(s[9]), Double.parseDouble(s[10]), Double.parseDouble(s[11]), s[12]);
    //             invDat.add(getInvDat);
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } finally {
    //         try {
    //             if (br != null) {
    //                 br.close();
    //             }
    //             if (fr != null) {
    //                 fr.close();
    //             }
    //         } catch (IOException ex) {
    //             ex.printStackTrace();
    //         }
    //     }
    //     return (InvLinkedList<Invoice>) invDat;
    // }

    // public List convertToItemList(String s1) {
    //     String[] item = s1.split(",");
    //     List itemList = new ArrayList();
    //     for (int i = 0; i < item.length; i++) {
    //         itemList.add(item[i]);
    //     }
    //     return itemList;
    // }

    // public List convertToQtyList(String s2) {
    //     String[] qty = s2.split(",");
    //     List qtyList = new ArrayList();
    //     for (int i = 0; i < qty.length; i++) {
    //         qtyList.add(qty[i]);
    //     }
    //     return qtyList;
    // }

    // public List convertToPriceList(String s3){
    //     String[] price = s3.split(",");
    //     List priceList = new ArrayList();
    //     for (int i = 0; i < price.length; i++)
    //         priceList.add(price[i]);
    //     return priceList;
    // }

    // public List convertToSubtotalList(String s4){
    //     String[] subtotal = s4.split(",");
    //     List subtotalList = new ArrayList();
    //     for (int i = 0; i < subtotal.length; i++)
    //         subtotalList.add(subtotal[i]);
    //     return subtotalList;
    // }

    // public List convertToDescList(String s5){
    //     String[] desc = s5.split(",");
    //     List descList = new ArrayList();
    //     for (int i = 0; i < desc.length; i++)
    //         descList.add(desc[i]);
    //     return descList;
    // }
}
