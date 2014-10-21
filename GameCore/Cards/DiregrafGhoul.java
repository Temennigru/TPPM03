//reference: http://magiccards.info/isd/en/97.html


package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class DiregrafGhoul extends Creature {

	boolean istapped = true;

	public DiregrafGhoul () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/DiregrafGhoul.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE;
        this.manaCost = "B";
        this.name = "Diregraf Ghoul"
        this.description = "Diregraf Ghoul enters the battlefield tapped.";
        this.flavor = "At least this one still has arms and legs. Well, most of its legs. _Enslow, ghoulcaller of Nephalia";
	    }

    private void reset() {
        this.power = 2;
        this.toughness = 2;
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
