//reference: http://magiccards.info/mma/en/140.html

//TODO: Kicker

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class CitanulWoodreaders extends Creature {

    public CitanulWoodreaders () {
        this.reset();
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.HUMAN; //GameEnums.CreatureSubType.DRUID
        this.manaCost = "2G";
        this.name = "Citanul Woodreaders";
        this.types = "Creature - Human Druid";
        this.description = "Kicker 2G (You may pay an additional 2G as you cast this spell"
        + "When Citanul Woodreaders enters the battlefield, if it was kicked, draw two cards.";
        this.flavor = "They seek out living trees to glean age-old secrets from sap and wood.";
    }

private void reset() {
        this.power = 1;
        this.toughness = 4;
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
