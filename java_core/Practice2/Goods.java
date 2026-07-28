package java_core.Practice2;

public abstract class Goods {
    protected String productCode;
    protected String name;
    protected int quantity;
    protected double unitPrice;

    public Goods(String productCode, String name, int quantity, double unitPrice){
        this.productCode = productCode;
        this.name = name;
        this.quantity = Math.max(0, quantity);
        this.unitPrice = unitPrice;
    }

    public String getProductCode(){ 
        return productCode; 
    }

    public String getName(){ 
        return name; 
    }

    public int getQuantity(){ 
        return quantity;
    }
    
    public double getUnitPrice(){ 
        return unitPrice;
    }

    protected abstract double getVATRate();

    public double getVATAmount(){
        return unitPrice * quantity * getVATRate();
    }

    public abstract String evaluate();

    public abstract void displayInfo();
}
