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
    int prior, status, itemPrice, ty1Quan, ty2Quan, ty3Quan, ac1Quan, ac2Quan, ac3Quan;
    double price, ty1Price, ty2Price, ty3Price, ac1Price, ac2Price, ac3Price;
    
    public CustomizedEntity(String OrderNo, String dateTime, String collectionDate, String custID, String style, String size, String type1, int ty1Quan, double ty1Price, String type2, int ty2Quan, double ty2Price, String type3, int ty3Quan, double ty3Price, String acc1, int ac1Quan, double ac1Price, String acc2, int ac2Quan, double ac2Price, String acc3, int ac3Quan, double ac3Price, int prior, double price, int status) {
        this.OrderNo = OrderNo;
        this.dateTime = dateTime;
        this.collectionDate = collectionDate;
        this.custID = custID;
        this.style = style;
        this.size = size;
        this.type1 = type1;
        this.ty1Quan = ty1Quan;
        this.ty1Price = ty1Price;
        this.type2 = type2;
        this.ty2Quan = ty2Quan;
        this.ty2Price = ty2Price;
        this.type3 = type3;
        this.ty3Quan = ty3Quan;
        this.ty3Price = ty3Price;
        this.acc1 = acc1;
        this.ac1Quan = ac1Quan;
        this.ac1Price = ac1Price;
        this.acc2 = acc2;
        this.ac2Quan = ac2Quan;
        this.ac2Price = ac2Price;
        this.acc3 = acc3;
        this.ac3Quan = ac3Quan;
        this.ac3Price = ac3Price;
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
    
    public int getTy1Quan() {
        return ty1Quan;
    }

    public void setTy1Quan(int ty1Quan) {
        this.ty1Quan = ty1Quan;
    }
    
    public double getTy1Price() {
        return ty1Price;
    }

    public void setTy1Price(double ty1Price) {
        this.ty1Price = ty1Price;
    }
    
    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
    
    public int getTy2Quan() {
        return ty2Quan;
    }

    public void setTy2Quan(int ty2Quan) {
        this.ty2Quan = ty2Quan;
    }
    
    public double getTy2Price() {
        return ty2Price;
    }

    public void setTy2Price(double ty2Price) {
        this.ty2Price = ty2Price;
    }
    
    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }
    
    public int getTy3Quan() {
        return ty3Quan;
    }

    public void setTy3Quan(int ty3Quan) {
        this.ty3Quan = ty3Quan;
    }
    
    public double getTy3Price() {
        return ty3Price;
    }

    public void setTy3Price(double ty3Price) {
        this.ty3Price = ty3Price;
    }
    
    public String getAcc1() {
        return acc1;
    }

    public void setAcc1(String acc1) {
        this.acc1 = acc1;
    }
    
    public int getAc1Quan() {
        return ac1Quan;
    }

    public void setAc1Quan(int ac1Quan) {
        this.ac1Quan = ac1Quan;
    }
    
    public double getAc1Price() {
        return ac1Price;
    }

    public void setAc1Price(double ac1Price) {
        this.ac1Price = ac1Price;
    }
    
    public String getAcc2() {
        return acc2;
    }

    public void setAcc2(String acc2) {
        this.acc2 = acc2;
    }
    
    public int getAc2Quan() {
        return ac2Quan;
    }

    public void setAc2Quan(int ac2Quan) {
        this.ac2Quan = ac2Quan;
    }
    
    public double getAc2Price() {
        return ac2Price;
    }

    public void setAc2Price(double ac2Price) {
        this.ac2Price = ac2Price;
    }
    
    public String getAcc3() {
        return acc3;
    }

    public void setAcc3(String acc3) {
        this.acc3 = acc3;
    }
    
    public int getAc3Quan() {
        return ac3Quan;
    }

    public void setAc3Quan(int ac3Quan) {
        this.ac3Quan = ac3Quan;
    }
    
    public double getAc3Price() {
        return ac3Price;
    }

    public void setAc3Price(double ac3Price) {
        this.ac3Price = ac3Price;
    }
    
    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
