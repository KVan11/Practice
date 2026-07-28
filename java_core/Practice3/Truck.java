package java_core.Practice3;

public class Truck extends Vehicle {
    private double tonnage;

    public Truck(String vehicleNumber, String manufacturer, int year, String color, Owner owner, double tonnage) {
        super(vehicleNumber, manufacturer, year, color, owner);
        this.tonnage = Math.max(0.0, tonnage);
    }

    public double getTonnage() { return tonnage; }

    @Override
    public void displayInfo() {
        System.out.println("Truck[" + vehicleNumber + "] manu=" + manufacturer + " year=" + year + " color=" + color + " tonnage=" + tonnage + " ownerId=" + (owner==null?"":owner.getIdNumber()));
    }
}
