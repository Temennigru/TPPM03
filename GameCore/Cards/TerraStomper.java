//reference: http://magiccards.info/tr/en/133.html
package GameCore.Cards;

//TODO: trample
//TODO: cant be countered

public class TerraStomper extends Creature {

	public TerraStomper () {
        this.m_sub = { GameEnums.CreatureSubType.BEAST };
        this.power = 8;
        this.toughness = 8;
        this.sick = true;
        this.manaCost = "3GGG";
        this.name = "Terra Stomper"
        this.description = "Terra Stomper can't be countered."
         + System.lineSeparator() + "Trample (If this creature would assign enough damage to its blockers to destroy them, you may have it assign the rest of its damage to defending player or planeswalker.)";
        this.flavor = "Its footfalls cause violent earthquakes, hurtling boulders, and unseasonable dust storms.";
    }

	public play (GameCore game) {
        this.power = 8;
        this.toughness = 8;
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
