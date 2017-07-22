package network.client;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Tavolo;
import model.carta.Carta;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;
import network.client.rmi.RMIClient;
import network.client.socket.SocketClient;
import network.server.RemotePlayer;
import userInterface.GuiClient;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Pinos on 10/06/2017.
 */
public class Client extends Application implements ClientInterface {
    private  String id = UUID.randomUUID().toString();
    private String username;

    private final int RMI_PORT = 6789;
    private final int SOCKET_PORT = 9876;

    private AbstractClient networkClient ;
    private GuiClient guiClient;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void mostraNotifica(CodiceNotifica codiceNotifica) {
        guiClient.updateUi(codiceNotifica);

    }

    @Override
    public void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        guiClient.aggiorna(tavolo,  giocatori);





    }

    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori){
        guiClient.iniziaGioco(tavolo, giocatori);
    }

    public Client(){

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        guiClient = new GuiClient(this);



        guiClient.initializeLoader(primaryStage);


    }



    public void setConnessioneRMI(){
        networkClient = new RMIClient(this, RMI_PORT);
        networkClient.connetti();
    }

    public void setConnessioneSocket(){
        networkClient = new SocketClient(this, SOCKET_PORT);
        networkClient.connetti();
    }



    public static void main(String[] args){
        Client c = new Client();
        c.launch();


    }

    @Override
    public void selezionaCartaInMano( Carta carta) {

        networkClient.selezionaCartaInMano(carta);
    }

    @Override
    public void selezionaCartaInTavola( Carta carta) {
        networkClient.selezionaCartaInTavola(carta);

    }

    @Override
    public void selezionaMazzetto(Mazzetto mazzetto) {
        networkClient.selezionaMazzetto(mazzetto);

    }
    @Override
    public void tiraCartaSulTavolo( Carta carta){

        networkClient.tiraCartaSulTavolo(carta);
    }

    @Override
    public void creaPartita( int numeroDIGiocatori) {
        networkClient.creaPartita(numeroDIGiocatori);

    }

    @Override
    public void entraInPartita() {
        networkClient.entraInPartita();

    }

    @Override
    public void login() {

        networkClient.login();

    }
    @Override
    public void abbandonaPartita(){
        networkClient.abbandonaPartita();
    }
}
