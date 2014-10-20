//reference: http://magiccards.info/dka/en/63.html

//TODO: enter play lose 2 life

package GameCore.Cards;

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

    private void reset() {
        this.power = 3;
        this.toughness = 2;
        this.hasCounter = false;
        this.untap();
    }

	public play (GameCore game) {
        this.reset();

        this.place (GameEnums.Zone.BATTLEFIELD);
	}
	
    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }
	public void discard (GameCore game) {
       	this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void kill () throws GameExceptions.GameException {
        // TODO: Make an exception if card is not in battlefield.
        if (!this.hasCounter) {
            this.play ();
            this.power++;
            this.toughness++;
            this.hasCounter = true;
        } else {
            this.power--;
            this.toughness--;
            this.hasCounter = false;
            this.place(GameEnums.Zone.GRAVEYARD);
        }
    }

    public String toString() {
        return this.name + " - " + this.manaCost + System.lineSeparator() +
        "Creature - Zombie" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
	}
}