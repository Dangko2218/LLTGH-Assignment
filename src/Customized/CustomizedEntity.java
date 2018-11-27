/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customized;

/**
 *
 * @author User
 */
public class CustomizedEntity implements Comparable<CustomizedEntity>{

    private String OrderNo;
    private String custID;
    private String style;
    private String size;
    private String type;
    private String acc;
    private int prior;
    private int price;
    private int status;
    
    public CustomizedEntity(String OrderNo, String custID, String style, String size, String type, String acc, int prior, int price, int status) {
        this.OrderNo = OrderNo;
        this.custID = custID;
        this.style = style;
        this.size = size;
        this.type = type;
        this.acc = acc;
        this.prior = prior;
        this.price = price;
        this.status = status;
    }
    
    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String OrderNo) {
        this.OrderNo = OrderNo;
    }
    
    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }
    
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }
    
    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int compareTo(CustomizedEntity customized) {
        
        if(this.prior >= customized.prior){
            return 1;
        }else   
            return -1;
    }
    
}
