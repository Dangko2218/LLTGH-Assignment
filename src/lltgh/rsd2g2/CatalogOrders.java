package lltgh.rsd2g2;

import Customized.ListInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
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
    String iName, custType;
    double creditLimit;
    List discountAmount = new ArrayList();
    List hasDRList = new ArrayList();
    List DRList = new ArrayList();

    Order order = new Order();
    CatalogMaintenance CM = new CatalogMaintenance();
    CustomerRegistration CR = new CustomerRegistration();

    public void printTest() {
        char nextCust = '\0';
        do {
            int typeOpt = orderItem();
            switch (typeOpt) {
                case -1:
                case 4:
                    valid = false;
                    break;
                default:
                    pickUpMethod();
                    haveId(order.getTotal());
                    generateSO();
                    nextCust = nextCustomer();
                    if (nextCust == 'Y') {
                        order = new Order();
                    } else {
                        valid=false;
                        break;
                    }
            }
        } while (valid == true);
    }

    public int orderItem() {
        int typeOpt, actOpt = 0;

        do {
            typeOpt = itemMenu();
            switch (typeOpt) {
                case -1:
                case 4:
                    break;
                default:
                    getQuantity();
                    actOpt = moreItem();
                    if (actOpt == 1 || actOpt == 3) {
                        valid = false;
                    }
            }
        } while (valid == false);
        return typeOpt;
    }

    public int itemMenu() {
        int typeOpt = 0;

        do {
            System.out.println("\n========================================================");
            System.out.println("                     Catalog Order");
            System.out.println("========================================================");
            System.out.println("1) Fresh Flowers");
            System.out.println("2) Bouquets");
            System.out.println("3) Floral Arrangement");
            System.out.println("4) Back to Main Menu");
            System.out.print("Please select a product type: ");

            try {
                valid = true;
                typeOpt = scanner.nextInt();
                scanner.nextLine();
                if (typeOpt >= 1 && typeOpt <= 3) {
                    showDetail(typeOpt);
                    valid = getProdId(typeOpt);
                } else if (typeOpt == 4) {
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
        ListInterface<Product> prodList = CM.readProdDatList();

        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "ID", "Name", "Type", "Detail", "Stock", "Price");
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");

        for (int i = 0; i < prodList.size(); i++) {
            String prodType = prodList.get(i).getprodType();
            if (typeOpt == 1 && prodType.equals("Fresh Flower")) {
                getProductListFromDat(i);
            } else if (typeOpt == 2 && prodType.equals("Bouquet")) {
                getProductListFromDat(i);
            } else if (typeOpt == 3 && prodType.equals("Floral Arrangement")) {
                getProductListFromDat(i);
            }
        }

        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|\n", "-----", "--------------------", "--------------------", "------------------------------", "--------", "------");
    }

    public void getProductListFromDat(int i) {
        ListInterface<Product> prodList = CM.readProdDatList();
        System.out.printf("\n|%-5s|%-20s|%-20s|%-30s|%-8s|%-6s|", prodList.get(i).getProdID(), prodList.get(i).getprodName(), prodList.get(i).getprodType(), prodList.get(i).getprodDetail(), prodList.get(i).getprodPrice(), prodList.get(i).getprodStock());
    }

    public boolean getProdId(int typeOpt) {
        String itemId;

        do {
            System.out.print("Please enter item ID(Enter -1 to back): ");
            itemId = scanner.nextLine();
            if (itemId.equals("-1")) {
                valid = false;
                break;
            } else {
                valid = chkItem(itemId, typeOpt);
                if (valid == false) {
                    System.out.println("***The item ID is not exist.Please enter again.***\n");
                }
            }
        } while (valid == false);
        return valid;
    }

    public boolean chkItem(String itemId, int typeOpt) {
        valid = false;
        String prodId;
        ListInterface<Product> prodList = CM.readProdDatList();

        for (int i = 0; i < prodList.size(); i++) {
            String prodType = prodList.get(i).getprodType();
            if (typeOpt == 1 && prodType.equals("Fresh Flower")) {
                prodId = prodList.get(i).getProdID();
                if (itemId.equals(prodId)) {
                    iName = prodList.get(i).getprodName();
                    valid = true;
                    break;
                }
            } else if (typeOpt == 2 && prodType.equals("Bouquet")) {
                prodId = prodList.get(i).getProdID();
                if (itemId.equals(prodId)) {
                    iName = prodList.get(i).getprodName();
                    valid = true;
                    break;
                }
            } else if (typeOpt == 3 && prodType.equals("Floral Arrangement")) {
                prodId = prodList.get(i).getProdID();
                if (itemId.equals(prodId)) {
                    iName = prodList.get(i).getprodName();
                    valid = true;
                    break;
                }
            }
        }
        return valid;
    }

    public void getQuantity() {
        int quantity = 0;
        int validInt = 1;

        do {
            System.out.print("Please enter quantity: ");
            try {
                quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity > 0) {
                    validInt = chkStock(quantity);
                    if (validInt == 1) {
                        valid = true;
                    } else if (validInt == 0) {
                        valid = false;
                    } else if (validInt == -1) {
                        break;
                    }
                } else {
                    System.out.println("***Invalid input.Please enter again.***\n");
                    valid = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }

            if (valid == true) {
                order.setOrderItem(iName);
                order.setQuantity(quantity);
            }
        } while (valid == false);
    }

    public int chkStock(int quantity) {
        int valid = 1;
        int numStock;
        ListInterface<Product> prodList = CM.readProdDatList();

        for (int j = 0; j < prodList.size(); j++) {
            if (iName.equals(prodList.get(j).getprodName())) {
                numStock = prodList.get(j).getprodStock();
                if (numStock == 0) {
                    System.out.println("***There is no more stock.***\n");
                    valid = -1;
                } else if (numStock - quantity < 0) {
                    System.out.println("***There is no enough stock.***\n");
                    valid = 0;
                }
                break;
            }
        }
        return valid;
    }

    public int moreItem() {
        int actOpt = 0;

        do {
            System.out.println("\n1) More items?");
            System.out.println("2) Place order");
            System.out.println("3) Cancel order");
            System.out.print("Please enter option: ");
            try {
                valid = true;
                actOpt = scanner.nextInt();
                scanner.nextLine();
                if (actOpt == 1) {
                    break;
                } else if (actOpt == 2) {
                    calTotal();
                    order.setOrderId();
                } else if (actOpt == 3) {
                    break;
                } else {
                    System.out.println("***Invalid input!Please enter again.***");
                    valid = false;
                }
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return actOpt;
    }

    public void calTotal() {
        int size = order.getOrderItem().size();
        double price, total = 0.0;
        String itemId;
        ListInterface<Product> prodList = CM.readProdDatList();

        for (int i = 0; i < size; i++) {     //orderItem array
            String itemName = (String) order.getOrderItem().get(i);
            int quantity = (int) order.getQuantity().get(i);
            for (int j = 0; j < prodList.size(); j++) {    //product array
                if (itemName.equals(prodList.get(j).getprodName())) {
                    itemId = prodList.get(j).getProdID();
                    price = getPrice(itemId, quantity);
                    total += (price * quantity);

                    updateStock(itemName, quantity);
                    break;
                }
            }
        }
        order.setTotal(total);
    }

    public double getPrice(String itemId, int quantity) {
        double price = 0.0;
        boolean hasDR;
        int month = LocalDate.now().getMonth().getValue();
        ListInterface<Promotion> promoList = CM.readPromoDatList();
        int size = promoList.size();
        ListInterface<Product> prodList = CM.readProdDatList();

        for (int j = 0; j < prodList.size(); j++) {
            if (itemId.equals(prodList.get(j).getProdID())) {
                price = prodList.get(j).getprodPrice();
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            if ((promoList.get(i).getpromoMonth() == month) && (itemId.equals(promoList.get(i).getProdID()))) {
                int discountRate = promoList.get(i).getdiscountRate();
                DRList.add(discountRate);
                price = calDiscount(price, discountRate, quantity);
                hasDR = true;
                hasDRList.add(hasDR);
                break;
            } else if ((i == size - 1) && (!itemId.equals(promoList.get(i).getProdID()))) {
                hasDR = false;
                DRList.add(0);
                discountAmount.add(0);
                hasDRList.add(hasDR);
            }
        }
        return price;
    }

    public double calDiscount(double oriPrice, int discountRate, int quantity) {
        double discountPrice;
        discountAmount.add(((oriPrice / 100) * discountRate) * quantity);
        discountPrice = (oriPrice / 100) * (100 - discountRate);
        return discountPrice;
    }

    public void updateStock(String itemName, int quantity) {
        ListInterface<Product> prodList = CM.readProdDatList();

        for (int j = 0; j < prodList.size(); j++) {
            if (itemName.equals(prodList.get(j).getprodName())) {
                int stock = prodList.get(j).getprodStock();
                stock -= quantity;
                prodList.get(j).setprodStock(stock);
                CM.writeProdDatList(prodList);
                break;
            }
        }
    }

    public void pickUpMethod() {
        int methodOpt = 0;

        do {
            System.out.println("\n1) Pick up");
            System.out.println("2) Delivery");
            System.out.print("Please select pick up method: ");
            try {
                valid = true;
                methodOpt = scanner.nextInt();
                scanner.nextLine();
                if (methodOpt == 1) {
                    order.setPickUpMethod("Pick up");
                    String orderDate = pickUpDate();
                    pickUpTime(orderDate);
                } else if (methodOpt == 2) {
                    order.setPickUpMethod("Delivery");
                    String orderDate = pickUpDate();
                    pickUpTime(orderDate);
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

    public String pickUpDate() {
        int day, month, year;
        String orderDate = null;

        do {
            valid = true;
            System.out.println("\nPlease enter pick up date: ");
            year = getYear();
            month = getMonth();
            day = getDay(month, year);

            orderDate = day + "/" + month + "/" + year;
            valid = cmpDate(orderDate);

            if (valid == true) {
                order.setPDate(orderDate);
            }
        } while (valid == false);
        return orderDate;
    }

    public int getYear() {
        int year = 0;

        do {
            valid = true;
            try {
                System.out.print("Year: ");
                year = scanner.nextInt();
                scanner.nextLine();
                valid = chkYear(year);
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return year;
    }

    public boolean chkYear(int year) {
        valid = true;

        LocalDate today = LocalDate.now();
        int toYear = today.getYear();
        if (year < toYear) {
            System.out.println("***The year entered has passed.Please enter again.***\n");
            valid = false;
        }
        return valid;
    }

    public int getMonth() {
        int month = 0;

        do {
            valid = true;
            try {
                System.out.print("Month: ");
                month = scanner.nextInt();
                scanner.nextLine();
                valid = chkMonth(month);
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return month;
    }

    public boolean chkMonth(int month) {
        valid = true;
        if (month < 1 || month > 12) {
            System.out.println("***Invalid month!Please enter again.***\n");
            valid = false;
        }
        return valid;
    }

    public int getDay(int month, int year) {
        int day = 0;

        do {
            valid = true;
            try {
                System.out.print("Day: ");
                day = scanner.nextInt();
                scanner.nextLine();
                valid = chkDay(day, month, year);
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                System.out.println("Month entered is: " + month);
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return day;
    }

    public boolean chkDay(int day, int month, int year) {
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
                    valid = false;
                }
                break;
            case 2:
                if ((year % 4 != 0) && (day < 1 || day > 28)) {
                    System.out.println("***Invalid day!Please enter again.***\n");
                    System.out.println("Month entered is: " + month);
                    System.out.println("This year is not a leap year.Only 28 days.");
                    valid = false;
                } else if ((year % 4 == 0) && (day < 1 || day > 29)) {
                    System.out.println("***Invalid day!Please enter again.***\n");
                    System.out.println("Month entered is: " + month);
                    System.out.println("This year is a leap year.Only 29 days.");
                    valid = false;
                }
                break;
        }
        return valid;
    }

    public boolean cmpDate(String orderDate) {
        valid = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y");

        LocalDate toDate = LocalDate.now();
        LocalDate pDate = LocalDate.parse(orderDate, formatter);
        Period diff = Period.between(toDate, pDate);

        if (pDate.isBefore(toDate)) {
            System.out.println("***The date entered has passed.Please enter again.***");
            valid = false;
        } else if (diff.getMonths() > 2 || diff.getYears() > 0) {  //assume order only in 3 month ,count from 0
            System.out.println("***The date entered is too far.Please enter another date.***");
            valid = false;
        }
        return valid;
    }

    public void pickUpTime(String orderDate) {
        int hours, minutes;
        String meridiem;

        do {
            System.out.println("\nPlease enter pick up time: ");
            hours = getHours();
            minutes = getMinutes();
            meridiem = getMeridiem();
            valid = chkOpenTime(hours, meridiem);
            if (valid == true) {
                valid = cmpTime(orderDate, hours, minutes, meridiem);
                if (valid == true) {
                    String orderTime = hours + ":" + String.format("%02d", minutes) + meridiem;
                    order.setPTime(orderTime);
                }
            }
        } while (valid == false);
    }

    public int getHours() {
        int hours = 0;

        do {
            valid = true;
            try {
                System.out.print("Hours(12-Hours form): ");
                hours = scanner.nextInt();
                scanner.nextLine();
                valid = chkHours(hours);
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return hours;
    }

    public boolean chkHours(int hours) {
        valid = true;
        if (hours < 1 || hours > 12) {
            System.out.println("***Invalid hours.Please enter again.***\n");
            valid = false;
        }
        return valid;
    }

    public int getMinutes() {
        int minutes = 0;

        do {
            valid = true;
            try {
                System.out.print("Minutes: ");
                minutes = scanner.nextInt();
                scanner.nextLine();
                valid = chkMinutes(minutes);
            } catch (InputMismatchException ex) {
                System.out.println("***Invalid input!Please enter again.***\n");
                scanner.next();
                valid = false;
            }
        } while (valid == false);
        return minutes;
    }

    public boolean chkMinutes(int minutes) {
        valid = true;
        if (minutes < 0 || minutes > 59) {
            System.out.println("***Invalid minutes.Please enter again.***\n");
            valid = false;
        }
        return valid;
    }

    public String getMeridiem() {
        String meridiem = null;

        do {
            valid = true;
            System.out.print("AM or PM: ");
            meridiem = scanner.nextLine();
            meridiem = meridiem.toUpperCase();
            if (!"AM".equals(meridiem) && !"PM".equals(meridiem)) {
                System.out.println("***Invalid input.Please enter again.***\n");
                valid = false;
            }
        } while (valid == false);
        return meridiem;
    }

    public boolean chkOpenTime(int hours, String meridiem) {
        valid = true;

        //Assume open from 9am to 5pm
        switch (meridiem) {
            case "AM":
                if (hours < 9 || hours > 11) {
                    System.out.println("***Shop open from 9am.Please choose another time.***\n");
                    valid = false;
                }
                break;
            case "PM":
                if (hours != 12 && hours > 4) {
                    System.out.println("***Shop closed on 5pm.Please choose another time.***\n");
                    valid = false;
                }
                break;
        }
        return valid;
    }

    public boolean cmpTime(String orderDate, int hours, int minutes, String meridiem) {
        valid = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y H:m");

        LocalDateTime toTime = LocalDateTime.now();
        if (meridiem.equals("AM") && hours == 12) {
            hours -= 12;
        } else if (meridiem.equals("PM") && hours < 11) {
            hours += 12;
        }
        String orderDateTime = orderDate + " " + hours + ":" + minutes;
        LocalDateTime pTime = LocalDateTime.parse(orderDateTime, formatter);

        if (pTime.isBefore(toTime)) {
            System.out.println("***The time entered has passed.Please enter again.***");
            valid = false;
        }
        return valid;
    }

    public void getAddress() {
        String address = null;
        do {
            valid = true;
            System.out.println("\nPlease enter delivery address: ");
            address = scanner.nextLine();
            if (address.equals("") || address.equals(" ")) {
                System.out.println("***Please enter an address.***");
                valid = false;
            }
        } while (valid == false);
        order.setAddress(address);
    }

    public void generateSO() {
        double price = 0.0;
        double total = order.getTotal();
        ListInterface<Product> prodList = CM.readProdDatList();
        InvListInterface<Order> orderList = readOrderDatList();

        System.out.println("\n|---------------------------------|");
        System.out.println("|           Sales  Order          |");
        System.out.println("|---------------------------------|");
        System.out.printf("|Order ID   : %-20s|\n", order.getOrderId());
        System.out.printf("|Customer ID: %-20s|",order.getCustId());
        System.out.printf("\n|%-33s|", " ");
        System.out.printf("\n|Order Item : %-20s|\n", " ");

        for (int i = 0; i < order.getOrderItem().size(); i++) {
            String itemName = (String) order.getOrderItem().get(i);
            int orderQty = (int) order.getQuantity().get(i);
            for (int j = 0; j < prodList.size(); j++) {
                if (itemName.equals(prodList.get(j).getprodName())) {
                    price = prodList.get(j).getprodPrice();
                    break;
                }
            }

            if ((boolean) hasDRList.get(i) == true) {
                System.out.printf("|%7s%-18s%7s |", orderQty + "x ", order.getOrderItem().get(i), String.format("%.2f", price * orderQty));
                System.out.printf("\n|%7s%-18s%7s |", " ", "Discount: " + DRList.get(i) + "%", "-" + String.format("%.2f", discountAmount.get(i)));
                System.out.printf("\n|%-33s|\n", " ");
            } else {
                System.out.printf("|%7s%-18s%7s |", orderQty + "x ", order.getOrderItem().get(i), String.format("%.2f", price * orderQty));
                System.out.printf("\n|%-33s|\n", " ");
            }
        }

        System.out.printf("|Total      : RM%-18s|", String.format("%.2f", total));
        System.out.printf("\n|Method     : %-20s|", order.getPickUpMethod());
        System.out.printf("\n|Date       : %-20s|", order.getPDate());
        System.out.printf("\n|Time       : %-20s|", order.getPTime());
        System.out.println("\n|---------------------------------|");

        orderList.add(order);
        writeOrderDatList(orderList);

        System.out.print("\nPress enter to continue...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(LLTGHRSD2G2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void haveId(double total) {
        do {
            valid = true;
            System.out.print("\nHave ID? (Y=Yes;N=No): ");
            char haveId = scanner.next().charAt(0);
            scanner.nextLine();
            haveId = Character.toUpperCase(haveId);
            if (haveId == 'Y') {
                String custId = getCustId();
                if (custType.equals("Corporate")) {
                    getPaymentMethod(total, custId);
                }
            } else if (haveId == 'N') {
                break;
            } else {
                System.out.println("***Invalid input.Please enter again.***");
                valid = false;
            }
        } while (valid == false);
    }

    public String getCustId() {
        String custId;
        do {
            System.out.print("Please enter customer ID: ");
            custId = scanner.nextLine();
            custId = custId.toUpperCase();

            if (!chkCustId(custId)) {
                System.out.println("***Invalid customer ID.Please enter again.***\n");
            }
        } while (valid == false);
        return custId;
    }

    public boolean chkCustId(String custId) {
        InvListInterface<Customer> custList = CR.readCustFile();

        for (int i = 0; i < custList.size(); i++) {
            valid = true;
            if (custId.equals(custList.get(i).getCustID())) {
                order.setCustId(custId);
                if (custId.charAt(0) == 'C') {
                    custType = "Corporate";
                    creditLimit = custList.get(i).getCreditLimit();
                } else {
                    custType = "Normal";
                    order.setPaymentMethod("Cash");
                }
                break;
            } else {
                valid = false;
            }
        }
        return valid;
    }

    public void getPaymentMethod(double total, String custId) {
        do {
            valid = true;
            System.out.println("1) Credit Limit");
            System.out.println("2) Cash");
            System.out.print("Please select a payment method: ");

            try {
                int paymentOpt = scanner.nextInt();
                scanner.nextLine();
                if (paymentOpt == 1) {
                    chkCreditLimit(total, custId);
                } else if (paymentOpt == 2) {
                    order.setPaymentMethod("Cash");
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

    public boolean chkCreditLimit(double total, String custId) {
        double limitLeft = creditLimit - total;
        if (creditLimit >= total) {
            System.out.printf("Order total: RM%s\n", String.format("%.2f", total));
            System.out.printf("Your credit limit left: RM%s\n", String.format("%.2f", limitLeft));
            order.setPaymentMethod("Credit Limit");
            updateCreditLimit(custId, limitLeft);
        } else {
            System.out.printf("Order total: RM%s\n", String.format("%.2f", total));
            System.out.printf("Your credit limit left: RM%s\n", String.format("%.2f", creditLimit));
            System.out.println("***Credit limit left is not enough.***\n");
            valid = false;
        }
        return valid;
    }

    public void updateCreditLimit(String custId, double limitLeft) {
        InvListInterface<Customer> custList = CR.readCustFile();

        for (int i = 0; i < custList.size(); i++) {
            if (custId.equals(custList.get(i).getCustID())) {
                custList.get(i).setCreditLimit(limitLeft);
                CR.writeCustDat(custList);
                break;
            }
        }
    }

    public char nextCustomer() {
        char nextCust;
        do {
            valid = true;
            System.out.print("\nNext customer? (Y=Yes;N=No): ");
            nextCust = scanner.next().charAt(0);
            nextCust = Character.toUpperCase(nextCust);
            if (nextCust != 'Y' && nextCust != 'N') {
                System.out.println("***Only 'Y' or 'N'.Please enter again.***");
                valid = false;
            }
        } while (valid == false);
        return nextCust;
    }

    //Order.dat
    public void writeOrderDatList(InvListInterface<Order> orderList) {
        String s = "";
        int size = orderList.size();

        for (int i = 0; i < size; i++) {
            Order orderEntry = orderList.get(i);
//            orderList.get(i);
            s += orderEntry.getOrderId() + "|" + orderEntry.getCustId() + "|";
            s = writeOrderItem(s, orderEntry) + "|";
            s = writeOrderQuantity(s, orderEntry) + "|";
            s += orderEntry.getTotal() + "|" + orderEntry.getPaymentMethod() + "|" + orderEntry.getPickUpMethod() + "|" + orderEntry.getPDate() + "|" + orderEntry.getPTime() + "|" + orderEntry.getAddress() + "|" + orderEntry.getPayment() + "|" + orderEntry.getStatus() + "\n";

//            s += prodEn.getProdID() + "|" + prodEn.getprodName() + "|" + prodEn.getprodType() + "|" + prodEn.getprodDetail() + "|" + Double.toString(prodEn.getprodPrice()) + "|" + Integer.toString(prodEn.getprodStock()) + "\n";
        }

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("../LLTGH-Assignment/src/lltgh/rsd2g2/Order.dat");
            bw = new BufferedWriter(fw);
            bw.write(s);
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

    public String writeOrderItem(String s, Order orderEntry) {
        int size = orderEntry.getOrderItem().size();
        for (int i = 0; i < size; i++) {
            s += orderEntry.getOrderItem().get(i);
            if (i != size - 1) {
                s += ",";
            }
        }
        return s;
    }

    public String writeOrderQuantity(String s, Order orderEntry) {
        int size = orderEntry.getOrderItem().size();
        for (int i = 0; i < size; i++) {
            s += orderEntry.getQuantity().get(i);
            if (i != size - 1) {
                s += ",";
            }
        }
        return s;
    }

    public InvListInterface<Order> readOrderDatList() {
        InvListInterface<Order> orderList = new InvLinkedList<>();
        BufferedReader br = null;
        FileReader fr = null;
        List itemList = new ArrayList();
        List qtyList = new ArrayList();

        try {
            fr = new FileReader("../LLTGH-Assignment/src/lltgh/rsd2g2/Order.dat");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split("\\|");
                itemList = convertToItemList(s[2]);
                qtyList = convertToQtyList(s[3]);
                Order orderEntry = new Order(s[0], s[1], itemList, qtyList, Double.parseDouble(s[4]), s[5], s[6], s[7], s[8], s[9],s[10],Integer.parseInt(s[11]));
                orderList.add(orderEntry);
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
        return orderList;
    }

    public List convertToItemList(String s1) {
        String[] item = s1.split(",");
        List itemList = new ArrayList();
        for (int i = 0; i < item.length; i++) {
            itemList.add(item[i]);
        }
        return itemList;
    }

    public List convertToQtyList(String s2) {
        String[] qty = s2.split(",");
        List qtyList = new ArrayList();
        for (int i = 0; i < qty.length; i++) {
            qtyList.add(qty[i]);
        }
        return qtyList;
    }
}
