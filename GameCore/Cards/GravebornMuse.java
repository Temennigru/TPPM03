//reference: http://magiccards.info/10e/en/145.html

//TODO: at the beginning of your upkeep...

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class GravebornMuse extends Creature {

	public GravebornMuse () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/GravebornMuse.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE; //GameEnums.CreatureSubType.SPIRIT  
        this.manaCost = "2BB";
        this.name = "Graveborn Muse"
        this.description = "At the beginning of your upkeep, you draw X cards and you lose X life, where X is the number of Zombies you control.";
        this.flavor = "Her voice is damnation, unyielding and certain. _Phage the Untouchable";
	}

    private void reset() { 
        this.power = 3;
        this.toughness = 3;
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
