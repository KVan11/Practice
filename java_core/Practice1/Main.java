package java_core.Practice1;

public class Main {
    public static void main (String[] args){
        Shape[] shapes = new Shape[2];
        
        shapes[0] = new Circle(3.0);
        shapes[1] = new Rectangle(4.0, 5.0);

        for (Shape s : shapes) {
            s.displayInfo();
        }
    }
}
