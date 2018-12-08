/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lltgh.rsd2g2;

/**
 *
 * @author Desmond
 */
public class Product implements Comparable<Product>{

    private String prodID;
    private String prodName;
    private String prodType;
    private String prodDetail;
    private double prodPrice;
    private int prodStock;

    public Product() {
        prodID = null;
        prodName = null;
        prodType = null;
        prodDetail = null;
        prodPrice = 0;
        prodStock = 0;
    }

    public Product(String prodID, String prodName, String prodType, String prodDetail, double prodPrice, int prodStock) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodType = prodType;
        this.prodDetail = prodDetail;
        this.prodPrice = prodPrice;
        this.prodStock = prodStock;
    }

    public String getProdID() {
        return prodID;
    }

    public String getprodName() {
        return prodName;
    }

    public String getprodType() {
        return prodType;
    }

    public String getprodDetail() {
        return prodDetail;
    }

    public double getprodPrice() {
        return prodPrice;
    }

    public int getprodStock() {
        return prodStock;
    }

    public void setProdID(String prodID){
        this.prodID = prodID;
    }
    public void setprodName(String prodName){
        this.prodName = prodName;
    }
    public void setprodType(String prodType){
        this.prodType = prodType;
    }
    public void setprodDetail(String prodDetail){
        this.prodDetail = prodDetail;
    }
    public void setprodPrice(double prodPrice){
        this.prodPrice = prodPrice;
    }
    public void setprodStock(int prodStock){
        this.prodStock = prodStock;
    }
    
    public String toString() {
        return "\nProduct ID: " + prodID
                + "\nProduct Name: " + prodName
                + "\nProduct Type: " + prodType
                + "\nProduct Detail: " + prodDetail
                + "\nProduct Price: " + prodPrice
                + "\nProduct Stock: " + prodStock
                + "\n";
    }

    @Override
    public int compareTo(Product prod) {
        if(this.prodStock >= prod.prodStock){
            return 1;
        }else   
            return -1;
    }

}
