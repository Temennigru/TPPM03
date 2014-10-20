//reference: http://magiccards.info/dka/en/127.html
package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

public class StranglerootGeist extends Creature {
    boolean hasCounter;


    public StranglerootGeist () {
        this.reset();
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.SPIRIT;
        this.manaCost = "GG";
        this.name = "Strangleroot Geist";
        this.types = "Creature - Spirit";
        this.description = "Haste" + String.format("%n") + "Undying (when this creature dies," +
        " if it had no +1/+1 counters on it, return it to the battlefield under it's owner's control" +
        "with a +1/+1 counter on it.";
        this.flavor = "Geists of the hanged often haunt the tree on which they died.";
    }

    private void reset() {
        this.haste = true;
        this.power = 2;
        this.toughness = 1;
        this.hasCounter = false;
        this.untap();
    }

    public void play () throws GameExceptions.GameException {
        this.reset();
        this.place (GameEnums.Zone.BATTLEFIELD);
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
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
}
