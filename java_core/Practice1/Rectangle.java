package java_core.Practice1;

public class Rectangle extends Shape {
    public Rectangle (double width, double height){
        super(width, height);
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter(){
        return 2*(width+height);
    }

    @Override
    public void displayInfo() {
        System.out.println("Hinh chu nhat voi chieu rong " + width + ", chieu cao " + height + ", dien tich: " + getArea() + ", chu vi: " + getPerimeter());
    }
}
