package GameCore;

import java.util.Vector;
import GameCore.Cards.*;
import GameCore.GameObjectCore.*;
import GameCore.ConsoleCore.*;

import java.io.IOException;
import java.io.InputStream;

public abstract class Player {
    public String name;
    protected int life;
    protected Deck library;
    protected Vector<Card> hand;
    protected Vector<Card> graveyard;
    private int[] manaPool;
    protected Console commandInterface;

    protected boolean dead = false;

    // Damage dealing is the game's responsibility. The player can only lose life.

    protected Player() {}
    public Player(String name, Deck deck) {}

    public abstract void removeLife(int ammount);
    public abstract void shuffle(GameEnums.Zone zone);
    public abstract void takeTurn();



    private boolean manaPoolManip(String mana, GameEnums.ManaPoolDirection direction) {
        int addSub;
        int[] resultingMana = new int[6];

        switch (direction) {
            case ADD:
                addSub = 1;
                break;
            case SUB:
                addSub = -1;
                break;
            default: // Bad
                addSub = 0;
                assert false;
                break;
        }

        // Set mana modifiers
        for (int i = 0; i < mana.length(); i++) {
            switch (mana.charAt(i)) {
                case 'R':
                    resultingMana[0] += addSub;
                    break;
                case 'G':
                    resultingMana[1] += addSub;
                    break;
                case 'B':
                    resultingMana[2] += addSub;
                    break;
                case 'U':
                    resultingMana[3] += addSub;
                    break;
                case 'W':
                    resultingMana[4] += addSub;
                    break;
                default:
                    if (Character.isDigit(mana.charAt(i))) {
                        int j = i;
                        while (Character.isDigit(mana.charAt(i))) { i++; }
                        resultingMana[5] += addSub * Integer.parseInt(mana.substring(j, i));
                    } else {
                        assert false;
                    }
                    break;
            }
        }

        // Set resulting mana
        // TODO: Implement mana prompt to chose color
        for (int i = 0; i < 6; i++) {
            resultingMana[i] += this.manaPool[i];
        }

        // Check if resulting mana is negative
        for (int i = 0; i < 6; i++) {

            if (resultingMana[i] < 0) {
                if (i != 5) { return false; } // Not enough colored mana in pool

                else { // Colorless mana can be negative
                    // TODO: Implement support for multicolored decks (this only checks one color)
                    for (int j = 0; j < 6; j++) { // mana[i] = colorless, mana[j] = colored
                        if (resultingMana[j] + resultingMana[i] > 0) {
                            resultingMana[j] += resultingMana[i]; // Add colorless debt from colored mana
                            resultingMana[i] = 0; // Debt paid
                        }
                    } // Monocolored support only ends here

                    if (resultingMana[i] < 0) { return false; } // If after subtracting colored mana there is still a debt, the transaction failed.
                }
            }
        }

        // Refresh values
        for (int i = 0; i < 6; i++) {
            this.manaPool[i] = resultingMana[i];
        }
        return true;
    }

    public void addMana(String mana) {
        manaPoolManip(mana, GameEnums.ManaPoolDirection.ADD);
    }

    public boolean removeMana(String mana) {
        return manaPoolManip(mana, GameEnums.ManaPoolDirection.SUB);
    }

    public void emptyManaPool() {
        for (int i = 0; i < 6; i++) {
            this.manaPool[i] = 0;
        }
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

    public final Card prompt() throws IOException, InterruptedException { return this.commandInterface.prompt(); }

    
}