package model.insiemeDiCarte;

import model.carta.Carta;
import model.insiemeDiCarte.Mazzo;

/**
 * Created by Pinos on 10/06/2017.
 */
public class Mazzetto extends Mazzo {




    public Carta mostraPrimaCarta(){

        if(mazzo.size() != 0)
          return mazzo.peek();
        else return null;
    }

    @Override
    public void pushCarta(Carta carta) {
        super.pushCarta(carta);
    }

    @Override
    public Carta popCarta() {
        return super.popCarta();
    }


    @Override
    public String toString() {
        return mazzo.toString();
    }
}
