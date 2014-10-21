//reference: http://magiccards.info/extra/token/magic-2015/zombie.html

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class TokenZombie extends Creature {
    
    protected boolean token = true;

	public TokenZombie () {
        this.reset();
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE;
        this.sick = true;
        this.manaCost = "";
        this.name = "Zombie"
        this.description = " ";
        this.flavor = " ";
	}

    private void reset() {
        this.power = 2;
        this.toughness = 2;
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
        this.place (GameEnums.Zone.EXILE_FUP);
    }
}