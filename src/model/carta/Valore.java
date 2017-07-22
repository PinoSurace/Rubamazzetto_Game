package model.carta;

import java.io.Serializable;

/**
 * Created by Pinos on 18/05/2017.
 */
public enum Valore implements Serializable{
    ASSO(1), DUE(2), TRE(3), QUATTRO(4), CINQUE(5), SEI(6), SETTE(7), DAMA(8), CAVALLO(9), RE(10);

    private int valore;

    Valore(int valore){
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }
}
