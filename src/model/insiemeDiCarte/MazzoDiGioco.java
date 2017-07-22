package model.insiemeDiCarte;

import model.carta.Carta;
import model.carta.Seme;
import model.carta.Valore;
import model.insiemeDiCarte.Mazzo;

import java.util.Collections;

/**
 * Created by Pinos on 10/06/2017.
 */
public class MazzoDiGioco extends Mazzo {



    public void setMazzoDiGioco(){
        for(Seme s : Seme.values()){
            for(Valore v : Valore.values()){
                mazzo.push(new Carta(s , v));
            }
        }
    }

    @Override
    public Carta popCarta() {
        return super.popCarta();
    }

    @Override
    public void pushCarta(Carta carta) {
        super.pushCarta(carta);
    }

    public void mescolaMazzoDiGioco(){
        Collections.shuffle(mazzo);
    }

}
