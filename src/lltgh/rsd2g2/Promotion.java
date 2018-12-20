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
public class Promotion implements Comparable<Promotion> {

    private int promoMonth;
    private String prodID;
    private int discountRate;
    
    public Promotion() {
        promoMonth = 0;
        prodID = null;
        discountRate = 0;
    }

    public Promotion(int promoMonth, String prodID,int discountRate) {
        this.promoMonth= promoMonth;
        this.prodID = prodID;
        this.discountRate = discountRate;
    }

    public int getpromoMonth() {
        return promoMonth;
    }
    
    public String getProdID() {
        return prodID;
    }

    public int getdiscountRate() {
        return discountRate;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public void setpromoMonth(int promoMonth) {
        this.promoMonth = promoMonth;
    }
    
    public void setdiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public String toString() {
        return "\nPromotion Month: " + promoMonth
                + "\nProduct ID: " + prodID
                + "\nDiscount Rate: " + discountRate
                + "\n";
    }
    
    @Override
    public int compareTo(Promotion t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
