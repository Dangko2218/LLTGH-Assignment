package lltgh.rsd2g2;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author XinYi
 */
public class Order {
    
    private String orderId;
    private List<String> orderItem;
    private List<Integer> quantity;
    private double total;
    private String method;
    private String pDate;
    private String pTime;
    private String address;
    
    public Order(){
        orderId=null;
        orderItem=new ArrayList<>();
        quantity=new ArrayList<>();
        total=0;
        method=null;
        pDate=null;
        pTime=null;
        address=null;
    }
    
    public Order(String orderId,String orderItem,int quantity,double total,String method,String pDate,String pTime,String address){
        this.orderId=orderId;
        this.orderItem.add(orderItem);
        this.quantity.add(quantity);
        this.total=total;
        this.method=method;
        this.pDate=pDate;
        this.pTime=pTime;
        this.address=address;
    }
    
    public void setOrderId(){
        int rNum=(int)(Math.random() * 999 + 1);
        String orderId="OR" + rNum;
        this.orderId=orderId;
    }
    
    public void setOrderItem(String orderItem){
        this.orderItem.add(orderItem);
    }
    
    public void setQuantity(int quantity){
        this.quantity.add(quantity);
    }
    
    public void setTotal(double total){
        this.total=total;
    }
    
    public void setMethod(String method){
        this.method=method;
    }
    
    public void setPDate(String pDate){
        this.pDate=pDate;
    }
    
    public void setPTime(String pTime){
        this.pTime=pTime;
    }
    
    public void setAddress(String address){
        this.address=address;
    }
    
    public String getOrderId(){
        return orderId;
    }
    
    public List<String> getOrderItem(){
        return orderItem;
    }
    
    public List<Integer> getQuantity(){
        return quantity;
    }
    
    public double getTotal(){
        return total;
    }
    
    public String getMethod(){
        return method;
    }
    
    public String getPDate(){
        return pDate;
    }
    
    public String getPTime(){
        return pTime;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String toString(){
        return "\nOrder ID: " + orderId +
               "\nOrder Item: " + orderItem + 
               "\nQuantity: " + quantity +
               "\nTotal: " + total +
               "\nMethod: " + method +
               "\nDate: " + pDate +
               "\nTime: " + pTime + "\n";
    }
}