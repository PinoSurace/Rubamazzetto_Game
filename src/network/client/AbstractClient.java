package network.client;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.server.RemotePlayer;

import java.rmi.RemoteException;

/**
 * Created by Pinos on 10/06/2017.
 */
public abstract class AbstractClient {

    public abstract void selezionaCartaInMano(Carta carta);
    public abstract void selezionaCartaInTavola(Carta carta);
    public abstract void selezionaMazzetto(Mazzetto mazzetto);
    public abstract void tiraCartaSulTavolo(Carta carta);
    public abstract void creaPartita(int numeroDiGiocatori);
    public abstract void entraInPartita();
    public abstract void login();
    public abstract void connetti();
    public abstract void abbandonaPartita();

}
