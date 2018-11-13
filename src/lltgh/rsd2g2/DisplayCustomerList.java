package lltgh.rsd2g2;

import java.util.ArrayList;
import java.util.List;

public class DisplayCustomerList {
    CustomerRegistration regCust = new CustomerRegistration();
    
    public void displayCust(){
        for (int i = 0; i < regCust.customerList.size(); i++)
            System.out.printf(regCust.customerList.get(i).getName() + "\t" + regCust.customerList.get(i).getType() + "\t" + regCust.customerList.get(i).getCreditLimit() + "\n");
    }
}
