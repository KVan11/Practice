package java_core.Practice1;

public class Main {
    public static void main (String[] args){
        Shape[] shapes = new Shape[3];
        
        shapes[0] = new Shape(2.0, 3.0);
        shapes[1] = new Circle(3.0);
        shapes[2] = new Rectangle(4.0, 5.0);

        for (Shape s : shapes) {
            s.displayInfo();
        }
    }
}
