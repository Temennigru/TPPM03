//reference: http://magiccards.info/fvl/en/14.html
package GameCore.Cards;

//TODO: when cast, destroy
//TODO: annihilator 4
//TODO: indestructible
//TODO: when put into graveyard, shuffles graveyard into library

public class UlamogTheInfiniteGyre extends Creature {

	public UlamogTheInfiniteGyre () {
        this.m_sub = { GameEnums.CreatureSubType.LEGENDARY, GameEnums.CreatureSubType.ELDRAZI };
        this.power = 10;
        this.toughness = 10;
        this.sick = true;
        this.manaCost = "11";
        this.name = "Ulamog, the Infinite Gyre"
        this.description = "When you cast Ulamog, the Infinite Gyre, destroy target permanent."
        + System.lineSeparator() + "Annihilator 4 (Whenever this creature attacks, defending player sacrifices four permanents.)"
        + System.lineSeparator() + "Ulamog is indestructible."
        + System.lineSeparator() + "When Kozilek is put into a graveyard from anywhere, its owner shuffles his or her graveyard into his or her library.";
        this.flavor = " ";
    }

	public play (GameCore game) {
        this.power = 10;
        this.toughness = 10;
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
        "Legendary Creature - Eldrazi" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
