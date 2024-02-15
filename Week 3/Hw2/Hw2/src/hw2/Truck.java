package hw2;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.collections.ObservableList;

// TODO: Finish writing the Truck class.
//       This is similar to the Car class.
//       Do not add anymore members to its public interface.
//       You may, however, add any needed private members.
//       Note: overloading an inherited public method does not
//       add it to the public interface because it is already
//       a part of the public interface.

public class Truck extends Vehicle
{

    private final Polygon cab = new Polygon();
    private final Rectangle body = new Rectangle();
    private Circle backWheel = new Circle();
    private Circle middleWheel = new Circle();
    private Circle frontWheel = new Circle();

    public Truck(double xPos, double yPos, Color theColor)
    {
        super(xPos, yPos, theColor);
        body.setWidth(78);
        body.setHeight(11);
        body.setFill(getColor());

        backWheel.setRadius(9);
        backWheel.setFill(Color.BLACK);

        middleWheel.setRadius(9);
        middleWheel.setFill(Color.BLACK);

        frontWheel.setRadius(9);
        frontWheel.setFill(Color.BLACK);

        cab.setFill(getColor());

        updateChildren();

        getChildren().addAll(cab, body, backWheel, middleWheel, frontWheel);
    }

    public Truck(Color theColor)
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
        double x = getX();
        double y = getY();
        body.setX(x);
        body.setY(y + 24);
        backWheel.setCenterX(x + 12);
        backWheel.setCenterY(y + 36);
        middleWheel.setCenterX(x + 30);
        middleWheel.setCenterY(y + 36);
        frontWheel.setCenterX(x + 66);
        frontWheel.setCenterY(y + 36);
        ObservableList<Double> points = cab.getPoints();
        points.clear();
        points.addAll(
                42.0 + x, 0 + y,
                42.0 + x, 35.0 + y,
                78.0 + x, 35.0 + y,
                78.0 + x, 12.0 + y,
                66 + x, 12.0 + y,
                60 + x, 0 + y
        );
    }
}
