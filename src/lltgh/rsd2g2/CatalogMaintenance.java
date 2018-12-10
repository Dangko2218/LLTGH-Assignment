/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import Customized.List;
import Customized.ListInterface;
import Customized.QueueInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CatalogMaintenance {

    public static ArrayList<Product> prod = new ArrayList<Product>();//product   //xinyi add static

    Scanner input = new Scanner(System.in);

    public void printTest() {
        String option = null;

//        prod.add(new Product("p0001", "Red Rose", "Fresh Flower", "Rose in Red Color", 2, 30));
//        prod.add(new Product("p0002", "I Love You", "Bouquet", "520 Rose", 520, 5));
//        prod.add(new Product("p0003", "LWY Pack", "Floral Arrangement", "Made by Low Wei Yin", 200, 5));
//        prod.add(new Product("p0004", "Love You Forever", "Bouquet", "1001 Rose", 1000, 3));
//        prod.add(new Product("p0005", "TJH Pack", "Floral Arrangement", "Made by Tai Jia Hao", 200, 5));
//        prod.add(new Product("p0006", "White Rose", "Fresh Flower", "Rose in White Color", 2, 30));
//        prod.add(new Product("p0007", "Pink Rose", "Fresh Flower", "Rose in Pink Color", 2, 30));
//        prod.add(new Product("p0008", "GCY Pack", "Floral Arrangement", "Made by Goh Ching Yaw", 200, 5));
//        prod.add(new Product("p0009", "Blue Rose", "Fresh Flower", "Rose in Blue Color", 2, 30));
//        prod.add(new Product("p0010", "LXY Pack", "Floral Arrangement", "Made by Lim Xin Yi", 200, 5));
//        prod.add(new Product("p0011", "100% Love You", "Bouquet", "100 Red Rose", 100, 8));
//        prod.add(new Product("p0012", "HZW Pack", "Floral Arrangement", "Made by Hoe Zhi Wen", 200, 5));
        do {
            System.out.printf("\n" + "Catalog Maintenance\n");
            System.out.println("1) View Product");
            System.out.println("2) View Promotions");
            System.out.println("3) Maintain Catalog");
            System.out.println("4) Search Product");
            System.out.println("5) Check Stock");
            System.out.println("6) Back");
            System.out.print("Please enter your option>");
            option = input.nextLine();

            switch (option) {
                case "1":
                    viewProduct();
                    break;
                case "2":
                    viewPromotions();
                    break;
                case "3":
                    maintainCatalog();
                    break;
                case "4":
                    searchProduct();
                    break;
                case "5":
                    checkStock();
                    break;
                case "6":
                    break;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 5.***");
                    System.out.println("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!option.equals("6"));
    }

    public void viewProduct() {
        ListInterface<Product> prodList = readProdDatList();
        String option = null;
        do {
            System.out.println();
            System.out.println("View Products");
            System.out.println("1) Fresh Flowers");
            System.out.println("2) Bouquets");
            System.out.println("3) Floral Arrangement");
            System.out.println("4) View All");
            System.out.println("5) Back");
            System.out.print("Please enter your option>");
            option = input.nextLine();

            switch (option) {
                case "1":
                    viewFlowerList(prodList, "1");
                    break;
                case "2":
                    viewFlowerList(prodList, "2");
                    break;
                case "3":
                    viewFlowerList(prodList, "3");
                    break;
                case "4":
                    viewAll(prodList);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 4.***");
                    System.out.println("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!option.equals("5"));
    }

    public void viewPromotions() {
        System.out.println("Constructing...");

    }

    public void maintainCatalog() {
        System.out.println();
        System.out.println("Maintain Catalog");
        System.out.println("1) Add");
        System.out.println("2) Edit");
        System.out.println("3) Delete");
        System.out.println("4) Back");
    }

    public void searchProduct() {
        String option = null;
        do {
            System.out.println();
            System.out.println("Search Products");
            System.out.println("1) By Price");
            System.out.println("2) By Name");
            System.out.println("3) Back");
            System.out.print("Please enter your option>");
            option = input.nextLine();

            switch (option) {
                case "1":
                    searchByPrice();
                    break;
                case "2":
                    searchByProduct();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 4.***");
                    System.out.println("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!option.equals("3"));
    }

    public void searchByPrice() {
        String option = null;
        do {
            option = null;
            System.out.println();
            System.out.println("Search Products By Price");
            System.out.println("1) More Than");
            System.out.println("2) Less Than");
            System.out.println("3) Between");
            System.out.println("4) Back");
            System.out.print("Please enter your option>");
            option = input.nextLine();

            switch (option) {
                case "1":
                    searchPriceOption("1");
                    break;
                case "2":
                    searchPriceOption("2");
                    break;
                case "3":
                    searchPriceOption("3");
                    break;
                case "4":
                    break;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 4.***");
                    System.out.println("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!option.equals("4"));
    }

    public void searchByProduct() {
        ListInterface<Product> prod = readProdDatList();
        String userInput = null;
        String nextSearch = null;
        boolean isContinue = false;
        do {
            System.out.print("Enter product name to Search>");
            userInput = input.nextLine();
            header();
            for (int i = 0; i < prod.size(); i++) {
                userInput = userInput.toLowerCase();
                if (prod.get(i).getprodName().toLowerCase().contains(userInput) || prod.get(i).getprodDetail().toLowerCase().contains(userInput)) {
                    getProductListFromDat(prod, i);
                }
            }
            tailer();
            System.out.println();
            System.out.print("Continue Search?(Y/N)>");
            nextSearch = input.nextLine();
            nextSearch = nextSearch.toLowerCase();
            if ("y".equals(nextSearch) || "yes".equals(nextSearch) || "ya".equals(nextSearch) || "ok".equals(nextSearch)) {
                isContinue = true;
            } else if ("n".equals(nextSearch) || "no".equals(nextSearch) || "nope".equals(nextSearch)) {
                isContinue = false;
            } else {
                System.out.println("Invalid Input, Please Try Again!");
                isContinue = false;
            }
        } while (isContinue == true);

    }

    public void searchPriceOption(String option) {
        ListInterface<Product> ProdList = readProdDatList();
        String priceInput = null;
        String priceInput2 = null;

        if ("1".equals(option)) {
            do {
                System.out.print("Enter a price to search>");
                priceInput = input.nextLine();
            } while (isDouble(priceInput) != true);
            header();
            for (int i = 0; i < ProdList.size(); i++) {
                if (ProdList.get(i).getprodPrice() >= Double.parseDouble(priceInput)) {
                    getProductListFromDat(ProdList, i);
                }
            }
            tailer();
        } else if ("2".equals(option)) {
            do {
                System.out.print("Enter a price to search>");
                priceInput = input.nextLine();
            } while (isDouble(priceInput) != true);
            header();
            for (int i = 0; i < ProdList.size(); i++) {
                if (ProdList.get(i).getprodPrice() <= Double.parseDouble(priceInput)) {
                    getProductListFromDat(ProdList, i);
                }
            }
            tailer();
        } else {
            do {
                System.out.print("Enter Starting price>");
                priceInput = input.nextLine();
            } while (isDouble(priceInput) != true);
            boolean isMoreThan = false;
            do {
                do {

                    System.out.print("Enter Ending price>");
                    priceInput2 = input.nextLine();
                    if (Double.parseDouble(priceInput2) <= Double.parseDouble(priceInput)) {
                        System.out.println("Ending Price must more than Starting Price!");
                        isMoreThan = false;
                    } else {
                        isMoreThan = true;
                    }
                } while (isMoreThan != true);
            } while (isDouble(priceInput2) != true);

            header();
            for (int i = 0; i < ProdList.size(); i++) {
                if (ProdList.get(i).getprodPrice() >= Double.parseDouble(priceInput) && ProdList.get(i).getprodPrice() <= Double.parseDouble(priceInput2)) {
                    getProductListFromDat(ProdList, i);
                }
            }
            tailer();
        }

    }

    public void checkStock() {
        String option = null;
        int prodPosition = 0;
        int hole = 0;

        do {
            ListInterface<Product> prodList = readProdDatList();
            Product tempProd = null;
            Product modProd = null;
            header();
            for (int i = 0; i < prodList.size(); i++) {
                if (prodList.get(i).getprodStock() == 0) {
                    getProductListFromDat(prodList, i);
                }

            }
            tailer();
            for (int i = 1; i < prodList.size(); i++) {
                tempProd = prodList.get(i);
                hole = i;
                while (hole > 0 && prodList.get(hole - 1).getprodStock() >= tempProd.getprodStock()) {
                    prodList.remove(hole);
                    prodList.add(hole - 1, prodList.get(hole));
                    hole--;
                }
                prodList.remove(hole);
                prodList.add(hole, tempProd);

            }
            prodList = readProdDatList();
            for (int i = 0; i < prodList.size(); i++) {
                if (prodList.get(i).getprodStock() != 0) {
                    getProductListFromDat(prodList, i);
                }
            }
            tailer();
            System.out.println();
            System.out.println("Check Stock");
            System.out.println("1) Add Stock");
            System.out.println("2) Edit Stock");
            System.out.println("3) Remove Stock");
            System.out.println("4) Back");
            System.out.print("Please enter your option>");
            option = input.nextLine();

            switch (option) {
                case "1":
                    addStock(prodList, prodPosition, modProd);
                    break;
                case "2":
                    editStock(prodList, prodPosition, modProd);
                    break;
                case "3":
                    removeStock(prodList, prodPosition, modProd);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("***Invalid input, please enter between 1 to 4.***");
                    System.out.println("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } while (!option.equals("4"));
    }

    public void addStock(ListInterface<Product> prodList, int prodPosition, Product modProd) {
        boolean isCorrect = false;
        boolean isValid = false;
        String stockNum = null;
        String userInput = null;
        String confirmation = null;
        int total = 0;
        do {
            System.out.print("Enter Product ID>");
            userInput = input.nextLine();
            for (int i = 0; i < prodList.size(); i++) {
                userInput = userInput.toLowerCase();

                if (prodList.get(i).getProdID().toLowerCase().contains(userInput) || prodList.get(i).getprodName().toLowerCase().contains(userInput) || prodList.get(i).getprodDetail().toLowerCase().contains(userInput)) {
                    header();
                    getProductListFromDat(prodList, i);
                    tailer();
                    isCorrect = true;
                    prodPosition = i;
                    modProd = prodList.get(i);
                    break;
                } else {
                    isCorrect = false;
                }
            }
            if (isCorrect == false) {
                System.out.println("Invalid Input!!!");

            }
        } while (isCorrect != true);

        System.out.println();
        do {
            do {
                System.out.print("Enter Number of Stock to ADD >");
                stockNum = input.nextLine();
                if (isInteger(stockNum) == true && Integer.parseInt(stockNum) > 0) {
                    System.out.print("Are u sure want to ADD " + stockNum + " into Stock?(Y/N)>");
                    confirmation = input.nextLine();
                    confirmation = confirmation.toLowerCase();
                    if (confirmation.equals("yes") || confirmation.equals("ok") || confirmation.equals("y")) {
                        total = modProd.getprodStock() + Integer.parseInt(stockNum);
                        modProd.setprodStock(total);
                        prodList.update(prodPosition, modProd);
                        writeProdDatList(prodList);
                        isValid = true;
                    } else {
                        break;
                    }
                } else {
                    isValid = false;
                    System.out.println("Stock to add cannot be 0 or less than 0!");
                }
            } while (isValid != true);
        } while (isInteger(stockNum) != true);
    }

    public void editStock(ListInterface<Product> prodList, int prodPosition, Product modProd) {
        boolean isCorrect = false;
        String stockNum = null;
        String userInput = null;
        String confirmation = null;
        do {
            System.out.print("Enter Product>");
            userInput = input.nextLine();
            for (int i = 0; i < prodList.size(); i++) {
                userInput = userInput.toLowerCase();

                if (prodList.get(i).getProdID().toLowerCase().contains(userInput) || prodList.get(i).getprodName().toLowerCase().contains(userInput) || prodList.get(i).getprodDetail().toLowerCase().contains(userInput)) {
                    header();
                    getProductListFromDat(prodList, i);
                    tailer();
                    isCorrect = true;
                    prodPosition = i;
                    modProd = prodList.get(i);
                    break;
                } else {
                    isCorrect = false;
                }
            }
            if (isCorrect == false) {
                System.out.println("Invalid Input!!!");

            }
        } while (isCorrect != true);

        System.out.println();
        do {
            System.out.print("Enter A Number to change Number of Stock >");
            stockNum = input.nextLine();
        } while (isInteger(stockNum) != true);

        if (isInteger(stockNum) == true) {
            System.out.print("Are u sure want to change " + prodList.get(prodPosition).getprodStock() + " to " + stockNum + " ?(Y/N)>");
            confirmation = input.nextLine();
            confirmation = confirmation.toLowerCase();
            if (confirmation.equals("yes") || confirmation.equals("ok") || confirmation.equals("y")) {
                modProd.setprodStock(Integer.parseInt(stockNum));
                prodList.update(prodPosition, modProd);
                writeProdDatList(prodList);
            }
        }
    }

    public void removeStock(ListInterface<Product> prodList, int prodPosition, Product modProd) {
        boolean isCorrect = false;
        boolean isValid = false;
        boolean isNotZero = false;
        String stockNum = null;
        String userInput = null;
        String confirmation = null;
        int total = 0;
        do {
            System.out.print("Enter Product>");
            userInput = input.nextLine();
            for (int i = 0; i < prodList.size(); i++) {
                userInput = userInput.toLowerCase();

                if (prodList.get(i).getprodStock() != 0) {
                    if (prodList.get(i).getProdID().toLowerCase().contains(userInput) || prodList.get(i).getprodName().toLowerCase().contains(userInput) || prodList.get(i).getprodDetail().toLowerCase().contains(userInput)) {
                        header();
                        getProductListFromDat(prodList, i);
                        tailer();
                        isNotZero = true;
                        isCorrect = true;
                        prodPosition = i;
                        modProd = prodList.get(i);
                        break;
                    } else {
                        isCorrect = false;
                    }
                } else {
                    isNotZero = false;
                }
            }
            if (isCorrect == false) {
                System.out.println("Invalid Input!!!");
            }
            if (isNotZero == false) {
                System.out.println("You cannot remove product stock that is 0!!!");
            }
        } while (isCorrect != true);

        System.out.println();
        do {
            do {
                System.out.print("Enter Number of Stock to remove >");
                stockNum = input.nextLine();
                if (isInteger(stockNum) == true && Integer.parseInt(stockNum) <= modProd.getprodStock() && Integer.parseInt(stockNum) > 0) {
                    System.out.print("Are u sure want to Remove " + stockNum + " from Stock?(Y/N)>");
                    confirmation = input.nextLine();
                    confirmation = confirmation.toLowerCase();
                    if (confirmation.equals("yes") || confirmation.equals("ok") || confirmation.equals("y")) {
                        total = modProd.getprodStock() - Integer.parseInt(stockNum);
                        modProd.setprodStock(total);
                        prodList.update(prodPosition, modProd);
                        writeProdDatList(prodList);
                        isValid = true;
                    } else {
                        break;
                    }
                } else {
                    isValid = false;
                    System.out.println("Stock to remove cannot be 0 and must less than original Stock!");
                }
            } while (isValid != true);
        } while (isInteger(stockNum) != true);
    }

    public void viewFlowerList(ListInterface<Product> prodList, String option) {
        header();
        for (int i = 0; i < prodList.size(); i++) {
            if ("Fresh Flower".equals(prodList.get(i).getprodType()) && "1".equals(option)) {
                getProductListFromDat(prodList, i);
            } else if ("Bouquet".equals(prodList.get(i).getprodType()) && "2".equals(option)) {
                getProductListFromDat(prodList, i);
            } else if ("Floral Arrangement".equals(prodList.get(i).getprodType()) && "3".equals(option)) {
                getProductListFromDat(prodList, i);
            }
        }
        tailer();
        System.out.println();

    }

    public void viewFlower(ArrayList<Product> al, String option) { // for arraylist let people use
        header();
        for (int i = 0; i < al.size(); i++) {
            if ("Fresh Flower".equals(al.get(i).getprodType()) && "1".equals(option)) {
                getProductList(al, i);
            } else if ("Bouquet".equals(al.get(i).getprodType()) && "2".equals(option)) {
                getProductList(al, i);
            } else if ("Floral Arrangement".equals(al.get(i).getprodType()) && "3".equals(option)) {
                getProductList(al, i);
            }
        }
        tailer();
        System.out.println();

    }

    public void viewAll(ListInterface<Product> prodList) {
        prodList = readProdDatList();
        header();
        for (int i = 0; i < prodList.size(); i++) {
            if ("Fresh Flower".equals(prodList.get(i).getprodType())) {
                getProductListFromDat(prodList, i);
            }
        }
        for (int i = 0; i < prodList.size(); i++) {
            if ("Bouquet".equals(prodList.get(i).getprodType())) {
                getProductListFromDat(prodList, i);
            }
        }
        for (int i = 0; i < prodList.size(); i++) {
            if ("Floral Arrangement".equals(prodList.get(i).getprodType())) {
                getProductListFromDat(prodList, i);
            }
        }
        tailer();
        System.out.println();
    }

    public static void getProductList(ArrayList<Product> al, int i) {
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());
    }

    public void getProductListFromDat(ListInterface<Product> prodList, int i) {
//        prodList = readProdDatList();
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", prodList.get(i).getProdID(), prodList.get(i).getprodName(), prodList.get(i).getprodType(), prodList.get(i).getprodDetail(), prodList.get(i).getprodPrice(), prodList.get(i).getprodStock());
    }

    public boolean isDouble(String userInput) {
        boolean isDouble = true;
        try {
            double doubleValue = Double.parseDouble(userInput);
            isDouble = true;
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer");
            isDouble = false;
        }
        return isDouble;
    }

    public boolean isInteger(String userInput) {
        boolean isInt = true;
        try {
            int intValue = Integer.parseInt(userInput);
            isInt = true;
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer");
            isInt = false;
        }
        return isInt;
    }

    public ListInterface<Product> readProdDatList() {//get orderData from dat file with list
        ListInterface<Product> prodDatList = new List<>();
        //read data from CustomizedOrderData.dat
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader("../LLTGH-Assignment/src/lltgh/rsd2g2/Product.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split("\\|");
                Product prodEn = new Product(s[0], s[1], s[2], s[3], Double.parseDouble(s[4]), Integer.parseInt(s[5]));
                prodDatList.add(prodEn);//add to list
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
        return prodDatList;
    }

    public void writeProdDatList(ListInterface<Product> prodList) {//Rewrite dat file
        String s = "";
        int size = prodList.size();
        for (int i = 0; i < size; i++) {
            Product prodEn = prodList.remove(0);
            s += prodEn.getProdID() + "|" + prodEn.getprodName() + "|" + prodEn.getprodType() + "|" + prodEn.getprodDetail() + "|" + Double.toString(prodEn.getprodPrice()) + "|" + Integer.toString(prodEn.getprodStock()) + "\n";
        }

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("../LLTGH-Assignment/src/lltgh/rsd2g2/Product.dat");
            bw = new BufferedWriter(fw);
            bw.write(s);
            System.out.println("Process Completed.");
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

    public static void header() {
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "ID", "Name", "Type", "Detail", "Price", "Stock");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
    }

    public static void tailer() {
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
    }

}
