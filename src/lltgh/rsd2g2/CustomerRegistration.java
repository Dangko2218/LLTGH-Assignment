package lltgh.rsd2g2;

import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CustomerRegistration {
    
    // global variable declaration<?>
    String custID = null, custName = null, custIC = null, contactNo = null, custType =null, custCorp = null, corpAddr = null, custSelection = null;
    double creditLimit = 0;

    // new object<?>
    // CustomerRegistration regCust = new CustomerRegistration();
    public static InvListInterface<Customer> customerList = new InvLinkedList<>();
    
    Scanner input = new Scanner(System.in);
      
    // display registration form
    public void custReg() throws IOException{

        customerList = readCustFile();

        System.out.println("  Customer Registration  ");
        System.out.println("=========================");
        
        // get customer name
        System.out.print("Customer name > ");
        custName = input.nextLine();
        
        // get ic no.
        System.out.print("Identity Card No./Passport no. > ");
        custIC = input.nextLine();
        
        // get contact no.
        System.out.print("Contact no. > ");
        contactNo = input.nextLine();        
        
        
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
            custCorp = input.nextLine();
            
            System.out.print("Company/Corporate address > ");
            corpAddr = input.nextLine();
            
            System.out.print("Credit limit > ");
            creditLimit = input.nextDouble();
        }
        
        // generate id for customer; to be updated
        custID = generateCustID(custType);
        
        // add customer details into list
        Customer newCust = new Customer(custID, custName, custIC, contactNo, custType, custCorp, corpAddr, creditLimit);
        customerList.add(newCust);
        System.out.println("Customer Successfully Saved.");
        writeCustDat(customerList);
    }
    
    public String selectType(){
        System.out.println("--------------------");
        System.out.println("| 1. Normal        |");
        System.out.println("| 2. Corporate     |");
        System.out.println("--------------------");
        
        System.out.print("Customer Type > ");
        return custSelection = input.nextLine();
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
            ID = "N" + String.format("%03d", nCounter);
        }
        else{
            cCounter++;
            ID = "C" + String.format("%03d", cCounter);
        }  
        return ID;
    }

    public InvLinkedList<Customer> readCustFile() {
        InvListInterface<Customer> custDat = new InvLinkedList<>();
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader("../LLTGH-Assignment/src/lltgh/rsd2g2/Customer.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] d = sCurrentLine.split("\\|");
                Customer getData = new Customer(d[0], d[1], d[2], d[3], d[4], d[5], d[6], Double.parseDouble(d[7]));
                custDat.add(getData);
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
        return (InvLinkedList<Customer>) custDat;
    }

    public void writeCustDat(InvListInterface<Customer> customerList){
        String s = "";
        int size = customerList.size();
        for (int i = 0; i < size; i++){
            Customer cust = customerList.get(i);
            s += cust.getCustID() + "|" +cust.getName() + "|" + cust.getCustIC() + "|" + cust.getContactNo() + "|" + cust.getType() + "|" + cust.getCustCorp() + "|" + cust.getCorpAddr() + "|" + cust.getCreditLimit() + "\n";
        }

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("../LLTGH-Assignment/src/lltgh/rsd2g2/Customer.dat");
            bw = new BufferedWriter(fw);
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (Exception ex) { ex.printStackTrace();}
        }
    }
}

/*
C001|Timothy Goh|980506-13-6009|0165769856|Corporate|ABC|IDK the place|200.0
C002|Joshua Mok|901209-56-7781|0172235644|Corporate|ABC|IDK the place|500.0
N001|Arthur Pendragon|31195855|0172235644|Normal|N/A|N/A|0.0
*/
