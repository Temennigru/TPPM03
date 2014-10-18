package Core;

import java.util.ArrayList;
import java.util.Random;
import Cards.Abstract.*;

public abstract class Deck {
    public int numCards;
    protected ArrayList<Card> cards = new ArrayList<Card>();
    //private ArrayList<Card> discardedCards = new ArrayList<Card>();
    private Random rand;
    
    //Construtor
    public abstract Deck(){
        rand = new Random();
        createDeck();
        shuffle();
    }
    
    //enche o deck com cartas
    private abstract void createDeck(){
        //for (int i = 0; i < numCards ; i++){
            //cards.add (new Card());
        //}
    }
    
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    //embaralha o deck
    public final void shuffle(){
        for (int i=0 ; i < cards.size(); i++){
            int x = rand.nextInt(cards.size());
            int y = rand.nextInt(cards.size());
            Card temp = cards.get(x);
            cards.set(x,cards.get(y));
            cards.set(y,temp);
        }
    }
    
    //retorna true se o deck nao tem mais cartas
    public final boolean isEmpty() {
        return cards.size() == 0;
    }
    
    //iteracao no deck, para acessar um elemento especifico, cards.get(3) acessaria esse elemento
    //public void accessDeck (Deck deck){
	//for (int i=0, n=cards.size(); i < n; i++)
    //     cards.get(i);
    //}

    public Card draw(){
        if (cards.size() == 0) {
            return null;
        }
        return cards.remove(0);
    }  
}
