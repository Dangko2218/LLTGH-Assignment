/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
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
    private String iName;

    private Order order = new Order();
    private List<Order> orderList = new ArrayList<>();

    CatalogMaintenance CM = new CatalogMaintenance();

    public void printTest() {

        System.out.println("\n========================================================");
        System.out.println("                     Catalog Order");
        System.out.println("========================================================");

//        getCustId();
        int typeOpt = orderItem();
        switch (typeOpt) {
            case -1:
                break;
            default:
                pickUpMethod();
                getAddress();
                generateSO();   //sales order?
        }
    }

//    public void getCustId() {
//        String inCustId;
//
//        do {
//            System.out.print("Please enter customer ID: ");
//            inCustId = scanner.next();
//            if (!inCustId.equals()) {
//                System.out.println("Invalid customer ID!");
//                System.out.println("Press enter to continue...");
//            }
//        } while (!inCustId.equals(custId));
//    }
    public int orderItem() {
        int typeOpt, actOpt = 0;

        typeOpt = itemMenu();
        switch (typeOpt) {
            case -1:
                break;
            default:
                actOpt = moreItem();
                while (actOpt == 1) {
                    System.out.println("\n========================================================");
                    System.out.println("                     Catalog Order");
                    System.out.println("========================================================");

                    orderItem();
                    break;
                }
        }
        return typeOpt;
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
        String itemId;

        do {
            System.out.print("Please enter item ID: ");
            itemId = scanner.next();
            valid = chkItem(itemId, typeOpt);
            if (valid == false) {
                System.out.println("***The item ID is not exist.Please enter again.***\n");
            }
        } while (valid == false);
    }

    public boolean chkItem(String itemId,int typeOpt) {
        valid = false;
        String prodId;

        for (int i = 0; i < CM.prod.size(); i++) {
            if (typeOpt == 1 && CM.prod.get(i).getprodType() == "Fresh Flower") {
                prodId = CM.prod.get(i).getProdID();
                if (itemId.equals(prodId)) {
//                    order.setOrderItem(CM.prod.get(i).getprodName());
                    iName=CM.prod.get(i).getprodName();
                    valid = true;
                    break;
                }
            } else if (typeOpt == 2 && CM.prod.get(i).getprodType() == "Bouquet") {
                prodId = CM.prod.get(i).getProdID();
                if (itemId.equals(prodId)) {
//                    order.setOrderItem(CM.prod.get(i).getprodName());
                    iName=CM.prod.get(i).getprodName();
                    valid = true;
                    break;
                }
            } else if (typeOpt == 3 && CM.prod.get(i).getprodType() == "Floral Arrangement") {
                prodId = CM.prod.get(i).getProdID();
                if (itemId.equals(prodId)) {
//                    order.setOrderItem(CM.prod.get(i).getprodName());
                    iName=CM.prod.get(i).getprodName();
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
                    valid = chkStock(quantity);
//                    if (valid == true) {
//                        order.setOrderItem(iName);
//                        order.setQuantity(quantity);
//                    }
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
    
    public boolean chkStock(int quantity) {
        valid = true;
        int numStock;

//        for (int i = 0; i < size; i++) {
//            String itemName = (String) order.getOrderItem().get(i);
            for (int j = 0; j < CM.prod.size(); j++) {
                if (iName.equals(CM.prod.get(j).getprodName())) {
                    numStock = CM.prod.get(j).getprodStock();
                    if (numStock == 0) {
                        System.out.println("***There is no more stock.***\n");
                        itemMenu();
                    } else if (numStock - quantity < 0) {
                        System.out.println("***There is no enough stock.***\n");
                        valid = false;
                    }else{
                        order.setOrderItem(iName);
                        order.setQuantity(quantity);
                    }
                    break;
                }
            }
//        }
        return valid;
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
                    order.setOrderId();
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

                    updateStock(itemName, quantity);
                    break;
                }
            }
        }
    }

    private void updateStock(String itemName, int quantity) {
        for (int j = 0; j < CM.prod.size(); j++) {
            if (itemName.equals(CM.prod.get(j).getprodName())) {
                int stock = CM.prod.get(j).getprodStock();
                stock -= quantity;
                CM.prod.get(j).setprodStock(stock);
                break;
            }
        }
    }

    public void pickUpMethod() {
        int methodOpt;

        do {
            System.out.println("1) Pick up");
            System.out.println("2) Delivery");
            System.out.print("Please select pick up method: ");
            try {
                valid = true;
                methodOpt = scanner.nextInt();
                if (methodOpt == 1) {
                    order.setMethod("Pick up");
                    pickUpDT();
                } else if (methodOpt == 2) {
                    order.setMethod("Delivery");
                    pickUpDT();
                    getAddress();
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
    }

    public void pickUpDT() {
        do {
            System.out.println("Please enter pick up date: ");
            System.out.print("Day: ");
            int day = scanner.nextInt();
            System.out.print("Month: ");
            int month = scanner.nextInt();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            valid = chkDate(day, month, year);
        } while (valid == false);
    }

    public boolean chkDate(int day, int month, int year) {
        do {
            valid = true;
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day < 1 || day > 31) {
                        System.out.println("***Invalid day!Please enter again.***\n");
                        System.out.println("Month entered is: " + month);
                        System.out.print("Day: ");
                        int newDay = scanner.nextInt();
                        day = newDay;
                        valid = false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day < 1 || day > 30) {
                        System.out.println("***Invalid day!Please enter again.***\n");
                        System.out.println("Month entered is: " + month);
                        System.out.print("Day: ");
                        int newDay = scanner.nextInt();
                        day = newDay;
                        valid = false;
                    }
                    break;
                case 2:
                    if ((year % 4 != 0) && (day < 1 || day > 28)) {
                        System.out.println("***Invalid day!Please enter again.***\n");
                        System.out.println("Month entered is: " + month);
                        System.out.println("This year is not a leap year.Only 28 days.");
                        System.out.print("Day: ");
                        int newDay = scanner.nextInt();
                        day = newDay;
                        valid = false;
                    } else if ((year % 4 == 0) && (day < 1 || day > 29)) {
                        System.out.println("***Invalid day!Please enter again.***\n");
                        System.out.println("Month entered is: " + month);
                        System.out.println("This year is a leap year.Only 29 days.");
                        System.out.print("Day: ");
                        int newDay = scanner.nextInt();
                        day = newDay;
                        valid = false;
                    }
                    break;
                default:
                    System.out.println("***Invalid month!Please enter again.***\n");
                    System.out.print("Month: ");
                    int newMonth = scanner.nextInt();
                    month = newMonth;
                    valid = false;
                    break;
            }
        } while (valid == false);

        String orderDate = day + "/" + month + "/" + year;
        LocalDate date = LocalDate.of(year, month, day);
        Date pDate = null;
        try {
            pDate = new SimpleDateFormat("dd/MM/yyyy").parse(orderDate);
        } catch (ParseException ex) {
            Logger.getLogger(CatalogOrders.class.getName()).log(Level.SEVERE, null, ex);
        }
        valid = cmpDate(pDate, date);
        if (valid == true) {
            order.setPDate(orderDate);
        }
        return valid;
    }

    public boolean cmpDate(Date pDate, LocalDate date) {
        valid = true;
        Date today = new Date();

        LocalDate toDate = LocalDate.now();
        Period diff = Period.between(toDate, date);

        if (pDate.before(today)) {
            System.out.println("***The date entered has passed.Please enter again.***");
            valid = false;
        } else if (diff.getMonths() > 2 || diff.getYears() > 0) {  //3 month ,count from 0
            System.out.println("***The date entered is too far.Please enter another date.***");
        }
        return valid;
    }

    public void getAddress() {

    }

    public void generateSO() {
        System.out.println(order);
        System.out.print("Press enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
        //next customer please.......
    }

}
