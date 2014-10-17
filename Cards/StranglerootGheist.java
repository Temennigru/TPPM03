//reference: http://magiccards.info/dka/en/127.html

package Cards.Concrete;

import Core.*;
import Cards.*;

public class StranglerootGheist extends Creature {
    boolean hasCounter;

    public StranglerootGheist () {
        this.m_sub = new GameEnums.CreatureSubType[1]; m_sub[0] = GameEnums.CreatureSubType.SPIRIT;
        this.power = 2;
        this.toughness = 1;
        this.sick = false;
        this.manaCost = "GG";
        this.hasCounter = false;
        this.name = "Strangleroot Gheist";
        this.description = "Haste" + System.lineSeparator() + "Undying (when this creature dies," +
        " if it had no +1/+1 counters on it, return it to the battlefield under it's owner's control" +
        "with a +1/+1 counter on it.";
        this.flavor = "Geists of the hanged often haunt the tree on which they died.";
    }

    public void play () {
        this.power = 2;
        this.toughness = 1;
        this.sick = false; // Haste
        this.hasToken = false;

        // TODO: Register in battlefield here \/
    }

    public void discard () {
        // TODO: Make an exception if card is not in hand.
        this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone) {
        this.place (game, zone, 0);
    }

    public void place (GameEnums.Zone zone, int position) {
        // TODO: Register in zone here \/
    }

    public void kill () {
        if (!this.hasCounter) {
            this.power++;
            this.toughness++;
            this.hasCounter = true;
            this.place (game, GameEnums.Zone.BATTLEFIELD);
        }
    }

    public String toString() {
        return this.name + " - " + this.manaCost + System.lineSeparator() +
        "Creature - Spirit" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();

    }
}
