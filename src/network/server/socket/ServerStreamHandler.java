package network.server.socket;

import model.carta.Carta;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by Pinos on 29/06/2017.
 */
public class ServerStreamHandler {

    private ObjectOutputStream output;
    private ObjectInputStream input;
    private SocketPlayer player;

    private HashMap<CodiceNotifica, ResponseInnerInterface> responseMap = new HashMap<>();

    public ServerStreamHandler(ObjectOutputStream output, ObjectInputStream input, SocketPlayer player){
        this.input = input;
        this.output = output;
        this.player = player;
        fillMap();
    }

    private void fillMap(){

        responseMap.put(CodiceNotifica.LOGIN_RICHIESTA, this::login);
        responseMap.put(CodiceNotifica.ENTRA_IN_PARTITA_RICHIESTA, this::entraInPartita);
        responseMap.put(CodiceNotifica.CREA_NUOVA_PARTITA_RICHIESTA, this::creaPartita);
        responseMap.put(CodiceNotifica.SELEZIONA_CARTA_IN_MANO_RICHIESTA, this::selezionaCartaInMano);
        responseMap.put(CodiceNotifica.SELEZIONA_CARTA_IN_TAVOLA_RICHIESTA, this::selezionaCartaInTavola);
        responseMap.put(CodiceNotifica.SELEZIONA_MAZZETTO_RICHIESTA, this::selezionaMazzetto);
        responseMap.put(CodiceNotifica.TIRA_CARTA_RICHIESTA, this::tiraCarta);
        responseMap.put(CodiceNotifica.ABBANDONA_PARTITA_RICHIESTA, this::abbandonaPartita);
    }

    public void login(){
        try {
            String giocatoreId = (String) input.readObject();
            String username = (String) input.readObject();
            player.login(giocatoreId, username);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore login");
        }
    }

    public void entraInPartita(){
        player.entraInPartita();

    }

    public void creaPartita(){
        try {
            int numeroDiGiocatori = (int) input.readObject();
            player.creaPartita(numeroDiGiocatori);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore crea partita");
        }



    }

    public void abbandonaPartita(){
        player.abbandonaPartita();
    }

    public void selezionaCartaInMano(){
        try {
            Carta carta = (Carta) input.readObject();
            player.selezionataCartaInMano(carta);//todo sistema che non va

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore seleziona carta in mano");
        }


    }

    public void selezionaCartaInTavola(){
        try {
            Carta carta = (Carta) input.readObject();
            player.selezionataCartaInTavola(carta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore seleziona carta in tavola");
        }

    }

    public void selezionaMazzetto(){
        try {
            Mazzetto mazzetto = (Mazzetto) input.readObject();
            player.selezionatoMazzetto(mazzetto);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore seleziona mazzetto");
        }

    }
    public void tiraCarta(){
        try {
            Carta carta = (Carta) input.readObject();
            player.tirataCartaSulTavolo(carta);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore tira carta");
        }

    }

    public void respond(CodiceNotifica codiceNotifica) {
        ResponseInnerInterface handler = responseMap.get(codiceNotifica);

        if (handler != null) {
            handler.operate();
        }
        else System.out.println("errore notifica");
    }

    @FunctionalInterface
    public interface ResponseInnerInterface {
        void operate();
    }

}
