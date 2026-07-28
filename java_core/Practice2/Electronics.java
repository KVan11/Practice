package java_core.Practice2;

public class Electronics extends Goods {
    private int warrantyMonths;
    private double powerKW;

    public Electronics(String productCode, String name, int quantity, double unitPrice, int warrantyMonths, double powerKW) {
        super(productCode, name, quantity, unitPrice);
        this.warrantyMonths = Math.max(0, warrantyMonths);
        this.powerKW = Math.max(0.0, powerKW);
    }

    @Override
    protected double getVATRate() {
        return 0.10;
    }

    @Override
    public String evaluate() {
        if (quantity < 3) return "De ban";
        return "Binh thuong";
    }

    @Override
    public void displayInfo() {
        System.out.println("Dien tu[" + productCode + "] Ten=" + name + " SL=" + quantity + " Gia don vi=" + unitPrice + " Bao hanh(thang)=" + warrantyMonths + " Cong suat(kW)=" + powerKW + " VAT=" + getVATAmount());
    }
}
