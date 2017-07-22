package userInterface.controllers;

import javafx.fxml.Initializable;
import network.client.ClientInterface;
import userInterface.GuiClient;

/**
 * Created by Pinos on 02/07/2017.
 */
public abstract class Controller implements Initializable{
        private GuiClient guiClient;
    //private Loader loader;

    public GuiClient getGuiClient() {
        return guiClient;
    }

    public void setGuiClient(GuiClient guiClient) {
        this.guiClient = guiClient;
    }

}
