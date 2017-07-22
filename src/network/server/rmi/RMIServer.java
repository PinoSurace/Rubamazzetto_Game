package network.server.rmi;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.client.rmi.RMIClientInterface;
import network.server.AbstractServer;
import network.server.RemotePlayer;
import network.server.ServerInterface;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Pinos on 10/06/2017.
 */
public class RMIServer extends AbstractServer implements RMIServerInterface{
    public RMIServer(ServerInterface serverController){
        super(serverController);
    }

    @Override
    public void startServer(int port) {
        System.out.println("RMI Server started");
        try{
            Registry reg;
            try{
                reg = LocateRegistry.createRegistry(port);
                System.out.println("java RMI registry created");
            }catch (Exception e){
                System.out.println("Using existing registry");
                reg = LocateRegistry.getRegistry();
            }

            reg.bind("RMIServerInterface", this);
            UnicastRemoteObject.exportObject(this, port);

        }catch (RemoteException e){
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selezionaCartaInMano(String giocatoreId, Carta carta) throws RemoteException {

        getServerController().getGiocatore(giocatoreId).selezionataCartaInMano(carta);

    }

    @Override
    public void selezionaCartaInTavola(Carta carta, String giocatoreId) throws RemoteException {
        getServerController().getGiocatore(giocatoreId).selezionataCartaInTavola(carta);

    }

    @Override
    public void selezionaMazzetto(Mazzetto mazzetto, String giocatoreId) throws RemoteException {
        getServerController().getGiocatore(giocatoreId).selezionatoMazzetto(mazzetto);

    }

    public void tiraCartaSulTavolo( Carta carta, String giocatoreId){

        getServerController().getGiocatore(giocatoreId).tirataCartaSulTavolo(carta);
    }

    @Override
    public void creaPartita(String giocatoreId, int numeroDiGiocatori) throws RemoteException {


        getServerController().creaPartita(giocatoreId, numeroDiGiocatori);

    }

    @Override
    public void entraInPartita(String giocatoreId) throws RemoteException {
        getServerController().entraInPartita(giocatoreId);

    }

    @Override
    public void login(String giocatoreId, String username, RMIClientInterface rmiClientInterface) throws RemoteException {
        RMIPlayer giocatore = new RMIPlayer(rmiClientInterface,giocatoreId);
        getServerController().login(giocatoreId,username, giocatore);


    }

    @Override
    public void abbandonaPartita(String giocatoreId) throws RemoteException {
        getServerController().getGiocatore(giocatoreId).abbandonaPartita();

    }
}
