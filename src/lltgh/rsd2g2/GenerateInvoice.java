package lltgh.rsd2g2;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;

public class GenerateInvoice {
    CustomerRegistration regCust = new CustomerRegistration();
    public static List<Invoice> invoice = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    
    private String custID  = null, custName = null, custContact = null, custCorp = null, corpAddr = null;
    private int unpaid = 0;
    
    private void chkCustID(){
        System.out.print("Enter customer id > ");
        custID = input.nextLine();
        for (int i = 0; i < regCust.customerList.size(); i++){
            if(custID.equals(regCust.customerList.get(i).getCustID())){
                for (int j = 0; j < invoice.size(); j++){
                    if (custID.equals(invoice.get(j).getCustID()) && invoice.get(j).getInvoiceStatus().equals("Paid")){
                        System.out.println("This customer has no unpaid invoice.");
                    }
                }
            }
        }
    }
}
