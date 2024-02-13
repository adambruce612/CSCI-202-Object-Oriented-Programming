package shape;

public class Triangle extends Shape
{
    private final double x1, y1, x2, y2, x3, y3;

    public Triangle(double x1, double y1, double x2, double y2,
                    double x3, double y3)
    {
        super(3); // call Shape's constructor
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    private static double dist(double x1, double y1, double x2, double y2)
    {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx*dx + dy*dy);
    }

    @Override
    public double getArea()
    {
        // Use Heron's formula
        double a = dist(x1, y1, x2, y2);
        double b = dist(x2, y2, x3, y3);
        double c = dist(x1, y1, x3, y3);
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public String toString()
    {
        return "Triangle: (" + x1 + ", " + y1 + "), (" + x2 + "," +
                y2 + "), (" + x3 + ", " + y3 + ")";
    }
}
