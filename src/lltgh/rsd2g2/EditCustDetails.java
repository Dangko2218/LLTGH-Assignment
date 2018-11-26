package lltgh.rsd2g2;

import java.util.Scanner;

public class EditCustDetails {

    CustomerRegistration regCust = new CustomerRegistration();

    private String searchID = null;
    Scanner scan = new Scanner(System.in);

    public void modCreditLimit() {
        while (!hasRecord(searchID)) {
            System.out.print("Customer's ID > ");
            searchID = scan.nextLine();

            if (hasRecord(searchID)) {
                for (int i = 0; i < regCust.customerList.size(); i++) {
                    if (searchID.equals(regCust.customerList.get(i).getCustID())) {
                        System.out.print("Current credit limit > RM " + regCust.customerList.get(i).getCreditLimit());
                        System.out.print("New credit limit > ");
                    }
                }
            } else {
                System.out.print("Customer record not found.");
            }
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
