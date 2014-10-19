//reference: http://magiccards.info/avr/en/89.html

//TODO: enter play lose 2 life
//TODO: undying

package Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class GeralfsMessenger extends Creature {

    boolean istapped = true;

	public GeralfsMessenger () {
        this.m_sub = { GameEnums.CreatureSubType.ZOMBIE}; 
        this.power = 3;
        this.toughness = 2;
        this.sick = true;
        this.manaCost = "BBB";
        this.name = "Geralf's Messenger"
        this.description = "Geralf's Messenger enters the battlefield tapped."
        + "When Geralf's Messenger enters the battlefield, target opponent loses 2 life."
        + "Undying (when this creature dies, if it had no +1/+1 counters on it, return it to the battlefield under it's owner's control with a +1/+1 counter on it.";
        this.flavor = "Without a mind, it doesn`t fear death. Without a soul, it doesn`t mind killing.";
	}

	public play (GameCore game) {
        this.power = 3;
        this.toughness = 2;
        this.sick = true;
	}
	
	public play (GameCore game, GameEnums.Zone zone){
		this.power = 3;
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
