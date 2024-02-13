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


    public Truck(double xPos, double yPos, Color theColor)
    {
        super(xPos, yPos, theColor);


    }

    public Truck(Color theColor)
    {
        this(0.0, 0.0, theColor);
    }


}
