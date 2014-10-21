//reference: http://magiccards.info/c13/en/69.html

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

//TODO: 13 zombie tokens
//TODO: flashback

public class ArmyOfTheDamned extends Sorcery {
	
	public ArmyOfTheDamned () {
		this.m_imgLocation = "GameCore/Cards/Img/ArmyOfTheDamned.jpg";
		this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.SORCERY;
        this.manaCost = "5BBB";
        this.name = "ArmyOfTheDamned"
        this.description = "Put thirteen 2/2 black Zombie creature tokens onto the battlefield tapped." + System.lineSeparator()
        	+ "Flashback 7BBB (You may cast this card from your graveyard for its flashback cost. Then exile it.)";
        this.flavor = "Sometimes death comes knocking. Sometimes it tears down the walls.";
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