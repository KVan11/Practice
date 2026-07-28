package java_core.Practice3;

public class Motorbike extends Vehicle {
    private double capacity;

    public Motorbike(String vehicleNumber, String manufacturer, int year, String color, Owner owner, double capacity) {
        super(vehicleNumber, manufacturer, year, color, owner);
        this.capacity = Math.max(0.0, capacity);
    }

    public double getCapacity() { return capacity; }

    @Override
    public void displayInfo() {
        System.out.println("Motorbike[" + vehicleNumber + "] manu=" + manufacturer + " year=" + year + " color=" + color + " capacity=" + capacity + " ownerId=" + (owner==null?"":owner.getIdNumber()));
    }
}
