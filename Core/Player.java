package Core;

import java.util.Vector;

public abstract class Player {
    int life;
    Deck deck;
    Vector<Card> hand;
    Vector<Card> graveyard;
    //Console commandInterface;

    // Damage dealing is the game's responsibility. The player can only lose life.
    public abstract void removeLife(int ammount);
    public abstract void play(GameEnums.Zone zone, int pos);
    public abstract void shuffle(GameEnums.Zone zone);
    public abstract void takeTurn();
    
}