//reference: http://magiccards.info/pch/en/39.html

//TODO: when enters, each discard a card
//TODO: Unearth

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class RottingRats extends Creature {

	public RottingRats () {
        this.m_sub = { GameEnums.CreatureSubType.ZOMBIE, GameEnums.CreatureSubType.RAT }; 
        this.power = 1;
        this.toughness = 1;
        this.sick = true;
        this.manaCost = "1B";
        this.name = "Rotting Rats"
        this.description = "When Rotting Rats enters the battlefield, each player discards a card."
        + "Unearth 1B (1B: Return this card from your graveyard to the battlefield. It gains haste. Exile it at the beginning of the next step or if it would leave play. Unearth only as a sorcery)";
        this.flavor = " ";
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
        "Creature - Zombie Rat" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
	}
}
