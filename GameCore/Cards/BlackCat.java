//reference: http://magiccards.info/m15/en/86.html

//TODO: opponent discards a card when it dies

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class BlackCat extends Creature {

	public BlackCat () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/BlackCat.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE; //GameEnums.CreatureSubType.CAT 
        this.manaCost = "1B";
        this.name = "Black Cat"
        this.description = "When Black Cat dies, target opponent discards a card at random.";
        this.flavor = "Its last life is spent tormenting your deams.";
	}

private void reset() {
        this.power = 1;
        this.toughness = 1;
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
