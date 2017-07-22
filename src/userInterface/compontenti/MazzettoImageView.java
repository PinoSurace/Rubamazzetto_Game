package userInterface.compontenti;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import model.carta.Carta;
import model.insiemeDiCarte.Mazzetto;
import network.server.RemotePlayer;
import userInterface.compontenti.CartaImageView;

import java.awt.*;

/**
 * Created by Pinos on 02/07/2017.
 */
public class MazzettoImageView extends CartaImageView {
    private RemotePlayer giocatore;

    public MazzettoImageView(){


        giocatore = null;
    }



    @Override
    public Carta getCarta() {
        return super.getCarta();
    }

    @Override
    public void setCarta(Carta carta) {
        super.setCarta(carta);
    }

    public RemotePlayer getRemotePlayer() {
        return giocatore;
    }

    public void setRemotePlayer(RemotePlayer giocatore) {
        this.giocatore = giocatore;

    }
}
