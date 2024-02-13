package shape;

public class Rectangle extends Shape
{
    private final double xLeft, yUpper, width, height;

    public Rectangle(double x, double y, double w, double h)
    {
        super(4); // call Shape's constructor
        xLeft = x;
        yUpper = y;
        width = w;
        height = h;
    }

    public double getXLeft()
    {
        return xLeft;
    }

    public double getYUpper()
    {
        return yUpper;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    @Override
    public double getArea()
    {
        return width*height;
    }

    @Override
    public String toString()
    {
        return "Rectangle: upper left = (" + xLeft + ", " + yUpper +
                "), width = " + width + ", height = " + height;
    }
}
