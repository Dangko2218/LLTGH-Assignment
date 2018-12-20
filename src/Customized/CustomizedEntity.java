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

    private String OrderNo, dateTime, collectionDate, custID, style, size, type1, type2, type3, acc1, acc2, acc3, itemCode, itemName, itemStatus;
    int prior, price, status, itemPrice;
    
    public CustomizedEntity(){
        this.OrderNo = null;
        this.dateTime = null;
        this.collectionDate = null;
        this.custID = null;
        this.style = null;
        this.size = null;
        this.type1 = null;
        this.type2 = null;
        this.type3 = null;
        this.acc1 = null;
        this.acc2 = null;
        this.acc3 = null;
        this.prior = 0;
        this.price = 0;
        this.status = 0;
    }
    
    public CustomizedEntity(String OrderNo, String dateTime, String collectionDate, String custID, String style, String size, String type1, String type2, String type3, String acc1, String acc2, String acc3, int prior, int price, int status) {
        
        this.OrderNo = OrderNo;
        this.dateTime = dateTime;
        this.collectionDate = collectionDate;
        this.custID = custID;
        this.style = style;
        this.size = size;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.acc3 = acc3;
        this.prior = prior;
        this.price = price;
        this.status = status;
        this.OrderNo = OrderNo;
        this.dateTime = dateTime;
        this.collectionDate = collectionDate;
        this.custID = custID;
        this.style = style;
        this.size = size;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.acc3 = acc3;
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
    
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
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
    
    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }
    
    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
    
    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }
    
    public String getAcc1() {
        return acc1;
    }

    public void setAcc1(String acc1) {
        this.acc1 = acc1;
    }
    
    public String getAcc2() {
        return acc2;
    }

    public void setAcc2(String acc2) {
        this.acc2 = acc2;
    }
    
    public String getAcc3() {
        return acc3;
    }

    public void setAcc3(String acc3) {
        this.acc3 = acc3;
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
    
    public CustomizedEntity(String itemCode, String itemName, int itemPrice, String itemStatus){
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemStatus = itemStatus;
    }
    
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public int compareTo(CustomizedEntity customized) {
        
        if(this.prior >= customized.prior){
            return 1;
        }else   
            return -1;
    }
    
}
