/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CatalogMaintenance {

    public static ArrayList<Product> prod = new ArrayList<Product>();//product
    Scanner input = new Scanner(System.in);

    public void printTest() {
        String option = null;

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

        System.out.println("Catalog Maintenance");
        System.out.println("1) View Product");
        System.out.println("2) View Promotions");
        System.out.println("3) Maintain Catalog");
        System.out.println("4) Check Stock");
        System.out.println("5) Back");
        do {
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
                    System.out.println("CheckStock");
                    break;
                case "5":
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
        } while (!option.equals("5"));

    }

    public void viewProduct() {
        String option = null;
        System.out.println("View Products");
        System.out.println("1) Fresh Flowers");
        System.out.println("2) Bouquets");
        System.out.println("3) Floral Arrangement");
        System.out.println("4) View All");
        System.out.println("5) Back");
        do {
            System.out.print("Please enter your option>");
            option = input.nextLine();

            switch (option) {
                case "1":
                    viewFlower(prod, "1");
                    break;
                case "2":
                    viewFlower(prod, "2");
                    break;
                case "3":
                    viewFlower(prod, "3");
                    break;
                case "4":
                    viewAll(prod);
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

    }

    public void maintainCatalog() {
        System.out.println("1) Add");
        System.out.println("2) Edit");
        System.out.println("3) Delete");
        System.out.println("4) Back");
    }

    public static void viewFlower(ArrayList<Product> al, String option) {
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "ID", "Name", "Type", "Detail", "Price", "Stock");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getprodType() == "Fresh Flower" && option == "1") {
                System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());
            } else if (al.get(i).getprodType() == "Bouquet" && option == "2") {
                System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());

            } else if (al.get(i).getprodType() == "Floral Arrangement" && option == "3") {
                System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());
            }
        }
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        System.out.println();

    }

    public static void viewAll(ArrayList<Product> al) {
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "ID", "Name", "Type", "Detail", "Price", "Stock");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        //here maybe can use stack;
        //push to stack ??
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getprodType() == "Fresh Flower") {
                System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());
            }
        }
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getprodType() == "Bouquet") {
                System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());
            }
        }
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).getprodType() == "Floral Arrangement") {
                System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", al.get(i).getProdID(), al.get(i).getprodName(), al.get(i).getprodType(), al.get(i).getprodDetail(), al.get(i).getprodPrice(), al.get(i).getprodStock());
            }
        }
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        System.out.println();
    }

}
