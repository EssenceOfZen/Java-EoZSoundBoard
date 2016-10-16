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

    @FXML private GridPane button_grid;
    int sound_index = 0;
    private Sound sounds[] = {new Sound("Clap"), new Sound("Shouting", "/music"), new Sound()};

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

//        Sound sounds[]; // We create an array that will hold our sounds objects


        for (Sound sound : sounds) {
            // Add buttons to the gui!



        }
    }

    private void addButton(){
        final Button temporary = new Button()
    }



    public static void main(String[] args) {
        launch(args);
    }
}
