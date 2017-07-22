package network.server.socket;

import model.Tavolo;
import model.carta.Carta;
import model.giocatore.Giocatore;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;
import network.server.RemotePlayer;
import network.server.ServerInterface;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pinos on 10/06/2017.
 */
public class SocketPlayer extends RemotePlayer implements Runnable {

    private transient ServerInterface serverController;

    private transient ObjectInputStream input;
    private transient ObjectOutputStream output;
    private transient ServerStreamHandler streamHandler;

    public SocketPlayer(ServerInterface serverController, Socket clientSocket) {

        this.serverController = serverController;
        try {
            input = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            output = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            output.flush();
        } catch (IOException e){
            System.out.println("errore stream non inizializzati");
        }
        streamHandler = new ServerStreamHandler(output, input, this);
    }

    @Override
    public void run(){
        try {
            while (true) {

               CodiceNotifica codiceNotifica = (CodiceNotifica) input.readObject();

                streamHandler.respond(codiceNotifica);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("errore run");

            e.printStackTrace();
        } finally {
            closeStream(input);
            closeStream(output);
        }
    }
    private void closeStream(Closeable closeable){
        try {
            closeable.close();
        } catch (IOException e) {
            System.out.println("errore chiusura stream");
        }
    }

    @Override
    public void selezionataCartaInMano(Carta carta) {
        getPartita().selezionaCartaInMano(getGiocatoreId(), carta);
    }

    @Override
    public void selezionataCartaInTavola(Carta carta) {
        getPartita().selezionaCartaInTavola(getGiocatoreId(), carta);
    }

    @Override
    public void selezionatoMazzetto(Mazzetto mazzetto) {
        getPartita().selezionaMazzetto(getGiocatoreId(), mazzetto);
    }

    @Override
    public void tirataCartaSulTavolo(Carta carta) {

        getPartita().tiraCartaSulTavolo(getGiocatoreId(), carta);
    }

    @Override
    public void notifica(CodiceNotifica codiceNotifica) {
        try {
            //first write string
            output.writeObject(CodiceNotifica.NOTIFICA);
            output.writeObject(codiceNotifica);
            output.flush();
        } catch (IOException e) {
            System.out.println("errore notifica");
        }

    }

    @Override
    public void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        try {
            output.reset();
            output.writeObject(CodiceNotifica.AGGIORNA);
            output.writeObject(tavolo);
            output.writeObject(giocatori);

            output.flush();
        } catch (IOException e){
            System.out.println("errore aggiorna");
            e.printStackTrace();
        }

    }

    @Override
    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        try {

            output.writeObject(CodiceNotifica.INIZIA_GIOCO);
            output.writeObject(tavolo);
            output.writeObject(giocatori);

            output.flush();
        } catch (IOException e){
            System.out.println("errore inizia gioco");
            e.printStackTrace();
        }

    }

    public void creaPartita(int numeroDiGiocatori){
        serverController.creaPartita(this.getGiocatoreId(), numeroDiGiocatori);
    }

    public void entraInPartita(){
        serverController.entraInPartita(this.getGiocatoreId());
    }

    public void login(String giocatoreId, String username){
        setId(giocatoreId);
        serverController.login(giocatoreId, username, this);

    }


}
