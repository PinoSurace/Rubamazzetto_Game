package userInterface.compontenti;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.carta.Carta;

/**
 * Created by Pinos on 02/07/2017.
 */
public class CartaImageView extends ImageView {
    Carta carta;



    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public void setImmagine(Image image){
        super.setImage(image);
    }
}
