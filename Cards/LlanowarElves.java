//reference: http://magiccards.info/m12/en/182.html

public class LlanowarElves extends Creature {

    private static class TapForMana extends Ability {

        private GameObject m_fatherObject;
        private GameObject m_source;

        public GameEnums.SuperType[] m_super = { GameEnums.SuperType.BASIC };
        public GameEnums.LandSubType[] m_sub = { GameEnums.LandSubType.FOREST };

        private GameEnums.AbilityType m_abilityType;

        public boolean stackable() { return false; }
        public String[] activateCost() { String[] ret = new String[1]; ret[0] = "T"; return ret; };

        public TapForMana (GameObject father) {
            this.m_abilityType = GameEnums.AbilityType.ACTIVE;
            this.m_fatherObject = father;
        }

        public void activate () {
            this.activate (this);
        }

        public void activate (GameObject source) {
            this.m_fatherObject.m_controler.addMana("G");
            ((Permanent)this.m_fatherObject).tap();
        }

    }

	public LlanowarElves () {
        this.m_sub = { GameEnums.CreatureSubType.ELF }; //this.m_sub = { GameEnums.CreatureSubType.DRUID }; 
		// TODO: dois subtipos???
        this.power = 1;
        this.toughness = 1;
        if (this.haste) { this.sick = false; }
        else { this.sick = true; }
        this.manaCost = "G";
        this.name = "Llanowar Elves"
        this.types = "Creature - Elf"
        this.description = "Tap: add G to your mana pool.";
        this.flavor = "One bone broken for every twig snapped underfoot. Llanowar penalty for trespassing";
        this.abilities.add(new TapForMana);
    }

	public play () {
        this.power = 1;
        this.toughness = 1;
        this.sick = true;
    }
	
	public void discard () {
        this.place (GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone) {
        this.place (zone, 0);
    }

    public void kill () {
        this.place (GameEnums.Zone.GRAVEYARD);
    }
}
