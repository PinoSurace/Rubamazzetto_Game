package network;

/**
 * Created by Pinos on 29/06/2017.
 */
public enum CodiceNotifica {
    OK,
    ERRORE,
    LOGIN_OK,
    ENTRATO_IN_PARTITA,
    PARTITA_CREATA,
    AGGIORNA,
    INIZIA_GIOCO,
    NOTIFICA,


    //---------------------richieste
    LOGIN_RICHIESTA,
    SELEZIONA_CARTA_IN_MANO_RICHIESTA,
    CREA_NUOVA_PARTITA_RICHIESTA,
    ENTRA_IN_PARTITA_RICHIESTA,

    SELEZIONA_MAZZETTO_RICHIESTA,
    SELEZIONA_CARTA_IN_TAVOLA_RICHIESTA,
    TIRA_CARTA_RICHIESTA,
    ABBANDONA_PARTITA_RICHIESTA;
}
