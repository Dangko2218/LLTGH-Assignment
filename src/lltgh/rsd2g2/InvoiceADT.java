package lltgh.rsd2g2;

public interface InvoiceADT {
    
    public void setInvoiceNo(String invoiceNo);
    public String getInvoiceNo();
    
    public void setCustID(String custID);
    public String getCustID();
    
    public void setCustName(String custName);
    public String getCustName();
    
    public void setCustContact(String contact);
    public String getCustContact();
    
    public void setCustCorp(String custCorp);
    public String getCustCorp();
    
    public void setCorpAddr(String corpAddr);
    public String getCorpAddr();
    
    public void setItemName(String itemName);
    public String getItemName();
    
    public void setItemPrice(double itemPrice);
    public double getItemPrice();
    
    public void setSubtotal(double subtotal);
    public double getSubtotal();
    
    public void setGrandTotal(double grandTotal);
    public double getGrandTotal();
    
    public void setInvoiceStatus(String invoiceStatus);
    public String getInvoiceStatus();
    
    
}