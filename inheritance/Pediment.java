public class Pediment extends Geometry {
    private double h;
    private double b;

    public Pediment (double h, double b){
        super("Pediment");
        this.h = h;
        this.b = b;
    }

    @Override
    public double getArea(){
        return 0.5*b*h;
    }
}
