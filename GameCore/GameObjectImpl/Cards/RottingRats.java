//reference: http://magiccards.info/pch/en/39.html

//TODO: when enters, each discard a card
//TODO: Unearth

package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

public class RottingRats extends Creature {

	public RottingRats (){ 
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/RottingRats.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE; // GameEnums.CreatureSubType.RAT 
        this.manaCost = "1B";
        this.name = "Rotting Rats"
        this.description = "When Rotting Rats enters the battlefield, each player discards a card."
        + "Unearth 1B (1B: Return this card from your graveyard to the battlefield. It gains haste. Exile it at the beginning of the next step or if it would leave play. Unearth only as a sorcery)";
        this.flavor = " ";
	}

    private void reset() { 
        this.power = 1;
        this.toughness = 1;
        this.untap();
        this.damage = 0;
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
        this.place (GameEnums.Zone.GRAVEYARD);
    }
}
