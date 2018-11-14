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
public interface ProductADT {

    public String getProdID();

    public String getprodName();

    public String getprodType();

    public String getprodDetail();

    public double getprodPrice();

    public int getprodStock();

    public void setProdID(String prodID);

    public void setprodName(String prodName);

    public void setprodType(String prodType);

    public void setprodDetail(String prodDetail);

    public void setprodPrice(double prodPrice);

    public void setprodStock(int prodStock);
    
    ProductADT add(ProductADT product);
    ProductADT update(ProductADT product);
    ProductADT delete(ProductADT product);
}
