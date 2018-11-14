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

    boolean valid;
    Scanner scanner = new Scanner(System.in);
    
    Order order = new Order();
    List<Order> orderList=new ArrayList<>();
    
//    CatalogMaintenance CM;
//    ArrayList<Product> prodList;

    public void printTest() {

        System.out.println("========================================================");
        System.out.println("                     Catalog Order");
        System.out.println("========================================================");

        orderItem();
        //getCustId();
        pickUpMethod();

    }

    private void orderItem() {
        int typeOpt=0, actOpt = 0;

        do {
            typeOpt=itemMenu();
            if(typeOpt!=-1){
                actOpt=moreItem();
            }
        } while (actOpt == 1);
    }

    private int itemMenu() {
        int typeOpt=0;
        
        do{
            System.out.println("1) Fresh Flowers");
            System.out.println("2) Bouquets");
            System.out.println("3) Floral Arrangement");
            System.out.print("Please select a product type(Enter -1 to back): ");

            try {
                valid = true;
                typeOpt = scanner.nextInt();
                if(typeOpt>=1 && typeOpt<=3){
                    showDetail(typeOpt);
                    getQuantity();
                }else{
                    System.out.println("Invalid input!Please enter again.\n");
                    valid = false;
                }
//                switch (typeOpt) {
//                    case 1:
//                        show
//                        getQuantity();
//                        break;
//                    case 2:
//                        order.setOrderItem("Bouquets");
//                        getQuantity();
//                        break;
//                    case 3:
//                        order.setOrderItem("Floral Arrangement");
//                        getQuantity();
//                        break;
//                    case -1:
//                        break;
//                    default:
//                        System.out.println("Invalid input!Please enter again.\n");
//                        valid = false;
//                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input!Please enter again.\n");
                scanner.next();
                valid = false;
            }
        }while(valid==false);
        return typeOpt;
    }

    private void showDetail(int typeOpt) {
        CatalogMaintenance CM=new CatalogMaintenance();
//        prodList=new ArrayList<Product>(CM.prod);
        
        if(typeOpt==1){
            System.out.println();
//            for(int i=0;i<prodList.size();i++){
//                System.out.println(prodList.get(i).getProdID());
//            }
        }
    }
    
    private void getQuantity() {
        int quantity;

        do {
            System.out.print("Please enter quantity: ");
            try {
                quantity = scanner.nextInt();
                if (quantity > 0) {
                    order.setQuantity(quantity);
                    valid = true;
                } else {
                    System.out.println("Invalid input.Please enter again.\n");
                    valid = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input!Please enter again.\n");
                scanner.next();
                valid = false;
            }
        } while (valid==false);
    }

    private int moreItem() {
        int actOpt=0;
        
        do {
            System.out.println("1) More items?");
            System.out.println("2) Place order");
            System.out.print("Please enter option: ");
            try {
                valid = true;
                actOpt = scanner.nextInt();
                if (actOpt != 1 && actOpt != 2) {
                    System.out.println("Invalid input!Please enter again.\n");
                    valid = false;
                }
                if (actOpt == 2) {
                    calTotal();
                    String orderId = generateId();
                    order.setOrderId(orderId);
                    System.out.println(order);
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input!Please enter again.\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return actOpt;
    }

//    public void getCustId() {
//        String inCustId;
//        String custId = ;
//
//        do {
//            scanner.nextLine();
//            System.out.print("Please enter customer ID: ");
//            inCustId = scanner.nextLine();
//            
//            if (!inCustId.equals(custId)) {
//                System.out.println("Invalid customer ID!");
//                System.out.println("Press enter to continue...");
//            }
//        } while (!inCustId.equals(custId));
//    }

    private void calTotal() {
        Product prod=new Product();
        int size=order.getOrderItem().size();
        
        for(int i=0;i<size;i++){
            double price=prod.getprodPrice();
        }
        //double total=
    }
    
    private String generateId() {
        int rNum = (int) (Math.random() * 999 + 1);
        String orderId = "OR" + rNum;
        return orderId;
    }
    
    private void pickUpMethod() {
        
    }
}