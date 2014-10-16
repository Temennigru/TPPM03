public class Forest extends Land {

    private static class TapForMana extends Ability {

        public final const boolean stackable = false;
        public final const String[] activateCost = { "T" };

        public Ability () {
            this.m_abilityType = GameEnums.AbilityTypes.ACTIVE;
            this.m_source = source;
        }

        public activate (GameCore game) {
            this.activate (game, this);
        }

        public activate (GameCore game, GameObject source) {
            // TODO: add mana to mana pool

        }

    }

    public Forest () {
        this.m_super = { GameEnums.SuperType.BASIC };
        this.m_sub = { GameEnums.LandSubType.FOREST };
        this.name = "Forest"
        this.description = "(T: Add G to your mana pool)";
        this.flavor = "";
        this.abilities.addElement(new TapForMana);
    }

    public play (GameCore game) {
        this.token = false;

        // TODO: Register in battlefield here \/
    }

    public void discard (GameCore game) {
        // TODO: Make an exception if card is not in hand.
        this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameCore game, GameEnums.Zone zone) {
        this.place (game, zone, 0);
    }

    public void place (GameCore game, GameEnums.Zone zone, int position) {
        // TODO: Register in zone here \/
    }

    public String toString() {
        return this.name + System.lineSeparator() +
        "Basic Land - Forest" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator();
    }
}