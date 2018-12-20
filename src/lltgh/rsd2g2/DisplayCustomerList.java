package lltgh.rsd2g2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayCustomerList {
    CustomerRegistration regCust = new CustomerRegistration();
    
    Scanner scan = new Scanner(System.in);
    
    private String choice;
    
    public void displayMenu(){
        System.out.println("==================================");
        System.out.println("| 1. Display normal customer     |");
        System.out.println("| 2. Display corporate customer  |");
        System.out.println("| 3. Display all                 |");
        System.out.println("| 4. Back                        |");
        System.out.println("==================================");
        System.out.print("What to display > ");
        choice = scan.nextLine();
        switch(choice){
            case "1":
                nCustList();
                break;
            case "2":
                cCustList();
                break;
            case "3":
                displayAll();
                break;
            case "4":
                break;
            default:
                System.out.println("***Invalid input, please enter between 1 to 3.***");
                System.out.print("Press enter to continue...");
                try {
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
    }
    
    // display all
    private void displayAll(){
        System.out.println("List of all customer :");
        for (int i = 0; i < regCust.customerList.size(); i++){
            if (regCust.customerList.get(i).getType().equals("Corporate"))
            System.out.printf("ID : " + regCust.customerList.get(i).getCustID() + "\n"
                    + "Name : " + regCust.customerList.get(i).getName() + "\n"
                    + "IC : " + regCust.customerList.get(i).getCustIC() + "\n"
                    + "Contact No. : " + regCust.customerList.get(i).getContactNo()+ "\n"
                    + "Type : " + regCust.customerList.get(i).getType() + "\n"
                    + "Corporation Name : " + regCust.customerList.get(i).getCustCorp()+ "\n"
                    + "Corporation Addr : " + regCust.customerList.get(i).getCorpAddr()+ "\n"
                    + "Credit Liimit : " + regCust.customerList.get(i).getCreditLimit() + "\n\n");
            else
                System.out.printf("ID : " + regCust.customerList.get(i).getCustID() + "\n"
                    + "Name : " + regCust.customerList.get(i).getName() + "\n"
                    + "IC : " + regCust.customerList.get(i).getCustIC() + "\n"
                    + "Contact No. : " + regCust.customerList.get(i).getContactNo()+ "\n"
                    + "Type : " + regCust.customerList.get(i).getType() + "\n\n");
        }
    }
    
    // display normal only
    private void nCustList(){
        System.out.println("List of normal customer :");
        for (int i = 0; i < regCust.customerList.size(); i++)
            if (regCust.customerList.get(i).getType().equals("Normal"))
                System.out.printf("ID : " + regCust.customerList.get(i).getCustID() + "\n"
                    + "Name : " + regCust.customerList.get(i).getName() + "\n"
                    + "IC : " + regCust.customerList.get(i).getCustIC() + "\n"
                    + "Contact No. : " + regCust.customerList.get(i).getContactNo()+ "\n"
                    + "Type : " + regCust.customerList.get(i).getType() + "\n\n");
    }
    
    // display corporate only
    private void cCustList(){
        System.out.println("List of corporate customer :");
        for (int i = 0; i < regCust.customerList.size(); i++){
            if (regCust.customerList.get(i).getType().equals("Corporate"))
                System.out.printf("ID : " + regCust.customerList.get(i).getCustID() + "\n"
                    + "Name : " + regCust.customerList.get(i).getName() + "\n"
                    + "IC : " + regCust.customerList.get(i).getCustIC() + "\n"
                    + "Contact No. : " + regCust.customerList.get(i).getContactNo()+ "\n"
                    + "Type : " + regCust.customerList.get(i).getType() + "\n"
                    + "Corporation Name : " + regCust.customerList.get(i).getCustCorp()+ "\n"
                    + "Corporation Addr : " + regCust.customerList.get(i).getCorpAddr()+ "\n"
                    + "Credit Liimit : " + regCust.customerList.get(i).getCreditLimit() + "\n\n");
        }
    }
    
    private void formatter(){
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("|  ID   |             Name              |         IC        |    Contact   |");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("| " + custID + " | " + custName + " | " + custIC + " | " + custContact + " |");
        System.out.println("----------------------------------------------------------------------------");
        
    }
}
