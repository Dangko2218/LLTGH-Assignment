package lltgh.rsd2g2;

public class Customer<T extends Comparable<? super T>> implements CustomerListADT<T> {

    private String custID, custName, custIC, contactNo, custType, custCorp, corpAddr;
    private double creditLimit;
    private int numOfEnt = 0;

    Customer() {
        this.custID = null;
        this.custName = null;
        this.custIC = null;
        this.contactNo = null;
        this.custType = null;
        this.custCorp = null;
        this.corpAddr = null;
        this.creditLimit = 0.0;
    }

    Customer(String custID, String name, String custIC, String contactNo, String type, String custCorp, String corpAddr, double creditLimit) {
        this.custID = custID;
        this.custName = name;
        this.custIC = custIC;
        this.contactNo = contactNo;
        this.custType = type;
        this.custCorp = custCorp;
        this.corpAddr = corpAddr;
        this.creditLimit = creditLimit;
    }

    @Override
    public int getNumOfEnt() {
        return numOfEnt;
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
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String getContactNo() {
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
    public void setCorpAddr(String corpAddr) {
        this.corpAddr = corpAddr;
    }

    @Override
    public String getCorpAddr() {
        return corpAddr;
    }

    @Override
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void regCustomer(T item) {
        numOfEnt++;
    }

    @Override
    public boolean isEmpty() {
        if (numOfEnt == 0) {
            return true;
        } else {
            return false;
        }
    }
}
