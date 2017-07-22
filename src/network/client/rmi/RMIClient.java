package network.client.rmi;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;
import network.client.AbstractClient;
import network.client.ClientInterface;
import network.server.RemotePlayer;
import network.server.rmi.RMIServerInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by Pinos on 10/06/2017.
 */
public class RMIClient extends AbstractClient implements RMIClientInterface {

    private transient String ipAddress;
    private transient int port;
    private transient RMIServerInterface rmiServerInterface;
    private  transient ClientInterface clientController;



    public RMIClient(ClientInterface clientController, int port){
        this.ipAddress = "127.0.0.1";
        this.port = port;
        this.clientController = clientController;
    }
    @Override
    public void connetti() {

        try{
            Registry registry = LocateRegistry.getRegistry(ipAddress, port);
            rmiServerInterface = (RMIServerInterface) registry.lookup("RMIServerInterface");
            UnicastRemoteObject.exportObject(this, 0);


        }
        catch (RemoteException e) {}

        catch (NotBoundException e) {}
    }

    @Override
    public void abbandonaPartita() {
        try {
            rmiServerInterface.abbandonaPartita(getId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ClientInterface getClientController() {
        return clientController;
    }

    @Override
    public void notifica(CodiceNotifica codiceNotifica) throws RemoteException {
        clientController.mostraNotifica(codiceNotifica);
    }

    @Override
    public void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) throws RemoteException {
        clientController.aggiorna(tavolo, giocatori);
    }
    @Override
    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) throws RemoteException{
        clientController.iniziaGioco(tavolo, giocatori);
    }

    public String getId(){
        return clientController.getId();
    }

    public String getUsername(){
        return clientController.getUsername();
    }

    @Override
    public void selezionaCartaInMano(Carta carta) {
        try {

            rmiServerInterface.selezionaCartaInMano( getId(),carta);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void selezionaCartaInTavola( Carta carta) {
        try {
            rmiServerInterface.selezionaCartaInTavola(carta,getId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void selezionaMazzetto(Mazzetto mazzetto) {
        try {
            rmiServerInterface.selezionaMazzetto(mazzetto,getId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void tiraCartaSulTavolo( Carta carta){
        try {

            rmiServerInterface.tiraCartaSulTavolo(carta,getId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void creaPartita( int numeroDiGiocatori) {
        try {
            rmiServerInterface.creaPartita(getId(), numeroDiGiocatori);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void entraInPartita() {
        try {
            rmiServerInterface.entraInPartita(getId());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void login() {
        try {
            rmiServerInterface.login(getId(), getUsername(), this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
