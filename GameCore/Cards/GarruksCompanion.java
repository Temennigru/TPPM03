//reference: http://magiccards.info/m12/en/175.html

//TODO: implementar o trample

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class GarruksCompanion extends Creature {

	public GarruksCompanion () {
        this.reset();
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.BEAST;
        this.manaCost = "GG";
        this.name = "Garruk's Companion"
        this.description = "Trample"
        + "(If this creature would assign enough damage to its blockers to destroy them, you may have it assign the rest of its damage to defending player or planeswalker.)";
        this.flavor = "They seek out living trees to glean age-old secrets from sap and wood.";
    }

    private void reset() {
        this.power = 3;
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
