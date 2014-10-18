package Cards;

import Cards.Abstract.*;
import Core.*;
import java.lang.*;
import java.util.Vector;


public class Forest extends Land {

    private static class TapForMana extends Ability {

        private GameObject m_fatherObject;
        private GameObject m_source;

        public GameEnums.SuperType[] m_super = { GameEnums.SuperType.BASIC };
        public GameEnums.LandSubType[] m_sub = { GameEnums.LandSubType.FOREST };

        private GameEnums.AbilityType m_abilityType;

        public boolean stackable() { return false; }
        public String[] activateCost() { String[] ret = new String[1]; ret[0] = "T"; return ret; };

        public TapForMana (GameObject father) {
            this.m_abilityType = GameEnums.AbilityType.ACTIVE;
            this.m_fatherObject = father;
        }

        public void activate () {
            this.activate (this);
        }

        public void activate (GameObject source) {
            this.m_fatherObject.m_controler.addMana("G");
            ((Permanent)this.m_fatherObject).tap();
        }

    }

    public Forest () {

        this.abilities = new Vector<Ability>();
        this.name = "Forest";
        this.description = "(T: Add G to your mana pool)";
        this.flavor = "";

        this.abilities.addElement(new TapForMana(this));
    }

    public void play () {
        this.token = false;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, GameEnums.Zone.BATTLEFIELD);
    }

    public void discard () {
        // TODO: Make an exception if card is not in hand.
        this.place (GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone) {
        this.place (zone, 0);
    }

    public void place (GameEnums.Zone zone, int position) {
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public String toString() {
        String tmp = this.name;
        if (this.isTapped()) { tmp += " T"; }
        tmp += String.format("%n") +
        "Basic Land - Forest" + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n");
        return tmp;
    }
}