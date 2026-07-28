package java_core.Practice1;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super(radius * 2, radius * 2);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("hinh tron co ban kinh: " + radius + ", dien tich: " + getArea() + ", chu vi: " + getPerimeter());
    }
}
