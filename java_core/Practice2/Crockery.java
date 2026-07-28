package java_core.Practice2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Crockery extends Goods {
	private String manufacturer;
	private LocalDate arrivalDate;

	public Crockery(String productCode, String name, int quantity, double unitPrice, String manufacturer, LocalDate arrivalDate) {
		super(productCode, name, quantity, unitPrice);
		this.manufacturer = manufacturer;
		this.arrivalDate = arrivalDate;
	}

	@Override
	protected double getVATRate() {
		return 0.10;
	}

	@Override
	public String evaluate() {
		if (quantity > 50 && arrivalDate != null) {
			long days = ChronoUnit.DAYS.between(arrivalDate, LocalDate.now());
			if (days > 10) return "Ban cham";
		}
		return "Binh thuong";
	}

	@Override
	public void displayInfo() {
		System.out.println("Do dung[" + productCode + "] Ten=" + name + " SL=" + quantity + " Gia don vi=" + unitPrice + " NSX=" + manufacturer + " Ngay ve=" + arrivalDate + " VAT=" + getVATAmount());
	}
}
