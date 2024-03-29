package lltgh.rsd2g2;

public interface CustomerListADT<T> {
    public int getNumOfEnt();
    public void setCustID(String custID);
    public String getCustID();
    public void setCustName(String custName);
    public String getName();
    public void setCustIC(String custIC);
    public String getCustIC();
    public void setContactNo(String contactNo);
    public String getContactNo();
    public void setCustType(String custType);
    public String getType();
    public void setCustCorp(String custCorp);
    public String getCustCorp();
    public void setCorpAddr(String corpAddr);
    public String getCorpAddr();
    public void setCreditLimit(double creditLimit);
    public double getCreditLimit();
    public void regCustomer(T item);
    public boolean isEmpty();
}