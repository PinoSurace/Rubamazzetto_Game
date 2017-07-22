package model;

import model.carta.Carta;
import model.insiemeDiCarte.MazzoDiGioco;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Pinos on 18/05/2017.
 */
public class Tavolo implements Serializable{

    private ArrayList<Carta> carteInTavola = new ArrayList<>();
    private MazzoDiGioco mazzoDiGioco = new MazzoDiGioco();


    public void setTavolo(){
        inizializzaMazzoDiGioco();


        for(int i = 0; i < 4; i++){
            carteInTavola.add(mazzoDiGioco.popCarta());
        }
    }

    public void aggiungiCarta(Carta carta){
        carteInTavola.add(carta);
    }

    public Carta selezionaCarta(Carta carta){
        for(Carta tmp: carteInTavola){
            if(tmp.equals(carta))
                return tmp;
        }
        return null;
    }

    public ArrayList<Carta> getCarteInTavola(){
        return carteInTavola;
    }

    public void rimuoviCarta(Carta carta){

        for(Carta tmp: carteInTavola){
            if(tmp.toString().equals(carta.toString())) {
                carteInTavola.remove(tmp);

                return;
            }
        }
    }

    public MazzoDiGioco getMazzoDiGioco(){
        return mazzoDiGioco;
    }

    public void inizializzaMazzoDiGioco(){
        mazzoDiGioco.setMazzoDiGioco();
        mazzoDiGioco.mescolaMazzoDiGioco();

    }










}
