package userInterface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import userInterface.controllers.Controller;

/**
 * Created by Pinos on 04/07/2017.
 */
public class Loader {

    //this might become a singleton

    private GuiClient guiClient;
    private Stage window;

    public Loader(GuiClient guiClient, Stage stage) {
        this.guiClient = guiClient;
        window = stage;
    }

    private void buildStage(String title, String fxmlUrl, int width, int height) {
        window.setTitle(title);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlUrl));
            Parent root = fxmlLoader.load();
            Controller controller = fxmlLoader.getController();
            controller.setGuiClient(guiClient);
            guiClient.setController(controller);
            window.setScene(new Scene(root, width, height));

        } catch (Exception e) {
            e.printStackTrace();
        }
        window.setOnCloseRequest( e -> Runtime.getRuntime().exit(0) );
        window.show();
    }





    public void buildConnectionStage(){buildStage("Connessione", "fxml/connection.fxml", 398, 400);}
    public void buildLogInStage() {
        buildStage("Log In", "fxml/login.fxml", 398, 400);
    }
    public void buildLobbyStage() {
        buildStage("Lobby", "fxml/lobby.fxml", 380, 300);
    }
    public void buildMainGameStage(){
        buildStage("RUBAMAZZETTO", "fxml/gui.fxml", 1200, 800);
        window.setOnCloseRequest( e -> {
            guiClient.getClientController().abbandonaPartita();
        });
    }
}
