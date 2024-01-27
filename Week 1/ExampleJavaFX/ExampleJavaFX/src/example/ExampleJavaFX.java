package example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ExampleJavaFX extends Application
{
    @Override
    public void start(Stage stage)
    {
        // Create new Labels
        Label label1 = new Label("Hello World!");
        Label label2 = new Label("Welcome to CSCI 202.");
        Label label3 = new Label("This is an example JavaFX program.");

        // Create a VBox and add our Labels to it
        VBox pane = new VBox();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().addAll(label1, label2, label3);

        // Create a Scene and place our pane in it
        Scene scene = new Scene(pane);
        stage.setTitle("Example JafaFX");  // set title of stage
        stage.setScene(scene);     // place scene in the stage
        stage.show();              // display the scene
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
