//reference: http://magiccards.info/dka/en/64.html
package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

//TODO: cant block
//TODO: cast from graveyard if you control a zombie

public class Gravecrawler extends Creature {

	boolean canblock = false;

	public Gravecrawler () {
	    this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/Gravecrawler.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE;
	    this.power = 2;
	    this.toughness = 1;
	    this.sick = true;
	    this.manaCost = "K";
	    this.name = "Gravecrawler"
	    this.description = "Gravecrawler can't block." + System.lineSeparator() + "You may cast Gravecrawler from your graveyard as long as you control a Zombie.";
	    this.flavor = "Innistrad's ghoulcallers are talented enough, but let me show you what someone with real power can create. _Liliana Vess";
	}

    private void reset() { 
        this.power = 2;
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

    public boolean cast () throws GameExceptions.GameException {
        return this.cast(true);
    }

    public boolean cast (boolean payManaCost) throws GameExceptions.GameException {
        // TODO: use stack
        if (this.location != GameEnums.Zone.HAND && this.location != GameEnums.Zone.GRAVEYARD) { throw new GameExceptions.WrongZoneException(this, this.location, GameEnums.Zone.HAND); }
        GameCore game = GameCore.getGame();
        if (payManaCost) {
            if (this.location == GameEnums.Zone.GRAVEYARD){
                //TODO: IF YOU CONTROL A ZOMBIE
                if (!game.spendMana(this.m_controler, this.manaCost)) { return false; } // Mana is subtracted from whoever controls the spell when it is cast.
            }
            //if not on graveyard then it's on the hand
            else if (!game.spendMana(this.m_controler, this.manaCost)) { return false; } // Mana is subtracted from whoever controls the spell when it is cast.
        }
        this.play();
        return true;
    }
}
