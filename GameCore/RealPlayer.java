package GameCore;

import GameCore.GameObjectCore.*;
import GameCore.ConsoleCore.*;
import java.util.Vector;


public class RealPlayer extends Player {
    private int life;
    public int[] manaPool;

    // Damage dealing is the game's responsibility. The player can only lose life.

    public RealPlayer(String name, Deck deck) {
    	this.life = 20;
    	this.name = name;
        this.commandInterface = new PlayerConsoleImpl(this);
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

}