//reference: http://magiccards.info/isd/en/97.html


package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class DiregrafGhoul extends Creature {

	boolean istapped = true;

	public DiregrafGhoul () {
        this.m_sub = { GameEnums.CreatureSubType.ZOMBIE }; 
        this.power = 2;
        this.toughness = 2;
        this.sick = true;
        this.manaCost = "B";
        this.name = "Diregraf Ghoul"
        this.description = "Diregraf Ghoul enters the battlefield tapped.";
        this.flavor = "At least this one still has arms and legs. Well, most of its legs. _Enslow, ghoulcaller of Nephalia";
	    }

	public play (GameCore game) {
        this.power = 2;
        this.toughness = 2;
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
        "Creature - Zombie" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
