package hw2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import java.util.Random;
import java.util.ArrayList;

public class Hw2 extends Application
{
    // window width and height
    private static final double WIDTH = 610;
    private static final double HEIGHT = 377;

    // maximum x and y position to place vehicles
    private static final double MAX_X_POS = WIDTH - 80;
    private static final double MAX_Y_POS = HEIGHT - 90;

    // spacing between and around elements
    private static final double SPACING = 10.0;

    private ArrayList<Vehicle> vehicles;
    private Pane drawPane;
    private Random generator;

    @Override
    public void start(Stage stage)
    {
        vehicles = new ArrayList<>();
        drawPane = new Pane();
        generator = new Random();

        Insets padding = new Insets(SPACING);

        HBox topBox = new HBox(SPACING);
        topBox.setPadding(padding);

        Button addCarBtn = new Button("Add Car");
        addCarBtn.setOnAction(this::addCar);
        topBox.getChildren().add(addCarBtn);

        // TODO: Create a button for adding Trucks
        //       similar to the one above for adding Cars.
        //       Connected this button to a method you create
        //       called addTruck(ActionEvent e).
        //       Add this button to topBox.
        Button addTruckBtn = new Button("Add Truck");
        addTruckBtn.setOnAction(this::addTruck);
        topBox.getChildren().add(addTruckBtn);

        // TODO: Create a button with the text "Move" on it.
        //       Connect this button to the method move(ActionEvent e).
        //       Add this button to topBox.
        Button moveBtn = new Button("Move");
        moveBtn.setOnAction(this::move);
        topBox.getChildren().add(moveBtn);

        // TODO: Create a button with the text "Clear" on it.
        //       Connect this button to the method clear(ActionEvent e).
        //       Add this button to topBox.
        Button clearBtn = new Button("Clear");
        clearBtn.setOnAction(this::clear);
        topBox.getChildren().add(clearBtn);

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(drawPane);

        // Create a scene and place it in the stage
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("Hw2");  // Set the stage title
        stage.setScene(scene);     // Place the scene in the stage
        stage.setResizable(false); // Prevent window from being resized
        stage.show();              // Display the stage
    }

    private void addCar(ActionEvent e)
    {
        // create a new car with a random color
        Car car = new Car(randomColor());

        // randomly position car
        randomlyPosition(car);

        vehicles.add(car); // add car to the vehicles ArrayList
        drawPane.getChildren().add(car); // add car to drawPane
    }

    // TODO: Create a private method called addTruck(ActionEvent e)
    //       similar to the addCar(ActionEvent e) method above.
    //       This is the method that will be called when the "Add Truck"
    //       button is clicked. In the body create a new Truck object set to
    //       a random color, randomly position the truck, add the
    //       truck to the vehicles ArrayList, and finally add the truck
    //       to drawPane.
    private void addTruck(ActionEvent e)
    {
        Truck truck = new Truck(randomColor());

        randomlyPosition(truck);

        vehicles.add(truck);
        drawPane.getChildren().add(truck);
    }
    // This method moves each vehicle to a random position on the screen
    private void move(ActionEvent e)
    {
        // TODO: For each vehicle v in the ArrayList vehicles,
        //       move it to a random position by calling
        //       randomlyPosition(v);
        for (int j = 0; j < vehicles.size(); j++)
        {
            randomlyPosition(vehicles.get(j));
        }
    }

    // This method removes the vehicles on the screen
    private void clear(ActionEvent e)
    {
        drawPane.getChildren().clear();
        vehicles.clear();
    }

    // This method moves a vehicle to a random position
    private void randomlyPosition(Vehicle v)
    {
        v.setPosition(
                generator.nextDouble()*MAX_X_POS,
                generator.nextDouble()*MAX_Y_POS);
    }

    // This method returns a random color
    private Color randomColor()
    {
        return new Color(generator.nextDouble(), // red component
                generator.nextDouble(), // green component
                generator.nextDouble(), // blue component
                1.0);                   // opacity
    }

    // The main method is only needed for IDEs with limited JavaFX support
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
