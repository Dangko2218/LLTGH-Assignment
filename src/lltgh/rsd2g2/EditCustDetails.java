package lltgh.rsd2g2;

import java.util.Scanner;

public class EditCustDetails {

    CustomerRegistration regCust = new CustomerRegistration();
    InvListInterface<Customer> cust = new InvLinkedList<>();

    private String searchID = " ", confirm = "";
    private double newCredit;
    Scanner scan = new Scanner(System.in);

    public void modCreditLimit() {
        cust = regCust.readCustFile();

        while (!(searchID.charAt(0) == 'C')) {
            System.out.print("Customer's ID > ");
            searchID = scan.nextLine();
            if (!(searchID.charAt(0) == 'C'))
                System.err.println("This type of customer is not allowed to modify the credit limit.");
        }
        if (searchID.charAt(0) == 'C') {
            if (hasRecord(searchID)) {
                for (int i = 0; i < cust.size(); i++) {
                    if (searchID.equals(cust.get(i).getCustID())) {
                        final int pos = i;
                        System.out.println("Current credit limit > RM " + cust.get(pos).getCreditLimit());
                        System.out.print("New credit limit > ");
                        newCredit = scan.nextDouble();
                        while ((!confirm.toUpperCase().equals("Y") && !confirm.toUpperCase().equals("YES"))
                                && (!confirm.toUpperCase().equals("N") && !confirm.toUpperCase().equals("NO"))) {
                            System.out.print("Confirm update? > ");
                            confirm = scan.nextLine();
                        }
                        if (confirm.toUpperCase().equals("Y") && !confirm.toUpperCase().equals("YES")) {
                            cust.get(pos).setCreditLimit(newCredit);
                            cust.update(pos, cust.get(pos));
                            regCust.writeCustDat(cust);
                        }
                    }
                }
            } else {
                System.out.println("Customer record not found.");
            }
        }
    }

    private boolean hasRecord(String searchId) {
        boolean isReg = false;
        for (int i = 0; i < cust.size(); i++) {
            if (searchId.equals(cust.get(i).getCustID())) {
                isReg = true;
            }
        }
        return isReg;
    }
}
