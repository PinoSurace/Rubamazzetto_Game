package userInterface.compontenti;


import javafx.scene.control.Label;

/**
 * Created by Pinos on 04/07/2017.
 */
public class LabelImageView extends Label {
    private String giocatoreId;

    public LabelImageView(String id, String text){
        super(text);
        this.giocatoreId = id;
    }

    public void setGiocatoreId(String giocatoreId) {
        this.giocatoreId = giocatoreId;
    }

    public String getGiocatoreId() {
        return giocatoreId;
    }


}
