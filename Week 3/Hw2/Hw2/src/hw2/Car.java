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
        // set width, height, and color for body
        body.setWidth(48);
        body.setHeight(14);
        body.setFill(getColor());

        // set back wheel radius and color
        backWheel.setRadius(6);
        backWheel.setFill(Color.BLACK);

        // set front wheel radius and color
        frontWheel.setRadius(6);
        frontWheel.setFill(Color.BLACK);


        roof.setFill(getColor());

        updateChildren(); // update position of children

        // TODO: add children nodes here
        getChildren().addAll(roof, body, backWheel, frontWheel);
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
        double x = getX();
        double y = getY();
        body.setX(x);
        body.setY(y + 11);
        backWheel.setCenterX(12 + x);
        backWheel.setCenterY(27 + y);
        frontWheel.setCenterX(36 + x);
        frontWheel.setCenterY(27 + y);
        ObservableList<Double> points = roof.getPoints();
        points.clear();
        points.addAll(
                12.0 + x, 0.0 + y,
                6.0 + x, 12.0 + y,
                35.0 + x, 12.0 + y,
                30.0 + x, 0.0 + y
        );

    }
}
