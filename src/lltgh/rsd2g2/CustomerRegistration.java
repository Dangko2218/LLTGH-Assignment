package lltgh.rsd2g2;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerRegistration {
    
    // global variable declaration<?>
    String custID = null, custName = null, custIC = null, contactNo = null, custType =null, custCorp = null, corpAddr = null, custSelection = null;
    double creditLimit = 0;

    // new object<?>
    // CustomerRegistration regCust = new CustomerRegistration();
    public static List<Customer> customerList = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);
      
    // display registration form
    public void custReg() throws IOException{
        System.out.println("  Customer Registration  ");
        System.out.println("=========================");
        
        // get customer name
        System.out.print("Customer name > ");
        custName = "acb"; //input.nextLine();
        
        // get ic no.
        System.out.print("Identity Card No./Passport no. > ");
        custIC = "901221567789"; // input.nextLine();
        
        // get contact no.
        System.out.print("Contact no. > ");
        contactNo = "0165769856" ;//input.nextLine();        
        
        
        // select customer type; loop if invalid selection
        do{
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
        
        // get credit limit if the customer type is corporate customer
        if (custType.equals("Normal")){
            creditLimit = 0;
            custCorp = corpAddr = "N/A";
        }
        else{
            // get customer company name
            System.out.print("Company/Corporate name > ");
            custCorp = "line";//input.nextLine();
            
            System.out.print("Company/Corporate address > ");
            corpAddr = "line"; //input.nextLine();
            
            System.out.print("Credit limit > ");
            creditLimit = 5.0; //input.nextDouble();
        }
        
        // generate id for customer; to be updated
        custID = generateCustID(custType);
        
        // add customer details into list
        Customer newCust = new Customer(custID, custName, custIC, contactNo, custType, custCorp, creditLimit);
        customerList.add(newCust);
        System.out.println("Customer Successfully Saved.");
        CustomerMaintenanceAndInvoicePayment custMain = new CustomerMaintenanceAndInvoicePayment();
        //custMain.printTest();
    }
    
    public String selectType(){
        System.out.println("--------------------");
        System.out.println("| 1. Normal        |");
        System.out.println("| 2. Corporate     |");
        System.out.println("--------------------");
        
        System.out.print("Customer Type > ");
        return custSelection = "2"; //input.nextLine();
    }
    
    public String generateCustID(String type){
        String ID = null;
        int nCounter = 0;
        int cCounter = 0;
        
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getType().equals("Normal"))
                nCounter++;
            else
                cCounter++;
        }
        
        if (type.equals("Normal")){
            nCounter++;
            ID = "N" + nCounter;
        }
        else{
            cCounter++;
            ID = "C" + cCounter;
        }
     
        return ID;
    }
}
