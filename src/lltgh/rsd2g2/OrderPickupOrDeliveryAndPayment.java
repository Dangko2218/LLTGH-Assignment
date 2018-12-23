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

import Customized.Queue;
import Customized.List;
import Customized.CustomizedEntity;
import Customized.ListInterface;
import Customized.Queue;
import Customized.QueueInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OrderPickupOrDeliveryAndPayment{
    
    ListInterface<Order> orderList = new List();     
    
    public static ArrayList<OPDP> orderpickup = new ArrayList<OPDP>();
    Scanner input = new Scanner(System.in);
    public String checkOrderNo = null;
    public int pickuped;
    public String checkDate = null;
    public int success = 0;
    public double pay = 0;
    
    public void printTest() throws ParseException{
        
        OrderPickupOrDeliveryAndPayment opodap = new OrderPickupOrDeliveryAndPayment();
        
        String opt = null;
        
         do{    
        
        opt = opodap.displayPage();
        
        switch(opt){
            case"1":
                viewOrderLIst();
                break;
            case"2":
                deliveryOrder();
                break;
            case"3":
                paymentManagement();
                break;
            case"4":
                  ViewPickedUp();
                break;
            case"5":
                break;
            default: 
                    System.out.println("***Invalid input, please enter between 1 to 5.***");
                    System.out.print("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }        
        }
        }while(!opt.equals("5"));   
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
    
    public void viewOrderLIst(){
        InvListInterface<Order> orderList = readOrderDatList();
        int s=0;
        int size = orderList.size();
        for(int i=0; i<size; i++){
           if("Done".equals(orderList.get(i).getPayment()) && orderList.get(i).getStatus() == 0 &&"Pick up".equals(orderList.get(i).getPickUpMethod())){
               s = 1;
           }
         }
         
         if(s==1){
        System.out.println("                                                <Order List>                                                                 ");
        System.out.printf("\n|%-9s|%-25s|%-50s|%-12s|%-9s|", "--------", "-------------------------", "--------------------------------------------------", "------------","---------");
        System.out.printf("\n|%-9s|%-25s|%-50s|%-12s|%-9s|", "Order No", "Customer IC", "Address", "Total Price","Payment");
        System.out.printf("\n|%-9s|%-25s|%-50s|%-12s|%-9s|", "--------", "-------------------------", "--------------------------------------------------", "------------","---------");
        for(int i = 0; i < size;i++ ){
            if("Done".equals(orderList.get(i).getPayment()) && orderList.get(i).getStatus() == 0&&"Pick up".equals(orderList.get(i).getPickUpMethod())){
                
            System.out.printf("\n|%-9s|%-25s|%-50s|RM%-10s|%-9s|",orderList.get(i).getOrderId(),orderList.get(i).getCustId(),orderList.get(i).getAddress(),orderList.get(i).getTotal(),orderList.get(i).getPayment());
           
            }
        }
        System.out.println("");
        System.out.println("Please enter the Order No that pickup already (Enter -1 to exit ) :");
        checkOrderNo = input.nextLine();
       
        for(int j = 0; j < size;j++ ){
           if(checkOrderNo.equals(orderList.get(j).getOrderId())&&"Done".equals(orderList.get(j).getPayment())&&orderList.get(j).getStatus() == 0&&"Pick up".equals(orderList.get(j).getPickUpMethod())){
            pickuped = 1;
            orderList.get(j).setStatus(pickuped);
               updatePickup(checkOrderNo);

                System.out.println("Successful!");
         
                success = 1;

                break;
           } else if(checkOrderNo.equals("-1")){
               success = 1;
               break;
           }else if(checkOrderNo.equals(orderList.get(j).getOrderId())&&"null".equals(orderList.get(j).getPayment())&&orderList.get(j).getPickUpMethod()=="Pick up"){
               success = -2;
           }else if(checkOrderNo.equals(orderList.get(j).getOrderId())&&"Done".equals(orderList.get(j).getPayment())&&orderList.get(j).getStatus() == 2 && orderList.get(j).getPickUpMethod()=="Pick up"){
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
         }else{
             System.out.println("Sorry! No Order List!");
         }
         
    }
    
    public void deliveryOrder(){
        InvListInterface<Order> orderList = readOrderDatList();
        int s=0;
        int size = orderList.size();
         for(int j = 0; j < size;j++ ){
           if("Done".equals(orderList.get(j).getPayment())&&orderList.get(j).getStatus() == 0&&"Delivery".equals(orderList.get(j).getPickUpMethod())){
               s = 1;
           }
         }
         if(s == 1){

        System.out.println(" ");
        System.out.println("      <Order List>      ");
        System.out.printf("\n|%-12s|%-9s|%-25s|%-50s|", "-----------","---------", "-------------------------", "--------------------------------------------------");
        System.out.printf("\n|%-12s|%-9s|%-25s|%-50s|", "Date","Order No","Customer IC","Address");
        System.out.printf("\n|%-12s|%-9s|%-25s|%-50s|", "-----------","---------", "-------------------------", "--------------------------------------------------");  
           success = 1;
          
        
        for(int j = 0; j < size;j++ ){

           if(orderList.get(j).getStatus()==0&&"Done".equals(orderList.get(j).getPayment())&&"Delivery".equals(orderList.get(j).getPickUpMethod())){ 

        System.out.printf("\n|%-12s|%-9s|%-25s|%-50s|",orderList.get(j).getPDate(),orderList.get(j).getOrderId(),orderList.get(j).getCustId(),orderList.get(j).getAddress());  
        success = 1;
        }
          }
        if(success == 1){
        System.out.println("");
        System.out.println("Please enter the Order No that pickup already (Enter -1 to exit ) :");
        checkOrderNo = input.nextLine();

        System.out.println("");

        for(int g = 0; g < size;g++ ){

           if(checkOrderNo.equals(orderList.get(g).getOrderId())&&"Done".equals(orderList.get(g).getPayment())&&orderList.get(g).getStatus() == 0&&"Delivery".equals(orderList.get(g).getPickUpMethod())){

                pickuped = 1;
                orderList.get(g).setStatus(pickuped);
                updatePickup(checkOrderNo);
                System.out.println("Successful!");
                success = 1;

               success = 1;
               break;
           } else if(checkOrderNo.equals("-1")){
               success = 1;
               break;
               
           }else if(checkOrderNo.equals(orderList.get(g).getOrderId())&&"null".equals(orderList.get(g).getPayment())&&"Delivery".equals(orderList.get(g).getPickUpMethod())){
               success = -2;
           }else if(checkOrderNo.equals(orderList.get(g).getOrderId())&&"Done".equals(orderList.get(g).getPayment())&&orderList.get(g).getStatus() == 1&&"Delivery".equals(orderList.get(g).getPickUpMethod())){
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
         }else{
             System.out.println("Sorry! No Order List!");
         }
     }
    
    public void paymentManagement(){
        InvListInterface<Order> orderList = readOrderDatList();
         int s=0;
        int size = orderList.size();
        
        for(int i = 0; i < size;i++ ){
            if("null".equals(orderList.get(i).getPayment()) && ("Cash".equals(orderList.get(i).getPaymentMethod()) || "null".equals(orderList.get(i).getPaymentMethod()))){
                s = 1;
            }
        }
        if(s ==1){
        double totalPay = 0;
        System.out.println("");
        System.out.println("      <Payment List>      ");
        System.out.printf("|%-12s|%-16s|%-12s|", "-----------","---------------","-----------" );
        System.out.printf("\n|%-12s|%-16s|%-12s|", "Order No","Customer IC","Total Amount");
        System.out.printf("\n|%-12s|%-16s|%-12s|", "-----------","---------------","-----------");
       
        for(int i = 0; i < size;i++ ){

            if("null".equals(orderList.get(i).getPayment()) && ("Cash".equals(orderList.get(i).getPaymentMethod()) || "null".equals(orderList.get(i).getPaymentMethod()))){
            System.out.printf("\n|%-12s|%-16s|RM%-10s|",orderList.get(i).getOrderId(),orderList.get(i).getCustId(),orderList.get(i).getTotal());
            }
        }
        System.out.println("\n");
        System.out.println("Please enter the Order No that want to Payment (Enter -1 to exit ) :");
        checkOrderNo = input.nextLine();

         for(int j = 0; j < size;j++ ){

           if(checkOrderNo.equals(orderList.get(j).getOrderId())&&"null".equals(orderList.get(j).getPayment())&&("Cash".equals(orderList.get(j).getPaymentMethod()) || "null".equals(orderList.get(j).getPaymentMethod()))){
               totalPay = orderList.get(j).getTotal();
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
                     String pay = "Done";
            orderList.get(j).setPayment(pay);
               updatePayment(checkOrderNo);

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
        }else{
            System.out.println("Invalid! Order No is not exist!!");
        }
    }
    
    public void ViewPickedUp(){
         InvListInterface<Order> orderList = readOrderDatList();
         success = 0;
         int size = orderList.size();
        for(int i = 0; i < size;i++ ){

            if("Done".equals(orderList.get(i).getPayment())&&orderList.get(i).getStatus() == 1){
                success = 1;
            }
        }
        
        if(success == 1){
        System.out.println("                                                <Order List>                                                                 ");
        System.out.printf("\n|%-9s|%-25s|%-50s|%-12s|", "--------", "-------------------------", "--------------------------------------------------", "------------");
        System.out.printf("\n|%-9s|%-25s|%-50s|%-12s|", "Order No", "Customer IC", "Address", "Total Price");
        System.out.printf("\n|%-9s|%-25s|%-50s|%-12s|", "--------", "-------------------------", "--------------------------------------------------", "------------");
        }else{
            System.out.println("Sorry! Don't have picked up order list!");
        }

        for(int i = 0; i < size;i++ ){

            if(orderList.get(i).getStatus() == 1 && "Done".equals(orderList.get(i).getPayment()))
            System.out.printf("\n|%-9s|%-25s|%-50s|RM%-10s|",orderList.get(i).getOrderId(),orderList.get(i).getCustId(),orderList.get(i).getAddress(),orderList.get(i).getTotal());
        }
        System.out.println("");
        System.out.println("");
    }
    
     public InvListInterface<Order> readOrderDatList() {
        InvListInterface<Order> orderList = new InvLinkedList<>();
        BufferedReader br = null;
        FileReader fr = null;
        java.util.List itemList = new ArrayList();
        java.util.List qtyList = new ArrayList();

        try {
            fr = new FileReader("../LLTGH-Assignment/src/lltgh/rsd2g2/Order.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split("\\|");
                itemList = convertToItemList(s[2]);
                qtyList = convertToQtyList(s[3]);
               Order orderEntry = new Order(s[0], s[1], itemList, qtyList, Double.parseDouble(s[4]), s[5], s[6], s[7], s[8], s[9],s[10],Integer.parseInt(s[11]));
                orderList.add(orderEntry);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return orderList;
    }

       public void writeOrderDatList(InvListInterface<Order> orderList) {
        String s = "";
        int size = orderList.size();

        for (int i = 0; i < size; i++) {
            Order orderEntry = orderList.get(i);

            s += orderEntry.getOrderId() + "|" + orderEntry.getCustId() + "|";
            s = writeOrderItem(s, orderEntry) + "|";
            s = writeOrderQuantity(s, orderEntry) + "|";
            s += orderEntry.getTotal() + "|" + orderEntry.getPaymentMethod() + "|" + orderEntry.getPickUpMethod() + "|" + orderEntry.getPDate() + "|" + orderEntry.getPTime() + "|" + orderEntry.getAddress()+ "|"  + orderEntry.getPayment() + "|" + orderEntry.getStatus() + "\n";

        }
        
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("../LLTGH-Assignment/src/lltgh/rsd2g2/Order.dat");
            bw = new BufferedWriter(fw);
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
      
      public void updatePickup(String pickup){
          InvListInterface<Order> orderList = readOrderDatList();
          Order update=null;
          int tempCount=0;
                 
          for(int i=0;i<orderList.size();i++){
                if(pickup.equals(orderList.get(i).getOrderId())){
                    update=orderList.get(i);
                    tempCount = i;
                }
            }
          
          InvListInterface<Order> order1 = readOrderDatList();
          order1.add(update);
          InvListInterface<Order> order2 = readOrderDatList();
          update.setStatus(1);
          orderList.update(tempCount+1, update);
          writeOrderDatList(orderList);
          
      }
  
  public void updatePayment(String orderNo){
          InvListInterface<Order> orderList = readOrderDatList();
          Order update=null;
          int tempCount=0;   
          
          for(int i=0;i<orderList.size();i++){
                if(orderNo.equals(orderList.get(i).getOrderId())){
                    update=orderList.get(i);
                    tempCount = i;
                }
            }
          
          InvListInterface<Order> orderList1 = readOrderDatList();
          orderList1.add(update);
          update.setPayment("Done");
          orderList.update(tempCount+1, update);
          writeOrderDatList(orderList);      
      }
    
     public java.util.List convertToItemList(String s1) {
        String[] item = s1.split(",");
        java.util.List itemList = new ArrayList();
        for (int i = 0; i < item.length; i++) {
            itemList.add(item[i]);
        }
        return itemList;
    }

    public java.util.List convertToQtyList(String s2) {
        String[] qty = s2.split(",");
        java.util.List qtyList = new ArrayList();
        for (int i = 0; i < qty.length; i++) {
            qtyList.add(qty[i]);
        }
        return qtyList;
    }
    
     public String writeOrderItem(String s, Order orderEntry) {
        int size = orderEntry.getOrderItem().size();
        for (int i = 0; i < size; i++) {
            s += orderEntry.getOrderItem().get(i);
            if (i != size - 1) {
                s += ",";
            }
        }
        return s;
    }

    public String writeOrderQuantity(String s, Order orderEntry) {
        int size = orderEntry.getOrderItem().size();
        for (int i = 0; i < size; i++) {
            s += orderEntry.getQuantity().get(i);
            if (i != size - 1) {
                s += ",";
            }
        }
        return s;
    }
    
}
