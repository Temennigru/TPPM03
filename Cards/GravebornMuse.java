//reference: http://magiccards.info/10e/en/145.html

//TODO: at the beginning of your upkeep...

package Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class GravebornMuse extends Creature {

    boolean istapped = true;

	public GravebornMuse () {
        this.m_sub = { GameEnums.CreatureSubType.ZOMBIE, GameEnums.CreatureSubType.SPIRIT }; 
        this.power = 3;
        this.toughness = 3;
        this.sick = true;
        this.manaCost = "2BB";
        this.name = "Graveborn Muse"
        this.description = "At the beginning of your upkeep, you draw X cards and you lose X life, where X is the number of Zombies you control.";
        this.flavor = "Her voice is damnation, unyielding and certain. _Phage the Untouchable";
	}

	public play (GameCore game) {
        this.power = 3;
        this.toughness = 3;
        this.sick = true;
	}
	
	public play (GameCore game, GameEnums.Zone zone){
		this.power = 3;
        this.toughness = 3;
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
        "Creature - Zombie Spirit" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
	}
}
