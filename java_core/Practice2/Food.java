package java_core.Practice2;

import java.time.LocalDate;

public class Food extends Goods {
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private String supplier;

    public Food(String productCode, String name, int quantity, double unitPrice, LocalDate manufactureDate, LocalDate expiryDate, String supplier) {
        super(productCode, name, quantity, unitPrice);
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.supplier = supplier;
        if (this.manufactureDate != null && this.expiryDate != null && this.expiryDate.isBefore(this.manufactureDate)) {
            throw new IllegalArgumentException("Ngay het han phai bang hoac sau ngay san xuat");
        }
    }

    @Override
    protected double getVATRate() {
        return 0.05;
    }

    @Override
    public String evaluate() {
        if (quantity > 0 && expiryDate != null && expiryDate.isBefore(LocalDate.now())) {
            return "Kho ban";
        }
        return "Binh thuong";
    }

    @Override
    public void displayInfo() {
        System.out.println("Thuc pham[" + productCode + "] Ten=" + name + " SL=" + quantity + " Gia don vi=" + unitPrice + " NSX=" + manufactureDate + " HSD=" + expiryDate + " Nha cung cap=" + supplier + " VAT=" + getVATAmount());
    }
}
