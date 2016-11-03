package soundboardEoZ;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Controller {
    int index = 1;
    int target = 10;

    @FXML
    GridPane sound_bites_grid;

    public void initialize(){ /*This is called when the program runs*/
        System.out.println("Hey");

        String location = System.getProperty("user.dir"); // SystemGrabs the project directory
        int length = getNumbersOfFiles(location + "/settings/");
        System.out.println("Running some things: " + location);
        System.out.println("Number of files in Settings: " + length);

        while(index <= target){
            Button sound_button = new Button("Button_" + index);
            sound_bites_grid.add(sound_button,index,1);
            index++;
        }

    }

    int getNumbersOfFiles(String directory){
        int length = new File(directory).listFiles().length;

        return length;
    }

    void addButton(){
        Button sound_button = new Button("Button_" + index);
        sound_bites_grid.add(sound_button, index,2);
    }

}
