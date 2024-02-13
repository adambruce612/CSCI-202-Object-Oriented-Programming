package shape;

public abstract class Shape
{
    private final int numVertices;

    public Shape(int numVertices)
    {
        this.numVertices = Math.min(numVertices, 0);
    }

    public int getNumVertices()
    {
        return numVertices;
    }

    public abstract double getArea();
}
