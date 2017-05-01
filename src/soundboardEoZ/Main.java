/* Essence Of Zen Soundboard
*       This program is designed for the Essence Of Zen Podcast: After Dark
*       Feel free to use it for your purposes but credit the creators and source.
*
*       Created by: Zane "ZenOokami" Blalock
*       EssenceOfZen.org/
*
*
*
* */

/* This file is essentially the start of the program, but the Controller.java file is what runs the GUI's actions
* */

// todo: Create a "LogSnoot" for Java, implement it into this program.
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
    /*The Controller is tied to this stage via the sample.fxml where it sets fx:controller equal to our controller*/
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("EoZ Soundboard -- http://EssenceOfZen.org/#Software");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
