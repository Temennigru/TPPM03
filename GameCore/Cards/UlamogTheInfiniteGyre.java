//reference: http://magiccards.info/fvl/en/14.html
package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

//TODO: when cast, destroy
//TODO: annihilator 4
//TODO: indestructible
//TODO: when put into graveyard, shuffles graveyard into library

public class UlamogTheInfiniteGyre extends Creature {

	public UlamogTheInfiniteGyre () {
        this.reset;
        this.m_imgLocation = "GameCore/Cards/Img/UlamogTheInfiniteGyre.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.LEGENDARY; //GameEnums.CreatureSubType.ELDRAZI
        this.manaCost = "11";
        this.name = "Ulamog, the Infinite Gyre"
        this.description = "When you cast Ulamog, the Infinite Gyre, destroy target permanent."
        + System.lineSeparator() + "Annihilator 4 (Whenever this creature attacks, defending player sacrifices four permanents.)"
        + System.lineSeparator() + "Ulamog is indestructible."
        + System.lineSeparator() + "When Kozilek is put into a graveyard from anywhere, its owner shuffles his or her graveyard into his or her library.";
        this.flavor = " ";
    }

    private void reset() {
        this.power = 10;
        this.toughness = 10;
        this.untap();
        this.damage = 0;
    }
    
	public play (GameCore game) {
        this.reset();
        this.place (GameEnums.Zone.BATTLEFIELD);
    }

    public void place (GameCore game, GameEnums.Zone zone) {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public void kill (GameCore game) {
        this.place(GameEnums.Zone.GRAVEYARD);
    }
}
