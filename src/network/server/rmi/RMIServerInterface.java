package network.server.rmi;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.client.rmi.RMIClientInterface;
import network.server.RemotePlayer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Pinos on 28/06/2017.
 */
public interface RMIServerInterface extends Remote {

    void selezionaCartaInMano(String giocatoreId, Carta carta)throws RemoteException;
    void selezionaCartaInTavola( Carta carta, String giocatoreId)throws RemoteException;
    void tiraCartaSulTavolo( Carta carta, String giocatoreId)throws RemoteException;
    void selezionaMazzetto(Mazzetto mazzetto, String giocatoreId)throws RemoteException;
    void creaPartita(String giocatoreId, int NUMBER_OF_PLAYERS ) throws RemoteException;
    void entraInPartita(String giocatoreId) throws RemoteException;
    void login(String giocatoreId, String username,RMIClientInterface rmiClientInterface)throws RemoteException;
    void abbandonaPartita(String giocatoreId)throws RemoteException;


}
