package model.insiemeDiCarte;

import model.carta.Carta;

import java.io.Serializable;
import java.util.Stack;

/**
 * Created by Pinos on 18/05/2017.
 */
public class Mazzo implements Serializable{
    protected Stack<Carta> mazzo = new Stack<>();

    public Carta popCarta(){
        Carta carta = mazzo.peek();
        mazzo.pop();
        return carta;
    }

    public void pushCarta(Carta carta){
        mazzo.push(carta);
    }

    public int size(){
        return mazzo.size();
    }

}
