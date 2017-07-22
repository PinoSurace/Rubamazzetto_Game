package model.giocatore;

import model.carta.Carta;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Pinos on 18/05/2017.
 */
public class Mano  implements Serializable {
    ArrayList<Carta> carteInMano = new ArrayList<>();

    public void setCarteInMano(ArrayList<Carta> carteInMano) {
        this.carteInMano = carteInMano;
    }

    public ArrayList<Carta> getCarteInMano() {
        return carteInMano;
    }


    public void aggiungiCarta(Carta carta) {
        carteInMano.add(carta);
    }

    public void rimuoviCarta(Carta carta) {

        for(Carta tmp: carteInMano){
            if(tmp.toString().equals(carta.toString())) {
                carteInMano.remove(tmp);

                return;
            }
        }

    }

}
