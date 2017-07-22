package userInterface;

import javafx.application.Platform;
import javafx.stage.Stage;
import model.Tavolo;
import model.carta.Carta;
import model.insiemeDiCarte.Mazzetto;
import network.CodiceNotifica;
import network.client.ClientInterface;
import network.server.RemotePlayer;
import userInterface.controllers.Controller;
import userInterface.controllers.GUIController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pinos on 03/07/2017.
 */
public class GuiClient {

    private int numeroDiGiocatori;
    private transient ClientInterface clientController;
    private transient HashMap<CodiceNotifica, uiInnerInterface> map = new HashMap<>();
    private Controller controller;
    private Loader loader;


    public GuiClient(ClientInterface clientController) {
        this.clientController = clientController;
        fillMap();
    }

    public void initializeLoader(Stage stage){
        loader = new Loader(this, stage);
        loader.buildConnectionStage();


        //loader.buildLogInStage();
    }

    public Controller getController(){
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public ClientInterface getClientController() {
        return clientController;
    }

    public String getId(){
        return clientController.getId();
    }

    private void fillMap(){
        map.put(CodiceNotifica.LOGIN_OK, this::loginEffettuato);
        map.put(CodiceNotifica.ENTRATO_IN_PARTITA, this::entratoInPartita);
        map.put(CodiceNotifica.PARTITA_CREATA, this::partitaCreata);
        map.put(CodiceNotifica.OK, this::operazioneOk);

    }


    public void setConnessioneRMI(){
        clientController.setConnessioneRMI();
        loader.buildLogInStage();
    }

    public void setConnessioneSocket(){
        clientController.setConnessioneSocket();
        loader.buildLogInStage();
    }

    public void login(){

        clientController.login();
    }
    public void creaPartita(int numberOfPlayers){
        numeroDiGiocatori = numberOfPlayers;
        clientController.creaPartita(numberOfPlayers);
    }
    public void entraInPartita(){
        clientController.entraInPartita();
    }
    public void selezionaCartaInMano(Carta carta){

        clientController.selezionaCartaInMano(carta);
    }
    public void selezionaCartaInTavola(Carta carta){
        clientController.selezionaCartaInTavola(carta);
    }
    public void selezionaMazzetto(Mazzetto mazzetto){
        clientController.selezionaMazzetto(mazzetto);
    }

    public void tiraCartaSulTavolo( Carta carta){

        clientController.tiraCartaSulTavolo(carta);}
    public void setUsername(String username){clientController.setUsername(username);}





    public void loginEffettuato() {

        Platform.runLater( () -> loader.buildLobbyStage() );
    }


    public void entratoInPartita() {
        Platform.runLater( () ->{
            loader.buildMainGameStage();



        });

    }


    public void partitaCreata() {
        Platform.runLater( () -> {
            loader.buildMainGameStage();
            ((GUIController) controller).creaPartita(numeroDiGiocatori);//todo passare numero di giocatori

        });

    }



    protected void operazioneOk() {

    }




    public synchronized void aggiorna(Tavolo tavolo, ArrayList<RemotePlayer> giocatori) {
        Platform.runLater(()->{
            ((GUIController)controller).aggiorna(tavolo, giocatori);}
        );

    }

    public void iniziaGioco(Tavolo tavolo, ArrayList<RemotePlayer> giocatori){
        Platform.runLater( () ->{
            loader.buildMainGameStage();
            ((GUIController)controller).iniziaGioco(tavolo, giocatori);

        });


    }





    public void updateUi(CodiceNotifica rc) {
        uiInnerInterface handler = map.get(rc);
        if (handler != null) {
            handler.update();
        }
        else System.out.println("errore update");
    }

    @FunctionalInterface
    private interface uiInnerInterface {
        void update();
    }



}
