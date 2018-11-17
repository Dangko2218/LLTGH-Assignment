package lltgh.rsd2g2;

import java.util.ArrayList;
import java.util.List;

public class DisplayCustomerList {
    CustomerRegistration regCust = new CustomerRegistration();
    
    // display all
    public void displayCust(){
        System.out.println("List of all customer :");
        for (int i = 0; i < regCust.customerList.size(); i++)
            System.out.printf(regCust.customerList.get(i).getCustID() + "\n"
                    + regCust.customerList.get(i).getName() + "\n"
                    + regCust.customerList.get(i).getCustIC() + "\n"
                    + regCust.customerList.get(i).getContactNo()+ "\n"
                    + regCust.customerList.get(i).getType() + "\n"
                    + regCust.customerList.get(i).getCustCorp()+ "\n"
                    + regCust.customerList.get(i).getCreditLimit() + "\n\n");
    }
    
    // display normal only
    public void nCustList(){
        System.out.println("List of normal customer :");
        for (int i = 0; i < regCust.customerList.size(); i++)
            if (regCust.customerList.get(i).getType().equals("Normal"))
                System.out.printf(regCust.customerList.get(i).getCustID() + "\n"
                    + regCust.customerList.get(i).getName() + "\n"
                    + regCust.customerList.get(i).getCustIC() + "\n"
                    + regCust.customerList.get(i).getContactNo()+ "\n"
                    + regCust.customerList.get(i).getType() + "\n"
                    + regCust.customerList.get(i).getCustCorp()+ "\n"
                    + regCust.customerList.get(i).getCreditLimit() + "\n\n");
    }
    
    // display corporate only
    public void cCustList(){
        System.out.println("List of corporate customer :");
        for (int i = 0; i < regCust.customerList.size(); i++){
            if (regCust.customerList.get(i).getType().equals("Corporate"))
                System.out.printf(regCust.customerList.get(i).getCustID() + "\n"
                    + regCust.customerList.get(i).getName() + "\n"
                    + regCust.customerList.get(i).getCustIC() + "\n"
                    + regCust.customerList.get(i).getContactNo()+ "\n"
                    + regCust.customerList.get(i).getType() + "\n"
                    + regCust.customerList.get(i).getCustCorp()+ "\n"
                    + regCust.customerList.get(i).getCreditLimit() + "\n\n");
        }
    }
}
