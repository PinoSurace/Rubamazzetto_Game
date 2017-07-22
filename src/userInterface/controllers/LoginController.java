package userInterface.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Pinos on 04/07/2017.
 */
public class LoginController extends Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="pane"
    private Pane pane; // Value injected by FXMLLoader

   /* @FXML // fx:id="image"
    private ImageView image; // Value injected by FXMLLoader*/

    @FXML // fx:id="button"
    private JFXButton button; // Value injected by FXMLLoader

    @FXML // fx:id="username"
    private JFXTextField username; // Value injected by FXMLLoader

    @FXML
    private ImageView image;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        image.setImage(new Image("userInterface/immagini/login.png"));

        button.setText("Log In");
        button.setVisible(true);

        button.setOnAction(event -> {


            if(username.getText().isEmpty()){

                Platform.runLater(()->{getGuiClient().setUsername("Username");
                    getGuiClient().login();});

            }
            else{

                getGuiClient().setUsername(username.getText());
                getGuiClient().login();
            }

        });



    }
}
