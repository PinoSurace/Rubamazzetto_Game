package network.server;

/**
 * Created by Pinos on 28/06/2017.
 */
public interface ServerInterface {

    RemotePlayer getGiocatore(String giocatoreId);

    void login(String giocatoreId, String username, RemotePlayer player);

    void entraInPartita(String giocatoreId);

    void creaPartita(String giocatoreId, int numeroDiGiocatori);

}
