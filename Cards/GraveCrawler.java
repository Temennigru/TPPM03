//reference: http://magiccards.info/dka/en/64.html

public class Gravecrawler extends Creature {

	boolean canblock = false;

	public Gravecrawler () {
	        this.m_sub = { GameEnums.CreatureSubType.ZOMBIE }; 
	        this.power = 2;
	        this.toughness = 1;
	        this.sick = true;
	        this.manaCost = "K";
	        this.name = "Gravecrawler"
	        this.description = "Gravecrawler can't block." + System.lineSeparator() + "You may cast Gravecrawler from your graveyard as long as you control a Zombie.";
	        this.flavor = "Innistrad's ghoulcallers are talented enough, but let me show you what someone with real power can create. _Liliana Vess";
	}

	public play (GameCore game) {
	        this.power = 2;
	        this.toughness = 1;
	        this.sick = true;
	}
	
	public play (GameCore game, GameEnums.Zone zone){
		// TODO: if you control a zombie
		// TODO: can play from graveyard
		this.power = 2;
	        this.toughness = 1;
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
	        "Creature - Zombie" + System.lineSeparator() +
	        this.description + System.lineSeparator() +
	        this.flavor + System.lineSeparator() +
	        this.power.toString() + "/" + this.toughness.toString() + System.lineSeparator();
	}
}
