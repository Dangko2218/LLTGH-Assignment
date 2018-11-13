package lltgh.rsd2g2;

import java.util.Scanner;

public class CustomerMaintenanceAndInvoicePayment {
    
    Scanner scan = new Scanner(System.in);
    String addMore = null;
    
    
    public void printTest(){
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
        int cmipSelection = scan.nextInt();
        
        switch(cmipSelection){
            case 1: 
                CustomerRegistration regCust = new CustomerRegistration();
                regCust.custReg();
                break;
            case 2:
                DisplayCustomerList displayList = new DisplayCustomerList();
                displayList.displayCust();
                break;
            case 3:
                break;                
            case 4:
                break;                
            case 5:
                break;
            case 6:
                System.exit(0);
                break;
        }
    }
    
}
