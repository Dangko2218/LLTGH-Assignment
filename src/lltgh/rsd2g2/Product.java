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
public class Product implements ProductADT{

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
    public ProductADT add(ProductADT product) {
        ProductADT latestProd = new Product();
        latestProd.setProdID(product.getProdID());
        latestProd.setprodName(product.getprodName());
        latestProd.setprodDetail(product.getprodDetail());
        latestProd.setprodType(product.getprodType());
        latestProd.setprodPrice(product.getprodPrice());
        latestProd.setprodStock(product.getprodStock());
        return product;
    }

    @Override
    public ProductADT update(ProductADT product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductADT delete(ProductADT product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
