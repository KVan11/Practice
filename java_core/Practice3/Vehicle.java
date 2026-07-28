package java_core.Practice3;

import java.time.LocalDate;

public abstract class Vehicle {
    protected String vehicleNumber; // exactly 5 chars
    protected String manufacturer; // Honda, Yamaha, Toyota, Suzuki
    protected int year; // >2000 and <= current year
    protected String color;
    protected Owner owner;

    public Vehicle(String vehicleNumber, String manufacturer, int year, String color, Owner owner) {
        if (vehicleNumber == null || vehicleNumber.length() != 5) {
            throw new IllegalArgumentException("vehicleNumber must be exactly 5 characters");
        }
        if (manufacturer == null || !(manufacturer.equals("Honda") || manufacturer.equals("Toyota") || manufacturer.equals("Suzuki") || manufacturer.equals("Yamaha"))) {
            throw new IllegalArgumentException("manufacturer must be one of: Honda, Toyota, Suzuki, Yamaha");
        }
        int currentYear = LocalDate.now().getYear();
        if (year <= 2000 || year > currentYear) {
            throw new IllegalArgumentException("year must be >2000 and <= current year");
        }
        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color == null ? "" : color;
        this.owner = owner;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public Owner getOwner() { return owner; }

    public abstract void displayInfo();
}
