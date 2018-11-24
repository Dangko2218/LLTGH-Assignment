/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CatalogOrders {

    private boolean valid;
    private Scanner scanner = new Scanner(System.in);

    private Order order = new Order();
    private List<Order> orderList = new ArrayList<>();

    CatalogMaintenance CM = new CatalogMaintenance();

    public void printTest() {

        System.out.println("\n========================================================");
        System.out.println("                     Catalog Order");
        System.out.println("========================================================");

//        getCustId();
        orderItem();
        pickUpMethod();
    }

//    public void getCustId() {
//        String inCustId;
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
    
    public void orderItem() {
        int typeOpt, actOpt = 0;

        typeOpt = itemMenu();
        switch (typeOpt) {
            case -1:
                break;
            default:
                actOpt = moreItem();
                while(actOpt==1){
                    printTest();
                    break;
                }
        }
    }

    public int itemMenu() {
        int typeOpt = 0;

        do {
            System.out.println("1) Fresh Flowers");
            System.out.println("2) Bouquets");
            System.out.println("3) Floral Arrangement");
            System.out.print("Please select a product type(Enter -1 to back): ");

            try {
                valid = true;
                typeOpt = scanner.nextInt();
                if (typeOpt >= 1 && typeOpt <= 3) {
                    showDetail(typeOpt);
                    getId(typeOpt);
                    getQuantity();
                } else if (typeOpt == -1) {
                    break;
                } else {
                    System.out.println("***Invalid input!Please enter again.***\n");
                    valid = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return typeOpt;
    }

    public void showDetail(int typeOpt) {
        if (typeOpt == 1) {
            CM.viewFlower(CM.prod, "1");
        } else if (typeOpt == 2) {
            CM.viewFlower(CM.prod, "2");
        } else {
            CM.viewFlower(CM.prod, "3");
        }
    }

    public void getId(int typeOpt) {
        String itemId = "";

        do {
            System.out.print("Please enter item ID: ");
            itemId = scanner.next();
            valid = chkItem(itemId, typeOpt);
            if (valid == false) {
                System.out.println("***The item ID is not exist.Please enter again.***\n");
            }
        } while (valid == false);
    }

    public boolean chkItem(String itemId, int typeOpt) {
        valid = false;
        String prodId;

        for (int i = 0; i < CM.prod.size(); i++) {
            if (typeOpt == 1 && CM.prod.get(i).getprodType() == "Fresh Flower") {
                prodId = CM.prod.get(i).getProdID();
                if (itemId.equals(prodId)) {
                    order.setOrderItem(CM.prod.get(i).getprodName());
                    valid = true;
                    break;
                }
            } else if (typeOpt == 2 && CM.prod.get(i).getprodType() == "Bouquet") {
                prodId = CM.prod.get(i).getProdID();
                if (itemId.equals(prodId)) {
                    order.setOrderItem(CM.prod.get(i).getprodName());
                    valid = true;
                    break;
                }
            } else if (typeOpt == 3 && CM.prod.get(i).getprodType() == "Floral Arrangement") {
                prodId = CM.prod.get(i).getProdID();
                if (itemId.equals(prodId)) {
                    order.setOrderItem(CM.prod.get(i).getprodName());
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }

    public void getQuantity() {
        int quantity;

        do {
            System.out.print("Please enter quantity: ");
            try {
                quantity = scanner.nextInt();
                if (quantity > 0) {
                    order.setQuantity(quantity);
                    valid = true;
                } else {
                    System.out.println("***Invalid input.Please enter again.***\n");
                    valid = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
    }

    public int moreItem() {
        int actOpt = 0;

        do {
            System.out.println("1) More items?");
            System.out.println("2) Place order");
            System.out.print("Please enter option: ");
            try {
                valid = true;
                actOpt = scanner.nextInt();
                if (actOpt != 1 && actOpt != 2) {
                    System.out.println("***Invalid input!Please enter again.***\n");
                    valid = false;
                }
                if (actOpt == 2) {
                    calTotal();
                    String orderId = generateId();
                    order.setOrderId(orderId);
                    System.out.println(order);
                    System.out.print("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return actOpt;
    }

    public void calTotal() {
        int size = order.getOrderItem().size();
        double price, total = 0.0;

        for (int i = 0; i < size; i++) {     //orderItem array
            String itemName = (String) order.getOrderItem().get(i);
            int quantity = (int) order.getQuantity().get(i);
            for (int j = 0; j < CM.prod.size(); j++) {    //product array
                if (itemName.equals(CM.prod.get(j).getprodName())) {
                    price = CM.prod.get(j).getprodPrice();
                    total += (price * quantity);
                    order.setTotal(total);
                    break;
                }
            }
        }
    }

    public String generateId() {
        int rNum = (int) (Math.random() * 999 + 1);
        String orderId = "OR" + rNum;
        return orderId;
    }

    public void pickUpMethod() {

    }
}
