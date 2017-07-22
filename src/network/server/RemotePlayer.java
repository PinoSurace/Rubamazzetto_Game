package network.server;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import model.partita.Partita;
import network.CodiceNotifica;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Pinos on 10/06/2017.
 */
public abstract class RemotePlayer extends Giocatore{
    private String giocatoreId;
    private String username;
    private Partita partita;
    private boolean mioTurno;
    private boolean lasciaGioco;
    private boolean vincitore;

    public void setLasciaGioco(boolean lasciaGioco) {
        this.lasciaGioco = lasciaGioco;
    }

    public void setVincitore(boolean vincitore) {
        this.vincitore = vincitore;
    }

    public void abbandonaPartita(){
        getPartita().abbandonaPartita(giocatoreId);

    }

    public boolean getLasciaGioco() {
        return lasciaGioco;
    }

    public boolean getVincitore() {
        return vincitore;
    }

    public void setMioTurno(boolean mioTurno) {
        this.mioTurno = mioTurno;
    }

    public boolean getMioTurno(){
        return mioTurno;
    }

    public void setId(String giocatoreId){
        this.giocatoreId = giocatoreId;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public abstract void selezionataCartaInMano(Carta carta);
    public abstract void selezionataCartaInTavola( Carta carta);
    public abstract void selezionatoMazzetto(Mazzetto mazzetto);
    public abstract void tirataCartaSulTavolo( Carta carta);
    public Partita getPartita(){
        return partita;
    }
    public void setPartita(Partita partita){
        this.partita = partita;
    }
    public String getGiocatoreId(){
        return giocatoreId;
    }
    public abstract void notifica(CodiceNotifica codiceNotifica);
    public abstract void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori);
    public abstract void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori);


}
