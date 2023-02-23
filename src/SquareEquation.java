public class SquareEquation {
    public double a;
    private double b;
    private double c;
    Solve solve = x1 -> a*x1*x1+b*x1+c;
    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args) {
        SquareEquation s = new SquareEquation(-2,3,10);
        double x=0;
        System.out.println(s.solve.calc(10));
        s.solve = x1 -> x1*x1;
        System.out.println(s.solve.calc(10));
    }
}

@FunctionalInterface
interface Solve{
    double calc(double x);
}


