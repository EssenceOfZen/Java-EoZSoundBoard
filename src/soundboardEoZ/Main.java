/* This file is essentially the start of the program, but the Controller.java file is what runs the GUI's actions
* */

package soundboardEoZ;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //private Sound sounds[] = {new Sound("Clap"), new Sound("Shouting", "/music"), new Sound()};

    @Override
    public void start(Stage primaryStage) throws Exception{ /*Main class main method that starts the gui*/
    /*We basically state that we load the fxml file as our resources and set the stage for the window*/
    /*The MainController is tied to this stage via the Main.fxml where it sets fx:controller equal to our controller*/
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("EoZ Soundboard -- http://EssenceOfZen.org/#Software");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
