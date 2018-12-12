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
public class OPDP implements OPDPInterface{
    
    private String orderNo;
    private String customerName;
    private String customerIC;
    private String address;
    private double total;
    private String pickup;
    private String deliveryDate;
    private String payment;
    private String checkDateDuplicate;
    private double distance;
    
    public OPDP(){
        orderNo = null;
        customerName = null;
        customerIC = null;
        address = null;
        total = 0;
        pickup = null;
        deliveryDate = null;
        payment = null;
        checkDateDuplicate = null;
        distance = 0;
    }
    
    public OPDP(String orderNo, String customerName , String customerIC, String address, double total, String pickup, String date,String payment,String checkDateDuplicate , double distance){
        this.orderNo = orderNo;
        this.customerName = customerName;
        this.customerIC = customerIC;
        this.address = address;
        this.total = total;
        this.pickup = pickup;
        this.deliveryDate = date;
        this.payment = payment;
        this.checkDateDuplicate = checkDateDuplicate;
        this.distance = distance;
    }
    
    public void setOrderNo(String orderNo){
        this.orderNo = orderNo;
    }
    
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    
    public void setCustomerIC(String customerIC){
        this.customerIC = customerIC;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public void setPickup(String pickup){
        this.pickup = pickup;
    }
    
    public void setDate(String date){
        this.deliveryDate = date;
    }
    
    public void setPayment(String payment){
        this.payment = payment;
    }

    public void setCheckDateDuplicate(String checkDateDuplicate){
        this.checkDateDuplicate = checkDateDuplicate;
    }
    
    public void setDistance(double distance){
        this.distance = distance;
    }
    
    public double getDistance(){
        return distance;
    }
    
    public String getCheckDateDuplicate(){
        return checkDateDuplicate;
    }
    
    public String getPayment(){
        return payment;
    }
    
    public String getOrderNo(){
        return orderNo;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    
    public String getCustomerIC(){
        return customerIC;
    }
    
    public String getAddress(){
        return address;
    }
    
    public double getTotal(){
        return total;
    }
    
    public String getPickup(){
        return pickup;
    }
    
    public String getDate(){
         return deliveryDate;
     }
    
    
    public OPDPInterface add(OPDPInterface opdp){
        OPDPInterface latestOpdp = new OPDP(){};
        latestOpdp.setOrderNo(opdp.getOrderNo());
        latestOpdp.setCustomerName(opdp.getCustomerName());
        latestOpdp.setCustomerIC(opdp.getCustomerIC());
        latestOpdp.setAddress(opdp.getAddress());
        latestOpdp.setTotal(opdp.getTotal());
        latestOpdp.setPickup(opdp.getPickup());
        latestOpdp.setDate(opdp.getDate());
        latestOpdp.setPayment(opdp.getPayment());
        latestOpdp.setCheckDateDuplicate(opdp.getCheckDateDuplicate());
        latestOpdp.setDistance(opdp.getDistance());
        return opdp;
    }
    
//    public OPDPInterface update(OPDPInterface opdp){
//        return opdp;
//    }
    
}
