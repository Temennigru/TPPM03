//reference: http://magiccards.info/rtr/en/140.html
package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

//TODO: token 5/5 wurm with trample http://magiccards.info/extra/token/return-to-ravnica/wurm.html
//TODO: trample
//TODO: when dies, put three 5/5
//TODO: when put into graveyard, shuffle it into library
//TODO: token wurm card

public class WorldspineWurm extends Creature {

	public WorldspineWurm () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/WorldspineWurm.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.WURM;
        this.manaCost = "8GGG";
        this.name = "Worldspine Wurm"
        this.description = "When Worldspine Wurm dies, put three 5/5 green Wurm creature tokens with trample onto the battlefield."
         + System.lineSeparator() + "Trample (If this creature would assign enough damage to its blockers to destroy them, you may have it assign the rest of its damage to defending player or planeswalker.)"
         + System.lineSeparator() + "When Worldspine Wurm is put into a graveyard from anywhere, shuffle it into its owner's library."
        this.flavor = " ";
    }

    private void reset() {
        this.power = 15;
        this.toughness = 15;
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
