package lltgh.rsd2g2;

import java.util.*;

public class Invoice<T extends Comparable<? super T>> implements InvoiceADT<T> {

    private String invoiceNo = null, custID = null, custName = null, custContact = null, custCorp = null, corpAddr = null;
    private String invoiceStatus = null, date = null;
    private List<String> orderItem;
    private List<Integer> qty;
    private List<Double> itemPrice, subtotal;
    private double grandTotal = 0;

    public Invoice(String invoiceNo, String date, String custID, String custName, String custContact, String custCorp, String corpAddr, List orderItem, List itemPrice, List itemQty, List subtotal, double grandTotal, String invoiceStatus) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.custID = custID;
        this.custName = custName;
        this.custContact = custContact;
        this.custCorp = custCorp;
        this.corpAddr = corpAddr;
        this.orderItem = orderItem;
        this.itemPrice = itemPrice;
        this.qty = itemQty;
        this.subtotal = subtotal;
        this.grandTotal = grandTotal;
        this.invoiceStatus = invoiceStatus;
    }

    public Invoice() {
        this.invoiceNo = null;
        this.date = null;
        this.custID = null;
        this.custName = null;
        this.custContact = null;
        this.custCorp = null;
        this.corpAddr = null;
        this.orderItem = null;
        this.itemPrice = null;
        this.qty = null;
        this.subtotal = null;
        this.grandTotal = 0.0;
        this.invoiceStatus = null;
    }

    @Override
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Override
    public String getInvoiceNo() {
        return invoiceNo;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setCustID(String custID) {
        this.custID = custID;
    }

    @Override
    public String getCustID() {
        return custID;
    }

    @Override
    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String getCustName() {
        return custName;
    }

    @Override
    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    @Override
    public String getCustContact() {
        return custContact;
    }

    @Override
    public void setCustCorp(String custCorp) {
        this.custCorp = custCorp;
    }

    @Override
    public String getCustCorp() {
        return custCorp;
    }

    @Override
    public void setCorpAddr(String corpAddr) {
        this.corpAddr = corpAddr;
    }

    @Override
    public String getCorpAddr() {
        return corpAddr;
    }

    @Override
    public void setOrderItem(List orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public List<String> getOrderItem() {
        return orderItem;
    }

    @Override
    public void setItemPrice(List itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public List<Double> getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemQty(List qty) {
        this.qty = qty;
    }

    @Override
    public List<Integer> getQty() {
        return qty;
    }

    @Override
    public void setSubtotal(List subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public List<Double> getSubtotal() {
        return subtotal;
    }

    @Override
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public double getGrandTotal() {
        return grandTotal;
    }

    @Override
    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    @Override
    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public String toString() {
        String s = "Invoice No: " + invoiceNo + "\n"
                + "Date: " + date + "\n"
                + "Customer ID: " + custID + "\n"
                + "Customer: " + custName + "\n"
                + "Contact No: " + custContact + "\n"
                + "Corporation: " + custCorp + "\n"
                + "Address: " + corpAddr + "\n"
                + "Item: " + getOrderItem() + "\n"
                + "Unit Price: " + itemPrice + "\n"
                + "Quantity: " + qty + "\n"
                + "Subtotal: " + subtotal + "\n"
                + "Grand Total: " + grandTotal + "\n"
                + "Status: " + invoiceStatus + "\n";
        return s;
    }
}
