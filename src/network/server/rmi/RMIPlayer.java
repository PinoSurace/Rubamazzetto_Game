package network.server.rmi;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import model.partita.Partita;
import network.CodiceNotifica;
import network.client.rmi.RMIClientInterface;
import network.server.RemotePlayer;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Pinos on 10/06/2017.
 */
public class RMIPlayer extends RemotePlayer{

    public RMIPlayer(RMIClientInterface rmiClientInterface, String clientId){

        this.rmiclientInterface = rmiClientInterface;
        setId(clientId);

    }

    private  transient RMIClientInterface rmiclientInterface;

    @Override
    public void selezionataCartaInMano( Carta carta) {

        getPartita().selezionaCartaInMano(getGiocatoreId(), carta);
    }

    @Override
    public void selezionataCartaInTavola( Carta carta) {

        getPartita().selezionaCartaInTavola(getGiocatoreId(), carta);

    }

    public void tirataCartaSulTavolo( Carta carta){

        getPartita().tiraCartaSulTavolo(getGiocatoreId(), carta);
    }

    @Override
    public void selezionatoMazzetto(Mazzetto mazzetto) {
        getPartita().selezionaMazzetto(getGiocatoreId(), mazzetto);

    }

    public Partita getPartita(){
        return super.getPartita();
    }

    public void setPartita(Partita partita){
        super.setPartita(partita);
    }

    @Override
    public void notifica(CodiceNotifica codiceNotifica) {
        try {
            rmiclientInterface.notifica(codiceNotifica);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        try {
            rmiclientInterface.aggiorna(tavolo, giocatori);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        try {
            rmiclientInterface.iniziaGioco(tavolo, giocatori);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }


}
