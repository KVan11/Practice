public class Main {
    public static void main(String[] args) {
        Geometry[] shapes = new Geometry[4];

        shapes[0] = new Circle(5);
        shapes[1] = new Square(4);
        shapes[2] = new Rectangle(8, 3);
        shapes[3] = new Pediment(6, 4);

        for (Geometry shape : shapes) {
            shape.displayInfo();
        }
    }
}