package network.client.rmi;

import model.Tavolo;
import model.giocatore.Giocatore;
import network.CodiceNotifica;
import network.client.ClientInterface;
import network.server.RemotePlayer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Pinos on 28/06/2017.
 */
public interface RMIClientInterface extends Remote{
    ClientInterface getClientController()throws RemoteException;

    void notifica(CodiceNotifica codiceNotifica) throws RemoteException;

    void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) throws RemoteException;
    void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) throws RemoteException;
}
