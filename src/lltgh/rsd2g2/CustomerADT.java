package lltgh.rsd2g2;

public interface CustomerADT {
    public void setCustName(String custName);
    public String getName();
    public void setCustType(String custType);
    public String getType();
    public void setCreditLimit(double creditLimit);
    public double getCreditLimit();
}
