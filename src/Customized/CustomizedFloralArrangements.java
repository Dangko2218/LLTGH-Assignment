/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customized;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import lltgh.rsd2g2.LLTGHRSD2G2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CustomizedFloralArrangements {
    Scanner scanner = new Scanner(System.in);
    String inputScanner, consumer, custStyle, custSize, custType, custAcc, pickupPrio, modifyStatus;
    Boolean chkConsumer, chkStyle, chkSize, chkType, chkAcc, chkPickupPrio, chkModifyStatus;

    public void printTest(){
        String option = null;
         
        do{   
          option = displayMenu();
        
//          if (option == "1"){
//            displayCustMenu();
//            break;
//          }
//          else if (option == "2"){
//            displayManageMenu();
//            break;
//          }
//          else if (option == "3"){
//            LLTGHRSD2G2 main = new LLTGHRSD2G2();
//            main.displayMainMenu();
//            break;
//          }
//          else{
//            System.out.println("Invalid input(Please enter 1-3 only).");
//            System.out.print("Press enter to continue...");
//            try {
//                System.in.read();
//            } catch (IOException ex) {
//                Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
//            }
//          }
          switch(option){
            case "1":
                displayCustMenu();
                break;
            case "2":
                displayOrderMenu();
                break;    
            case "3":
                displayManageMenu();
                break;
            case "4":
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
       
        }while(!option.equals("4"));
    }
    
    public String displayMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("               Customized Floral Arrangement");
        System.out.println("========================================================");

        System.out.println("These are the options you can choose:");
        System.out.println("1) Customized for Consumer");
        System.out.println("2) View Customized Order");
        System.out.println("3) Manage Floral Arrangement");
        System.out.println("4) Back to Main Menu");
        System.out.print("Please enter your option > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public void displayCustMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("                 Customized for Consumer");
        System.out.println("========================================================");
        
        //display consumer list
//        do{
//            System.out.println("\n\n\n========================================================");
//            System.out.println("                        Consumer");
//            System.out.println("========================================================");
//            System.out.print("\nPlease Enter Consumer ID (Enter -1 to Exit) > ");
//            consumer = scanner.nextLine();
//            chkConsumer = checkCustInput(consumer);
//        }while(chkConsumer == false);

        //display f.a.Style
        do{
            System.out.println("\n========================================================");
            System.out.println("               Flower Arrangement Style");
            System.out.println("========================================================");
            System.out.println("1) Traditional or Western");
            System.out.println("2) Oriental");
            System.out.println("3) Modern");
            System.out.print("Please Select Flower Arrangement Style (Enter -1 to Exit) > ");
            custStyle = scanner.nextLine();
            chkStyle = checkCustInput(custStyle);
        }while(chkStyle == false);

        //display f.a.Size
        do{
            System.out.println("\n========================================================");
            System.out.println("                Flower Arrangement Size");
            System.out.println("========================================================");
            System.out.println("1) Large(5.5” X 5.5”)");
            System.out.println("2) Medium(4.5” X 4.5”)");
            System.out.println("3) Small(3.5” X 3.5”)");
            System.out.print("Please Select Flower Arrangement Size (Enter -1 to Exit) > ");
            custSize = scanner.nextLine();
            chkSize = checkCustInput(custSize);
        }while(chkSize == false);
        
        //display f.Type
        //can choose maximum 3 type
        do{
            System.out.println("\n========================================================");
            System.out.println("                      Flower Type");
            System.out.println("========================================================");
            System.out.println("1) Baby's Breath");
            System.out.println("2) Carnations");
            System.out.println("3) Hydrangea");
            System.out.print("Please Select Flower Type(Maximum 3) (Enter -1 to Exit) > ");
            custType = scanner.nextLine();
            chkType = checkCustInput(custType);
        }while(chkType == false);
        
        //display Accessories
        //can choose maximum 3 type
        do{
            System.out.println("\n========================================================");
            System.out.println("                       Accessories");
            System.out.println("========================================================");
            System.out.println("1) Floral Tape");
            System.out.println("2) Clear Cellophane");
            System.out.println("3) Wire Gravestone Saddle");
            System.out.print("Please Select Accessories(Maximum 3) (Enter -1 to Exit) > ");
            custAcc = scanner.nextLine();
            chkAcc = checkCustInput(custAcc);
        }while(chkAcc == false);
        
        //display Pick-up Priority
        do{
            System.out.println("\n========================================================");
            System.out.println("                    Pick-up Priority");
            System.out.println("========================================================");
            System.out.println("1) Express(Highest Priority)");
            System.out.println("2) Normal(Median Priority)");
            System.out.println("3) Flexi(Lowest Priority)");
            System.out.print("Please Select Pick-up Priority (Enter -1 to Exit) > ");
            pickupPrio = scanner.nextLine();
            chkPickupPrio = checkCustInput(pickupPrio);
        }while(chkPickupPrio == false);
        System.out.println("\nTHANKS FOR YOUR ORDER.");
    }
    
    public Boolean checkCustInput(String custInput){
        Boolean returnValue = true;
        
//        switch(custInput){
//                case "-1":
//                    returnValue = false;
//                    break;
//                default:
//                    returnValue = true;
//        
//        }
        
        if(custInput == null || custInput.isEmpty()){
            System.out.println("***Do Not Leave Blank. Please enter again...");
            returnValue = false;
        }
        else{
            
            try { 
                Integer.parseInt(custInput); 
            } catch(NumberFormatException e) { 
                System.out.println("***Please Enter Only Digit Number.");
                returnValue = false;
            }
        
            if(returnValue == true){
//                if(custInput.equals("-1")){
//                        displayMenu();
//                    }
//                    else{
//                        returnValue = true;
//                    }
                if(custInput.equals("1") || custInput.equals("2") || custInput.equals("3") || custInput.equals("-1")){ 
                    if(custInput.equals("-1")){
                        displayMenu();
                    }
                    else{
                        returnValue = true;
                    }
                    //returnValue = true;
                }
                else{
                    System.out.println("***Please Enter A Valid Selection.");
                    returnValue = false;
                }
            }
        }
        
        return returnValue;
    }
    
    public void displayOrderMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("                      Customized Order");
        System.out.println("========================================================");
        System.out.println("These are the options you can choose:");
        System.out.println("1) View Customized Order");
        System.out.println("2) Update Customized Order Status");
        System.out.println("3) Back to Previous");
        System.out.print("Please enter your option > ");
        inputScanner = scanner.nextLine();
        checkOrderInput(inputScanner);
    }
    
    public void checkOrderInput(String orderInput){
        
        do{   
            
            switch(orderInput){
                case "1":
                    viewOrder();
                    break;
                case "2":
                    modifyOrder();
                    break;  
                case "3":
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
        }while(!orderInput.equals("3"));
    }
    
    public void viewOrder(){
        System.out.println("\n\n\n====================================================================================================================================================================================");
        System.out.println("                                                                                    View Customized Order");
        System.out.println("====================================================================================================================================================================================");
        QueueInterface<CustomizedEntity> orderList = readCustDat();
        printCustOrderList(orderList);

        System.out.print("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
             Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modifyOrder(){
        System.out.println("\n\n\n====================================================================================================================================================================================");
        System.out.println("                                                                                              Update Status");
        System.out.println("====================================================================================================================================================================================");
        ListInterface<CustomizedEntity> orderList = readCustDatList();
        printCustOrderListList(orderList);
        orderList = readCustDatList();
        int selected, input2;
        
        do{
            System.out.print("Enter Order No. to Update Status > ");
            modifyStatus = scanner.nextLine();
            
            selected = Integer.parseInt(modifyStatus);
            CustomizedEntity update = orderList.get(selected-1);

            System.out.println("\n\n");
            QueueInterface<CustomizedEntity> tempQueue = new Queue();
            tempQueue.enqueue(update);
            printCustOrderList(tempQueue);

            System.out.println("\n========================================================");
            System.out.println("                       Order Status");
            System.out.println("========================================================");
            System.out.println("1) Pending");
            System.out.println("2) Completed");
            System.out.println("3) Cancelled");
            System.out.print("Please enter the new status(1-3)> ");
            inputScanner = scanner.nextLine();
            input2 = Integer.parseInt(inputScanner);

            update.setStatus(input2);
            orderList.update(selected-1, update);
            writeCustDatList(orderList);
            System.out.println("\n***Updated successfully!!***");
            tempQueue.enqueue(update);
            printCustOrderList(tempQueue);  
        }while(Integer.parseInt(modifyStatus) > orderList.size());
        
        System.out.print("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
        displayOrderMenu();
    }
    
//    public void modifyOrder(){
//        System.out.println("\n\n\n====================================================================================================================================================================================");
//        System.out.println("                                                                                              Update Status");
//        System.out.println("====================================================================================================================================================================================");
//        ListInterface<CustomizedEntity> orderList = readCustDatList();
//        printCustOrderListList(orderList);
//        orderList = readCustDatList();
//        int selected;
//        String input2;
//        
//        do{
//            System.out.print("Enter Order No. to Update Status > ");
//            modifyStatus = scanner.nextLine();
//            
//            if(modifyStatus.equals("")){
//                System.out.println("Do Not Leave Blank. Please enter again...");
//            }
//            if(Integer.parseInt(modifyStatus) > orderList.size() || Integer.parseInt(modifyStatus) <= 0)
//                System.out.println("Invalid selection. Please enter again...");
//            else{
//                selected = Integer.parseInt(modifyStatus);
//                CustomizedEntity update = orderList.get(selected-1);
//
//                System.out.println("\n\n");
//                QueueInterface<CustomizedEntity> tempQueue = new Queue();
//                tempQueue.enqueue(update);
//                printCustOrderList(tempQueue);
//
//                do{
//                    System.out.println("\n========================================================");
//                    System.out.println("                       Order Status");
//                    System.out.println("========================================================");
//                    System.out.println("1) Pending");
//                    System.out.println("2) Completed");
//                    System.out.println("3) Cancelled");
//                    System.out.print("Please enter the new status(1-3)> ");
//                    input2 = scanner.nextLine();
//                    
//                    if(input2.equals("")){
//                        System.out.println("Do Not Leave Blank. Please enter again...");
//                    }
//                    if(!(Integer.parseInt(input2) >= 1 && Integer.parseInt(input2) <= 3)){
//                        System.out.println("Invalid selection. Please enter again...");
//                    }
//                    else{
//                        update.setStatus(Integer.parseInt(input2));
//                        orderList.update(selected-1, update);
//                        writeCustDatList(orderList);
//                        System.out.println("\n***Updated successfully!!***");
//                        tempQueue.enqueue(update);
//                        printCustOrderList(tempQueue);
//                    }  
//                }while(Integer.parseInt(input2) < 0);
//                !(Integer.parseInt(input2) >= 1 && Integer.parseInt(input2) <= 3) || input2.equals("")
//            }
//        }while(Integer.parseInt(modifyStatus) > orderList.size());
//        
//        //Integer.parseInt(modifyStatus) > orderList.size() || Integer.parseInt(modifyStatus) <= 0 || modifyStatus.equals("")
//        System.out.print("Press enter to continue...");
//        try {
//            System.in.read();
//        } catch (IOException ex) {
//            Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        displayOrderMenu();
//    }
    
    private void printCustOrderList(QueueInterface<CustomizedEntity> orderList){//print Customized Order List
        String prior="", status="";
        System.out.printf("|%-5s|%-15s|%-30s|%-30s|%-30s|%-30s|%-10s|%-10s|%-10s|\n", "No.", "Customer ID","Style", "Size","Flower Type", "Accessories", "Priority", "Price(RM)", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int size = orderList.size();
        for(int i=0; i<size; i++){
            CustomizedEntity cust = orderList.dequeue();
            
            if(cust.getPrior() == 1)
                prior = "Express";
            else if(cust.getPrior() == 2)
                prior = "Normal";
            else if(cust.getPrior() == 3)
                prior = "Flexi";

            if(cust.getStatus() == 1)
                status = "Pending";
            else if(cust.getStatus() == 2)
                status = "Completed";
            else if(cust.getStatus() == 3)
                status = "Cancelled";

            System.out.printf("|%-5s|%-15s|%-30s|%-30s|%-30s|%-30s|%-10s|%-10d|%-10s|\n", i+1, cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType(), cust.getAcc(), prior, cust.getPrice(), status);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    private void printCustOrderListList(ListInterface<CustomizedEntity> orderList){//print Customized Order List
        String prior="", status="";
        System.out.printf("|%-5s|%-15s|%-30s|%-30s|%-30s|%-30s|%-10s|%-10s|%-10s|\n", "No.", "Customer ID","Style", "Size","Flower Type", "Accessories", "Priority", "Price(RM)", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int size = orderList.size();
        for(int i=0; i<size; i++){
            CustomizedEntity cust = orderList.remove(0);
            
            if(cust.getPrior() == 1)
                prior = "Express";
            else if(cust.getPrior() == 2)
                prior = "Normal";
            else if(cust.getPrior() == 3)
                prior = "Flexi";

            if(cust.getStatus() == 1)
                status = "Pending";
            else if(cust.getStatus() == 2)
                status = "Completed";
            else if(cust.getStatus() == 3)
                status = "Cancelled";

            System.out.printf("|%-5s|%-15s|%-30s|%-30s|%-30s|%-30s|%-10s|%-10d|%-10s|\n", i+1, cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType(), cust.getAcc(), prior, cust.getPrice(), status);
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public QueueInterface<CustomizedEntity> readCustDat(){//get requests from dat file
        QueueInterface<CustomizedEntity> custQueue = new Queue<>();
        //read data from Request.dat
        BufferedReader br = null;
	FileReader fr = null;

	try {
            fr = new FileReader("../LLTGH-Assignment/src/Customized/CustomizedOrderData.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;
            
            while ((sCurrentLine = br.readLine()) != null) {
                
                String[] s =sCurrentLine.split("\\|");
                CustomizedEntity custEn = new CustomizedEntity(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), Integer.parseInt(s[6]), Integer.parseInt(s[7]));
                custQueue.enqueue(custEn);//add to list
            }

	} catch (IOException e) {
            e.printStackTrace();
	} finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                    ex.printStackTrace();
            }
	}
        
        return custQueue;

    }
    
    public ListInterface<CustomizedEntity> readCustDatList(){//get equipment from dat file with list
        ListInterface<CustomizedEntity> custDatList = new List<>();
        //read data from Request.dat
        BufferedReader br = null;
	FileReader fr = null;

	try {
            fr = new FileReader("../LLTGH-Assignment/src/Customized/CustomizedOrderData.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] s =sCurrentLine.split("\\|");
                CustomizedEntity custEn = new CustomizedEntity(s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), Integer.parseInt(s[6]), Integer.parseInt(s[7]));
                custDatList.add(custEn);//add to list
            }

	} catch (IOException e) {
            e.printStackTrace();
	} finally {
	try {
            if (br != null)
		br.close();
            if (fr != null)
		fr.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	}
        return custDatList;
     }
    
    public void writeCustDatList(ListInterface<CustomizedEntity> orderList){//Rewrite dat file
        String s ="";
        int size = orderList.size();

        for(int i=0; i<size; i++){
            CustomizedEntity custEn = orderList.remove(0);
            s += custEn.getCustID()+ "|" + custEn.getStyle() + "|" + custEn.getSize() + "|" + custEn.getType() + "|" + custEn.getAcc() + "|" + Integer.toString(custEn.getPrior()) + "|" + Integer.toString(custEn.getPrice()) + "|" + Integer.toString(custEn.getStatus()) + "\n";
        }

        BufferedWriter bw = null;
	FileWriter fw = null;

	try {
            fw = new FileWriter("../LLTGH-Assignment/src/Customized/CustomizedOrderData.dat");
            bw = new BufferedWriter(fw);
            bw.write(s);
            System.out.println("Process Completed.");
	} catch (IOException e) {
            e.printStackTrace();
	} finally {
            try {
		if (bw != null)
                    bw.close();
		if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
	}
    }

    public void displayManageMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("               Manage Floral Arrangement");
        System.out.println("========================================================");

        System.out.println("These are the options you can choose:");
        System.out.println("1) Flower Arrangement Style");
        System.out.println("2) Flower Arrangement Size");
        System.out.println("3) Flower Type");
        System.out.println("4) Accessories");
        System.out.println("5) Back to Previous");
        System.out.print("Please enter your option > ");
        inputScanner = scanner.nextLine();
        checkManageInput(inputScanner);
    }
    
    public void checkManageInput(String manageInput){
        do{   
          
            switch(manageInput){
                case "1":
                    displayStyleMenu();
                    break;
                case "2":
                    displaySizeMenu();
                    break;
                case "3":
                    displayTypeMenu();
                    break;
                case "4":
                    displayAccMenu();
                    break;
                case "5":
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
        }while(!manageInput.equals("5"));
    }
    
    public String displayStyleMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("                Flower Arrangement Style");
        System.out.println("========================================================");
        
        //display style list
        System.out.println("These are the options you can choose:");
        System.out.println("1) Add Arrangement Style");
        System.out.println("2) Modify Arrangement Style");
        System.out.println("3) Back to Previous");
        System.out.print("Please enter your option > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public String displaySizeMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("                Flower Arrangement Size");
        System.out.println("========================================================");
        
        //display size list
        System.out.println("These are the options you can choose:");
        System.out.println("1) Add Arrangement Size");
        System.out.println("2) Modify Arrangement Size");
        System.out.println("3) Back to Previous");
        System.out.print("Please enter your option > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public String displayTypeMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("                      Flower Type");
        System.out.println("========================================================");
        
        //display flower type list
        System.out.println("These are the options you can choose:");
        System.out.println("1) Add Flower Type");
        System.out.println("2) Modify Flower Type");
        System.out.println("3) Back to Previous");
        System.out.print("Please enter your option > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public String displayAccMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("                      Accessories");
        System.out.println("========================================================");
        
        //display accessories list
        System.out.println("These are the options you can choose:");
        System.out.println("1) Add Accessories");
        System.out.println("2) Modify Accessories");
        System.out.println("3) Back to Previous");
        System.out.print("Please enter your option > ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
}
