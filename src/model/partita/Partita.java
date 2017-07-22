package model.partita;

import model.carta.Carta;
import model.insiemeDiCarte.Mazzetto;
import model.insiemeDiCarte.MazzoDiGioco;
import model.Tavolo;
import model.giocatore.Giocatore;
import network.CodiceNotifica;
import network.server.RemotePlayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Pinos on 19/05/2017.
 */
public  class Partita implements Serializable{

    private int numeroDiGiocatori;
    //private MazzoDiGioco mazzoDiGioco = new MazzoDiGioco();
    private Tavolo tavolo = new Tavolo();
    private transient HashMap<String, RemotePlayer> giocatori = new HashMap<>();
    private ArrayList<RemotePlayer> giocatoriTurno = new ArrayList<>();
   //private RemotePlayer giocatoreCorrente;
    private String giocatoreCorrente;
    private int turno = 1;
    private int numAzione = 1;
    private Azione azione = new Azione();

    public Partita(int numeroDiGiocatori){
        this.numeroDiGiocatori = numeroDiGiocatori;

    }

    public RemotePlayer getGiocatore(String giocatoreId){
        return giocatori.get(giocatoreId);
    }

    public void tiraCartaSulTavolo(String giocatoreId, Carta carta){

        if(giocatoreId.equals(giocatoreCorrente)){
            azione.tiraCartaSulTavolo(getGiocatore(giocatoreId), carta, tavolo);
            //aggiornaGiocatori();
            cambiaTurno();
            aggiornaGiocatori();
        }
    }

    public void selezionaCartaInTavola(String giocatoreId, Carta carta){

        if(azione.selezionaCartaInTavola(tavolo,carta, getGiocatore(giocatoreId)) && giocatoreId.equals(giocatoreCorrente)){

            //aggiornaGiocatori();
            cambiaTurno();
            aggiornaGiocatori();
        }
    }

    public void selezionaCartaInMano(String giocatoreId, Carta carta){

        if(azione.selezionaCartaInMano(getGiocatore(giocatoreId),carta, tavolo) && giocatoreId.equals(giocatoreCorrente)){

            //aggiornaGiocatori();
            cambiaTurno();
            aggiornaGiocatori();
        }
    }

    public void selezionaMazzetto(String giocatoreId, Mazzetto mazzetto){

        Mazzetto a = null;
        for(RemotePlayer tmp: giocatori.values()){


            if(tmp.getMazzetto().toString().equals(mazzetto.toString())){

                 a = tmp.getMazzetto();
            }
        }

        if(a != null && azione.selezionaMazzetto(a, getGiocatore(giocatoreId)) && giocatoreId.equals(giocatoreCorrente)){

            //aggiornaGiocatori();
            cambiaTurno();
            aggiornaGiocatori();
        }
    }

    public boolean aggiungiGiocatore(RemotePlayer giocatore){
        if(giocatori.values().size() == numeroDiGiocatori)
            return false;
        giocatori.put(giocatore.getGiocatoreId(), giocatore);
        giocatore.notifica(CodiceNotifica.ENTRATO_IN_PARTITA);
        System.out.println(giocatori.values());
        if(giocatori.values().size() == numeroDiGiocatori) {
            giocatoriTurno.addAll(giocatori.values());
            giocatoreCorrente = giocatoriTurno.get(0).getGiocatoreId();
            giocatori.get(giocatoreCorrente).setMioTurno(true);
            setPartita();
            iniziaGioco();
            distribuisciCarteAiGiocatori();
            aggiornaGiocatori();
        }
        return true;
    }


    public void distribuisciCarteAiGiocatori(){
        //for(int i = 0; i < numeroDiGiocatori; i++){
        if(tavolo.getMazzoDiGioco().size() > 0) {
            for (Giocatore tmp : giocatori.values()) {
                tmp.setMano(tavolo.getMazzoDiGioco());
            }
            //}
            aggiornaGiocatori();
        }
    }

    public void setPartita(){
        tavolo.setTavolo();
    }

    public void checkVincitore(){
        int size = -1;

        for(RemotePlayer tmp: giocatori.values()){
            if(tmp.getMazzetto().size() > size && !tmp.getLasciaGioco()){
                size = tmp.getMazzetto().size();
            }
        }
        for(RemotePlayer tmp: giocatori.values()){
            if(tmp.getMazzetto().size() == size && !tmp.getLasciaGioco())
                tmp.setVincitore(true);
        }

        aggiornaGiocatori();
    }

    public void cambiaTurno(){
        if(checkCambioTurno()){
            distribuisciCarteAiGiocatori();
            if(turno == 12/ numeroDiGiocatori){ //todo è 12
                checkVincitore();
                return;
            }
            turno++;

        }
        cambiaGiocatoreCorrente();
    }

    public void cambiaGiocatoreCorrente(){
        for(int i = 0; i < giocatoriTurno.size()-1; i++){
            if(giocatoreCorrente.equals(giocatoriTurno.get(i).getGiocatoreId())){
                giocatoreCorrente = giocatoriTurno.get(i+1).getGiocatoreId();
                for(RemotePlayer tmp: giocatori.values()){
                    if(tmp.getGiocatoreId().equals(giocatoreCorrente))
                        tmp.setMioTurno(true);
                    else
                        tmp.setMioTurno(false);
                }
                return;
            }
        }
        giocatoreCorrente = giocatoriTurno.get(0).getGiocatoreId();

        for(RemotePlayer tmp: giocatori.values()){
            if(tmp.getGiocatoreId().equals(giocatoreCorrente))
                tmp.setMioTurno(true);
            else
                tmp.setMioTurno(false);
        }

    }

    public void aggiornaGiocatori(){
        ArrayList<RemotePlayer> players = new ArrayList<>();
        players.addAll(giocatori.values());
        for(RemotePlayer tmp: giocatori.values()){
            tmp.aggiorna(tavolo, players);
        }
    }

    public boolean checkCambioTurno(){

        for(Giocatore tmp: giocatori.values()){
            if(tmp.getMano().getCarteInMano().size() > 0)
                return false;
        }
        return true;
    }

    public void iniziaGioco(){
        //cambiaGiocatoreCorrente();
        ArrayList<RemotePlayer> players = new ArrayList<>();
        players.addAll(giocatori.values());
        for(RemotePlayer tmp: giocatori.values()){
            tmp.iniziaGioco(tavolo, players);
        }
    }


    public void abbandonaPartita(String giocatoreId){
        getGiocatore(giocatoreId).setLasciaGioco(true);
        checkVincitore();
        aggiornaGiocatori();

    }





}

