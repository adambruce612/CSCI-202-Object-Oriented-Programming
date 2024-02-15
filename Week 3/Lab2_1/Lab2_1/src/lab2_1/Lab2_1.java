package lab2_1;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Lab2_1 extends Application
{
    @Override
    public void start(Stage stage)
    {
        // TODO: Add code here to draw the house
        Group group = new Group();

        // Create the walls of the house
        Rectangle walls = new Rectangle(0, 100, 200, 150);
        walls.setFill(Color.RED);
        group.getChildren().add(walls);

        // Create the door of the house
        Rectangle door = new Rectangle(25, 150,55, 150);
        door.setFill(Color.web("rgb(109, 89, 89)"));
        group.getChildren().add(door);

        // Create the window
        Rectangle window = new Rectangle(125, 150, 50, 50);
        window.setFill(Color.web("hsl(157, 62%, 80%)"));
        window.setStroke(Color.BLACK);
        group.getChildren().add(window);

        // Create roof
        Polygon roof = new Polygon();
        roof.setFill(Color.web("#974E00")); // roof color is brown
        roof.getPoints().addAll(0.0, 100.0);
        roof.getPoints().addAll(100.0, 0.0);
        roof.getPoints().addAll(200.0, 100.0);
        group.getChildren().add(roof);

        // Create the sun
        Circle sun = new Circle(0,0,40); // center (0,0), radius 40
        sun.setFill(Color.YELLOW);
        group.getChildren().add(sun);

        // Create pane and add the group
        Pane mainPane = new Pane(group);

        // Set the background color of the main pane
        mainPane.setStyle("-fx-background-color: lightblue");

        // Create the scene and place it on the main stage
        Scene scene = new Scene(mainPane, 200, 250);
        stage.setTitle("Lab2_1");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // The main() method is only needed for IDEs with limited JavaFX support
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
