package lltgh.rsd2g2;

import java.util.*;

public interface InvoiceADT<T> {
    
    public void setInvoiceNo(String invoiceNo);
    public String getInvoiceNo();
    
    public void setDate(String date);
    public String getDate();
    
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
    
    public void setOrderItem(List orderItem);
    public List<String> getOrderItem();
    
    public void setItemPrice(List itemPrice);
    public List<Double> getItemPrice();

    public void setItemQty(List qty);
    public List<Integer> getQty();
    
    public void setSubtotal(List subtotal);
    public List<Double> getSubtotal();
    
    public void setGrandTotal(double grandTotal);
    public double getGrandTotal();
    
    public void setInvoiceStatus(String invoiceStatus);
    public String getInvoiceStatus();
    
    
}
