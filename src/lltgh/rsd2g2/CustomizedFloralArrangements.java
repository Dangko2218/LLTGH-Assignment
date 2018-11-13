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
    String inputScanner = null;

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
        System.out.print("Please Enter Consumer ID (Enter -1 to Exit) > ");
        inputScanner = scanner.nextLine();
        
        //display f.a.Style
        System.out.print("Please Select Flower Arrangement Style (Enter -1 to Exit) > ");
        inputScanner = scanner.nextLine();
        
        //display f.a.Size
        System.out.print("Please Select Flower Arrangement Size (Enter -1 to Exit) > ");
        inputScanner = scanner.nextLine();
        
        //display f.Type
        System.out.print("Please Select Flower Type Code (Enter -1 to Exit) > ");
        inputScanner = scanner.nextLine();
        
        //display Accessories
        System.out.print("Please Enter Accessories Code (Enter -1 to Exit) > ");
        inputScanner = scanner.nextLine();
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
