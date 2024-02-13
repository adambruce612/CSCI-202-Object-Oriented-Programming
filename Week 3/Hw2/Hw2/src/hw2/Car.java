package hw2;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.collections.ObservableList;

public class Car extends Vehicle
{
    private final Polygon roof = new Polygon();
    private final Rectangle body = new Rectangle();
    private final Circle backWheel = new Circle();
    private final Circle frontWheel = new Circle();

    public Car(double xPos, double yPos, Color theColor)
    {
        super(xPos, yPos, theColor);

        // TODO: Initialize properties of the children nodes that
        //       are not updated in updateChildren(). updateChildren()
        //       only updates the x and y coordinates of each children.

        updateChildren(); // update position of children

        // TODO: add children nodes here
    }

    public Car(Color theColor)
    {
        this(0.0, 0.0, theColor);
    }

    @Override
    public void setPosition(double x, double y)
    {
        super.setPosition(x, y);
        updateChildren();
    }

    private void updateChildren()
    {
        // TODO: Update the x and y coordinates of each children node.
        //       The x and y coordinate of this object can be
        //       retrieved with getX() and getY() respectively.
    }
}
