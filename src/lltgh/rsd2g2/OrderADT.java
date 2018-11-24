/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

import java.util.List;

/**
 *
 * @author XinYi
 */
public interface OrderADT<T> {
    
    public void setOrderId(String orderId);
    
    public void setOrderItem(String orderItem);
    
    public void setQuantity(int quantity);
    
    public void setTotal(double total);
    
    public void setMethod(String method);
    
    public void setPDate(String pDate);
    
    public void setPTime(String pTime);
    
    public void setAddress(String address);
    
    public String getOrderId();
    
    public List<String> getOrderItem();
    
    public List<Integer> getQuantity();
    
    public double getTotal();
    
    public String getMethod();
    
    public String getPDate();
    
    public String getPTime();
    
    public String getAddress();
    
    public String toString();
}