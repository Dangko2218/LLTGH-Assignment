package lltgh.rsd2g2;

import java.util.Scanner;

public class EditCustDetails {

    CustomerRegistration regCust = new CustomerRegistration();

    private String searchID = null, confirm;
    private double newCredit;
    Scanner scan = new Scanner(System.in);

    public void modCreditLimit() {
        System.out.print("Customer's ID > ");
        searchID = scan.nextLine();

        if (hasRecord(searchID)) {
            for (int i = 0; i < regCust.customerList.size(); i++) {
                if (searchID.equals(regCust.customerList.get(i).getCustID())) {
                    System.out.println("Current credit limit > RM " + regCust.customerList.get(i).getCreditLimit());
                    System.out.print("New credit limit > ");
                    newCredit = scan.nextDouble();
                    regCust.customerList.get(i).setCreditLimit(newCredit);
                    do{
                        System.out.print("Confirm update? > ");
                        confirm = scan.nextLine();
                    }while(!confirm.toUpperCase().equals("Y") && !confirm.toUpperCase().equals("YES"));
                }
            }
        } else {
            System.out.print("Customer record not found.");
        }
    }

    private boolean hasRecord(String searchId) {
        boolean isReg = false;
        for (int i = 0; i < regCust.customerList.size(); i++) {
            if (searchId.equals(regCust.customerList.get(i).getCustID())) {
                isReg = true;
            }
        }
        return isReg;
    }
}
