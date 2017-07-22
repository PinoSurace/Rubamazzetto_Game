package network.client.socket;

import model.Tavolo;
import network.CodiceNotifica;
import network.server.RemotePlayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Pinos on 04/07/2017.
 */
public class ClientStreamHandler {

    private ObjectInputStream input;
    private SocketClient client;

    private HashMap<CodiceNotifica, ResponseInnerInterface> responseMap = new HashMap<>();

    public ClientStreamHandler(ObjectInputStream input, SocketClient client){
        this.input = input;
        this.client = client;
        fillMap();
    }

    private void fillMap(){

        responseMap.put(CodiceNotifica.NOTIFICA, this::notifica);
        responseMap.put(CodiceNotifica.AGGIORNA, this::aggiorna);
        responseMap.put(CodiceNotifica.INIZIA_GIOCO, this::iniziaGioco);


    }

    private void notifica(){
        try{
            CodiceNotifica codiceNotifica = (CodiceNotifica) input.readObject();
            client.notifica(codiceNotifica);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("errore notifica");
        }
    }


    private void aggiorna(){
        try {
            Tavolo tavolo = (Tavolo) input.readObject();
            ArrayList<RemotePlayer> players = (ArrayList<RemotePlayer>) input.readObject();
            client.aggiorna(tavolo, players);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("errore aggiornamento");
            e.printStackTrace();
        }
    }

    private void iniziaGioco(){
        try {
            Tavolo tavolo = (Tavolo) input.readObject();
            ArrayList<RemotePlayer> players = (ArrayList<RemotePlayer>) input.readObject();

            client.iniziaGioco(tavolo, players);
        } catch (IOException | ClassNotFoundException e){
            System.out.println("errore inizio gioco");
            e.printStackTrace();
        }
    }



    public void respond(CodiceNotifica codiceNotifica) {
        ResponseInnerInterface handler = responseMap.get(codiceNotifica);
        if (handler != null) {
            handler.operate();
        }
        else System.out.println("errore codice notifica");
    }

    @FunctionalInterface
    private interface ResponseInnerInterface {
        void operate();
    }
}
