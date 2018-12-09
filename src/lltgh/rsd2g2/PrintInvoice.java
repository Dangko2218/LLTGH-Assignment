package lltgh.rsd2g2;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;

public class PrintInvoice {
    CustomerRegistration regCust = new CustomerRegistration();
    public static List<Invoice> invoice = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    
    private String custID  = null, custName = null, custContact = null, custCorp = null, corpAddr = null;
    private int unpaid = 0;
    private static String getPINV[];
    
    public static int unpaidRec = 0;
    
    private void chkCustID(){
        System.out.print("Enter customer id > ");
        custID = input.nextLine();
        for (int i = 0; i < regCust.customerList.size(); i++){
            if (custID.equals(invoice.get(i).getCustID())){
                if (hasUnpaidRecord(custID)){
                    printInvoice(getPINV);
                }
                else {
                    System.out.print("This customer has no unpaid invoice.");
                    break;
                }
            }
        }
    }
    
    private boolean hasUnpaidRecord(String custID){
        boolean hasUnpaid = false;
        int k = 0;
        
        for (int i = 0; i < invoice.size(); i++){
            if (custID.equals(invoice.get(i).getCustID())){
                if (invoice.get(i).getInvoiceStatus().equals("Unpaid")){
                    hasUnpaid = true;
                    unpaidRec++;
                    getPINV[k] = invoice.get(i).getInvoiceNo();
                    k++;
                }
            }
        }
        return hasUnpaid;
    }
    
    private void printInvoice(String invNo[]){
        System.out.println("\f");
        /*
        for (int i = 0; i < 50; i++){
            System.out.print("=");
        }
        for (int i = 0; i < 50; i++){
            System.out.print("-");
        }
        for (int i = 0; i < 50; i++){
            System.out.print("-");
        }
        for (int i = 0; i < 50; i++){
            System.out.print("=");
        }
        */
        for (int i = 0; i < invNo.length; i++)
            System.out.println(invNo[i]);
               
    }
}
