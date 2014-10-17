package Cards.Concrete;

import Land.*;
import GameCore.*;
import GameEnums.*;
import GameObject.*;
import System.*;

public class Swamp extends Land {

    private static class TapForMana extends Ability {

        public boolean stackable() { return false; }
        public String[] activateCost() { String[] ret = new String[1]; ret[0] = "T"; return ret; };

        public TapForMana () {
            this.m_abilityType = GameEnums.AbilityTypes.ACTIVE;
            this.m_source = source;
        }

        public void activate (GameCore game) {
            this.activate (game, this);
        }

        public void activate (GameCore game, GameObject source) {
            // TODO: add mana to mana pool

        }

    }

    public Swamp () {
        this.m_super = new GameEnums.SuperType[1]; this.m_super[0] = GameEnums.SuperType.BASIC;
        this.m_sub = new GameEnums.LandSubType[1]; this.m_sub[0] = GameEnums.LandSubType.SWAMP;
        this.name = "Swamp";
        this.description = "(T: Add K to your mana pool)";
        this.flavor = "";
        this.abilities.addElement(new TapForMana());
    }

    public void play () {
        this.token = false;

        // TODO: Register in battlefield here \/
    }

    public void discard () {
        // TODO: Make an exception if card is not in hand.
        this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone) {
        this.place (game, zone, 0);
    }

    public void place (GameEnums.Zone zone, int position) {
        // TODO: Register in zone here \/
    }

    public String toString() {
        return this.name + System.lineSeparator() +
        "Basic Land - Swamp" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator();
    }
}
