package GameCore;

import java.util.ArrayList;
import java.util.Random;
import GameCore.GameObjectCore.*;
import java.util.Iterator;

public abstract class Deck {
    public int numCards;
    protected ArrayList<Card> cards = new ArrayList<Card>();
    //private ArrayList<Card> discardedCards = new ArrayList<Card>();
    private Random rand;
    protected Player m_owner;
    
    //Construtor
    private Deck(){}
    public Deck (Player player){ m_owner = player; this.createDeck(); }

    //enche o deck com cartas
    protected abstract void createDeck();
    
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    //embaralha o deck
    public final void shuffle(){
        rand = new Random();
        for (int i=0 ; i < cards.size(); i++){
            int x = rand.nextInt(cards.size() - 1);
            int y = rand.nextInt(cards.size() - 1);
            Card temp = cards.get(x);
            cards.set(x,cards.get(y));
            cards.set(y,temp);
        }
    }
    
    //retorna true se o deck nao tem mais cartas
    public final boolean isEmpty() {
        return cards.size() == 0;
    }
    
    public final void add (Card card) {
        this.cards.add(card);
    }

    public final Card draw(){
        if (cards.size() == 0) {
            return null;
        }
        return cards.remove(0);
    }  
}
