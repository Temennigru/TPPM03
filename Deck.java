import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public int numberOfCards;
    private ArrayList<Card> cards = new ArrayList<Card>();
    //private ArrayList<Card> discardedCards = new ArrayList<Card>();
    private Random rand;
    
    //Construtor
    public Deck(){
        rand = new Random();
        createDeck();
        shuffle();
    }
    
    //enche o deck com cartas
    private void createDeck(){
        //for (int i = 0; i < numCards ; i++){
            //cards.add (new Card());
        //}
    }
    
    //embaralha o deck
    public void shuffle(){
        for (int i=0 ; i < cards.size(); i++){
            int x = rand.nextInt(cards.size());
            int y = rand.nextInt(cards.size());
            Card temp = cards.get(x);
            cards.set(x,cards.get(y);
            cards.set(y,temp);
        }
    }
    
    //retorna true se o deck nao tem mais cartas
    public boolean isEmpty() {
        return cards.size() == 0;
    }
    
    public Card draw() throws EmptyDeckException{
        if (cards.size == 0) {
            throw new EmptyDeckException();
        }
        return cards.remove(0);
    }  
}
