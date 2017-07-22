package userInterface.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Pinos on 04/07/2017.
 */
public class LobbyController extends Controller {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton partita4;

    @FXML
    private JFXButton partita3;

    @FXML
    private JFXButton partita2;

    @FXML
    private JFXButton entraInPartita;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partita2.setOnAction(e -> getGuiClient().creaPartita(2));
        partita3.setOnAction(e-> getGuiClient().creaPartita(3));
        partita4.setOnAction(e-> getGuiClient().creaPartita(4));
        entraInPartita.setOnAction(e-> getGuiClient().entraInPartita());

    }
}
