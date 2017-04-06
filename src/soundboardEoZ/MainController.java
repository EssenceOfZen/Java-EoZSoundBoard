package soundboardEoZ;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;


public class MainController {
    // Class global variables
    private String directory = System.getProperty("user.dir"); // System Grabs the project directory
    private int index = 0;
    private Media current_sound;
    private MediaPlayer player = null;

    // FXML IDs to variables --------
    @FXML GridPane sound_bites_grid;
    @FXML GridPane sound_effects_grid;
    @FXML GridPane music_sting_grid;
    @FXML Slider time_slider;
    @FXML Button stop_button;
    @FXML Label status_indicator;

    public void initialize(){ /*This is called when the program runs*/
        // Check to see if our Directories are there
        createFolder("soundbites");
        createFolder("soundeffects");
        createFolder("musicstings");



        //int soundeffects_length = getNumbersOfFiles(directory + "/settings/");

        System.out.println("Project Directory: " + directory);


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


        // Music Stings ==========================
        int stings_per_column = 8;
        int stings_target = getNumbersOfFiles(directory + "/musicstings/");
        File stings_files[] = getFiles(directory + "/musicstings/");

        for(index = 0; index < stings_target; index++){
            Button sound_button = new Button(stings_files[index].getName());
            music_sting_grid.add(sound_button,(index%stings_per_column),((index / stings_per_column) + 1));

            sound_button.setOnAction(event -> playSound(sound_button, "musicstings/"));
        }

        stop_button.setOnAction(event -> stopSound());

    }


    public void newLine(){
        System.out.println();
    }


    private void createFolder(String folder_name){
        File folder = new File(folder_name);

        try{
            if(folder.isDirectory()){
                System.out.println("Folder: " + folder_name + " already exists.");
            }else{
                folder.mkdir(); // creating our directory
                System.out.println("Creating folder: " + folder_name);
            }

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
        // Check to see if sound is playing, if so, stop it!
        if(player != null){
            player.stop();

        }

        current_sound = new Media(new File(directory + sound_button.getText()).toURI().toString());
        player = new MediaPlayer(current_sound);

        // Set the MediaPlayer to be ready so the sound file is properly loaded - meaning we can grab data.
        player.setOnReady(new Runnable() {
            @Override
            public void run() {

                player.play();
                status_indicator.setText(sound_button.getText());

                System.out.println("Playing: " + sound_button.getText());

                System.out.println("Duration: " + current_sound.getDuration().toSeconds());

                // Run while the media player is changing in time
                player.currentTimeProperty().addListener((observable, oldValue, newValue) ->{
                    //System.out.println(player.getCurrentTime().toSeconds());
                    //System.out.println("Player:" + observable + " | Changed from playing at: " + oldValue + " to play at " + newValue);

                    // Set the slider's max volume to the max of the selected sound file
                    time_slider.setMax(current_sound.getDuration().toSeconds());
                    // Update the slider's value as the file plays
                    time_slider.setValue(player.getCurrentTime().toSeconds());
                });
            }
        });
        newLine();

    }

    private void stopSound(){
        player.stop();
    }


}
