import java.util.ArrayList;

public class Hand {
    private ArrayList<card> cards;
    private Player player;

    void addCard (Card c) {
        cards.add(c);
    }
    
    //verificar na discard phase
    public int size (){
        return cards.size();
    }

    //public boolean isEmpty(){
        //return cards.size() == 0;
    //}
    
}

