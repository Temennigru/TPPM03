package Core;

import java.util.Vector;
import Cards.Abstract.*;

public abstract class Player {
    private int life;
    protected Deck library;
    protected Vector<Card> hand;
    protected Vector<Card> graveyard;
    private int[] manaPool;
    //Console commandInterface;

    // Damage dealing is the game's responsibility. The player can only lose life.

    protected Player() {}
    public Player(Deck deck) {}

    public abstract void removeLife(int ammount);
    public abstract void shuffle(GameEnums.Zone zone);
    public abstract void takeTurn();
    public abstract void addMana(String mana);
    public void addToHand      (Card card) {}
    public void addToDeck      (Card card) {}
    public void addToGraveyard (Card card) {}
}