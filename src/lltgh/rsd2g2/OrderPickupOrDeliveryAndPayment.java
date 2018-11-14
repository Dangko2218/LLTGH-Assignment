/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

/**
 *
 * @author User
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OrderPickupOrDeliveryAndPayment {
    
    public void printTest(){
        
        
        
        OrderPickupOrDeliveryAndPayment opodap = new OrderPickupOrDeliveryAndPayment();
        
        String opt = null;
        
         do{    
        
        opt = opodap.displayPage();
        
        switch(opt){
            case"1":
                viewOrderLIst();
                break;
            case"2":
                System.out.println("pick up order");
                break;
            case"3":
                System.out.println("Consumer Payment");    
            case"4":
                LLTGHRSD2G2 main = new LLTGHRSD2G2();
                main.displayMainMenu();
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
        }while(!opt.equals(4));   
        
        
        
        
        }
    
    public String displayPage(){
        System.out.println("========================================================");
        System.out.println("           Order Pickup Or Delivery And Payment");
        System.out.println("========================================================");
        System.out.println("1) View the order list");
        System.out.println("2) Pick up order");
        System.out.println("3) Consumer Payment");
        System.out.println("4) Back");
        System.out.print("Please enter your option > "); 
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public void viewOrderLIst(){
        System.out.println("Order No:");
        System.out.println("Product Name:");
        System.out.println("Quantity:");
        System.out.println("Customer Name:");
        System.out.println("Customer IC:");
        System.out.println("Address:");
        System.out.println("Total Amount:");
    }
    
    
    
    
}
