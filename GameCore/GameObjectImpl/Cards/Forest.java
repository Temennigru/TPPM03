package GameCore.Cards;

import GameCore.GameObjectCore.*;
import GameCore.*;
import java.lang.*;
import java.util.Vector;


public class Forest extends Land {


    public GameEnums.SuperType[] m_super = { GameEnums.SuperType.BASIC };
    public GameEnums.LandSubType[] m_sub = { GameEnums.LandSubType.FOREST };

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

    public Forest () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/Forest.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.LAND;
        this.abilities = new Vector<Ability>();
        this.name = "Forest";
        this.types = "Basic Land - Forest";
        this.description = "(T: Add G to your mana pool)";

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