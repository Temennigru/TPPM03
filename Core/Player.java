package Core;

import java.util.Vector;
import Cards.Abstract.*;

public abstract class Player {
    public String name;
    private int life;
    protected Deck library;
    protected Vector<Card> hand;
    protected Vector<Card> graveyard;
    private int[] manaPool;
    //Console commandInterface;

    // Damage dealing is the game's responsibility. The player can only lose life.

    protected Player() {}
    public Player(String name, Deck deck) {}

    public abstract void removeLife(int ammount);
    public abstract void shuffle(GameEnums.Zone zone);
    public abstract void takeTurn();
    public abstract void addMana(String mana);

    public void addToHand      (Card card) throws GameExceptions.GameException {
        if (card.m_owner != this) { throw new GameExceptions.WrongOwnerException(card, card.m_owner, this); }
        this.hand.add(card); 
    }

    public void addToLibrary   (Card card) throws GameExceptions.GameException {
        if (card.m_owner != this) { throw new GameExceptions.WrongOwnerException(card, card.m_owner, this); }
        //this.library.add(card);
    }

    public void addToGraveyard (Card card) throws GameExceptions.GameException {
        if (card.m_owner != this) { throw new GameExceptions.WrongOwnerException(card, card.m_owner, this); }
        this.graveyard.add(card);
    }
}