//reference: http://magiccards.info/rtr/en/140.html
package GameCore.Cards;

//TODO: trample
//TODO: when dies, put three 5/5
//TODO: when put into graveyard, shuffle it into library
//TODO: token wurm card

public class WorldspineWurm extends Creature {

	public WorldspineWurm () {
        this.m_sub = { GameEnums.CreatureSubType.WURM };
        this.power = 15;
        this.toughness = 15;
        this.sick = true;
        this.manaCost = "8GGG";
        this.name = "Worldspine Wurm"
        this.description = "When Worldspine Wurm dies, put three 5/5 green Wurm creature tokens with trample onto the battlefield."
         + System.lineSeparator() + "Trample (If this creature would assign enough damage to its blockers to destroy them, you may have it assign the rest of its damage to defending player or planeswalker.)"
         + System.lineSeparator() + "When Worldspine Wurm is put into a graveyard from anywhere, shuffle it into its owner's library."
        this.flavor = " ";
    }

	public play (GameCore game) {
        this.power = 15;
        this.toughness = 15;
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
        "Creature - Wurm" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
