package lltgh.rsd2g2;

import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CustomerRegistration {
    
    String custType = "";
    double creditLimit = 0;
    
    public static List<Customer> customerList = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);
    
    public void custReg(){
        System.out.println("  Customer Registration  ");
        System.out.println("=========================");
        System.out.print("Customer name > ");
        String custName = input.nextLine();
        System.out.println("--------------------");
        System.out.println("| 1. Normal        |");
        System.out.println("| 2. Corporate     |");
        System.out.println("--------------------");
        
        System.out.print("Customer Type > ");
        int custSelection = input.nextInt();
        if (custSelection == 1)
            custType = "Normal";
        else if (custSelection == 2)
            custType = "Corporate";
        else
            System.out.println("Invalid selection. Please re-select: ");
        /*do{
           switch(custSelection){
                case 1: custType = "Normal"; break;
                case 2: custType = "Corporate"; break;
                default: System.out.println("Invalid selection. Please re-select.");            
            }
        }while(custSelection != 1 || custSelection != 2);*/
        
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
    }
}
