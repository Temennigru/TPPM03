package GameCore;

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

    protected boolean dead = false;

    // Damage dealing is the game's responsibility. The player can only lose life.

    protected Player() {}
    public Player(String name, Deck deck) {}

    public abstract void removeLife(int ammount);
    public abstract void shuffle(GameEnums.Zone zone);
    public abstract void takeTurn();



    private void manaPoolManip(String mana, GameEnums.ManaPoolDirection direction) {
        int addSub;
        int manaR = 0;
        int manaG = 0;
        int manaB = 0;
        int manaU = 0;
        int manaW = 0;
        int manaC = 0;

        switch (direction) {
            case ADD:
                addSub = 1;
                break;
            case SUB:
                addSub = -1;
                break;
            default: // 
                assert false;
                break;
        }

        for (int i = 0; i < mana.length(); i++) {
            switch (mana.charAt(i)) {
                case 'R':
                    manaR += addSub;
                    break;
                case 'G':
                    manaG += addSub;
                    break;
                case 'B':
                    manaB += addSub;
                    break;
                case 'U':
                    manaU += addSub;
                    break;
                case 'W':
                    manaW += addSub;
                    break;
                default:
                    if (Character.isDigit(mana.charAt(i))) {
                        int j = i;
                        while (Character.isDigit(mana.charAt(i))) { i++; }
                        manaW += addSub * Integer.parseInt(mana.substring(j, i));
                    } else {
                        assert false;
                    }
                    break;
            }
        }

        // TODO: Implement mana prompt
        manaR += this.manaPool[0];
    }

    public abstract void addMana(String mana) {
        manaPoolManip(mana, GameEnums.ManaPoolDirection.ADD);
    }

    public abstract void removeMana(String mana) {
        manaPoolManip(mana, GameEnums.ManaPoolDirection.SUB);
    }

    public void addToHand      (Card card) throws GameExceptions.GameException {
        if (card.m_owner != this) { throw new GameExceptions.WrongOwnerException(card, card.m_owner, this); }
        this.hand.add(card); 
    }

    public void addToLibrary   (Card card) throws GameExceptions.GameException {
        if (card.m_owner != this) { throw new GameExceptions.WrongOwnerException(card, card.m_owner, this); }
        this.library.add(card);
    }

    public void addToGraveyard (Card card) throws GameExceptions.GameException {
        if (card.m_owner != this) { throw new GameExceptions.WrongOwnerException(card, card.m_owner, this); }
        this.graveyard.add(card);
    }

    public final void lose () { this.dead = true; }

    public final boolean lost() { return this.dead; } // No cheating =)
}