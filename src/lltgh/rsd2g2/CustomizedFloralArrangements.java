/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

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
    String inputScanner, consumer, custStyle, custSize, custType, custAcc, pickupPrio;
    Boolean chkConsumer, chkStyle, chkSize, chkType, chkAcc, chkPickupPrio;

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
                displayManageMenu();
                break;
            case "3":
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
       
        }while(!option.equals("3"));
    }
    
    public String displayMenu(){
        System.out.println("\n\n\n========================================================");
        System.out.println("               Customized Floral Arrangement");
        System.out.println("========================================================");

        System.out.println("These are the options you can choose:");
        System.out.println("1) Customized for Consumer");
        System.out.println("2) Manage Floral Arrangement");
        System.out.println("3) Back to Main Menu");
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
                if(custInput.equals("1") || custInput.equals("2") || custInput.equals("3") || custInput.equals("-1")){
                    if(custInput.equals("-1")){
                        displayMenu();
                    }
                    else{
                        returnValue = true;
                    }
                }
                else{
                    System.out.println("***Please Enter A Valid Selection.");
                    returnValue = false;
                }
            }
        }
        
        return returnValue;
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
                    displayMenu();
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
