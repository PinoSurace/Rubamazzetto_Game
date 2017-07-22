package model.giocatore;

import model.insiemeDiCarte.Mazzetto;
import model.insiemeDiCarte.MazzoDiGioco;
import model.carta.Carta;

import java.io.Serializable;

/**
 * Created by Pinos on 18/05/2017.
 */
public class Giocatore implements Serializable{

    String id;
    Mano mano = new Mano();
    Mazzetto mazzetto = new Mazzetto();

    public Carta selezionaCartaInMano(Carta carta){
        for(Carta tmp: mano.getCarteInMano()){
            if(tmp.equals(carta)){
                return tmp;
            }
        }
        return null;
    }

    public void aggiungiCartaInMano(Carta carta){
        mano.aggiungiCarta(carta);
    }

    public void aggiungiCartaAlMazzetto(Carta carta){
        mazzetto.pushCarta(carta);
    }

    public void giocaCarta(Carta carta){

        mano.rimuoviCarta(carta);

    }

    public void setMano(MazzoDiGioco mazzoDiGioco){
        for(int i = 0 ; i < 3; i++){
            mano.aggiungiCarta(mazzoDiGioco.popCarta());
        }
    }

    public Mazzetto getMazzetto(){
        return mazzetto;
    }

    public Mano getMano() {
        return mano;
    }
}
