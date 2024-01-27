package lab1_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Lab1_1 extends Application
{
    @Override
    public void start(Stage stage)
    {
        // Create new labels
        Label greetLbl = new Label("Greetings intellectual being.");
        Label nameLbl = new Label("My name is Adam Bruce.");
        Label ageLbl = new Label("I am 31 years old.");
        Label fromLbl = new Label("I am from Green Bay, WI.");

        // Create an VBox and add our Labels to it
        VBox pane = new VBox();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().addAll(greetLbl, nameLbl, ageLbl, fromLbl);

        // Create a Scene and place our pane in it.
        Scene scene = new Scene(pane);
        stage.setTitle("Lab1_1"); // Set title of stage
        stage.setScene(scene); // place scene in the stage
        stage.show(); // display the stage
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
