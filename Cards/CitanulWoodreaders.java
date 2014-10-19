//reference: http://magiccards.info/mma/en/140.html

//TODO: Kicker

package Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class CitanulWoodreaders extends Creature {

    public CitanulWoodreaders () {
        this.m_sub = { GameEnums.CreatureSubType.HUMAN, GameEnums.CreatureSubType.DRUID };
        this.power = 1;
        this.toughness = 4;
        this.sick = true;
        this.manaCost = "2G";
        this.name = "Citanul Woodreaders";
        this.types = "Creature - Human Druid";
        this.description = "Kicker 2G (You may pay an additional 2G as you cast this spell"
        + "When Citanul Woodreaders enters the battlefield, if it was kicked, draw two cards.";
        this.flavor = "They seek out living trees to glean age-old secrets from sap and wood.";
    }

    public play (GameCore game) {
        this.power = 1;
        this.toughness = 4;
        this.sick = true;
    }
    
    public void discard (GameCore game) {
        this.place (game, GameEnums.Zone.GRAVEYARD);
    }
    
    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.place (game, zone, 0);
    }

    public void kill (GameCore game) {
    }

    public String toString() {
        return this.name + " - " + this.manaCost + System.lineSeparator() +
        "Creature - Beast" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
