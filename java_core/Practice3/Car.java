package java_core.Practice3;

public class Car extends Vehicle {
    private int seats;
    private String engineType;

    public Car(String vehicleNumber, String manufacturer, int year, String color, Owner owner, int seats, String engineType) {
        super(vehicleNumber, manufacturer, year, color, owner);
        this.seats = Math.max(1, seats);
        this.engineType = engineType == null ? "" : engineType;
    }

    public int getSeats() { return seats; }
    public String getEngineType() { return engineType; }

    @Override
    public void displayInfo() {
        System.out.println("Car[" + vehicleNumber + "] manu=" + manufacturer + " year=" + year + " color=" + color + " seats=" + seats + " engine=" + engineType + " ownerId=" + (owner==null?"":owner.getIdNumber()));
    }
}
