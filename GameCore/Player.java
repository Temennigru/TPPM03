package GameCore;

import java.util.Vector;
import GameCore.GameObjectImpl.Cards.*;
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
    private int[] manaPool = new int[6]; // RGBUWC
    // protected Console commandInterface; Obsolete
    protected int numberLandDrops = 1;

    protected boolean dead = false;

    private int poison = 0;

    // Damage dealing is the game's responsibility. The player can only lose life.

    protected Player() {}
    public Player(String name) {}

    public int life() {
        return this.life;
    }

    public abstract void removeLife(int ammount);

    public abstract void takeTurn();

    public int poison() {
        return this.poison;
    }
    
    public void poison(int val) {
        this.poison += val;
    }

    public void setDeck(Deck deck) {
        this.library = deck;
    }

    public void shuffle() {
        this.library.shuffle();
    }

    public boolean landDrop() {
        if (numberLandDrops < 1) {
            return false;
        }
        numberLandDrops--;
        return true;
    }

    public void landDrop(int val) {
        this.numberLandDrops = val;
    }

    private int[] getResultingMana(String mana, GameEnums.ManaPoolDirection direction) {
        int addSub;
        int[] resultingMana = new int[6];
        resultingMana[0] = 0;
        resultingMana[1] = 0;
        resultingMana[2] = 0;
        resultingMana[3] = 0;
        resultingMana[4] = 0;
        resultingMana[5] = 0;

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
                    resultingMana[0] += addSub * 1;
                    break;
                case 'G':
                    resultingMana[1] += addSub * 1;
                    break;
                case 'B':
                    resultingMana[2] += addSub * 1;
                    break;
                case 'U':
                    resultingMana[3] += addSub * 1;
                    break;
                case 'W':
                    resultingMana[4] += addSub * 1;
                    break;
                default:
                    if (Character.isDigit(mana.charAt(i))) {
                        int j = i;
                        while (i < mana.length() && Character.isDigit(mana.charAt(i))) { i++; }
                        resultingMana[5] += addSub * Integer.parseInt(mana.substring(j, i));
                        i--;
                    } else {
                        assert false;
                    }
                    break;
            }
        }

        // Set resulting mana
        for (int i = 0; i < 6; i++) {
            resultingMana[i] += this.manaPool[i];
        }

        return resultingMana;
    }

    private int[] getResultingMana(int[] mana, GameEnums.ManaPoolDirection direction) {
        if (mana.length != 6) {
            throw new GameExceptions.WrongManaColorAmmountException(mana.length);
        }

        int[] resultingMana = new int[6];
        resultingMana[0] = this.manaPool[0];
        resultingMana[1] = this.manaPool[1];
        resultingMana[2] = this.manaPool[2];
        resultingMana[3] = this.manaPool[3];
        resultingMana[4] = this.manaPool[4];
        resultingMana[5] = this.manaPool[5];


        switch (direction) {
            case ADD:
                resultingMana[0] += mana[0];
                resultingMana[1] += mana[1];
                resultingMana[2] += mana[2];
                resultingMana[3] += mana[3];
                resultingMana[4] += mana[4];
                resultingMana[5] += mana[5];
                break;
            case SUB:
                resultingMana[0] -= mana[0];
                resultingMana[1] -= mana[1];
                resultingMana[2] -= mana[2];
                resultingMana[3] -= mana[3];
                resultingMana[4] -= mana[4];
                resultingMana[5] -= mana[5];
                break;
            default: // Bad
                addSub = 0;
                assert false;
                break;
        }

        return resultingMana;
    }

    public boolean spendable(String mana) {

        int[] resultingMana = getResultingMana(mana, direction);

        for (int i = 0; i < 6; i++) {

            if (resultingMana[i] < 0) {
                return false; // Not enough mana in pool
            }
        }
        return true;
    }


    public boolean spendable(int[] mana) {

        int[] resultingMana = getResultingMana(mana, direction);

        for (int i = 0; i < 6; i++) {

            if (resultingMana[i] < 0) {
                return false; // Not enough mana in pool
            }
        }
        return true;
    }

    private boolean manaPoolManip(String mana, GameEnums.ManaPoolDirection direction) {

        int[] resultingMana = getResultingMana(mana, direction);

        // Check if resulting mana is negative
        for (int i = 0; i < 6; i++) {

            if (resultingMana[i] < 0) {
                return false; // Not enough mana in pool

                /* Obsolete code
                else { // Colorless mana can be negative
                    // TODO: Implement support for multicolored decks (this only checks one color)
                    for (int j = 0; j < 6; j++) { // mana[i] = colorless, mana[j] = colored
                        if (resultingMana[j] + resultingMana[i] >= 0) {
                            resultingMana[j] += resultingMana[i]; // Add colorless debt from colored mana
                            resultingMana[i] = 0; // Debt paid
                        }
                    } // Monocolored support only ends here

                    if (resultingMana[i] < 0) { return false; } // If after subtracting colored mana there is still a debt, the transaction failed.
                    
                }*/
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

    public String getManaPool() {
        String ret = "";
        if (this.manaPool[5] != 0) { ret += Integer.toString(manaPool[5]); }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < this.manaPool[i]; j++) {
                switch (i) {
                    case 0:
                        ret += "R";
                        break;
                    case 1:
                        ret += "G";
                        break;
                    case 2:
                        ret += "B";
                        break;
                    case 3:
                        ret += "U";
                        break;
                    case 4:
                        ret += "W";
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("Mana pool: " + ret + String.format("%n"));
        return ret;
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

    public final void lose() throws GameExceptions.GameException {
        this.dead = true;
        System.out.println (this.name + " has lost");
        GameCore game = GameCore.getGame();
        //if (game.m_currentPlayer == this) {
            throw new GameExceptions.CurrentPlayerLostException(this);
        //}
    }

    public final boolean lost() { return this.dead; } // No cheating =)
    /* Obsolete
    public final Card prompt() throws IOException, InterruptedException { return this.commandInterface.prompt(); }

    public final Card prompt(boolean playerOnly) throws IOException, InterruptedException { return this.commandInterface.prompt(playerOnly); }
    */
    
}