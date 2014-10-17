//reference: http://magiccards.info/wwk/en/107.html

public class LeatherbackBaloth extends Creature {

	 public LeatherbackBaloth () {
        this.m_sub = { GameEnums.CreatureSubType.BEAST };
        this.power = 4;
        this.toughness = 5;
        this.sick = true;
        this.manaCost = "GGG";
        this.name = "Leatherback Baloth"
        this.description = " ";
        this.flavor = "Heavy enough to withstand the Roil, leatherback skeletons are havens for travelers in storms and landshifts";
    }

	 public play (GameCore game) {
        this.power = 4;
        this.toughness = 5;
        this.sick = true;
    }
	
	public void discard (GameCore game) {
        this.place (game, GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameCore game, GameEnums.Zone zone) {
        this.place (game, zone);
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
