//reference: http://magiccards.info/wwk/en/107.html

package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

public class LeatherbackBaloth extends Creature {

	 public LeatherbackBaloth () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/LeatherbackBaloth.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.BEAST;
        this.manaCost = "GGG";
        this.name = "Leatherback Baloth"
        this.description = " ";
        this.flavor = "Heavy enough to withstand the Roil, leatherback skeletons are havens for travelers in storms and landshifts";
    }

    private void reset() { 
        this.power = 4;
        this.toughness = 5;
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
