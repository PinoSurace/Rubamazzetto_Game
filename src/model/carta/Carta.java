package model.carta;

import java.io.Serializable;

/**
 * Created by Pinos on 18/05/2017.
 */
public class Carta implements Serializable{
    private Seme seme;
    private Valore valore;

    public Carta(Seme seme, Valore valore){
        this.seme = seme;
        this.valore = valore;
    }



    public Seme getSeme() {
        return seme;
    }

    public Valore getValore() {
        return valore;
    }

    public void setSeme(Seme seme) {
        this.seme = seme;
    }

    public void setValore(Valore valore) {
        this.valore = valore;
    }

    @Override
    public String toString() {
        return valore.getValore() + seme.getSeme();
    }
}
