package network.client;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;
import network.server.RemotePlayer;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Pinos on 28/06/2017.
 */
public interface ClientInterface {
    void selezionaCartaInMano( Carta carta);
    void selezionaCartaInTavola( Carta carta);
    void selezionaMazzetto(Mazzetto mazzetto);
    void tiraCartaSulTavolo( Carta carta);
    void creaPartita(int numeroDiGiocatori);
    void entraInPartita();
    void login();
    void setConnessioneRMI();
    void setConnessioneSocket();
    String getId();
    String getUsername();
    void setUsername(String username);
    void mostraNotifica(CodiceNotifica codiceNotifica) ;
    void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori);
    void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori);
    void abbandonaPartita();
}
