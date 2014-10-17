//reference: http://magiccards.info/m12/en/182.html

public class LlanowarElves extends Creature {

	 public LlanowarElves () {
        this.m_sub = { GameEnums.CreatureSubType.ELF }; //this.m_sub = { GameEnums.CreatureSubType.DRUID }; 
		// TODO: dois subtipos???
        this.power = 1;
        this.toughness = 1;
        this.sick = true;
        this.manaCost = "G";
        this.name = "Llanowar Elves"
        this.description = "Tap: add G to your mana pool.";
        this.flavor = "One bone broken for every twig snapped underfoot. _Llanowar penalty for trespassing";
    }

	 public play (GameCore game) {
        this.power = 1;
        this.toughness = 1;
        this.sick = true;
    }
	
	public activateTap (){
		// TODO: add G to your mana pool
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
        "Creature - Elf Druid" + System.lineSeparator() +
        this.description + System.lineSeparator() +
        this.flavor + System.lineSeparator() +
        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
    }
}
