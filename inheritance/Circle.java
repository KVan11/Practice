public class Circle extends Geometry {
    private double a;

    public Circle (double a){
        super("Circle");
        this.a = a;
    }

    @Override
    public double getArea(){
        return Math.PI*a*a;
    }
}
