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
public class CatalogMaintenance {
    
    public void printTest() {
        String option = null;

        System.out.println("Catalog Maintenance");
        System.out.println("1) View Product");
        System.out.println("2) View Promotions");
        System.out.println("3) Maintain Catalog");
        System.out.println("4) Check Stock");
        System.out.println("5) Back");

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
                System.out.println("***Invalid input, please enter between 1 to 6.***");
                System.out.print("Press enter to continue...");
        }

    }
    
    public void viewProduct(){
        System.out.println("1) Fresh Flowers");
        System.out.println("2) Bouquets");
        System.out.println("3) Floral Arrangement");
        System.out.println("4) Back");
    }

    public void viewPromotions() {
        
    }
    
    public void maintainCatalog(){
        System.out.println("1) Add");
        System.out.println("2) Edit");
        System.out.println("3) Delete");
        System.out.println("4) Back");
    }
    
    
}


