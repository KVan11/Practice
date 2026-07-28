package java_core.Practice1;

public abstract class Shape {
    protected double width;
    protected double height;

    public Shape (double width, double height){
        this.width = width;
        this.height = height;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public void displayInfo(){
        System.out.println("chieu rong: " + width + ", chieu cao: " + height);
    }
}
