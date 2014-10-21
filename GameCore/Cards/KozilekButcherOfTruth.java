//reference: http://magiccards.info/roe/en/6.html

package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

//TODO: when cast, draw 4 cards
//TODO: annihilator 4
//TODO: when put into graveyard, shuffles graveyard into library

public class KozilekButcherOfTruth extends Creature {

	public KozilekButcherOfTruth () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/KozilekButcherOfTruth.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.LEGENDARY; //GameEnums.CreatureSubType.ELDRAZI };
        this.manaCost = "10";
        this.name = "Kozilek, Butcher of Truth"
        this.description = "When you cast Kozilek, Butcher of Truth, draw four cards"
        + System.lineSeparator() + "Annihilator 4 (Whenever this creature attacks, defending player sacrifices four permanents.)"
        + System.lineSeparator() + "When Kozilek is put into a graveyard from anywhere, its owner shuffles his or her graveyard into his or her library.";
        this.flavor = " ";
    }
    
    private void reset() { 
        this.power = 12;
        this.toughness = 12;
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
