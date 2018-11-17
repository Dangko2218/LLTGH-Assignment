package lltgh.rsd2g2;

public class Customer implements CustomerADT{

    private String custID, custName, custIC, contactNo, custType, custCorp;
    private double creditLimit;
    
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
    public String getName() {
        return custName;
    }
    
    @Override
    public void setCustIC(String custIC) {
        this.custIC = custIC;
    }

    @Override
    public String getCustIC() {
        return custIC;
    }
    
    @Override
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    
    @Override
    public String getContactNo(){
        return contactNo;
    }

    @Override
    public void setCustType(String custType) {
        this.custType = custType;
    }

    @Override
    public String getType() {
        return custType;
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
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public double getCreditLimit() {
        return creditLimit;
    }
    
    Customer(String custID, String name, String custIC, String contactNo, String type, String custCorp, double creditLimit) {
        this.custID = custID;
        this.custName = name;
        this.custIC = custIC;
        this.contactNo = contactNo;
        this.custType = type;
        this.custCorp = custCorp;
        this.creditLimit = creditLimit;
    }
}
