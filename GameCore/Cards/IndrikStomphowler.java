//reference: http://magiccards.info/gvl/en/10.html
package GameCore.Cards;

//TODO: when enters, destroy target...

public class IndrikStomphowler extends Creature {

	public IndrikStomphowler () {
        this.m_sub = { GameEnums.CreatureSubType.BEAST };
        this.power = 4;
        this.toughness = 4;
        this.sick = true;
        this.manaCost = "GG";
        this.name = "Indrik Stomphowler"
        this.description = "When Indrik Stomphowler enters the battlefield, destroy target artifact or enchantment.";
        this.flavor = "An indrik's howl has destructive power much subtler than that of its crushing foot.";
    }

	public play (GameCore game) {
        this.power = 4;
        this.toughness = 4;
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
