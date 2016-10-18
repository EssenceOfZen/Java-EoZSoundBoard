package soundboardEoZ;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    int index = 1;
    int target = 10;

    @FXML
    GridPane sound_bites_grid;

    public void initialize(){ /*This is called when the program runs*/
        System.out.println("Hey");
        while(index <= target){
            Button sound_button = new Button("Button_" + index);
            sound_bites_grid.add(sound_button,index,1);
            index++;
        }

    }

    void test(){
        System.out.println("Testing");
    }

    void addButton(){
        Button sound_button = new Button("Button_" + index);
        sound_bites_grid.add(sound_button, index,2);
    }

}
