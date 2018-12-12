/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.util.Date;

/**
 *
 * @author User
 */
public interface OPDPInterface{
    
    public void setOrderNo(String orderNo);
    public void setCustomerName(String customerName);
    public void setCustomerIC(String customerIC);
    public void setAddress(String address);
    public void setTotal(double total);
    public void setPickup(String pickup);
    public void setDate(String date);
    public void setPayment(String payment);
    public void setCheckDateDuplicate(String checkDateDuplicate);
    public void setDistance(double distance);
    
    public double getDistance();
    public String getCheckDateDuplicate();
    public String getPayment();
    public String getOrderNo();
    public String getCustomerName();
    public String getCustomerIC();
    public String getAddress();
    public double getTotal();
    public String getPickup();
    public String getDate();

    
    OPDPInterface add(OPDPInterface opdp);
//    OPDPInterface update(OPDPInterface opdp);
}
