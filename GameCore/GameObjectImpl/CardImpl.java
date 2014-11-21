package GameCore;
import GameCore.GameObjectCore.Card;
import javax.swing.ImageIcon;

// Card factory
public class CardImpl implements Card {

	private String                m_default_name;
	private String                m_default_mana;
	private GameEnums.SuperType[] m_default_superTypes;
	private GameEnums.Type[]      m_default_types;
	private GameEnums.SubType[]   m_default_subTypes;
	private boolean               m_default_deathtouch;
	private boolean               m_default_defender;
	private boolean               m_default_doublestrike;
	private boolean               m_default_firststrike;
	private boolean               m_default_flash;
	private boolean               m_default_flying;
	private boolean               m_default_hexproof;
	private boolean               m_default_indestructible;
	private boolean               m_default_intimidate;
	private String                m_default_landwalk;
	private boolean               m_default_lifelink;
	private String                m_default_protection;
	private boolean               m_default_reach;
	private boolean               m_default_trample;
	private boolean               m_default_vigilance;
	private int                   m_default_regen;
	private Ability[]             m_default_abilities;
	private int                   m_default_power;
	private int                   m_default_toughness;
	private String                m_default_flavor;
	private boolean               m_default_stackable;

	private String                m_name;
	private String                m_mana;
	private GameEnums.SuperType[] m_superTypes;
	private GameEnums.Type[]      m_types;
	private GameEnums.SubType[]   m_subTypes;
	private boolean               m_deathtouch;
	private boolean               m_defender;
	private boolean               m_doublestrike;
	private boolean               m_firststrike;
	private boolean               m_flash;
	private boolean               m_flying;
	private boolean               m_hexproof;
	private boolean               m_indestructible;
	private boolean               m_intimidate;
	private String                m_landwalk;
	private boolean               m_lifelink;
	private String                m_protection;
	private boolean               m_reach;
	private boolean               m_trample;
	private boolean               m_vigilance;
	private int                   m_regen;
	private Vector<Ability>       m_abilities;
	private int                   m_power;
	private int                   m_toughness;
	private String                m_flavor;
	private boolean               m_stackable;
	private boolean               m_damage;
	private boolean               m_sick;
	private Player                m_owner;

	private GameEnums.Zone        m_location;
	private GameCore.GameCore     m_game;
	private int                   m_id;
	private boolean               m_tapped;

	// TODO: Add dynamic support for counters
	private int                   m_plusp1lus1; // +1/+1 counters

	public CardImpl(
		String                name,
		String                mana,
		GameEnums.SuperType[] superTypes,
		GameEnums.Type[]      types,
		GameEnums.SubType[]   subTypes,
		boolean               deathtouch,
		boolean               defender,
		boolean               doublestrike,
		boolean               firststrike,
		boolean               flash,
		boolean               flying,
		boolean               haste,
		boolean               hexproof,
		boolean               indestructible,
		boolean               intimidate,
		String                landwalk,
		boolean               lifelink,
		String                protection,
		boolean               reach,
		boolean               trample,
		boolean               vigilance,
		int                   regen,
		Ability[]             abilities,
		int                   power,
		int                   toughness,
		String                flavor,
		boolean               stackable,
		Player                owner

		) throws GameExceptions.GameException {

			if (name == null) name = "";
			if (mana == null) mana = "";
			if (landwalk == null) landwalk = "";
			if (flavor == null) flavor = "";
			if (abilities == null) abilities = new Ability[]();

			this.m_default_name = name;
			this.m_default_mana = mana;
			this.m_default_superTypes = superTypes;
			this.m_default_types = types;
			this.m_default_subTypes = subTypes;
			this.m_default_deathtouch = deathtouch;
			this.m_default_defender = defender;
			this.m_default_doublestrike = doublestrike;
			this.m_default_firststrike = firststrike;
			this.m_default_flash = flash;
			this.m_default_flying = flying;
			this.m_default_hexproof = hexproof;
			this.m_default_indestructible = indestructible;
			this.m_default_intimidate = intimidate;
			this.m_default_landwalk = landwalk;
			this.m_default_lifelink = lifelink;
			this.m_default_protection = protection;
			this.m_default_reach = reach;
			this.m_default_trample = trample;
			this.m_default_vigilance = vigilance;
			this.m_default_regen = regen;
			this.m_default_abilities = abilities;
			this.m_default_power = power;
			this.m_default_toughness = toughness;
			this.m_default_flavor = flavor;
			this.m_default_stackable = stackable;
			this.m_owner = owner;
			this.m_controler = owner;
			// TODO: Add dynamic support for counters
			this.plusp1lus1 = 0;

			this.reset("all");

			this.m_game = GameCore.getGame();
			if (!m_game.valid()) {
				throw new GameExceptions.InvalidGameException();
			}

			this.m_id = this.m_game.getUniqueId();
	}

	private void getTriggerString (String event, String append) {
		StringBuilder ret = new StringBuilder();
		ret.append ("event = "); ret.append(event); ret.append("; ");
		ret.append ("name = "); ret.append(this.m_name); ret.append("; ");
		ret.append ("mana = "); ret.append(this.m_mana); ret.append("; ");

		for (GameEnums.SuperType i : this.m_superTypes) {
			ret.append ("supertype = "); ret.append(i.toString()); ret.append("; ");
		}

		for (GameEnums.Type i : this.m_superTypes) {
			ret.append ("type = "); ret.append(i.toString()); ret.append("; ");
		}

		for (GameEnums.SubType i : this.m_subTypes) {
			ret.append ("subtype = "); ret.append(i.toString()); ret.append("; ");
		}

		if (Arrays.asList(this.SubType).contains(GameEnums.Type.CREATURE)) {
			ret.append ("power = "); ret.append(this.m_power); ret.append("; ");
			ret.append ("toughness = "); ret.append(this.m_toughness); ret.append("; ");
		}

		ret.append ("deathtouch = "); ret.append(this.m_deathtouch); ret.append("; ");
		ret.append ("defender = "); ret.append(this.m_defender); ret.append("; ");
		ret.append ("doublestrike = "); ret.append(this.m_doublestrike); ret.append("; ");
		ret.append ("firststrike = "); ret.append(this.m_firststrike); ret.append("; ");
		ret.append ("flash = "); ret.append(this.m_flash); ret.append("; ");
		ret.append ("flying = "); ret.append(this.m_flying); ret.append("; ");
		ret.append ("hexproof = "); ret.append(this.m_hexproof); ret.append("; ");
		ret.append ("indestructible = "); ret.append(this.m_indestructible); ret.append("; ");
		ret.append ("intimidate = "); ret.append(this.m_intimidate); ret.append("; ");
		ret.append ("landwalk = "); ret.append(this.m_landwalk); ret.append("; ");
		ret.append ("lifelink = "); ret.append(this.m_lifelink); ret.append("; ");
		ret.append ("protection = "); ret.append(this.m_protection); ret.append("; ");
		ret.append ("reach = "); ret.append(this.m_reach); ret.append("; ");
		ret.append ("trample = "); ret.append(this.m_trample); ret.append("; ");
		ret.append ("vigilance = "); ret.append(this.m_vigilance); ret.append("; ");
		ret.append ("regen = "); ret.append(this.m_regen); ret.append("; ");

		ret.append ("id = "); ret.append(this.m_id); ret.append("; ");

		ret.append ("tapped = "); ret.append(this.m_tapped); ret.append("; ");
		ret.append ("sick = "); ret.append(this.m_sick); ret.append("; ");
		// TODO: Add dynamic support for counters
		ret.append ("plusp1lus1 = "); ret.append(this.m_plusp1lus1);

		if (append != null && !append.isEmpty()) {
			ret.append("; ");
			ret.append(append);
		}


		return ret.toString();
	}

	private void sendTriggerEvent(String event) {
		this.m_game.trigger(this.getTriggerString(event, null), this);
	}

	private void sendTriggerEvent(String event, String append) {
		this.m_game.trigger(this.getTriggerString(event, append), this);
	}

	// This is where the magic happens
    public boolean cast (String mana) throws GameExceptions.GameException {
    	this.cast(true);
    }

    public boolean cast (boolean payManaCost) throws GameExceptions.GameException {

    	if (payManaCost) {
	    	if (this.controler.spendMana(this.m_mana)) {
	    		this.m_game.stack(this);
	    		return true;
	    	} else {
	    		return false;
	    	}
	    } else {
    		this.m_game.stack(this);
    		return true;
	    }

	    this.sendTriggerEvent("cast", "location = " + this.m_location.toString());
    }

    public abstract boolean cast(GameObject from) throws GameExceptions.GameException {
    	throw new GameExceptions.MethodNotImplementedException();
    }


    public void play () throws GameExceptions.GameException {
    	if (Arrays.asList(this.SubType).contains(GameEnums.Type.CREATURE)     ||
    		Arrays.asList(this.SubType).contains(GameEnums.Type.LAND)         ||
    		Arrays.asList(this.SubType).contains(GameEnums.Type.ARTIFACT)     ||
    		Arrays.asList(this.SubType).contains(GameEnums.Type.ENCHANTMENT)  ||
    		Arrays.asList(this.SubType).contains(GameEnums.Type.PLANESWALKER)
    		) {
    		this.reset("all");
    		this.place(GameEnums.Zone.BATTLEFIELD);
    	} // For permanents this implementation is generally sufficient
    }

    public void discard () throws GameExceptions.GameException {
    	this.place(GameEnums.Zone.GRAVEYARD);
    	this.sendTriggerEvent("discard");
    }

    public void place (GameEnums.Zone zone) throws GameExceptions.GameException {
    	GameEnums.Zone temp = this.m_location;
    	registerOnZone(this, zone);
    	this.m_location = zone;

    	if (zone == GameEnums.Zone.BATTLEFIELD) {
	    	this.m_sick = true;
	    	this.sendTriggerEvent("etb", "location = " + temp.toString());
	    } else {
	    	this.sendTriggerEvent("enteredThe" + zone.toString(), "location = " + temp.toString());
	    }
	    this.reset("all");
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
    	// Not implemented
    	throw new GameExceptions.MethodNotImplementedException();
    }

    // Print card details
    public String toString() throws GameExceptions.GameException {
    	this.toString(false);
    }

    public String toString(boolean simple) throws GameExceptions.GameException {
    	StringBuilder ret = new StringBuilder();
		ret.append(this.m_name);

		if (!this.m_mana.isEmpty()) {
			ret.append(" - ");
			ret.append(this.m_mana);
		}

		if (!this.m_tapped) {
			ret.append(" - ");
			ret.append(this.m_mana);
		}

		ret.append(String.format("%n"));

		for (GameEnums.SuperType i : this.m_superTypes) {
			ret.append(i.toString()); ret.append(" ");
		}

		for (GameEnums.Type i : this.m_superTypes) {
			ret.append(i.toString()); ret.append(" ");
		}

		if (this.m_superTypes != null && this.m_superTypes.length > 0) {
			ret.append("- ");
		}

		for (GameEnums.SubType i : this.m_subTypes) {
			ret.append(i.toString()); ret.append(" ");
		}

		ret.append(String.format("%n"));
		ret.append(String.format("%n"));


		if (!simple) {
			if (this.m_deathtouch){ ret.append("deathtouch"); ret.append(String.format("%n")); }
			if (this.m_defender){ ret.append("defender"); ret.append(String.format("%n")); }
			if (this.m_doublestrike){ ret.append("doublestrike"); ret.append(String.format("%n")); }
			if (this.m_firststrike){ ret.append("firststrike"); ret.append(String.format("%n")); }
			if (this.m_flash){ ret.append("flash"); ret.append(String.format("%n")); }
			if (this.m_flying){ ret.append("flying"); ret.append(String.format("%n")); }
			if (this.m_hexproof){ ret.append("hexproof"); ret.append(String.format("%n")); }
			if (this.m_indestructible){ ret.append("indestructible"); ret.append(String.format("%n")); }
			if (this.m_intimidate){ ret.append("intimidate"); ret.append(String.format("%n")); }
			if (this.m_landwalk){ ret.append("landwalk"); ret.append(String.format("%n")); }
			if (this.m_lifelink){ ret.append("lifelink"); ret.append(String.format("%n")); }
			if (this.m_protection){ ret.append("protection"); ret.append(String.format("%n")); }
			if (this.m_reach){ ret.append("reach"); ret.append(String.format("%n")); }
			if (this.m_trample){ ret.append("trample"); ret.append(String.format("%n")); }
			if (this.m_vigilance){ ret.append("vigilance"); ret.append(String.format("%n")); }
			if (this.m_regen > 0){ ret.append(Integer.toString(this.m_regen) + "x regenerate"); ret.append(String.format("%n")); }

			for (Ability i : this.m_abilities.toArray()) {
				ret.appent(i.toString()); ret.append(String.format("%n"));
			}
		}

		if (Arrays.asList(this.SubType).contains(GameEnums.Type.CREATURE)) {
			ret.append(this.m_power); ret.append("/");
			ret.append(this.m_toughness); ret.append(String.format("%n"));
		}

		return ret.toString();
    }

    public ImageIcon getImg(boolean large) {
    	ImageIcon[] imgs = this.m_game.getImages(this.m_name.replaceAll(" ", ""));
    	if (large) {
    		return imgs[2];
    	} else if (!this.m_tapped) {
    		return imgs[1];
    	} else {
    		return imgs[0];
    	}
    }

    // Ability access

    public Ability[] getAbilities() throws GameExceptions.GameException {
    	return this.m_abilities.toArray();
    }

    public boolean activateAt(int ability) throws GameExceptions.GameException {
    	this.m_game.stack(this.m_abilities.elementAt(ability));
    }

    // Modifiers / Member access
    public void reset(String field) throws GameExceptions.GameException {
    	if (field.equals("name") || field.equals("all")) {
			this.m_name = this.m_default_name;
		} if (field.equals("mana") || field.equals("all")) {
			this.m_mana = this.m_default_mana;
		} if (field.equals("superTypes") || field.equals("all")) {	
			this.m_superTypes = this.m_default_superTypes;
		} if (field.equals("types") || field.equals("all")) {	
			this.m_types = this.m_default_types;
		} if (field.equals("subTypes") || field.equals("all")) {	
			this.m_subTypes = this.m_default_subTypes;
		} if (field.equals("deathtouch") || field.equals("all")) {	
			this.m_deathtouch = this.m_default_deathtouch;
		} if (field.equals("defender") || field.equals("all")) {	
			this.m_defender = this.m_default_defender;
		} if (field.equals("doublestrike") || field.equals("all")) {	
			this.m_doublestrike = this.m_default_doublestrike;
		} if (field.equals("firststrike") || field.equals("all")) {	
			this.m_firststrike = this.m_default_firststrike;
		} if (field.equals("flash") || field.equals("all")) {	
			this.m_flash = this.m_default_flash;
		} if (field.equals("flying") || field.equals("all")) {	
			this.m_flying = this.m_default_flying;
		} if (field.equals("hexproof") || field.equals("all")) {	
			this.m_hexproof = this.m_default_hexproof;
		} if (field.equals("indestructible") || field.equals("all")) {	
			this.m_indestructible = this.m_default_indestructible;
		} if (field.equals("intimidate") || field.equals("all")) {	
			this.m_intimidate = this.m_default_intimidate;
		} if (field.equals("landwalk") || field.equals("all")) {	
			this.m_landwalk = this.m_default_landwalk;
		} if (field.equals("lifelink") || field.equals("all")) {	
			this.m_lifelink = this.m_default_lifelink;
		} if (field.equals("protection") || field.equals("all")) {	
			this.m_protection = this.m_default_protection;
		} if (field.equals("reach") || field.equals("all")) {	
			this.m_reach = this.m_default_reach;
		} if (field.equals("trample") || field.equals("all")) {	
			this.m_trample = this.m_default_trample;
		} if (field.equals("vigilance") || field.equals("all")) {	
			this.m_vigilance = this.m_default_vigilance;
		} if (field.equals("regen") || field.equals("all")) {	
			this.m_regen = this.m_default_regen;
		} if (field.equals("abilities") || field.equals("all")) {	
			this.m_abilities = new Vector<Ability>(Arrays.asList(this.m_default_abilities));
		} if (field.equals("power") || field.equals("all")) {	
			this.m_power = this.m_default_power;
		} if (field.equals("toughness") || field.equals("all")) {	
			this.m_toughness = this.m_default_toughness;
		} if (field.equals("flavor") || field.equals("all")) { 
			this.m_flavor = this.m_default_flavor;
		} if (field.equals("stackable") || field.equals("all")) { 
			this.m_stackable = this.m_default_stackable;
		} if (field.equals("tapped") || field.equals("all")) {
			this.m_tapped = false;
		} if (field.equals("counters") || field.equals("all")) {
			// TODO: Add dynamic support for counters
			this.m_plusp1lus1 = 0;
		} if (field.equals("damage") || field.equals("all")) {
			this.m_damage = 0;
		} if (field.equals("sick") || field.equals("all")) {
			this.m_sick = false;
		}
    }

    public int power () throws GameExceptions.GameException {
    	return this.m_power;
    } public void power (int value) throws GameExceptions.GameException {
    	this.m_power = value;
    }

    public int toughness() throws GameExceptions.GameException {
    	return this.m_toughness;
    } public void toughness(int value) throws GameExceptions.GameException {
    	this.m_toughness = value;
    }

    public int damage() throws GameExceptions.GameException {
    	return this.m_damage;
    } public void damage (int value) throws GameExceptions.GameException  {
    	this.m_damage = value;
    }

    public boolean isTapped() throws GameExceptions.GameException {
    	return this.m_tapped;
    } public void isTapped(boolean tapped) throws GameExceptions.GameException { // For use when no trigger should be 
    	this.m_tapped = tapped;
    }

    public void tap() throws GameExceptions.GameException {
    	this.isTapped(true);
    	this.sendTriggerEvent("tap");
    }
    public void unTap() throws GameExceptions.GameException {
    	this.isTapped(false);
    	this.sendTriggerEvent("untap");
    }

    public String name() throws GameExceptions.GameException {
    	return this.m_;
    } public void name(String name) throws GameExceptions.GameExceptio {
    	this.m_name = value;
    }

    public Player controler() throws GameExceptions.GameException {
    	return this.m_controler;
    } public void controler(Player player) throws GameExceptions.GameException {
    	this.m_controler = value;
    }

    public Player owner() throws GameExceptions.GameException { // Owner can't be changed
    	return this.m_owner;
	}

    public GameEnums.SuperType[] superTypes() throws GameExceptions.GameException {
    	return this.m_superTypes;
    } public void superTypes(GameEnums.SuperType[] subtypes) throws GameExceptions.GameException {
    	this.m_superTypes = value;
    }

    public GameEnums.Type[] types() throws GameExceptions.GameException {
    	return this.m_types;
    } public void types(GameEnums.Type[] subtypes) throws GameExceptions.GameException {
    	this.m_types = value;
    }

    public GameEnums.SubType[] subTypes() throws GameExceptions.GameException {
    	return this.m_subTypes;
    } public void subTypes(GameEnums.SubType[] subtypes) throws GameExceptions.GameException {
    	this.m_subTypes = value;
    }

    public GameEnums.Zone location() throws GameExceptions.GameException {
    	return this.m_location;
    }

    public boolean stackable() throws GameExceptions.GameException {
    	return this.m_stackable;
    } public void stackable(boolean val) throws GameExceptions.GameException {
    	this.m_stackable = value;
    }

    public GameObject source() throws GameExceptions.GameException {
    	return null;
    } public void source(GameObject val) throws GameExceptions.GameException {
    	// There is no source for cards
    }

    public GameObject[] targets() throws GameExceptions.GameException {
    	// TODO: Implement targetable spells
    	return null;
    	//return this.m_targets;
    } public void destination(GameObject val) throws GameExceptions.GameException {
    	//this.m_targets = value;
    }

    public Player owner() throws GameExceptions.GameException { // Owner can't change
    	return this.m_owner;
	}

    public Player controler() throws GameExceptions.GameException {
    	return this.m_controler;
    } public void controler(Player val) throws GameExceptions.GameException {
    	this.m_controler = value;
    }

    public boolean sick() throws GameExceptions.GameException {
    	return this.m_sick;
    } public sick(boolean val) throws GameExceptions.GameException {
    	this.m_sick = val;
    }

    public boolean castable() throws GameExceptions.GameException {
    	return (this.m_location == GameEnums.Zone.HAND && this.m_owner.spendable(this.m_mana));
    }

    public boolean checkMana(String mana) throws GameExceptions.GameException {
    	int[] cost = new int[6];
    	int[] payment = new int[6];

    	for (int i = 0; i < mana.length(); i++) {
            switch (mana.charAt(i)) {
                case 'R':
                    cost[0] += addSub * 1;
                    break;
                case 'G':
                    cost[1] += addSub * 1;
                    break;
                case 'B':
                    cost[2] += addSub * 1;
                    break;
                case 'U':
                    cost[3] += addSub * 1;
                    break;
                case 'W':
                    cost[4] += addSub * 1;
                    break;
                default:
                    if (Character.isDigit(mana.charAt(i))) {
                        int j = i;
                        while (i < mana.length() && Character.isDigit(mana.charAt(i))) { i++; }
                        cost[5] += addSub * Integer.parseInt(mana.substring(j, i));
                        i--;
                    } else {
                        assert false;
                    }
                    break;
            }
        }
		for (int i = 0; i < this.m_mana.length(); i++) {
            switch (this.m_mana.charAt(i)) {
                case 'R':
                    payment[0] += addSub * 1;
                    break;
                case 'G':
                    payment[1] += addSub * 1;
                    break;
                case 'B':
                    payment[2] += addSub * 1;
                    break;
                case 'U':
                    payment[3] += addSub * 1;
                    break;
                case 'W':
                    payment[4] += addSub * 1;
                    break;
                default:
                    if (Character.isDigit(this.m_mana.charAt(i))) {
                        int j = i;
                        while (i < this.m_mana.length() && Character.isDigit(this.m_mana.charAt(i))) { i++; }
                        payment[5] += addSub * Integer.parseInt(this.m_mana.substring(j, i));
                        i--;
                    } else {
                        assert false;
                    }
                    break;
            }
        }

        // If colored mana is less than required
        for (int i = 0; i < 5; i++) {
        	if (cost[i] > payment[i]) { return false; }
        }

        // If trying to spend more or less than required mana
        if (cost[0] + cost[1] + cost[2] + cost[3] + cost[4] + cost[5] + cost[6] !=
        	payment[0] + payment[1] + payment[2] + payment[3] + payment[4] + payment[5] + payment[6]) {
        	return false;
        }

        return true;
    }


    // Evergreen abilities
    public boolean deathtouch() throws GameExceptions.GameException {
    	return this.m_deathtouch;
    } public void deathtouch(boolean val) throws GameExceptions.GameException {
    	this.m_deathtouch = value;
    }

    public boolean defender() throws GameExceptions.GameException {
    	return this.m_defender;
    } public void defender(boolean val) throws GameExceptions.GameException {
    	this.m_defender = value;
    }

    public boolean doublestrike() throws GameExceptions.GameException {
    	return this.m_doublestrike;
    } public void doublestrike(boolean val) throws GameExceptions.GameException {
    	this.m_doublestrike = value;
    }

    public boolean firststrike() throws GameExceptions.GameException {
    	return this.m_firststrike;
    } public void firststrike(boolean val) throws GameExceptions.GameException {
    	this.m_firststrike = value;
    }

    public boolean flash() throws GameExceptions.GameException {
    	return this.m_flash;
    } public void flash(boolean val) throws GameExceptions.GameException {
    	this.m_flash = value;
    }

    public boolean flying() throws GameExceptions.GameException {
    	return this.m_flying;
    } public void flying(boolean val) throws GameExceptions.GameException {
    	this.m_flying = value;
    }

    public boolean haste() throws GameExceptions.GameException {
    	return this.m_haste;
    } public void haste(boolean val) throws GameExceptions.GameException {
    	this.m_haste = value;
    }

    public boolean hexproof() throws GameExceptions.GameException {
    	return this.m_hexproof;
    } public void hexproof(boolean val) throws GameExceptions.GameException {
    	this.m_hexproof = value;
    }

    public boolean indestructible() throws GameExceptions.GameException {
    	return this.m_indestructible;
    } public void indestructible(boolean val) throws GameExceptions.GameException {
    	this.m_indestructible = value;
    }

    public boolean intimidate() throws GameExceptions.GameException {
    	return this.m_intimidate;
    } public void intimidate(boolean val) throws GameExceptions.GameException {
    	this.m_intimidate = value;
    }

    public String landwalk() throws GameExceptions.GameException {
    	return this.m_landwalk;
    } public void landwalk(boolean val) throws GameExceptions.GameException {
    	this.m_landwalk = value;
    }

    public boolean lifelink() throws GameExceptions.GameException {
    	return this.m_lifelink;
    } public void lifelink(boolean val) throws GameExceptions.GameException {
    	this.m_lifelink = value;
    }

    public String protection() throws GameExceptions.GameException {
    	return this.m_protection;
    } public void protection(String val) throws GameExceptions.GameException {
    	this.m_protection = value;
    }

    public boolean reach() throws GameExceptions.GameException {
    	return this.m_reach;
    } public void reach(boolean val) throws GameExceptions.GameException {
    	this.m_reach = value;
    }

    public boolean trample() throws GameExceptions.GameException {
    	return this.m_trample;
    } public void trample(boolean val) throws GameExceptions.GameException {
    	this.m_trample = value;
    }

    public boolean vigilance() throws GameExceptions.GameException {
    	return this.m_vigilance;
    } public void vigilance(boolean val) throws GameExceptions.GameException {
    	this.m_vigilance = value;
    }

    public int regen() throws GameExceptions.GameException {
    	return this.m_regen;
    } public void regen(int val) throws GameExceptions.GameException {
    	this.m_regen = value;
    }

}