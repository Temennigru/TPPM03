package GameCore.Cards;

import GameCore.GameObjectCore.*;
import GameCore.*;
import java.lang.*;
import java.util.Vector;


public class Swamp extends Land {


    public GameEnums.SuperType[] m_super = { GameEnums.SuperType.BASIC };
    public GameEnums.LandSubType[] m_sub = { GameEnums.LandSubType.SWAMP };

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
            this.m_fatherObject.m_controler.addMana("B");
            ((Permanent)this.m_fatherObject).tap();
            return true;
        }

    }

    public Swamp () {
        this.reset();
        this.abilities = new Vector<Ability>();
        this.name = "Swamp";
        this.types = "Basic Land - Swamp";
        this.description = "(T: Add B to your mana pool)";

        this.abilities.addElement(new TapForMana(this));
    }

    private void reset() {
        this.untap();
    }

    public void play () throws GameExceptions.GameException {
        this.token = false;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, GameEnums.Zone.BATTLEFIELD);
    }
}
