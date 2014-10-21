//reference: http://magiccards.info/cns/en/113.html

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

//TODO: destroy tapped

public class Assassinate extends Sorcery {
	
	public Assassinate () {
		this.m_imgLocation = "GameCore/Cards/Img/Assassinate.jpg";
		this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.Sorcery;
        this.manaCost = "2B";
        this.name = "Assassinate"
        this.description = "Destroy target tapped creature.";
        this.flavor = "This is how wars are won - not with armies of soldiers but with a single knifle blade, artfully placed. _Yurin, royal assassin";
	}

	private void reset() {
    }

    public void play () throws GameExceptions.GameException {

    	this.place (GameEnums.Zone.GRAVEYARD);

    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }


}


