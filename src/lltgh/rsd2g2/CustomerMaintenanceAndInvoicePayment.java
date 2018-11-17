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
    public void printTest(){
        do{
        System.out.println("==========================================");
        System.out.println(" Customer Maintenance And Invoice Payment");
        System.out.println("==========================================");
        System.out.println("These are the options you can choose:");
        System.out.println("1) Customer Registration");
        System.out.println("2) View Customer List");
        System.out.println("3) To be confirmed");
        System.out.println("4) To be confirmed");
        System.out.println("5) To be confirmed");
        System.out.println("6) Exit");
        System.out.print("Please enter your option > ");
        
        cmipSelection = scan.nextLine();
        switch(cmipSelection){
            case "1": 
                CustomerRegistration regCust = new CustomerRegistration();
                regCust.custReg();
                break;
            case "2":
                DisplayCustomerList displayList = new DisplayCustomerList();
                displayList.displayCust();
                displayList.nCustList();
                displayList.cCustList();
                break;
            case "3":              
                break;                
            case "4":
                break;                
            case "5":
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
        }while(!cmipSelection.equals("6"));
    }
}
