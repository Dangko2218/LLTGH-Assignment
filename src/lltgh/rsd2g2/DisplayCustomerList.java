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

    public void displayMenu() {
        System.out.println("==================================");
        System.out.println("| 1. Display normal customer     |");
        System.out.println("| 2. Display corporate customer  |");
        System.out.println("| 3. Display all                 |");
        System.out.println("| 4. Back                        |");
        System.out.println("==================================");
        System.out.print("What to display > ");
        choice = scan.nextLine();
        switch (choice) {
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
    private void displayAll() {
        System.out.println("List of all customer :");
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--%-9s--%-20s--%-30s--%-12s--\n", "----", "------------------------------", "--------------", "-----------", "---------", "--------------------", "------------------------------", "------------");
        System.out.printf("|%-4s |%-30s |%-14s |%-11s |%-9s |%-20s |%-30s |%-12s |\n", "ID", "Name", "IC", "Contact", "Type", "Corporate", "Address", "Credit Limit");
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--%-9s--%-20s--%-30s--%-12s--\n", "----", "------------------------------", "--------------", "-----------", "---------", "--------------------", "------------------------------", "------------");
        for (int i = 0; i < regCust.customerList.size(); i++) 
            System.out.printf("|%-4s |%-30s |%-14s |%-11s |%-9s |%-20s |%-30s |RM %10.2f|\n", regCust.customerList.get(i).getCustID(), regCust.customerList.get(i).getName(), regCust.customerList.get(i).getCustIC(), regCust.customerList.get(i).getContactNo(), regCust.customerList.get(i).getType(), regCust.customerList.get(i).getCustCorp(), regCust.customerList.get(i).getCorpAddr(), regCust.customerList.get(i).getCreditLimit());
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--%-9s--%-20s--%-30s--%-12s--\n", "----", "------------------------------", "--------------", "-----------", "---------", "--------------------", "------------------------------", "------------");
    }

    // display normal only
    private void nCustList() {
        System.out.println("List of normal customer :");
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--\n", "----", "------------------------------", "--------------", "-----------");
        System.out.printf("|%-4s |%-30s |%-14s |%-11s |\n", "ID", "Name", "IC", "Contact");
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--\n", "----", "------------------------------", "--------------", "-----------");
        for (int i = 0; i < regCust.customerList.size(); i++) 
            if (regCust.customerList.get(i).getType().equals("Normal")) 
                System.out.printf("|%-4s |%-30s |%-14s |%-11s |\n", regCust.customerList.get(i).getCustID(), regCust.customerList.get(i).getName(), regCust.customerList.get(i).getCustIC(), regCust.customerList.get(i).getContactNo()); 
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--\n", "----", "------------------------------", "--------------", "-----------");
    }

    // display corporate only
    private void cCustList() {
        System.out.println("List of corporate customer :");
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--%-9s--%-20s--%-30s--%-12s--\n", "----", "------------------------------", "--------------", "-----------", "---------", "--------------------", "------------------------------", "------------");
        System.out.printf("|%-4s |%-30s |%-14s |%-11s |%-9s |%-20s |%-30s |%-12s |\n", "ID", "Name", "IC", "Contact", "Type", "Corporate", "Address", "Credit Limit");
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--%-9s--%-20s--%-30s--%-12s--\n", "----", "------------------------------", "--------------", "-----------", "---------", "--------------------", "------------------------------", "------------");
        for (int i = 0; i < regCust.customerList.size(); i++)
            if (regCust.customerList.get(i).getType().equals("Corporate"))
                System.out.printf("|%-4s |%-30s |%-14s |%-11s |%-9s |%-20s |%-30s |RM %10.2f|\n", regCust.customerList.get(i).getCustID(), regCust.customerList.get(i).getName(), regCust.customerList.get(i).getCustIC(), regCust.customerList.get(i).getContactNo(), regCust.customerList.get(i).getType(), regCust.customerList.get(i).getCustCorp(), regCust.customerList.get(i).getCorpAddr(), regCust.customerList.get(i).getCreditLimit());
        System.out.printf("-%-4s--%-30s--%-14s--%-11s--%-9s--%-20s--%-30s--%-12s--\n", "----", "------------------------------", "--------------", "-----------", "---------", "--------------------", "------------------------------", "------------");
    }
}
