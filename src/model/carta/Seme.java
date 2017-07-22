package model.carta;

import java.io.Serializable;

/**
 * Created by Pinos on 18/05/2017.
 */
public enum Seme implements Serializable{
    BASTONI("b"), COPPE("c"), DENARI("d"), SPADE("s");

    private String seme;

    Seme(String seme){
        this.seme = seme;
    }

    public String getSeme() {
        return seme;
    }


}
