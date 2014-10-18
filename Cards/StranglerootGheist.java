//reference: http://magiccards.info/dka/en/127.html

package Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class StranglerootGheist extends Creature {
    boolean hasCounter;

    public GameEnums.CreatureSubType[] m_sub = { GameEnums.CreatureSubType.SPIRIT };

    public StranglerootGheist () {
        // Set evergreen abilities
        this.haste = true;

        this.power = 2;
        this.toughness = 1;
        this.manaCost = "GG";
        this.hasCounter = false;
        this.name = "Strangleroot Gheist";
        this.description = "Haste" + String.format("%n") + "Undying (when this creature dies," +
        " if it had no +1/+1 counters on it, return it to the battlefield under it's owner's control" +
        "with a +1/+1 counter on it.";
        this.flavor = "Geists of the hanged often haunt the tree on which they died.";
    }

    public void play () {
        this.power = 2;
        this.toughness = 1;
        if (this.haste) { this.sick = false; }
        else { this.sick = true; }
        this.hasCounter = false;

        GameCore game = GameCore.getGame();
        game.registerOnZone(this, GameEnums.Zone.BATTLEFIELD);
    }

    public void discard () {
        // TODO: Make an exception if card is not in hand.
        this.place (GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone) {
        this.place (zone, 0);
    }

    public void place (GameEnums.Zone zone, int position) {
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public void kill () {
        if (!this.hasCounter) {
            this.play ();
            this.power++;
            this.toughness++;
            this.hasCounter = true;
        }
    }

    public String toString() {
        return this.name + " - " + this.manaCost + String.format("%n") +
        "Creature - Spirit" + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n") +
        Integer.toString(this.power) + "/" + Integer.toString(this.toughness) + String.format("%n");

    }
}
