package soundboardEoZ;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    //private Sound sounds[] = {new Sound("Clap"), new Sound("Shouting", "/music"), new Sound()};

    @Override
    public void start(Stage primaryStage) throws Exception{ /*Main class main method that starts the gui*/
    /*We basically state that we load the fxml file as our resources and set the stage for the window*/
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
