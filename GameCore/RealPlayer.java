package GameCore;

import GameCore.GameObjectCore.*;
import GameCore.ConsoleCore.*;
import java.util.Vector;


public class RealPlayer extends Player {
    // Damage dealing is the game's responsibility. The player can only lose life.

    public RealPlayer(String name) {
    	this.life = 20;
    	this.name = name;
        this.commandInterface = new PlayerConsoleImpl(this);
    	this.hand = new Vector<Card>();
    	this.graveyard = new Vector<Card>();
    }

    public void removeLife(int ammount) {
    	this.life -= ammount;
    }

    public void takeTurn() {}

}