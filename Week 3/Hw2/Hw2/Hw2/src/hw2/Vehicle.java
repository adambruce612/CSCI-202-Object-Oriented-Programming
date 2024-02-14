package hw2;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Vehicle extends Pane
{
    private double x; // current x position
    private double y; // current y position
    private final Color color; // vehicle color

    // create a vehicle at the given position
    protected Vehicle(double xPos, double yPos, Color theColor)
    {
        x = xPos;
        y = yPos;
        color = theColor;
    }

    public final double getX()
    {
        return x;
    }

    public final double getY()
    {
        return y;
    }

    public final Color getColor()
    {
        return color;
    }

    // Set the x and y coordinates.
    // This method should be overridden in subclasses to
    // update children nodes.
    public void setPosition(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}
