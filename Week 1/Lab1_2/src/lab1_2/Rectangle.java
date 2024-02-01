package lab1_2;

public class Rectangle
{
    private double lowerX;
    private double lowerY;
    private double rectangleLength;
    private double rectangleWidth;

    // Constructor for creating a rectangle with lower left corner (x,y) and given length and width
    public Rectangle (double x, double y, double length, double width)
    {
        lowerX = x;
        lowerY = y;
        rectangleLength = length;
        rectangleWidth = width;

    }

    // get method for the lower left x coordinate
    public double getX()
    {
        return lowerX;
    }

    // get method for the lower left y coordinate
    public double getY()
    {
        return lowerY;
    }

    // get method for the length
    public double getLength()
    {
        return rectangleLength;
    }

    // get method for the width
    public double getWidth()
    {
        return rectangleWidth;
    }

    // The following method return true if and only if the line segment
    // from a to b overlaps with the line segment from c to d on the real line.
    // Touching only at one point is not considered overlapping.
    // This method is to be called by method overlapsWith to help compute if two rectangles overlap.
    private static boolean doLinesOverlap(double a, double b, double c, double d)
    {
        return (a < c ? (a + b > c) : (c + d > a));
    }

    // The following method tests if two Rectangle objects overlap.
    // This method returns true if and only if the invoking object (the object referenced by the keyword this) overlaps with Rectangle other.
    // Touching only at a corner or only on an edge is not considered overlapping.
    public boolean overlapsWith(Rectangle other)
    {
        if (doLinesOverlap(this.lowerX, this.rectangleLength, other.lowerX, other.rectangleLength))
        {
            return doLinesOverlap(this.lowerY, this.rectangleWidth, other.lowerY, other.rectangleWidth);
        }
        else return false;
    }
}
