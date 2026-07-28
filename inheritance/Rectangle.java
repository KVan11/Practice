public class Rectangle extends Geometry {
    private double a;
    private double b;

    public Rectangle (double a, double b){
        super("Rectangle");
        this.a = a;
        this.b = b;
    }

    @Override
    public double getArea(){
        return a*b;
    }
}
