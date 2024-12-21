package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));

            // Create the Scene and set it on the Stage
            Scene scene = new Scene(root);
            stage.setTitle("Painter Application");
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException e) {
            System.err.println("FXML file not found. Please ensure Painter.fxml is located in the correct package.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while starting the application.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
//hihi