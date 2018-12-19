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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import lltgh.rsd2g2.CatalogMaintenance;
import lltgh.rsd2g2.Product;

/**
 *
 * @author User
 */
public class CustomizedFloralArrangements {
    Scanner scanner = new Scanner(System.in);
    String inputScanner, modifyStatus, itemCode, itemName, itemStatus, title, st, sz, ty1, ty2, ty3, ac1, ac2, ac3, custType1="-", custType2="-", custType3="-", custAcc1="-", custAcc2="-", custAcc3="-";
    Boolean chkModifyStatus, chkValid;
    int itemPrice, tyCount, acCount, tyIndex1, tyIndex2, tyIndex3, acIndex1, acIndex2, acIndex3;

    public void printTest() throws ParseException{
        alertMsg();
        do{
            System.out.println("\n\n\n========================================================");
            System.out.println("               Customized Floral Arrangement");
            System.out.println("========================================================");

            System.out.println("These are the options you can choose:");
            System.out.println("1) New Customize for Consumer");
            System.out.println("2) Manage Customized Order");
            System.out.println("3) Manage Floral Arrangement Item");
            System.out.println("4) Back to Main Menu");
            System.out.print("Please enter your option > ");
            inputScanner = scanner.nextLine();
        
            switch(inputScanner){
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
       
        }while(!inputScanner.equals("4"));
    }
    
    public void alertMsg() throws ParseException{
        boolean valid=true;
        String tempDate="";
        ListInterface<CustomizedEntity> custList = readDataList("CO");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dateFormat.parse(dateFormat.format(date)));
        c.add(Calendar.DATE, 1);  // number of days to add for collection date
        tempDate = dateFormat.format(c.getTime());
        
        for(int i=0; i<custList.size(); i++){
            if(custList.get(i).getStatus() == 1){
                if(tempDate.equals(custList.get(i).getCollectionDate())){
                    while(valid == true){
                        System.out.println("\n\n\n***ALERT***\nCollection Date of the Following Order(s) is TOMORROW:-");
                        valid = false;
                    }
                    System.out.println("- " + custList.get(i).getOrderNo());
                }
            } 
        }
        if(valid == false){
            System.out.println("\nPlease:-\n1. Complete Order(s) Listed Above AS SOON AS POSSIBLE\nOR\n2. Contact Consumer to EXTEND Collection Date");
            
            System.out.print("Press enter to continue...");
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
    }

    public boolean displayCustMenu() throws ParseException{
        title=""; st=""; sz=""; ty1=""; ty2=""; ty3=""; ac1=""; ac2=""; ac3=""; custType1="-"; custType2="-"; custType3="-"; custAcc1="-"; custAcc2="-"; custAcc3="-"; tyCount=0; acCount=0;
        tyIndex1=0; tyIndex2=0; tyIndex3=0; acIndex1=0; acIndex2=0; acIndex3=0;
        String orderNo="", dateTime="", collectionDate="", tempDate="", consumer="", custStyle="", custSize="", pickupPrior="";
        int totalCust=0, status=0, prior=0, numOfDay=0;
        
        CustomizedEntity newCustOrder = new CustomizedEntity(orderNo, dateTime, collectionDate, consumer, st, sz, ty1, ty2, ty3, ac1, ac2, ac3, prior, totalCust, status);
        ListInterface<CustomizedEntity> custList = readDataList("CO");
        String size=String.format("%03d", custList.size()+1);
        orderNo = "ON" + size;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("\n\n\n" + dateFormat.format(date)); 
        dateTime = dateFormat.format(date);
        
        System.out.println("================================================");
        System.out.println("             Customized for Consumer");
        System.out.println("================================================");
        System.out.println("|Customer ID    |Customer Name                 |");
        System.out.println("------------------------------------------------");
        System.out.println("|C0001          |Daniel                        |");
        System.out.println("|C0002          |Jennie                        |");
        System.out.println("|C0003          |Lisa                          |");
        System.out.println("------------------------------------------------");
        
        //display consumer list
//        do{
//            System.out.println("\n\n\n========================================================");
//            System.out.println("                        Consumer");
//            System.out.println("========================================================");
            System.out.print("Please Enter Consumer ID (Enter -1 to Exit) > ");
            inputScanner = scanner.nextLine();
            if(inputScanner.equals("-1"))
                return false;
//            chkConsumer = checkCustInput(consumer);
//        }while(chkConsumer == false);
        consumer = inputScanner.toUpperCase();
        custStyle = printItemMenu("ST");
        if(custStyle.equals("false"))
            return false;
        custSize = printItemMenu("SZ");
        if(custSize.equals("false"))
            return false;

        custType1 = printItemMenu("TY");
        tyCount++;
        if(custType1.equals("false"))
            return false;
        if(tyCount == 1){
            do{
                System.out.print("Do you want to select SECOND Flower Type?(Y/N) > ");
                inputScanner = scanner.nextLine();
                chkValid = checkNext(inputScanner); 
            }while(chkValid == false);
            if(inputScanner.toUpperCase().equals("Y")){
                custType2 = printItemMenu("TY");
                tyCount++;
                if(custType2.equals("false"))
                    return false;
            } 
        }
        if(tyCount == 2){
            do{
                System.out.print("Do you want to select THIRD Flower Type?(Y/N) > ");
                inputScanner = scanner.nextLine();
                chkValid = checkNext(inputScanner); 
            }while(chkValid == false);
            if(inputScanner.toUpperCase().equals("Y")){
                custType3 = printItemMenu("TY");
                tyCount++;
                if(custType3.equals("false"))
                    return false;
            }
        }
        
        //can choose maximum 3 type
        custAcc1 = printItemMenu("AC");
        acCount++;
        if(custAcc1.equals("false"))
            return false;
        
        if(acCount == 1){
            do{
                System.out.print("Do you want to select SECOND Accessory?(Y/N) > ");
                inputScanner = scanner.nextLine();
                chkValid = checkNext(inputScanner); 
            }while(chkValid == false);
            if(inputScanner.toUpperCase().equals("Y")){
                custAcc2 = printItemMenu("AC");
                acCount++;
                if(custAcc2.equals("false"))
                    return false;
            } 
        }
        if(acCount == 2){
            do{
                System.out.print("Do you want to select THIRD Accessory?(Y/N) > ");
                inputScanner = scanner.nextLine();
                chkValid = checkNext(inputScanner); 
            }while(chkValid == false);
            if(inputScanner.toUpperCase().equals("Y")){
                custAcc3 = printItemMenu("AC");
                acCount++;
                if(custAcc3.equals("false"))
                    return false;
            }
        }
        
        pickupPrior = printItemMenu("PR");
        if(pickupPrior.equals("false"))
            return false;
        totalCust = calcTotal(custStyle, custSize, custType1, custType2, custType3, custAcc1, custAcc2, custAcc3, pickupPrior);
        status = 1;
        
        if(pickupPrior.equals("1"))
            numOfDay = 3;
        else if(pickupPrior.equals("2"))
            numOfDay = 5;
        else if(pickupPrior.equals("3"))
            numOfDay = 7;
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
        tempDate = dateFormat2.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(dateFormat2.parse(tempDate));
        c.add(Calendar.DATE, numOfDay);  // number of days to add for collection date
        collectionDate = dateFormat2.format(c.getTime());
        
        newCustOrder.setOrderNo(orderNo);
        newCustOrder.setDateTime(dateTime);
        newCustOrder.setCollectionDate(collectionDate);
        newCustOrder.setCustID(consumer.toUpperCase());
        newCustOrder.setStyle(st);
        newCustOrder.setSize(sz);
        newCustOrder.setType1(ty1);
        newCustOrder.setType2("-");
        newCustOrder.setType3("-");
        if(tyCount == 2){
            newCustOrder.setType2(ty2);
        }  
        if(tyCount == 3){
            newCustOrder.setType2(ty2);
            newCustOrder.setType3(ty3);
        }  
        newCustOrder.setAcc1(ac1);
        newCustOrder.setAcc2("-");
        newCustOrder.setAcc3("-");
        if(acCount == 2){
            newCustOrder.setAcc2(ac2);
        }    
        if(acCount == 3){
            newCustOrder.setAcc2(ac2);
            newCustOrder.setAcc3(ac3);    
        }     
        newCustOrder.setPrior(Integer.parseInt(pickupPrior));
        newCustOrder.setPrice(totalCust);
        newCustOrder.setStatus(status);

        custList.add(newCustOrder);
        writeDataList(custList, "CO");
        printItemizedBill(orderNo);
        
        do{
            System.out.print("\nAre You CONFIRM to Add This New Customized Order?(Y/N) > ");
            inputScanner = scanner.nextLine();
            chkValid = checkNext(inputScanner); 
        }while(chkValid == false);
        
        if(inputScanner.toUpperCase().equals("Y")){
            CatalogMaintenance cat = new CatalogMaintenance();
            ListInterface<Product> prod = cat.readProdDatList();
            
            Product updateTY1=null, updateTY2=null, updateTY3=null, updateAC1=null, updateAC2=null, updateAC3=null;            
            updateTY1=prod.get(tyIndex1);
            updateTY1.setprodStock(updateTY1.getprodStock()-1);
            prod.update(tyIndex1, updateTY1);
            if(tyCount == 2 || tyCount == 3){
                updateTY2=prod.get(tyIndex2);
                updateTY2.setprodStock(updateTY2.getprodStock()-1);
                prod.update(tyIndex2, updateTY2);
            }
            if(tyCount == 3){
                updateTY3=prod.get(tyIndex3);
                updateTY3.setprodStock(updateTY3.getprodStock()-1);
                prod.update(tyIndex3, updateTY3);
            }
            
            updateAC1=prod.get(acIndex1);
            updateAC1.setprodStock(updateAC1.getprodStock()-1);
            prod.update(acIndex1, updateAC1);
            if(acCount == 2 || acCount == 3){
                updateAC2=prod.get(acIndex2);
                updateAC2.setprodStock(updateAC2.getprodStock()-1);
                prod.update(acIndex2, updateAC2);
            }
            if(acCount == 3){
                updateAC3=prod.get(acIndex3);
                updateAC3.setprodStock(updateAC3.getprodStock()-1);
                prod.update(acIndex3, updateAC3);
            }

            cat.writeProdDatList(prod);
            System.out.println("\nNew Item Added SUCCESSFULLY!!");
            System.out.println("THANKS FOR YOUR ORDER.");
            
            System.out.print("Press enter to continue...");
            try {
                System.in.read();
            } catch (IOException ex) {
                 Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(custList.size()-1);
        }
        else if(inputScanner.toUpperCase().equals("N")){
            custList = readDataList("CO");
            System.out.println(custList.size()-1);
            custList.remove(custList.size()-1);  
            writeDataList(custList, "CO");    
        }
        return true;
    }
    
    public String printItemMenu(String item){   
        if(item.equals("ST"))
            title = "Flower Arrangement Style";
        else if(item.equals("SZ"))
            title = "Flower Arrangement Size";
        else if(item.equals("TY"))
            title = "Flower Type";
        else if(item.equals("AC"))
            title = "Accessories";
        else if(item.equals("PR"))
            title = "Pick-up Priority";
        
        do{
            System.out.println("\n=================================================");
            System.out.println("               " + title);
            System.out.println("=================================================");
            
            if(item.equals("PR")){
                System.out.printf("|%-5s|%-30s|%-10s|\n", "No.", "Name", "Price(RM)");
                System.out.println("-------------------------------------------------");
                System.out.printf("|%-5s|%-30s|%-10s|\n", "1", "Express(3 days)", "30");
                System.out.printf("|%-5s|%-30s|%-10s|\n", "2", "Normal(5 days)", "20");
                System.out.printf("|%-5s|%-30s|%-10s|\n", "3", "Flexi(7 days)", "10");
                System.out.println("------------------------------------------------");
                System.out.print("Please Enter No. to Select Pick-up Priority (Enter -1 to Exit) > ");
                inputScanner = scanner.nextLine();
                if(inputScanner.equals("-1"))
                    return "false";
                chkValid = checkPrior(inputScanner);
            }
            else{
                if(item.equals("TY")){
                    System.out.println("Current Selected Flower Type Amount(Maximum 3): " + tyCount);
                    System.out.println("Type 1 Code: " + custType1);
                    System.out.println("Type 2 Code: " + custType2);
                    System.out.println("Type 3 Code: " + custType3);
                }
                else if(item.equals("AC")){
                    System.out.println("Current Selected Accessory Amount(Maximum 3): " + acCount);
                    System.out.println("Accessory 1 Code: " + custAcc1);
                    System.out.println("Accessory 2 Code: " + custAcc2);
                    System.out.println("Accessory 3 Code: " + custAcc3);
                }
                if(item.equals("TY")||item.equals("AC")){
                    CatalogMaintenance cat = new CatalogMaintenance();
                    ListInterface<Product> prod = cat.readProdDatList();
                    printProdList(prod, item);
                }
                else{
                    ListInterface<CustomizedEntity> custItem = readDataList(item);
                    printItem(custItem, 0);
                }
                
                System.out.print("Please Enter Code (Enter -1 to Exit) > ");
                inputScanner = scanner.nextLine();
                if(inputScanner.equals("-1"))
                    return "false";
                chkValid = checkCodeInput(inputScanner, item);
            }
            
        }while(chkValid == false);
        
        return inputScanner;  
    }
    
    private void printProdList(ListInterface<Product> prodList, String item){//print Customized Order List
        System.out.printf("|%-5s|%-25s|%-30s|%-8s|%-8s|\n", "Code", "Name", "Details", "Price", "Quantity");
        System.out.println("----------------------------------------------------------------------------------");

        int size = prodList.size();
        for(int i=0; i<size; i++){
            Product prod = prodList.remove(0);
            if(item.equals("TY")){
                if(prod.getprodType().equals("Fresh Flower")){
                    if(prod.getprodStock() != 0)
                        System.out.printf("|%-5s|%-25s|%-30s|%-8s|%-8s|\n", prod.getProdID(), prod.getprodName(), prod.getprodDetail(), prod.getprodPrice(), prod.getprodStock());
                }            
            }
            else if(item.equals("AC")){
                if(prod.getprodType().equals("Accessory")){
                    if(prod.getprodStock() != 0)
                        System.out.printf("|%-5s|%-25s|%-30s|%-8s|%-8s|\n", prod.getProdID(), prod.getprodName(), prod.getprodDetail(), prod.getprodPrice(), prod.getprodStock());
                }    
            }
        }
        System.out.println("----------------------------------------------------------------------------------");
    } 
    
    public Boolean checkCodeInput(String codeInput, String item){
        Boolean returnValue = true;
        
        if(codeInput == null || codeInput.isEmpty()){
            System.out.println("***Do Not Leave Blank. Please enter again...");
            returnValue = false;
        }
        else{
            if(returnValue == true){
                returnValue = false;
                if(item.equals("TY")||item.equals("AC")){
                    CatalogMaintenance cat = new CatalogMaintenance();
                    ListInterface<Product> prod = cat.readProdDatList();
                    for(int i=0;i<prod.size();i++){
                        if(item.equals("TY")){
                            if(prod.get(i).getProdID().toUpperCase().equals(codeInput.toUpperCase()) && prod.get(i).getprodType().equals("Fresh Flower") && prod.get(i).getprodStock() != 0){
                                returnValue = true; 
                                break;
                            }
                        }
                        else if(item.equals("AC")){
                            if(prod.get(i).getProdID().toUpperCase().equals(codeInput.toUpperCase()) && prod.get(i).getprodType().equals("Accessory") && prod.get(i).getprodStock() != 0){
                                returnValue = true; 
                                break;
                            }
                        }                      
                    }
                }
                else{
                    ListInterface<CustomizedEntity> itemList = readDataList(item);
                    for(int i=0;i<itemList.size();i++){
                        if(itemList.get(i).getItemCode().toUpperCase().equals(codeInput.toUpperCase())){
                            returnValue = true; 
                            break;
                        }
                    }
                }
                
                if(returnValue == false)
                   System.out.println("***Please Enter A Valid Code.");
                else{
                    if(item.equals("TY")){
                        if(codeInput.toUpperCase().equals(custType1.toUpperCase()) || codeInput.toUpperCase().equals(custType2.toUpperCase())){
                            System.out.println("***Please select different type of flower.");
                            returnValue = false;
                        }
                        else
                            returnValue = true;
                    }
                    else if(item.equals("AC")){
                        if(codeInput.toUpperCase().equals(custAcc1.toUpperCase()) || codeInput.toUpperCase().equals(custAcc2.toUpperCase())){
                            System.out.println("***Please select different type of accessory.");
                            returnValue = false;
                        }
                        else
                            returnValue = true;
                    }
                }
            }
        }
        
        return returnValue;
    }
    
    public Boolean checkPrior(String custInput){
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
                if(custInput.equals("1") || custInput.equals("2") || custInput.equals("3")){ 
                        returnValue = true;
                }
                else{
                    System.out.println("***Please Enter A Valid Selection(1 to 3).");
                    returnValue = false;
                }
            }
        }
        
        return returnValue;
    }
    
    public Boolean checkNext(String input){
        Boolean returnValue = true;
        
        if(input == null || input.isEmpty()){
            System.out.println("***Do Not Leave Blank. Please enter again...");
            returnValue = false;
        }
        else{
            if(returnValue == true){
                if(input.toUpperCase().equals("Y") || input.toUpperCase().equals("N")){ 
                        returnValue = true;
                }
                else{
                    System.out.println("***Please Enter Y/N.");
                    returnValue = false;
                }
            }
        }
        
        return returnValue;
    }
    
    public int calcTotal(String style, String size, String type1, String type2, String type3, String acc1, String acc2, String acc3, String prior){
        ListInterface<CustomizedEntity> styleList = readDataList("ST");
        ListInterface<CustomizedEntity> sizeList = readDataList("SZ");
        CatalogMaintenance cat = new CatalogMaintenance();
        ListInterface<Product> typeList = cat.readProdDatList();
        ListInterface<Product> accList = cat.readProdDatList();
        int stPrice=0, szPrice=0, tyPrice1=0, tyPrice2=0, tyPrice3=0, accPrice1=0, accPrice2=0, accPrice3=0, prPrice=0, total=0;
        
        for(int i=0;i<styleList.size();i++){
            if(styleList.get(i).getItemCode().toUpperCase().equals(style.toUpperCase())){
                stPrice = styleList.get(i).getItemPrice();
                st = styleList.get(i).getItemName();
            }
        }
        
        for(int i=0;i<sizeList.size();i++){
            if(sizeList.get(i).getItemCode().toUpperCase().equals(size.toUpperCase())){
                szPrice = sizeList.get(i).getItemPrice();
                sz = sizeList.get(i).getItemName();
            }
        }
        
        for(int i=0;i<typeList.size();i++){
            if(typeList.get(i).getProdID().toUpperCase().equals(type1.toUpperCase())){
                tyPrice1 = (int)typeList.get(i).getprodPrice();
                tyIndex1 = i;
                ty1 = typeList.get(i).getprodName();
            }
            else if(typeList.get(i).getProdID().toUpperCase().equals(type2.toUpperCase())){
                tyPrice2 = (int)typeList.get(i).getprodPrice();
                tyIndex2 = i;
                ty2 = typeList.get(i).getprodName();
            }
            else if(typeList.get(i).getProdID().toUpperCase().equals(type3.toUpperCase())){
                tyPrice3 = (int)typeList.get(i).getprodPrice();
                tyIndex3 = i;
                ty3 = typeList.get(i).getprodName();
            }
        }
        
        for(int i=0;i<accList.size();i++){
            if(accList.get(i).getProdID().toUpperCase().equals(acc1.toUpperCase())){
                accPrice1 = (int)accList.get(i).getprodPrice();
                acIndex1 = i;
                ac1 = accList.get(i).getprodName();
            }
            else if(accList.get(i).getProdID().toUpperCase().equals(acc2.toUpperCase())){
                accPrice2 = (int)accList.get(i).getprodPrice();
                acIndex2 = i;
                ac2 = accList.get(i).getprodName();
            }
            else if(accList.get(i).getProdID().toUpperCase().equals(acc3.toUpperCase())){
                accPrice3 = (int)accList.get(i).getprodPrice();
                acIndex3 = i;
                ac3 = accList.get(i).getprodName();
            }
        }
        
        if(prior.equals("1"))
            prPrice = 30;
        else if(prior.equals("2"))
            prPrice = 20;
        else if(prior.equals("3"))
            prPrice = 10;

        total = stPrice + szPrice + tyPrice1 + tyPrice2 + tyPrice3 + accPrice1 + accPrice2 + accPrice3 + prPrice;
        return total;
    }
    
    public void printItemizedBill(String CustNo){
        ListInterface<CustomizedEntity> custList = readDataList("CO");
        ListInterface<CustomizedEntity> styleList = readDataList("ST");
        ListInterface<CustomizedEntity> sizeList = readDataList("SZ");
        CatalogMaintenance cat = new CatalogMaintenance();
        ListInterface<Product> typeList = cat.readProdDatList();
        ListInterface<Product> accList = cat.readProdDatList();
        int stPrice=0, szPrice=0, tyPrice1=0, tyPrice2=0, tyPrice3=0, accPrice1=0, accPrice2=0, accPrice3=0, prPrice=0;
        String prName="";
        
        for(int x=0;x<custList.size();x++){
            if(custList.get(x).getOrderNo().toUpperCase().equals(CustNo.toUpperCase())){
                
                for(int i=0;i<styleList.size();i++){
                    if(styleList.get(i).getItemName().toUpperCase().equals(custList.get(x).getStyle().toUpperCase()))
                        stPrice = styleList.get(i).getItemPrice();
                        
                }

                for(int i=0;i<sizeList.size();i++){
                    if(sizeList.get(i).getItemName().toUpperCase().equals(custList.get(x).getSize().toUpperCase()))
                        szPrice = sizeList.get(i).getItemPrice();
                }

                for(int i=0;i<typeList.size();i++){
                    if(typeList.get(i).getprodName().toUpperCase().equals(custList.get(x).getType1().toUpperCase()))
                        tyPrice1 = (int)typeList.get(i).getprodPrice();
                    else if(typeList.get(i).getprodName().toUpperCase().equals(custList.get(x).getType2().toUpperCase()))
                        tyPrice2 = (int)typeList.get(i).getprodPrice();
                    else if(typeList.get(i).getprodName().toUpperCase().equals(custList.get(x).getType3().toUpperCase()))
                        tyPrice3 = (int)typeList.get(i).getprodPrice();
                }

                for(int i=0;i<accList.size();i++){
                    if(accList.get(i).getprodName().toUpperCase().equals(custList.get(x).getAcc1().toUpperCase()))
                        accPrice1 = (int)accList.get(i).getprodPrice();
                    else if(accList.get(i).getprodName().toUpperCase().equals(custList.get(x).getAcc2().toUpperCase()))
                        accPrice2 = (int)accList.get(i).getprodPrice();
                    else if(accList.get(i).getprodName().toUpperCase().equals(custList.get(x).getAcc3().toUpperCase()))
                        accPrice3 = (int)accList.get(i).getprodPrice();
                }
                
                if(custList.get(x).getPrior()==1){
                    prPrice = 30;
                    prName = "Express(3 days)";
                } 
                else if(custList.get(x).getPrior()==2){
                    prPrice = 20;
                    prName = "Normal(5 days)";
                }  
                else if(custList.get(x).getPrior()==3){
                    prPrice = 10;
                    prName = "Flexi(7 days)";
                }
                
                System.out.println("\n\n\n======================================================================");
                System.out.println("                         Itemized Bill");
                System.out.println("======================================================================");
                System.out.println("Order Number: " + CustNo.toUpperCase() + "                    Order Date: " + custList.get(x).getDateTime());
                System.out.println("Customer ID: " + custList.get(x).getCustID() + "                     Collection Date: " + custList.get(x).getCollectionDate());
                System.out.println("\nFlower Arrangement Style: " + custList.get(x).getStyle() + "(RM " + stPrice + ")");
                System.out.println("\nFlower Arrangement Size: " + custList.get(x).getSize() + "(RM " + szPrice + ")");
                System.out.println("\nFlower Type 1: " + custList.get(x).getType1() + "(RM " + tyPrice1 + ")");
                System.out.println("Flower Type 2: " + custList.get(x).getType2() + "(RM " + tyPrice2 + ")");
                System.out.println("Flower Type 3: " + custList.get(x).getType3() + "(RM " + tyPrice3 + ")");
                System.out.println("\nAccessory 1: " + custList.get(x).getAcc1() + "(RM " + accPrice1 + ")");
                System.out.println("Accessory 2: " + custList.get(x).getAcc2() + "(RM " + accPrice2 + ")");
                System.out.println("Accessory 3: " + custList.get(x).getAcc3() + "(RM " + accPrice3 + ")");
                System.out.println("\nPick-up Priority: " + prName + "(RM " + prPrice + ")");
                System.out.println("\nTotal Price: RM " + custList.get(x).getPrice());
                System.out.println("\n======================================================================");
            }
        }
        
        System.out.print("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void displayOrderMenu() throws ParseException{
        do{
            System.out.println("\n\n\n========================================================");
            System.out.println("                    Manage Customized Order");
            System.out.println("========================================================");
            System.out.println("These are the options you can choose:");
            System.out.println("1) View Itemized Bill");
            System.out.println("2) View Customized Order");
            System.out.println("3) Update Customized Order Status");
            System.out.println("4) Update Collection Date");
            System.out.println("5) Back to Previous");
            System.out.print("Please enter your option > ");
            inputScanner = scanner.nextLine();
            
            switch(inputScanner){
                case "1":
                    displayListForItemizedBill();
                    break;
                case "2":
                    displayViewOrderMenu();
                    break;
                case "3":
                    modifyOrder(3);
                    break;
                case "4":
                    modifyOrder(4);
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
        }while(!inputScanner.equals("5"));
    }
    
    public boolean displayListForItemizedBill(){
        ListInterface<CustomizedEntity> orderList = readDataList("CO");
        
        do{
            System.out.println("\n\n\n=======================================================================================================================================================================================================================================================================================================");
            System.out.println("                                                                                  Customized Order");
            System.out.println("=======================================================================================================================================================================================================================================================================================================");
            printCustOrderListList(orderList);
            System.out.print("Please Enter Order No. (Enter -1 to Exit) > ");
            inputScanner = scanner.nextLine();
            if(inputScanner.equals("-1"))
                return false;
            chkValid = checkValidOrderNo(inputScanner);
        }while(chkValid == false);
        
        printItemizedBill(inputScanner);
        return true;
    }
    
    public Boolean checkValidOrderNo(String input){
        ListInterface<CustomizedEntity> orderList = readDataList("CO");
        Boolean returnValue = true;
        
        if(input == null || input.isEmpty()){
            System.out.println("***Do Not Leave Blank. Please enter again...");
            returnValue = false;
        }
        else{
            if(returnValue == true){
                returnValue = false;
                for(int i=0;i<orderList.size();i++){
                    if(orderList.get(i).getOrderNo().toUpperCase().equals(input.toUpperCase())){
                        returnValue = true; 
                        break;
                    }
                }
                if(returnValue == false)
                   System.out.println("***Please Enter A Valid Code.");
            }
        }  
        return returnValue;
    }
    
    public void displayViewOrderMenu(){
        
        do{
            System.out.println("\n\n\n========================================================");
            System.out.println("                    View Customized Order");
            System.out.println("========================================================");
            System.out.println("These are the options you can choose:");
            System.out.println("1) View Customized Order(Pending)");
            System.out.println("2) View Customized Order(Completed)");
            System.out.println("3) View Customized Order(Cancelled)");
            System.out.println("4) Back to Previous");
            System.out.print("Please enter your option > ");
            inputScanner = scanner.nextLine();
            
            switch(inputScanner){
                case "1":
                    viewOrder("Pending");
                    break;
                case "2":
                    viewOrder("Completed");
                    break;
                case "3":
                    viewOrder("Cancelled");
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
        }while(!inputScanner.equals("4"));
        
    }
    
    public void viewOrder(String status){
        System.out.println("\n\n\n=======================================================================================================================================================================================================================================================================================================");
        System.out.println("                                                                              View Customized Order("+ status +")");
        System.out.println("=======================================================================================================================================================================================================================================================================================================");
        QueueInterface<CustomizedEntity> orderList = readCustDat();
        if(status.equals("Pending"))
            printCustOrderList(orderList,1);
        else if(status.equals("Completed"))
            printCustOrderList(orderList,2);
        else if(status.equals("Cancelled"))
            printCustOrderList(orderList,2);

        System.out.print("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
             Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean modifyOrder(int item) throws ParseException{
        ListInterface<CustomizedEntity> orderListL = readDataList("Co");
        QueueInterface<CustomizedEntity> orderListQ = readCustDat();
        
        int tempCount=0, status=0;
        boolean chkInput;
        String tempDate="";
        CustomizedEntity update=null;
        do{
            System.out.println("\n\n\n=======================================================================================================================================================================================================================================================================================================");
            System.out.println("                                                                                              Update Status");
            System.out.println("=======================================================================================================================================================================================================================================================================================================");
            printCustOrderList(orderListQ,1);
            orderListQ = readCustDat();

            System.out.print("Enter Order Number(e.g ON001) to Update Status(Enter -1 to Exit) > ");
            modifyStatus = scanner.nextLine();
            if(modifyStatus.equals("-1"))
                return false;

            for(int i=0;i<orderListL.size();i++){
                if(orderListL.get(i).getOrderNo().toUpperCase().equals(modifyStatus.toUpperCase())){
                    update=orderListL.get(i);
                    tempCount = i;
                }
            }
            if(modifyStatus == null || modifyStatus.isEmpty())
                System.out.println("\n***Do Not Leave Blank. Please enter again...***");
            else if(update==null)
                System.out.println("\n***Invalid Order Number. Please enter again...***");
            else if(update.getStatus()!=1)
                System.out.println("\n***The Selected Order Number is NOT Pending. Please enter again...***");
        }while(modifyStatus == null || modifyStatus.isEmpty() || update==null||update.getStatus()!=1);

        System.out.println("\n\n\n=======================================================================================================================================================================================================================================================================================================");
        System.out.println("                                                                                              Update Order");
        System.out.println("=======================================================================================================================================================================================================================================================================================================");
        QueueInterface<CustomizedEntity> tempQueue = new Queue();
        tempQueue.enqueue(update);
        printCustOrderList(tempQueue,0);

        if(item == 3){
            do{
                System.out.println("\n========================================================");
                System.out.println("                       Order Status");
                System.out.println("========================================================");
                System.out.println("1) Completed");
                System.out.println("2) Cancelled");
                System.out.println("3) Exit");
                System.out.print("Please enter the new status(1 - 3)> ");
                inputScanner = scanner.nextLine();
                if(inputScanner.equals("3"))
                        return false;
                chkInput = checkModifyStatus(inputScanner, update.getOrderNo());
            }while(chkInput == false);

            if(inputScanner.equals("1"))
                status = 2;
            else if(inputScanner.equals("2"))
                status = 3;
        }
        else if(item == 4){
            do{
                System.out.println("\n=======================================================================");
                System.out.println("                           Order Collection Date");
                System.out.println("=======================================================================");
                System.out.print("Please Enter New Collection Date(yyyy/MM/dd) (Enter -1 to Exit) > ");
                inputScanner = scanner.nextLine();
                if(inputScanner.equals("-1"))
                        return false;
                chkInput = dateValidation(inputScanner);
                tempDate = inputScanner;
            }while(chkInput == false);
        }

        do{
            System.out.print("\nAre You CONFIRM to Modify This Order?(Y/N) > ");
            inputScanner = scanner.nextLine();
            chkValid = checkNext(inputScanner); 
        }while(chkValid == false);

        if(inputScanner.toUpperCase().equals("Y")){
            if(item == 3)
                update.setStatus(status);  
            else if(item == 4)
                update.setCollectionDate(tempDate); 
            orderListL.update(tempCount, update);
            writeDataList(orderListL, "CO");
            System.out.println("\n***Updated successfully!!***");
            tempQueue.enqueue(update);
            System.out.println("\n\n\n=======================================================================================================================================================================================================================================================================================================");
            System.out.println("                                                                                              Updated Order");
            System.out.println("=======================================================================================================================================================================================================================================================================================================");
            printCustOrderList(tempQueue,0);  

            System.out.print("Press enter to continue...");
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            return false;

        return true;
    }
    
    public Boolean checkModifyStatus(String input, String orderNo){
        Boolean returnValue = true;
        
        if(input == null || input.isEmpty()){
            System.out.println("\n***Do Not Leave Blank. Please enter again...***");
            returnValue = false;
        }
        else{
            try { 
                Integer.parseInt(input); 
            } catch(NumberFormatException e) { 
                System.out.println("\n***Please Enter Only Digit Number.");
                returnValue = false;
            }
            
            if(returnValue == true){
                if(input.equals("1") || input.equals("2")){
                    returnValue = true;
                }
                else{
                    System.out.println("\n***Please Enter Between 1 to 3 Only.");
                    returnValue = false;
                }
            }
        }
        
        return returnValue;
    }
    
    public boolean dateValidation(String inputDate) throws ParseException {
        boolean value=true;
        String tempDate = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        tempDate = dateFormat.format(date);
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(inputDate);
        Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(tempDate);
        
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("****Date -" + inputDate + "- is not valid according to " +
                ((SimpleDateFormat) dateFormat).toPattern() + " pattern.\nPlease enter again...");
            value = false;
        }
        
        if(value == true){
            if(!date1.after(date2)){
                System.out.println("****Date -" + inputDate + "- is not After Today Date.\nPlease enter after TODAY DATE...");
                value = false;
            }  
        }
        return value;
    }

    
    private ListInterface<CustomizedEntity> printCustOrderList(QueueInterface<CustomizedEntity> orderList, int input){//print Customized Order List
        ListInterface<CustomizedEntity> pendingList = new List();
        
        String prior="", status="";
        System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10s|%-10s|\n", "Order Number", "Date/Time", "Collection Date", "Customer ID","Style", "Size", "Flower Type 1", "Flower Type 2", "Flower Type 3", "Accessories 1", "Accessories 2", "Accessories 3", "Priority", "Price(RM)", "Status");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int size = orderList.size();
        if(input == 0){
            for(int i=0; i<size; i++){
                CustomizedEntity cust = orderList.dequeue();
                if(cust.getPrior() == 1)
                    prior = "Express(3 days)";
                else if(cust.getPrior() == 2)
                    prior = "Normal(5 days)";
                else if(cust.getPrior() == 3)
                    prior = "Flexi(7 days)";

                if(cust.getStatus() == 1)
                    status = "Pending";
                else if(cust.getStatus() == 2)
                    status = "Completed";
                else if(cust.getStatus() == 3)
                    status = "Cancelled";

                System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10d|%-10s|\n", cust.getOrderNo(), cust.getDateTime(), cust.getCollectionDate(), cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType1(), cust.getType2(), cust.getType3(), cust.getAcc1(), cust.getAcc2(), cust.getAcc3(), prior, cust.getPrice(), status);
            }
        }
        else if(input == 1){
            for(int i=0; i<size; i++){
                CustomizedEntity cust = orderList.dequeue();
                if(cust.getStatus() == 1){
                    if(cust.getPrior() == 1)
                        prior = "Express(3 days)";
                    else if(cust.getPrior() == 2)
                        prior = "Normal(5 days)";
                    else if(cust.getPrior() == 3)
                        prior = "Flexi(7 days)";

                    status = "Pending";
                    pendingList.add(cust);
                    System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10d|%-10s|\n", cust.getOrderNo(), cust.getDateTime(), cust.getCollectionDate(), cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType1(), cust.getType2(), cust.getType3(), cust.getAcc1(), cust.getAcc2(), cust.getAcc3(), prior, cust.getPrice(), status);
                } 
            }      
        }
        else if(input == 2){
            for(int i=0; i<size; i++){
                CustomizedEntity cust = orderList.dequeue();
                if(cust.getStatus() == 2){
                    if(cust.getPrior() == 1)
                        prior = "Express(3 days)";
                    else if(cust.getPrior() == 2)
                        prior = "Normal(5 days)";
                    else if(cust.getPrior() == 3)
                        prior = "Flexi(7 days)";

                    status = "Completed";
                    System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10d|%-10s|\n", cust.getOrderNo(), cust.getDateTime(), cust.getCollectionDate(), cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType1(), cust.getType2(), cust.getType3(), cust.getAcc1(), cust.getAcc2(), cust.getAcc3(), prior, cust.getPrice(), status);
                }
            }               
        }
        else if(input == 3){
            for(int i=0; i<size; i++){
                CustomizedEntity cust = orderList.dequeue();
                if(cust.getStatus() == 3){
                    if(cust.getPrior() == 1)
                        prior = "Express(3 days)";
                    else if(cust.getPrior() == 2)
                        prior = "Normal(5 days)";
                    else if(cust.getPrior() == 3)
                        prior = "Flexi(7 days)";

                    status = "Cancelled";
                    System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10d|%-10s|\n", cust.getOrderNo(), cust.getDateTime(), cust.getCollectionDate(), cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType1(), cust.getType2(), cust.getType3(), cust.getAcc1(), cust.getAcc2(), cust.getAcc3(), prior, cust.getPrice(), status);
                }
            }                   
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        return pendingList;
    }
    
    private void printCustOrderListList(ListInterface<CustomizedEntity> orderList){//print Customized Order List
        String prior="", status="";
        System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10s|%-10s|\n", "Order Number", "Date/Time", "Collection Date", "Customer ID","Style", "Size", "Flower Type 1", "Flower Type 2", "Flower Type 3", "Accessories 1", "Accessories 2", "Accessories 3", "Priority", "Price(RM)", "Status");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int size = orderList.size();
        for(int i=0; i<size; i++){
            CustomizedEntity cust = orderList.remove(0);
            
            if(cust.getPrior() == 1)
                prior = "Express(3 days)";
            else if(cust.getPrior() == 2)
                prior = "Normal(5 days)";
            else if(cust.getPrior() == 3)
                prior = "Flexi(7 days)";

            if(cust.getStatus() == 1)
                status = "Pending";
            else if(cust.getStatus() == 2)
                status = "Completed";
            else if(cust.getStatus() == 3)
                status = "Cancelled";

            System.out.printf("|%-15s|%-19s|%-15s|%-15s|%-30s|%-30s|%-15s|%-15s|%-15s|%-25s|%-25s|%-25s|%-15s|%-10d|%-10s|\n", cust.getOrderNo(), cust.getDateTime(), cust.getCollectionDate(), cust.getCustID(), cust.getStyle(), cust.getSize(), cust.getType1(), cust.getType2(), cust.getType3(), cust.getAcc1(), cust.getAcc2(), cust.getAcc3(), prior, cust.getPrice(), status);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    public QueueInterface<CustomizedEntity> readCustDat(){//get orderData from dat file
        QueueInterface<CustomizedEntity> custQueue = new Queue<>();
        //read data from CustomizedOrderData.dat
        BufferedReader br = null;
	FileReader fr = null;

	try {
            fr = new FileReader("../LLTGH-Assignment/src/Customized/CustomizedOrderData.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;
            
            while ((sCurrentLine = br.readLine()) != null) {
                
                String[] s =sCurrentLine.split("\\|");
                CustomizedEntity custEn = new CustomizedEntity(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], Integer.parseInt(s[12]), Integer.parseInt(s[13]), Integer.parseInt(s[14]));
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
    
    public ListInterface<CustomizedEntity> readDataList(String item){//get orderData from dat file with list
        ListInterface<CustomizedEntity> dataList = new List<>();
        //read data from CustomizedOrderData.dat
        BufferedReader br = null;
	FileReader fr = null;

	try {
            if(item.equals("CO"))
                fr = new FileReader("../LLTGH-Assignment/src/Customized/CustomizedOrderData.dat");
            else if(item.equals("ST"))
                fr = new FileReader("../LLTGH-Assignment/src/Customized/StyleData.dat");
            else if(item.equals("SZ"))
                fr = new FileReader("../LLTGH-Assignment/src/Customized/SizeData.dat");
                
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] s =sCurrentLine.split("\\|");
                if(item.equals("CO")){
                    CustomizedEntity custEn = new CustomizedEntity(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9], s[10], s[11], Integer.parseInt(s[12]), Integer.parseInt(s[13]), Integer.parseInt(s[14]));
                    dataList.add(custEn);
                }
                else if(item.equals("ST")||item.equals("SZ")){
                    CustomizedEntity itemEn = new CustomizedEntity(s[0], s[1], Integer.parseInt(s[2]), s[3]);
                    dataList.add(itemEn);//add to list
                }
                //add to list
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
        return dataList;
    }
    
    public void writeDataList(ListInterface<CustomizedEntity> list, String item){//Rewrite dat file
        String s ="";
        int size = list.size();

        for(int i=0; i<size; i++){
            CustomizedEntity custEn = list.remove(0);
            if(item.equals("CO"))
                s += custEn.getOrderNo() + "|" + custEn.getDateTime() + "|" + custEn.getCollectionDate() + "|" + custEn.getCustID()+ "|" + custEn.getStyle() + "|" + custEn.getSize() + "|" + custEn.getType1() + "|" + custEn.getType2() + "|" + custEn.getType3() + "|" + custEn.getAcc1() + "|" + custEn.getAcc2() + "|" + custEn.getAcc3() + "|" + Integer.toString(custEn.getPrior()) + "|" + Integer.toString(custEn.getPrice()) + "|" + Integer.toString(custEn.getStatus()) + "\n";
            else if(item.equals("ST")||item.equals("SZ"))
                s += custEn.getItemCode() + "|" + custEn.getItemName() + "|" + Integer.toString(custEn.getItemPrice())+ "|" + custEn.getItemStatus() + "\n";
        }

        BufferedWriter bw = null;
	FileWriter fw = null;  

	try {
            if(item.equals("CO"))
                fw = new FileWriter("../LLTGH-Assignment/src/Customized/CustomizedOrderData.dat");
            else if(item.equals("ST"))
                fw = new FileWriter("../LLTGH-Assignment/src/Customized/StyleData.dat");
            else if(item.equals("SZ"))
                fw = new FileWriter("../LLTGH-Assignment/src/Customized/SizeData.dat");
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

    public boolean displayManageMenu(){
        
        do{
            System.out.println("\n\n\n========================================================");
            System.out.println("               Manage Floral Arrangement");
            System.out.println("========================================================");

            System.out.println("These are the options you can choose:");
            System.out.println("1) Flower Arrangement Style");
            System.out.println("2) Flower Arrangement Size");
            System.out.println("3) Back to Previous");
            System.out.print("Please enter your option > ");
            inputScanner = scanner.nextLine();
          
            switch(inputScanner){
                case "1":
                    displayItemMenu("ST");
                    break;
                case "2":
                    displayItemMenu("SZ");
                    break;
                case "3":
                    return false;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 3.***");
                    System.out.print("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }      
        }while(!inputScanner.equals("3"));
        return true;  
    }
    
    
    public boolean displayItemMenu(String item){ 
        if(item.equals("ST"))
            title = "Flower Arrangement Style";
        else if(item.equals("SZ"))
            title = "Flower Arrangement Size";
            
        do{
            System.out.println("\n\n\n==============================================================");
            System.out.println("                " + title);
            System.out.println("==============================================================");

            ListInterface<CustomizedEntity> custItem = readDataList(item);
            printItem(custItem, 1);
            //display style list
            System.out.println("These are the options you can choose:");
            System.out.println("1) Add " + title);
            System.out.println("2) Update " + title +" Status");
            System.out.println("3) Back to Previous");
            System.out.print("Please enter your option > ");
            inputScanner = scanner.nextLine();

            switch(inputScanner){
                case "1":
                    addItem(item);
                    break;
                case "2":
                    updateItem(item);
                    break;
                case "3":
                    return false;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 3.***");
                    System.out.print("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }      
        }while(!inputScanner.equals("3"));
        return true;
    }
    
    public boolean addItem(String item){
        CustomizedEntity addItem = new CustomizedEntity(itemCode, itemName, itemPrice, itemStatus);
        ListInterface<CustomizedEntity> itemList = readDataList(item);
        String size=String.format("%03d", itemList.size()+1);
        boolean returnValue=true;
        do{
            returnValue=true;
            do{
                System.out.println("\n\n\n=============================================================");
                System.out.println("                Add " + title);
                System.out.println("=============================================================");

                System.out.print("Enter New " + title +" (Enter -1 to exit) > ");
                inputScanner = scanner.nextLine();
                if(inputScanner.equals("-1"))
                    return false;
                else if(inputScanner.equals(""))
                    System.out.println("***Please Do Not Leave Blank***");
            }while(inputScanner.isEmpty());
            addItem.setItemName(inputScanner); 
            System.out.print("Enter Price(Enter -1 to exit) > ");
            inputScanner = scanner.nextLine();
            if(inputScanner.equals("-1"))
                return false;
            else if(inputScanner.equals("") || inputScanner.isEmpty()){
                System.out.println("***Please Do Not Leave Blank***");
                returnValue = false;
            }
            
            if(returnValue == true){
                try { 
                    Integer.parseInt(inputScanner); 
                } catch(NumberFormatException e) { 
                    System.out.println("\n***Please Enter Only Digit Number.");
                    returnValue = false;
                }
                if(returnValue == true){
                    if(Integer.parseInt(inputScanner)<1){
                        System.out.println("***Price must be more than or equal to RM1. Please enter again...***");
                        returnValue = false;
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException ex) {

                            Logger.getLogger(CustomizedFloralArrangements.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else{
                        addItem.setItemPrice(Integer.parseInt(inputScanner));
                        addItem.setItemCode(item + size);
                        addItem.setItemStatus("Available");

                        do{
                            System.out.print("\nAre You CONFIRM to Add This New Item?(Y/N) > ");
                            inputScanner = scanner.nextLine();
                            chkValid = checkNext(inputScanner); 
                        }while(chkValid == false);
                        
                        if(inputScanner.toUpperCase().equals("Y")){
                            itemList.add(addItem);
                            writeDataList(itemList, item);
                            System.out.print("New Item Added SUCCESSFULLY!!\n");
                            returnValue = true;
                        }
                        else
                            return false;
                        
                    }
                }
            }

        }while(returnValue==false);

        System.out.print("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
             Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean updateItem(String item){
        ListInterface<CustomizedEntity> custItem = readDataList(item);
        
        int tempCount=0;
        String status = "";
        boolean chkInput;
        CustomizedEntity update=null;
        do{
            System.out.println("\n\n\n=============================================================");
            System.out.println("                Update " + title + " Status");
            System.out.println("=============================================================");
            printItem(readDataList(item), 1);
            System.out.print("Enter Code to Update Status(Enter -1 to Exit) > ");
            inputScanner = scanner.nextLine();
            if(inputScanner.equals("-1"))
                return false;
            for(int i=0;i<custItem.size();i++){
                if(custItem.get(i).getItemCode().toUpperCase().equals(inputScanner.toUpperCase())){
                    update=custItem.get(i);
                    tempCount = i;
                }
            }
            System.out.println(tempCount);
            if(inputScanner == null || inputScanner.isEmpty())
                System.out.println("\n***Do Not Leave Blank. Please enter again...***");
            else if(update==null)
                System.out.println("\n***Invalid Item Code. Please enter again...***");
        }while(inputScanner == null || inputScanner.isEmpty());

        ListInterface<CustomizedEntity> selectedItem = new List();
        selectedItem.add(update);
        do{
            System.out.println("\n\n\n==============================================================");
            System.out.println("                Update " + title + " Status");
            System.out.println("==============================================================");
            printItem(selectedItem, 1);
            
            System.out.println("1) Available");
            System.out.println("2) Unavailable");
            System.out.println("3) Exit");
            System.out.print("Please enter the new status(1 - 3)> ");
            inputScanner = scanner.nextLine();
            if(inputScanner.equals("3"))
                    return false;
            chkInput = checkUpdate(inputScanner);
        }while(chkInput == false);
        
        if(inputScanner.equals("1"))
            status = "Available";
        else if(inputScanner.equals("2"))
            status = "Unavailable";
        
        do{
            System.out.print("\nAre You CONFIRM to Modify This Item Status to \""+ status +"\"?(Y/N) > ");
            inputScanner = scanner.nextLine();
            chkValid = checkNext(inputScanner); 
        }while(chkValid == false);

        if(inputScanner.toUpperCase().equals("Y")){
            update.setItemStatus(status);
            custItem.update(tempCount, update);
            writeDataList(custItem, item);
            System.out.println("\n***Updated successfully!!***");
            selectedItem.add(update);
            System.out.println("\n\n\n==============================================================");
            System.out.println("                Updated " + title + " Status");
            System.out.println("==============================================================");
            printItem(selectedItem, 1); 

            System.out.print("Press enter to continue...");
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(CustomizedFloralArrangements.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            return false;

        return true;
    }
    
    public Boolean checkUpdate(String input){
        Boolean returnValue = true;
        
        if(input == null || input.isEmpty()){
            System.out.println("\n***Do Not Leave Blank. Please enter again...***");
            returnValue = false;
        }
        else{
            try { 
                Integer.parseInt(input); 
            } catch(NumberFormatException e) { 
                System.out.println("\n***Please Enter Only Digit Number.");
                returnValue = false;
            }
            
            if(returnValue == true){
                if(input.equals("1") || input.equals("2"))
                    returnValue = true;
                else{
                    System.out.println("\n***Please Enter Between 1 to 3 Only.");
                    returnValue = false;
                }
            }
        }
        return returnValue;
    }
    
    private void printItem(ListInterface<CustomizedEntity> item, int status){//print Customized Order List
        if(status == 1){
            System.out.printf("|%-5s|%-30s|%-10s|%-12s|\n", "Code", "Name", "Price(RM)", "Status");
            System.out.println("--------------------------------------------------------------");

            int size = item.size();
            for(int i=0; i<size; i++){
                CustomizedEntity custItem = item.remove(0);
                System.out.printf("|%-5s|%-30s|%-10d|%-12s|\n", custItem.getItemCode(), custItem.getItemName(), custItem.getItemPrice(), custItem.getItemStatus());
            }
            System.out.println("--------------------------------------------------------------");
        }
        else if(status == 0){
            System.out.printf("|%-5s|%-30s|%-10s|\n", "Code", "Name", "Price(RM)");
            System.out.println("-------------------------------------------------");
            
            int size = item.size();
            for(int i=0; i<size; i++){
                CustomizedEntity custItem = item.remove(0);
                if(custItem.getItemStatus().equals("Available"))
                    System.out.printf("|%-5s|%-30s|%-10d|\n", custItem.getItemCode(), custItem.getItemName(), custItem.getItemPrice());
            }
            System.out.println("-------------------------------------------------");
        }  
    }  
}
    
