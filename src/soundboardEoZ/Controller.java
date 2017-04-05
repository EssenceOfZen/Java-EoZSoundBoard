package soundboardEoZ;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;


public class Controller {
    private String directory = System.getProperty("user.dir"); // System Grabs the project directory
    private int index = 0;

    @FXML
    GridPane sound_bites_grid;
    
    @FXML
    GridPane sound_effects_grid;

    public void initialize(){ /*This is called when the program runs*/
        // Check to see if our Directories are there
        createFolder("soundbites");
        createFolder("soundeffects");



        //int soundeffects_length = getNumbersOfFiles(directory + "/settings/");

        System.out.println("Project Directory: " + directory);

        //System.out.println(files[1].getName());


        // What we need to do here is replace this [while function] with another that uses the [length] variable
        // We then should then grab them file by file - using the name of the file for the text.

//        while(index <= target){
//            // Todo: add a sub loop that counts how many items are on each line.
//            // We're starting at 0, ending at 10 -- when we go over 10 (so 11) we want to switch the sub target to 2 for rowindex
//            // Since we're using ints - we can do ((index / 10) + 1) which will give us the row number we want
//            Button sound_button = new Button("Button_" + index);
//            sound_bites_grid.add(sound_button,index,1);
//            index++;
//        }


        // Sound Effects =========================
        int sound_effects_target = getNumbersOfFiles(directory + "/soundeffects/");
        File soundeffects_files[] = getFiles(directory + "/soundeffects/");

        int sound_effects_per_column = 5;

        for(index = 0; index < sound_effects_target; index++){
//            Button sound_button = new Button("Button_" + index);
            Button sound_button = new Button(soundeffects_files[index].getName());
            sound_effects_grid.add(sound_button,(index%sound_effects_per_column),((index / sound_effects_per_column) + 1));

            //System.out.println(files[index].getName());

            sound_button.setOnAction(event -> playSound(sound_button, "soundeffects/"));

        }

        // Sound Bites ==========================
        int sound_bites_per_column = 8;
        int sound_bites_target = getNumbersOfFiles(directory + "/soundbites/");
        File soundbites_files[] = getFiles(directory + "/soundbites/");

        for(index = 0; index < sound_bites_target; index++){
            Button sound_button = new Button(soundbites_files[index].getName());
            sound_bites_grid.add(sound_button,(index%sound_bites_per_column),((index / sound_bites_per_column) + 1));

            sound_button.setOnAction(event -> playSound(sound_button, "soundbites/"));
        }

    }



    private void createFolder(String folder_name){
        File folder = new File(folder_name);

        try{
            folder.mkdir(); // creating our directory
            System.out.println("Creating folder: " + folder_name);

        }catch (SecurityException security_exception){
            //System.out.println(security_exception);
            throw security_exception;

        }
    }


    private int getNumbersOfFiles(String directory){
        int number_of_files = new File(directory).listFiles().length;
        System.out.println("Number of files in " + directory + ": " + number_of_files);

        // return new File(directory).listFiles().length;
        return number_of_files;
    }


    private File[] getFiles(String directory){
        File[] files = new File(directory).listFiles();
        //System.out.println(files[0]);
        //System.out.println(files[0].getName());

        return files;
    }

    private void addButton(){
        Button sound_button = new Button("Button_" + index);
        sound_bites_grid.add(sound_button, index,2);
    }

    private void playSound(Button sound_button, String directory){
        Media activated = new Media(new File(directory + sound_button.getText()).toURI().toString());
        MediaPlayer player = new MediaPlayer(activated);
        player.play();
        System.out.println("Playing: " + sound_button.getText());
    }

    private void stopSound(){
        
    }

}
