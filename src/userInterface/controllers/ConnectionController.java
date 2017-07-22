package userInterface.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Pinos on 10/07/2017.
 */
public class ConnectionController extends Controller{

    @FXML
    private JFXButton buttonRMI;

    @FXML
    private JFXButton buttonSocket;

    @FXML
    private ImageView image;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image.setImage(new Image("userInterface/immagini/login.png"));
        buttonRMI.setOnAction(e->  getGuiClient().setConnessioneRMI());
        buttonSocket.setOnAction(e-> getGuiClient().setConnessioneSocket());


    }
}
