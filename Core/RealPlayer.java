package Core;
import Cards.Abstract.*;
import java.util.Vector;


public class RealPlayer extends Player {
    private int life;
    //private Deck deck;
    protected Vector<Card> hand;
    protected Vector<Card> graveyard;
    public int[] manaPool;
    private String name;
    //Console commandInterface;

    // Damage dealing is the game's responsibility. The player can only lose life.

    public RealPlayer (Deck deck) {
    	this.life = 20;
    	//this.deck = deck;
    	this.hand = new Vector<Card>();
    	this.graveyard = new Vector<Card>();
    	this.manaPool = new int[6]; // RGBUWC
    }

    public void removeLife(int ammount) {
    	this.life -= ammount;
    }

    public void shuffle(GameEnums.Zone zone) {
    	//this.deck.shuffle();
    }

    public void takeTurn() {}

    public void addMana(String mana) { 
      	for (int i = 0; i < mana.length(); i++) {
        	switch (mana.charAt(i)) {
            	case 'R':
            		this.manaPool[0]++;
            		break;
            	case 'G':
            		this.manaPool[1]++;
            		break;
            	case 'B':
            		this.manaPool[2]++;
            		break;
            	case 'U':
            		this.manaPool[3]++;
            		break;
            	case 'W':
            		this.manaPool[4]++;
            		break;
            	default:
            		if (Character.isDigit(mana.charAt(i))) {
            			this.manaPool[5]++;
            		} else {
            			assert false;
            		}
            		break;
        	}
    	}
    }

}