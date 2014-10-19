//reference: http://magiccards.info/m12/en/175.html
//TODO: implementar o trample

public class GarruksCompanion extends Creature {

	public GarruksCompanion () {
        this.m_sub = { GameEnums.CreatureSubType.BEAST };
        this.power = 3;
        this.toughness = 2;
        this.sick = true;
        this.manaCost = "GG";
        this.name = "Garruk's Companion"
        this.description = "Trample"
        + "(If this creature would assign enough damage to its blockers to destroy them, you may have it assign the rest of its damage to defending player or planeswalker.)";
        this.flavor = "They seek out living trees to glean age-old secrets from sap and wood.";
    }

	 public play (GameCore game) {
        this.power = 3;
        this.toughness = 2;
        this.sick = true;
    }
	
	public void discard (GameCore game) {
        this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameCore game, GameEnums.Zone zone) {
        this.place (game, zone, 0);
    }

    public void kill (GameCore game) {
    }

    public String toString() {
        return this.name + " - " + this.manaCost + System.lineSeparator() +
        "Creature - Beast" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
