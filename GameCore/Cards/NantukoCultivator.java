//reference: http://magiccards.info/tr/en/133.html
package GameCore.Cards;

//TODO: comes into play, discard lands put +1+1 counters, draw cards

public class NantukoCultivator extends Creature {

	public NantukoCultivator () {
        this.m_sub = { GameEnums.CreatureSubType.INSECT, GameEnums.CreatureSubType.DRUID };
        this.power = 2;
        this.toughness = 2;
        this.sick = true;
        this.manaCost = "3G";
        this.name = "Nantuko Cultivator"
        this.description = "When Nantuko Cultivator comes into play, you may discard any number of land cards from your hand. Put that many +1/+1 counters on Nantuko Cultivator and draw that many cards.";
        this.flavor = " ";
    }

	public play (GameCore game) {
        this.power = 2;
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
        "Creature - Insect Druid" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
