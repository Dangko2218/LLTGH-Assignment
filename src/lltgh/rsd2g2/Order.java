package lltgh.rsd2g2;

import java.util.*;

public class Order{
    
    private String orderId;
    private String custId;
    private List<String> orderItem;
    private List<Integer> quantity;
    private double total;
    private String paymentMethod;
    private String pickUpMethod;
    private String pDate;
    private String pTime;
    private String address;
    private String payment;
    private int status;
    
    public Order(){
        orderId=null;
        custId=null;
        orderItem=new ArrayList<>();
        quantity=new ArrayList<>();
        total=0;
        paymentMethod=null;
        pickUpMethod=null;
        pDate=null;
        pTime=null;
        address=null;
        payment = null;
        status = 0;
    }
    
    public Order(String orderId,String custId,List orderItem,List quantity,double total,String paymentMethod,String pickUpMethod,String pDate,String pTime,String address,String payment,int status){
        this.orderId=orderId;
        this.custId=custId;
        this.orderItem=orderItem;
        this.quantity=quantity;
        this.total=total;
        this.paymentMethod=paymentMethod;
        this.pickUpMethod=pickUpMethod;
        this.pDate=pDate;
        this.pTime=pTime;
        this.address=address;
        this.payment = payment;
        this.status = status;
    }
    
    public void setOrderId(){
        int rNum = (int) (Math.random() * 999 + 1);
        String orderId = "OR" + rNum;
        this.orderId=orderId;
    }
    
    public void setCustId(String custId){
        this.custId=custId;
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
    
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod=paymentMethod;
    }
    
    public void setPickUpMethod(String pickUpMethod){
        this.pickUpMethod=pickUpMethod;
    }
    
    public void setPDate(String pDate){  //dd/mm/yyyy
        this.pDate=pDate;
    }
    
    public void setPTime(String pTime){  //hh:mm
        this.pTime=pTime;
    }
    
    public void setAddress(String address){
        this.address=address;
    }
    
    public String getOrderId(){
        return orderId;
    }
    
    public String getCustId(){
        return custId;
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
    
    public String getPaymentMethod(){
        return paymentMethod;
    }
    
    public String getPickUpMethod(){
        return pickUpMethod;
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
    
    public String getPayment(){
        return payment;
    }
    
    public void setPayment(String payment){
        this.payment = payment;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public int getStatus(){
        return status;
    }
}
