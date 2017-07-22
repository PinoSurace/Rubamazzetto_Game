package userInterface.compontenti;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Pinos on 06/07/2017.
 */
public class SelezioneImageView extends ImageView {
    public String name;
    public SelezioneImageView(Image image, String name){
        super(image);
        this.name = name;

        super.setFitHeight(50);
        super.setFitWidth(50);


    }

    public String getName() {
        return name;
    }
}
