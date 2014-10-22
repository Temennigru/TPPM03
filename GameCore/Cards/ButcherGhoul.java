//reference: http://magiccards.info/avr/en/89.html


package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

public class ButcherGhoul extends Creature {
    private boolean hasCounter;

	public ButcherGhoul () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/ButcherGhoul.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE;
        this.manaCost = "1B";
        this.name = "Butcher Ghoul";
        this.description = "Undying (When this creature dies, if it had no +1/+1 counters on it, return it to the battlefield under its owner\'s control with a +1/+1 counter on it. )";
        this.flavor = "Without a mind, it doesn\'t fear death. Without a soul, it doesn\'t mind killing.";
	}

    private void reset() {
        this.damage = 0;
        this.power = 1;
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
