package lltgh.rsd2g2;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerRegistration {
    
    String custType = "";
    String custSelection = null;
    double creditLimit = 0;
    String custName= null;
    
    public static List<Customer> customerList = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);
    
    public void custReg(){
        System.out.println("  Customer Registration  ");
        System.out.println("=========================");
        System.out.print("Customer name > ");
        custName = input.nextLine();
        
        
        do{
            /*custSelection = selectType();
            if (custSelection.equals("1"))
                custType = "Normal";
            else if (custSelection.equals("2"))
                custType = "Corporate";
            else{
                System.out.println("Invalid selection. Please re-select.");
            }*/
            custSelection = selectType();
            switch(custSelection){
                case "1":
                    custType = "Normal";
                    break;
                case "2":
                    custType = "Corporate";
                    break;
                default:
                    System.out.print("Invalid input. Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
        }while(!custSelection.equals("1") && !custSelection.equals("2"));
        
        if (custType.equals("Normal"))
                creditLimit = 0;
        else{
            System.out.print("Credit limit > ");
            creditLimit = input.nextDouble();
        }
        
        Customer newCust = new Customer(custName, custType, creditLimit);
        customerList.add(newCust);
        System.out.println("Customer Successfully Saved.");
        CustomerMaintenanceAndInvoicePayment custMain = new CustomerMaintenanceAndInvoicePayment();
        custMain.printTest();
        
        /*do{
           switch(custSelection){
                case 1: custType = "Normal"; break;
                case 2: custType = "Corporate"; break;
                default: System.out.println("Invalid selection. Please re-select.");            
            }
        }while(custSelection != 1 || custSelection != 2);*/
    }
    
    public String selectType(){
        System.out.println("--------------------");
        System.out.println("| 1. Normal        |");
        System.out.println("| 2. Corporate     |");
        System.out.println("--------------------");
        
        System.out.print("Customer Type > ");
        return custSelection = input.nextLine();
//        do{
//            switch (custSelection){
//                case "1":
//                    
//            }            
//        }while(!custSelection.equals("1") && !custSelection.equals("2"));
    }
}
