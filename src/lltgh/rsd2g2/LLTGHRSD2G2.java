/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LLTGHRSD2G2 { 

    public static void main(String[] args) {
        LLTGHRSD2G2 mainMenu = new LLTGHRSD2G2();//mainMenu
        String option = null;
        
        
        ArrayList<Product> prod = new ArrayList<Product>();//product

        prod.add(new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2, 30));
        prod.add(new Product("p0002", "I Love You", "Bouquet", "520 Rose", 520, 5));
        prod.add(new Product("p0003", "LWY Pack", "Floral Arrangement", "Made by Low Wei Yin", 200, 5));
        prod.add(new Product("p0004", "Love You Forever", "Bouquet", "1001 Rose", 1000, 3));
        prod.add(new Product("p0005", "TJH Pack", "Floral Arrangement", "Made by Tai Jia Hao", 200, 5));
        prod.add(new Product("p0006", "White Rose", "Fresh Flower", "Rose in White Color", 2, 30));
        prod.add(new Product("p0007", "Pink Rose", "Fresh Flower", "Rose in Pink Color", 2, 30));
        prod.add(new Product("p0008", "GCY Pack", "Floral Arrangement", "Made by Goh Ching Yaw", 200, 5));
        prod.add(new Product("p0009", "Blue Rose", "Fresh Flower", "Rose in Blue Color", 2, 30));
        prod.add(new Product("p0010", "LXY Pack", "Floral Arrangement", "Made by Lim Xin Yi", 200, 5));
        prod.add(new Product("p0011", "100% Love You", "Bouquet", "100 Red Rose", 100, 8));
        prod.add(new Product("p0012", "HZW Pack", "Floral Arrangement", "Made by Hoe Zhi Wen", 200, 5));
        
//        int i;
//        String placeholder;
//        Scanner scanner = new Scanner(System.in);
//        for(i=1; i<24; i++){System.out.println();}
//        placeholder = scanner.next();   
        
        do{
            option = mainMenu.displayMainMenu();
            
            switch(option){
                case "1":
                    CatalogMaintenance catalog = new CatalogMaintenance();
                    catalog.printTest();
                    break;
                case "2":
                    CustomerMaintenanceAndInvoicePayment custMain = new CustomerMaintenanceAndInvoicePayment();
                    custMain.printTest();
                    break;
                case "3":
                    CatalogOrders catOrder = new CatalogOrders();
                    catOrder.printTest();
                    break;
                case "4":
                    OrderPickupOrDeliveryAndPayment orderPayment = new OrderPickupOrDeliveryAndPayment();
                    orderPayment.printTest();
                    break;
                case "5":
                    CustomizedFloralArrangements cust = new CustomizedFloralArrangements();
                    cust.printTest();
                    break;
                case "6":
                    System.out.print("Thank you for using this system!");
                    break;
                default: 
                    System.out.println("***Invalid input, please enter between 1 to 6.***");
                    System.out.print("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }    
            }     
        }while(!option.equals("6"));
        
    }
    
    public String displayMainMenu(){

        System.out.println("\n\n\nWelcome to...");
        System.out.println("========================================================");
        System.out.println("                          LLTGH");
        System.out.println("                    Fiore Flowershop");
        System.out.println("========================================================");

        System.out.println("These are the options you can choose:");
        System.out.println("1) Catalog Maintenance");
        System.out.println("2) Customer Maintenance and Invoice Payment");
        System.out.println("3) Catalog Orders");
        System.out.println("4) Order Pickup/Delivery and Consumer Payment Management");
        System.out.println("5) Customized Floral Arrangements");
        System.out.println("6) Exit");
        System.out.print("Please enter your option > ");
        Scanner scanner = new Scanner(System.in); 
        return scanner.nextLine();
    }
    
}
