//reference: http://magiccards.info/pc/en/85.html

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

//TODO: destroy all creatures

public class Damnation extends Sorcery {
	
	public Damnation () {
		this.m_imgLocation = "GameCore/Cards/Img/Damnation.jpg";
		this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.SORCERY;
        this.manaCost = "2BB";
        this.name = "Damnation"
        this.description = "Destroy all creatures. They can't be regenerated.";
        this.flavor = " ";
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


