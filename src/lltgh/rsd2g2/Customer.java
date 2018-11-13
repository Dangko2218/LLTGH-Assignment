package lltgh.rsd2g2;

public class Customer implements CustomerADT{

    private String custName;
    private String custType;
    private double creditLimit;
    
    @Override
    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
    public String getName() {
        return custName;
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
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public double getCreditLimit() {
        return creditLimit;
    }
    
    Customer(String name, String type, double creditLimit) {
        this.custName = name;
        this.custType = type;
        this.creditLimit = creditLimit;
    }
    
}
