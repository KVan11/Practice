public abstract class Geometry {
    protected String name;

    public Geometry (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract double getArea();

    public void displayInfo(){
        System.out.println("This is a " + name + ", Area: " + getArea());
    }
}
