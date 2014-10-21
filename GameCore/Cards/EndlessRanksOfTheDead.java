//reference: http://magiccards.info/isd/en/99.html

package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

//TODO: upkeep place zombies

public class EndlessRanksOfTheDead extends ENCHANTMENT {
	
	public EndlessRanksOfTheDead () {
		this.m_imgLocation = "GameCore/Cards/Img/EndlessRanksOfTheDead.jpg";
		this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.ENCHANTMENT;
        this.manaCost = "2BB";
        this.name = "Endless Ranks Of The Dead"
        this.description = "At the beginning of your upkeep, put X 2/2 black Zombie creature tokens onto the battlefield, where X is half the number of Zombies you control, rounded down.";
        this.flavor = " ";
	}

	private void reset() {
    }

    public void play () throws GameExceptions.GameException {
    	this.place (GameEnums.Zone.BATTLEFIELD);

    }

    //ACTIVATE
    /*
    GameCore.Iterator<Card> 
    public Iterator<Card> iterator (Player player, GameEnums.Zone zone) {
    gamecore.iterator battlefield
    int x; //x is half the number of zombies you control rounded down
    for (i=0, i<x, i++){
    	zombie = new TokenZombie();
    	zombie.m_owner = this.m_controler;
		zombie.m_controler = this.m_controler;
		zombie.play();
    }
    */

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }


}
