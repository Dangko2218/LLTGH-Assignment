package lltgh.rsd2g2;

public class Invoice implements InvoiceADT{

    private String invoiceNo =  null, custID = null, custName = null, custContact = null, custCorp = null, corpAddr = null;
    private String itemName = null, invoiceStatus = null, date = null;
    private double itemPrice = 0, subtotal = 0, grandTotal = 0;
    private int qty;

//    Invoice(String invoiceNo, String date, String custID, String custName, String custContact, String custCorp, String corpAddr, String itemName, double itemPrice, int itemQty, double subtotal, double grandTotal, String invoiceStatus) {
//        this.invoiceNo = invoiceNo;
//        this.date = date;
//        this.custID = custID;
//        this.custName = custName;
//        this.custContact = custContact;
//        this.custCorp = custCorp;
//        this.corpAddr = corpAddr;
//        this.itemName = itemName;
//        this.itemPrice = itemPrice;
//        this.qty = itemQty;
//        this.subtotal = subtotal;
//        this.grandTotal = grandTotal;
//        this.invoiceStatus = invoiceStatus;
//    }
    
    @Override
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Override
    public String getInvoiceNo() {
        return invoiceNo;
    }
    
    @Override
    public void setDate(String date){
        this.date = date;
    }
    
    @Override
    public String getDate(){
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
    public String getCustContact(){
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
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public void setItemQty(int qty) {
        this.qty = qty;
    }

    @Override
    public int getQty() {
        return qty;
    }

    @Override
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public double getSubtotal() {
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
                + "Item: " + itemName + "\n"
                + "Unit Price: " + itemPrice + "\n"
                + "Quantity: " + qty + "\n"
                + "Subtotal: " + subtotal + "\n"
                + "Grand Total: " + grandTotal + "\n"
                + "Status: " + invoiceStatus + "\n";
        return s;
    }
}
