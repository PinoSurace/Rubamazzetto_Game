package network.client.socket;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;
import network.client.AbstractClient;
import network.client.ClientInterface;
import network.server.RemotePlayer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Pinos on 10/06/2017.
 */
public class SocketClient extends AbstractClient{
    private String ipAddress;
    private int port;
    private Socket socket;


    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ClientStreamHandler streamHandler;


    private ClientInterface clientInterface;

    public SocketClient(ClientInterface clientController,int port){
        this.clientInterface = clientController;
        this.ipAddress = "127.0.0.1";
        this.port = port;

    }

    public ClientInterface getClientInterface() {
        return clientInterface;
    }

    @Override
    public void connetti() {
        try {
            socket = new Socket(ipAddress, port);
        } catch (IOException e) {
            System.out.println("errore connessione");
        }
        initializeStreams();
        streamHandler = new ClientStreamHandler(input, this);

        new SocketClientListener(input, this).start();

    }

    @Override
    public void abbandonaPartita() {
        try {
            output.writeObject(CodiceNotifica.ABBANDONA_PARTITA_RICHIESTA);
            output.flush();
        } catch (IOException e) {
            System.out.println("errore richiesta abbandono partita");
        }
    }

    private void initializeStreams(){
        try {
            this.output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            output.flush();
            this.input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("errore inizializza streams");
        }

    }

    @Override
    public void selezionaCartaInMano(Carta carta) {
        try {
            output.writeObject(CodiceNotifica.SELEZIONA_CARTA_IN_MANO_RICHIESTA);
            output.writeObject(carta);
            output.flush();
        } catch (IOException e) {
            System.out.println("errore richiesta selezione carta in mano");
        }

    }

    @Override
    public void selezionaCartaInTavola(Carta carta) {
        try {
            output.writeObject(CodiceNotifica.SELEZIONA_CARTA_IN_TAVOLA_RICHIESTA);
            output.writeObject(carta);
            output.flush();
        } catch (IOException e) {
            System.out.println("errore richiesta selezione carta in tavola");
        }
    }

    @Override
    public void selezionaMazzetto(Mazzetto mazzetto) {
        try {
            output.writeObject(CodiceNotifica.SELEZIONA_MAZZETTO_RICHIESTA);
            output.writeObject(mazzetto);
            output.flush();
        } catch (IOException e) {
            System.out.println("errore richiesta selezione mazzetto");
        }

    }

    @Override
    public void tiraCartaSulTavolo(Carta carta) {
        try {
            output.writeObject(CodiceNotifica.TIRA_CARTA_RICHIESTA);
            output.writeObject(carta);
            output.flush();
        } catch (IOException e) {
            System.out.println("errore richiesta tira carta");
        }

    }

    @Override
    public void creaPartita(int numeroDiGiocatori) {
        try{
            output.writeObject(CodiceNotifica.CREA_NUOVA_PARTITA_RICHIESTA);
            output.writeObject(numeroDiGiocatori); //check if boxing is necessary
            output.flush();
        } catch (IOException e){
            System.out.println("errore reichiesta creazione partita");
        }

    }

    @Override
    public void entraInPartita() {
        try{
            output.writeObject(CodiceNotifica.ENTRA_IN_PARTITA_RICHIESTA);
            output.flush();
        } catch (IOException e){
            System.out.println("errore reichiesta entrata in partita");
        }

    }

    @Override
    public void login() {
        try{
            output.writeObject(CodiceNotifica.LOGIN_RICHIESTA);
            output.writeObject(clientInterface.getId());
            output.writeObject(clientInterface.getUsername());
            output.flush();
        } catch (IOException e){
            System.out.println("errore richiesta login");
        }

    }

    public void notifica(CodiceNotifica codiceNotifica){
        clientInterface.mostraNotifica(codiceNotifica);
    }

    public void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        clientInterface.aggiorna(tavolo, giocatori);
    }

    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        clientInterface.iniziaGioco(tavolo, giocatori);
    }

    public class SocketClientListener extends Thread {

        private ObjectInputStream input;
        private SocketClient socketClient;

        public SocketClientListener(ObjectInputStream input, SocketClient socketClient){
            this.input = input;
            this.socketClient = socketClient;
        }

        @Override
        public void run(){
            try {
                while (true) {

                    CodiceNotifica codiceNotifica = (CodiceNotifica) input.readObject();



                    //String serverRequestCode = (String) input.readObject();
                    System.out.println(codiceNotifica);
                    streamHandler.respond(codiceNotifica);
                }
            } catch (IOException | ClassNotFoundException  e) {
                System.out.println("errore stream handler non inizializzato");

                e.printStackTrace();
            }
        }
    }
}
