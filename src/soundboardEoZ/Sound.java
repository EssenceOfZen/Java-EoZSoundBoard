package soundboardEoZ;

/**
 * Created by zenoo on 9/7/2016.
 *
 */
class Sound {
    private String name;
    private String sound_file_location;

    Sound(){
        name = "";
        sound_file_location = "";
    }

    Sound(String initial_name){
        name = initial_name;
        sound_file_location = "";
    }

    Sound(String initial_name, String initial_location){
        name = initial_name;
        sound_file_location = initial_location;
    }


}
