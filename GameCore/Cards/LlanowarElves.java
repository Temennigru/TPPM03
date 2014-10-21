//reference: http://magiccards.info/m12/en/182.html
package GameCore.Cards;

import Core.*;
import Cards.Abstract.*;
import java.util.Vector;

public class LlanowarElves extends Creature {


    private static class TapForMana extends Ability {

        private GameObject m_fatherObject;
        private GameObject m_source;

        private GameEnums.AbilityType m_abilityType;

        public boolean stackable() { return false; }
        public String[] activateCost() { String[] ret = new String[1]; ret[0] = "T"; return ret; };

        public TapForMana (GameObject father) {
            this.m_abilityType = GameEnums.AbilityType.ACTIVE;
            this.m_fatherObject = father;
        }

        public boolean activate () throws GameExceptions.GameException {
            return this.activate (this);
        }

        public boolean activate (GameObject source) throws GameExceptions.GameException {
            if (((Permanent)this.m_fatherObject).location != GameEnums.Zone.BATTLEFIELD) { throw new GameExceptions.WrongZoneException(((Permanent)this.m_fatherObject), ((Permanent)this.m_fatherObject).location, GameEnums.Zone.BATTLEFIELD); }
            if (((Permanent)this.m_fatherObject).isTapped()) return false;
            this.m_fatherObject.m_controler.addMana("G");
            ((Permanent)this.m_fatherObject).tap();
            return true;
        }

    }

	public LlanowarElves () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/LlanowarElves.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ELF; // GameEnums.CreatureSubType.DRUID;
        this.abilities = new Vector<Ability>();
        this.manaCost = "G";
        this.name = "Llanowar Elves";
        this.types = "Creature - Elf";
        this.description = "T: add G to your mana pool.";
        this.flavor = "One bone broken for every twig snapped underfoot. Llanowar penalty for trespassing";

        this.abilities.add(new TapForMana(this));
    }


    private void reset() {
        this.power = 1;
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
}
