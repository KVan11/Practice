public class Square extends Geometry {
    private double b;

    public Square (double b){
        super("Square");
        this.b = b;
    }

    @Override
    public double getArea(){
        return b*b;
    }
}
