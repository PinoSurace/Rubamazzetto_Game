package model.partita;
import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;

import java.io.Serializable;

/**
 * Created by Pinos on 19/05/2017.
 */
public class Azione implements Serializable{
    Carta cartaInManoSelezionata;
    Carta cartaDaTavoloSelezionata;
    Mazzetto mazzettoSelezionato;

    public boolean tiraCartaSulTavolo(Giocatore giocatore, Carta carta, Tavolo tavolo){
        giocatore.giocaCarta(carta);
        tavolo.aggiungiCarta(carta);


        cartaInManoSelezionata = null;
        cartaDaTavoloSelezionata = null;
        mazzettoSelezionato = null;
        return true;

    }

    public boolean selezionaCartaInMano(Giocatore giocatore, Carta carta, Tavolo tavolo) {

        cartaInManoSelezionata = carta;
        if(cartaDaTavoloSelezionata != null){

            return prendiCarte(giocatore, tavolo );
        }
        if(mazzettoSelezionato != null){
            return prendiMazzetto(giocatore);
        }
        return false;
    }

    public boolean selezionaCartaInTavola(Tavolo tavolo, Carta carta, Giocatore giocatore) {
        cartaDaTavoloSelezionata = carta;
        mazzettoSelezionato = null;
        if(cartaInManoSelezionata != null){

            return prendiCarte(giocatore,tavolo);
        }
        return false;
    }

    public boolean selezionaMazzetto(Mazzetto mazzetto, Giocatore giocatore){
        mazzettoSelezionato = mazzetto;
        cartaDaTavoloSelezionata = null;
        if(cartaInManoSelezionata != null){
            return prendiMazzetto(giocatore);
        }
        return false;
    }

    public boolean prendiCarte(Giocatore giocatore, Tavolo tavolo){
        if(cartaInManoSelezionata.getValore().equals(cartaDaTavoloSelezionata.getValore())) {

            giocatore.aggiungiCartaAlMazzetto(cartaDaTavoloSelezionata);
            giocatore.aggiungiCartaAlMazzetto(cartaInManoSelezionata);
            tavolo.rimuoviCarta(cartaDaTavoloSelezionata);
            giocatore.giocaCarta(cartaInManoSelezionata);
            cartaInManoSelezionata = null;
            cartaDaTavoloSelezionata = null;
            return true;
        }
        cartaInManoSelezionata = null;
        cartaDaTavoloSelezionata = null;
        mazzettoSelezionato = null;
        return false;
    }

    public boolean prendiMazzetto(Giocatore giocatore){
        if(cartaInManoSelezionata.getValore().equals(mazzettoSelezionato.mostraPrimaCarta().getValore())){
            while(mazzettoSelezionato.size() > 0){

                giocatore.aggiungiCartaAlMazzetto(mazzettoSelezionato.popCarta());
            }
            giocatore.aggiungiCartaAlMazzetto(cartaInManoSelezionata);
            giocatore.giocaCarta(cartaInManoSelezionata);
            cartaInManoSelezionata = null;
            cartaDaTavoloSelezionata = null;
            mazzettoSelezionato = null;
            return true;
        }
        cartaInManoSelezionata = null;
        cartaDaTavoloSelezionata = null;
        mazzettoSelezionato = null;
        return false;
    }
































    //giocatore tira la carta
    //controlla le cose uguali
    // giocatore prende


    //per ogni giocatore controlla il mazzetto e nel caso prendi quello più grosso


    //controlla se la carta selezionata è uguale o la somma
    //prendi le carte (aggiungi al mazzzo personale
    //

}
