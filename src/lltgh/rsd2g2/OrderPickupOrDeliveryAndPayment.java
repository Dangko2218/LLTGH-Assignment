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


public class OrderPickupOrDeliveryAndPayment{
    
    public static ArrayList<OPDP> orderpickup = new ArrayList<OPDP>();
    Scanner input = new Scanner(System.in);
    public String checkOrderNo = null;
    public String pickuped;
    public String checkDate = null;
    public int success = 0;
    public double pay = 0;
    
    public void printTest(){
        
        orderpickup.add(new OPDP("A0001","Nicole","981214-01-4728","88,jalan tipu,taman besar,53000,KL",88.50,"null","25/12/2018","null","no",3));
        orderpickup.add(new OPDP("A0002","James","870423-09-3824","32,jalan diam,taman kecil,53000,KL",53.90,"null","12/1/2019","null","no",5));
        orderpickup.add(new OPDP("A0003","Gray","890719-01-8864","43,jalan buahan,taman bunga,53000,KL",35.20,"null","12/1/2019","null","no",1));
        orderpickup.add(new OPDP("A0004","Jay","910312-03-5219","67,jalan gula,taman pokok,53000,KL",40.90,"null","25/12/2018","null","no",2.5));
        orderpickup.add(new OPDP("A0005","Young","860511-11-3612","3,jalan bola,taman nasi,53000,KL",20.20,"null","12/1/2019","null","no",7));

        OrderPickupOrDeliveryAndPayment opodap = new OrderPickupOrDeliveryAndPayment();
        
        String opt = null;
        
         do{    
        
        opt = opodap.displayPage();
        
        switch(opt){
            case"1":
                viewOrderLIst(orderpickup);
                break;
            case"2":
                deliveryOrder(orderpickup);
                break;
            case"3":
                paymentManagement(orderpickup);
                break;
            case"4":
                ViewPickedUp(orderpickup);
                break;
            case"5":
                LLTGHRSD2G2 main = new LLTGHRSD2G2();
                main.displayMainMenu();
                break;
            default: 
                    System.out.println("***Invalid input, please enter between 1 to 4.***");
                    System.out.print("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }        
        }
        }while(!opt.equals(5));   

        }
    
    public String displayPage(){
        System.out.println("========================================================");
        System.out.println("           Order Pickup Or Delivery And Payment");
        System.out.println("========================================================");
        System.out.println("1) Pick up the Order List");
        System.out.println("2) Delivery");
        System.out.println("3) Payment");
        System.out.println("4) View Picked up Order List");
        System.out.println("5) Back");
        System.out.print("Please enter your option > "); 
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public void viewOrderLIst(ArrayList<OPDP> vol){
        
        System.out.println("                                                <Order List>                                                                 ");
        System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|", "--------", "-------------------------", "-------------------------", "--------------------------------------------------", "------------", "---------","---------");
        System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|", "Order No", " Customer Name", "Customer IC", "Address", "Total Price", "Pickup","Payment");
        System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|", "--------", "-------------------------", "-------------------------", "--------------------------------------------------", "------------", "---------","---------");
        for(int i = 0; i < vol.size();i++ ){
            System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|",vol.get(i).getOrderNo(),vol.get(i).getCustomerName(),vol.get(i).getCustomerIC(),vol.get(i).getAddress(),vol.get(i).getTotal(),vol.get(i).getPickup(),vol.get(i).getPayment());
        }
        System.out.println("");
        System.out.println("Please enter the Order No that pickup already (Enter -1 to exit ) :");
        checkOrderNo = input.nextLine();
       
        for(int j = 0; j < vol.size();j++ ){
           if(checkOrderNo.equals(vol.get(j).getOrderNo())&&vol.get(j).getPayment() == "Done"&&vol.get(j).getPickup() == "null"){
               pickuped = vol.get(j).getOrderNo();
               pickuped = "Pickup";
               vol.get(j).setPickup(pickuped);
                System.out.println("Successful!");
                success = 1;
                break;
           } else if(checkOrderNo.equals("-1")){
               success = 1;
               break;
           }else if(checkOrderNo.equals(vol.get(j).getOrderNo())&&vol.get(j).getPayment() == "null"){
               success = -2;
           }else if(checkOrderNo.equals(vol.get(j).getOrderNo())&&vol.get(j).getPayment() == "Done"&&vol.get(j).getPickup() == "Pickup"){
               success = -3;
           }

        }
        if(success == 0){
            System.out.println("Invalid Order No!!");
        }else if(success == -2){
            System.out.println("Sorry! Please clear the payment!");
        }else if(success == -3){
            System.out.println("Sorry! You already pickup!");
        }
        System.out.println("");
     
    }
    
    public void deliveryOrder(ArrayList<OPDP> vol){

        System.out.println("");
        System.out.println("      <Order List>      ");
        System.out.printf("\n|%-12s|", "-----------" );
        System.out.printf("\n|%-12s|", "Date");
        System.out.printf("\n|%-12s|", "-----------");
        int count = 0;
        for(int i = 0; i < vol.size();i++ ){   
            for(int k = 0; k < vol.size();k++ ){
            //duplication(Complete)
            if(vol.get(i).getDate() == vol.get(k).getDate()&&vol.get(i).getCheckDateDuplicate()=="no"&&vol.get(k).getCheckDateDuplicate()=="no"){
//            if(vol.get(i).getDate() == vol.get(k).getDate()&&vol.get(i).getCheckDateDuplicate()=="no"&&vol.get(k).getCheckDateDuplicate()=="no"&&vol.get(i).getPayment() == "Done"){
                count++;
                vol.get(i).setCheckDateDuplicate("check");
                vol.get(k).setCheckDateDuplicate("check");
            }else if(vol.get(i).getDate() == vol.get(k).getDate()&&vol.get(k).getCheckDateDuplicate()=="check"){
                vol.get(i).setCheckDateDuplicate("check");
            }else if(vol.get(i).getDate() == vol.get(k).getDate()&&vol.get(i).getCheckDateDuplicate()=="check"){
                vol.get(k).setCheckDateDuplicate("check");
            }
            if(count == 1){
            System.out.printf("\n|%-12s|",vol.get(i).getDate());
            count=0;
                 } 
            }
        }
        for(int i = 0; i < vol.size();i++ ){
            vol.get(i).setCheckDateDuplicate("no"); 
        }
        System.out.println("");
        System.out.println("Please enter the date to delivery (-1 to exit) : ");
        checkDate = input.nextLine();
        for(int j = 0; j < vol.size();j++ ){
           if(checkDate.equals(vol.get(j).getDate())){
        System.out.println(" ");
        System.out.println("      <Order List>      ");
        System.out.printf("\n|%-12s|%-9s|%-25s|%-25s|%-50s|%-9s|", "-----------","---------","-------------------------", "-------------------------", "--------------------------------------------------", "---------" );
        System.out.printf("\n|%-12s|%-9s|%-25s|%-25s|%-50s|%-9s|", "Date","Order No","Customer Name","Customer IC","Address","Distance");
        System.out.printf("\n|%-12s|%-9s|%-25s|%-25s|%-50s|%-9s|", "-----------","---------","-------------------------", "-------------------------", "--------------------------------------------------","---------");  
           success = 1;
           break;
           } else if(checkDate.equals("-1")){
               success = 2;
               break;
           }else{
            success = 0;
            }
        }
        for(int j = 0; j < vol.size();j++ ){
//           if(checkDate.equals(vol.get(j).getDate())&& vol.get(j).getPickup()=="null"&&vol.get(j).getPayment() == "Done"){ 
             if(checkDate.equals(vol.get(j).getDate())&& vol.get(j).getPickup()=="null"){
        System.out.printf("\n|%-12s|%-9s|%-25s|%-25s|%-50s|%-7sKM|",vol.get(j).getDate(),vol.get(j).getOrderNo(),vol.get(j).getCustomerName(),vol.get(j).getCustomerIC(),vol.get(j).getAddress(),vol.get(j).getDistance());  
        success = 1;
        }
          }
        if(success == 1){
        System.out.println("");
        System.out.println("Please enter the Order No that pickup already (Enter -1 to exit ) :");
        checkOrderNo = input.nextLine();

        System.out.println("");
       
        for(int g = 0; g < vol.size();g++ ){
//           if(checkOrderNo.equals(vol.get(g).getOrderNo())&&vol.get(g).getPayment() == "Done"&&vol.get(g).getPickup() == "null"){
             if(checkOrderNo.equals(vol.get(g).getOrderNo())&&vol.get(g).getPickup() == "null"){
               pickuped = vol.get(g).getOrderNo();
               pickuped = "Pickup";
               vol.get(g).setPickup(pickuped);
               System.out.println("Successful!!");
               success = 1;
               break;
           } else if(checkOrderNo.equals("-1")){
               success = 1;
               break;
               
           }else if(checkOrderNo.equals(vol.get(g).getOrderNo())&&vol.get(g).getPayment() == "null"){
               success = -2;
           }else if(checkOrderNo.equals(vol.get(g).getOrderNo())&&vol.get(g).getPayment() == "Done"&&vol.get(g).getPickup() == "Pickup"){
               success = -3;
           }
        }
        }else if(success == 2){
           
        }
        else{
            System.out.println("Invalid Date!!");
        }
    if(success == -1){
        System.out.println("Invalid Order No!!");
    }else if(success == -2){
            System.out.println("Sorry! Please clear the payment!");
        }else if(success == -3){
            System.out.println("Sorry! You already pickup!");
        }
    
     }
    
    public void paymentManagement(ArrayList<OPDP> vol){
        double totalPay = 0;
        System.out.println("");
        System.out.println("      <Payment List>      ");
        System.out.printf("|%-12s|%-16s|%-12s|", "-----------","---------------","-----------" );
        System.out.printf("\n|%-12s|%-16s|%-12s|", "Order No","Customer IC","Total Amount");
        System.out.printf("\n|%-12s|%-16s|%-12s|", "-----------","---------------","-----------");
        for(int i = 0; i < vol.size();i++ ){
            if(vol.get(i).getPayment() == "null"){
            System.out.printf("\n|%-12s|%-16s|RM%-12s|",vol.get(i).getOrderNo(),vol.get(i).getCustomerIC(),vol.get(i).getTotal());
            }
        }
        System.out.println("\n");
        System.out.println("Please enter the Order No that want to Payment (Enter -1 to exit ) :");
        checkOrderNo = input.nextLine();
       
         for(int j = 0; j < vol.size();j++ ){
           if(checkOrderNo.equals(vol.get(j).getOrderNo())&&vol.get(j).getPayment() == "null"){
               totalPay = vol.get(j).getTotal();
                System.out.printf("|%-12s : RM%-12s" , "Total amount",totalPay);  
                success = 1;
                
           } else if(checkOrderNo.equals("-1")){
               break;
           }else{
               success = 2;
           }
           if(totalPay != 0){
            System.out.println("");
                System.out.printf("Please enter the consumer pay (-1 to exit) :RM ");
                pay = input.nextDouble();
                if(pay >= totalPay){
                    double lPay = pay - totalPay;
                    System.out.println("Change: RM " + String.format("%.2f",lPay));
                    System.out.println("");
                    System.out.println("Thank You! ");
                    System.out.println("");
                    vol.get(j).setPayment("Done");
                    checkOrderNo = input.nextLine();
                    break;
                }else if(pay == -1){
                    checkOrderNo = input.nextLine();
               break;
           }else if(pay < totalPay){
                    System.out.println("Sorry! Money is not enough!");
                    System.out.println("Please try again!!");
                    checkOrderNo = input.nextLine();
                    break;
           }
                
                break;
           }
        }
         if(success == 2){
             System.out.println("Invalid! Order No is not exist!!");
         }
         
    }
    
    public void ViewPickedUp(ArrayList<OPDP> vol){
        for(int i = 0; i < vol.size();i++ ){
            if(vol.get(i).getPickup() == "Pickup"){
                success = 1;
            }
        }
        if(success == 1){
        System.out.println("                                                <Order List>                                                                 ");
        System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|", "--------", "-------------------------", "-------------------------", "--------------------------------------------------", "------------", "---------","---------");
        System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|", "Order No", " Customer Name", "Customer IC", "Address", "Total Price", "Pickup","Payment");
        System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|", "--------", "-------------------------", "-------------------------", "--------------------------------------------------", "------------", "---------","---------");
        }else{
            System.out.println("Sorry! Don't have picked up order list!");
        }
        for(int i = 0; i < vol.size();i++ ){
            if(vol.get(i).getPickup() == "Pickup")
            System.out.printf("\n|%-9s|%-25s|%-25s|%-50s|%-12s|%-9s|%-9s|",vol.get(i).getOrderNo(),vol.get(i).getCustomerName(),vol.get(i).getCustomerIC(),vol.get(i).getAddress(),vol.get(i).getTotal(),vol.get(i).getPickup(),vol.get(i).getPayment());
        }
        System.out.println("");
        System.out.println("");
    }
    
    
}
