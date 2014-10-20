//reference: http://magiccards.info/roe/en/6.html

package GameCore.Cards;

//TODO: when cast, draw 4 cards
//TODO: annihilator 4
//TODO: when put into graveyard, shuffles graveyard into library

public class KozilekButcherOfTruth extends Creature {

	public KozilekButcherOfTruth () {
        this.m_sub = { GameEnums.CreatureSubType.LEGENDARY, GameEnums.CreatureSubType.ELDRAZI };
        this.power = 12;
        this.toughness = 12;
        this.sick = true;
        this.manaCost = "10";
        this.name = "Kozilek, Butcher of Truth"
        this.description = "When you cast Kozilek, Butcher of Truth, draw four cards"
        + System.lineSeparator() + "Annihilator 4 (Whenever this creature attacks, defending player sacrifices four permanents.)"
        + System.lineSeparator() + "When Kozilek is put into a graveyard from anywhere, its owner shuffles his or her graveyard into his or her library.";
        this.flavor = " ";
    }

	public play (GameCore game) {
        this.power = 12;
        this.toughness = 12;
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
