/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.util.*;

/**
 *
 * @author User
 */
public class CatalogOrders {

    Order order = new Order();
    Scanner scanner = new Scanner(System.in);

    public void printTest() {

        System.out.println("========================================================");
        System.out.println("                     Catalog Order");
        System.out.println("========================================================");

        orderItem();
        getCustId();
        pickUpMethod();

    }

    public void orderItem() {
        int prodOpt, actOpt = 0;

        do {
            System.out.println("1) Fresh Flowers");
            System.out.println("2) Bouquets");
            System.out.println("3) Floral Arrangement");
            System.out.print("Please select a product: ");

            try {
                prodOpt = scanner.nextInt();
                switch (prodOpt) {
                    case 1:
                        order.setOrderItem("Fresh Flowers");
                        getQuantity();
                        break;
                    case 2:
                        order.setOrderItem("Bouquets");
                        getQuantity();
                        break;
                    case 3:
                        order.setOrderItem("Floral Arrangement");
                        getQuantity();
                        break;
                    default:
                        System.out.println("Invalid input!Please enter again.\n");
                        orderItem();
                }
            } 
            catch (InputMismatchException ex) {
                System.out.println("Invalid input!Please enter again.\n");
                scanner.next();
                orderItem();
            }

            System.out.println("1) More items?");
            System.out.println("2) Place order");
            System.out.print("Please enter option: ");
            try{
                actOpt = scanner.nextInt();
                if(actOpt!=1 && actOpt!=2){
                    System.out.println("Invalid input!Please enter again.\n");
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input!Please enter again.\n");
                scanner.next();
            }
        } while (actOpt == 1);
    }

    private void getQuantity() {
        int quantity;
        boolean valid;

        do {
            System.out.print("Please enter quantity: ");
            try{
                quantity = scanner.nextInt();
                if (quantity > 0) {
                    order.setQuantity(quantity);
                    valid = true;
                } 
                else {
                    System.out.println("Invalid input.Please enter again.\n");
                    valid = false;
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input!Please enter again.\n");
                scanner.next();
                valid=false;
            }
        } while (valid==false);
    }

    public void getCustId() {
        String inCustId;
        String custId = "C0001";

        do {
            System.out.print("Please enter customer ID: ");
            inCustId = scanner.nextLine();

            if (!inCustId.equals(custId)) {
                System.out.println("Invalid customer ID!");
            }
        } while (!inCustId.equals(custId));
    }

    public void pickUpMethod() {

    }

}