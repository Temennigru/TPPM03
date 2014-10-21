//reference: http://magiccards.info/c13/en/69.html

package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class ArmyOfTheDamned extends Sorcery {
	
	public ArmyOfTheDamned () {
		this.m_imgLocation = "GameCore/Cards/Img/ArmyOfTheDamned.jpg";
		this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.SORCERY;
        this.manaCost = "5BBB";
        this.name = "ArmyOfTheDamned"
        this.description = "Put thirteen 2/2 black Zombie creature tokens onto the battlefield tapped." + System.lineSeparator()
        	+ "Flashback 7BBB (You may cast this card from your graveyard for its flashback cost. Then exile it.)";
        this.flavor = "Sometimes death comes knocking. Sometimes it tears down the walls.";
	}

	private void reset() {
    }

    public void play () throws GameExceptions.GameException {
        
        for (i=0, i<13, i++){
            zombie = new TokenZombie();
            zombie.m_owner = this.m_controler;
            zombie.m_controler = this.m_controler;
            zombie.play();
        }

        if (this.location == GameEnums.Zone.GRAVEYARD){
        this.place (GameEnums.Zone.EXILE_FUP);
        }

    	this.place (GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
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
                if (!game.spendMana(this.m_controler, "7BBB")) { return false; } // Mana is subtracted from whoever controls the spell when it is cast.
            }
            //if not on graveyard then it's on the hand
            else if (!game.spendMana(this.m_controler, this.manaCost)) { return false; } // Mana is subtracted from whoever controls the spell when it is cast.
        }
        this.play();
        return true;
    }


}