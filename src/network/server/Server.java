package network.server;

import model.partita.Partita;
import network.CodiceNotifica;
import network.server.rmi.RMIServer;
import network.server.socket.SocketServer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pinos on 10/06/2017.
 */
public class Server implements ServerInterface{

    private RMIServer rmiServer = new RMIServer(this);
    private SocketServer socketServer = new SocketServer(this);

    private final Object MUTEX = new Object();

    private final int RMI_PORT = 6789;
    private final int SOCKET_PORT = 9876;

    private HashMap<String, RemotePlayer> listaGiocatori = new HashMap<>(); //key: id
    private HashMap<String, String> listaUsername = new HashMap<>();

    private ArrayList<Partita> partite = new ArrayList<>();

    public Server(){

    }

    private void startServer(){
        rmiServer.startServer(RMI_PORT);
        socketServer.startServer(SOCKET_PORT);
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();

    }

    @Override
    public RemotePlayer getGiocatore(String giocatoreId) {
        return listaGiocatori.get(giocatoreId);
    }

    @Override
    public void login(String giocatoreId, String username, RemotePlayer giocatore) {
        synchronized (MUTEX) {

            listaGiocatori.put(giocatoreId, giocatore);
            listaUsername.put(giocatoreId, username);


        }
        getGiocatore(giocatoreId).notifica(CodiceNotifica.LOGIN_OK);
    }




    @Override
    public void entraInPartita(String giocatoreId) {
        synchronized (MUTEX) {
            try {

                if(partite.size() == 0)
                    return;

                getGiocatore(giocatoreId).setUsername(listaUsername.get(giocatoreId));

                for(Partita tmp: partite){

                    if(tmp.aggiungiGiocatore(getGiocatore(giocatoreId)))
                        getGiocatore(giocatoreId).setPartita(tmp);

                }

                if(partite.get(partite.size()-1).aggiungiGiocatore(getGiocatore(giocatoreId))){
                    //getGiocatore(giocatoreId).notifica(CodiceNotifica.ENTRATO_IN_PARTITA);
                    getGiocatore(giocatoreId).setPartita(partite.get(partite.size() -1));
                    //getGiocatore(giocatoreId).getPartita().aggiornaGiocatori();

                }

            } catch ( ArrayIndexOutOfBoundsException e) {
                System.out.println("partita non disponibile");
                getGiocatore(giocatoreId).notifica(CodiceNotifica.ERRORE);
            }
        }
    }

    @Override
    public void creaPartita(String giocatoreId, int numeroDiGiocatori) {
        synchronized (MUTEX) {
            Partita partita = new Partita(numeroDiGiocatori);

            getGiocatore(giocatoreId).setUsername(listaUsername.get(giocatoreId));
            getGiocatore(giocatoreId).setPartita(partita);
            partita.aggiungiGiocatore(getGiocatore(giocatoreId));
            partite.add(partita);
            getGiocatore(giocatoreId).notifica(CodiceNotifica.PARTITA_CREATA);


        }
    }
}
