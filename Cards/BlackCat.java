//reference: http://magiccards.info/m15/en/86.html

//TODO: opponent discards a card when it dies

package Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class BlackCat extends Creature {

	public BlackCat () {
        this.m_sub = { GameEnums.CreatureSubType.ZOMBIE, GameEnums.CreatureSubType.CAT }; 
        this.power = 1;
        this.toughness = 1;
        this.sick = true;
        this.manaCost = "1B";
        this.name = "BlackCat"
        this.description = "When Black Cat dies, target opponent discards a card at random.";
        this.flavor = "Its last life is spent tormenting your deams.";
	}

	public play (GameCore game) {
        this.power = 1;
        this.toughness = 1;
        this.sick = true;
	}
	
	public play (GameCore game, GameEnums.Zone zone){
		this.power = 1;
        this.toughness = 1;
        this.sick = true;
	}
	
	public void discard (GameCore game) {
       	this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameCore game, GameEnums.Zone zone) {
		this.place (game, zone, 0);
	}

    public void kill (GameCore game) {
    }

    public String toString() {
        return this.name + " - " + this.manaCost + System.lineSeparator() +
        "Creature - Zombie Cat" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
	}
}
