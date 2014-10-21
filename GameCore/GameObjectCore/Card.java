package GameCore.GameObjectCore;

import GameCore.*;

import java.util.Vector;
import java.util.Arrays;

public abstract class Card extends GameObject {
    public Vector<Ability> abilities;

    public GameEnums.Zone location;
    public GameEnums.SuperType[] m_super = {};
    public GameEnums.Type[] m_type;
    public String m_imgLocation = "";

    // For printing purpouses
    protected int power = 0;
    protected int toughness = 0;
    private int damage = 0;
    protected boolean tapped = false;
    public boolean sick = true;
    public boolean isTapped() { return tapped; }

    public boolean haste = false;

    public String name = "";
    protected String description = "";
    protected String flavor = "";
    protected String types = "";
    protected String manaCost = "";

    // Cards that 
    public boolean cast () throws GameExceptions.GameException {
        return this.cast(true);
    }

    public boolean cast (boolean payManaCost) throws GameExceptions.GameException {
        // TODO: use stack
        if (this.location != GameEnums.Zone.HAND) { throw new GameExceptions.WrongZoneException(this, this.location, GameEnums.Zone.HAND); }
        GameCore game = GameCore.getGame();
        if (payManaCost) {
            if (!game.spendMana(this.m_controler, this.manaCost)) { return false; } // Mana is subtracted from whoever controls the spell when it is cast.
        }
        this.play();
        return true;
    }

    // This is where the magic happens
    public abstract void play () throws GameExceptions.GameException;

    public void discard () throws GameExceptions.GameException {
        if (this.location != GameEnums.Zone.HAND) { throw new GameExceptions.WrongZoneException(this, this.location, GameEnums.Zone.HAND); }
        this.place (GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone) throws GameExceptions.GameException {
        this.place (zone, 0);
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public final int damage () { return this.damage; }
    public final void damage (int value) { this.damage = value; }

    public String toString() {

        // Creature
        if (Arrays.asList(this.m_type).contains(GameEnums.Type.CREATURE)) {

            String tmp = "Owner: " + this.m_owner.name + String.format("%n") +
            "Controler: " + this.m_controler.name + String.format("%n");

            if (sick && !haste) { tmp += "Sick" + String.format("%n"); }

            tmp += this.name + " - " + this.manaCost;

            if (this.isTapped()) { tmp += " T"; }

            tmp += String.format("%n") +
            this.types + String.format("%n") +
            this.description + String.format("%n") +
            this.flavor + String.format("%n") +
            Integer.toString(this.power) + "/" + Integer.toString(this.toughness - this.damage) + String.format("%n");

            return tmp;
        // Permanent
        } else if (Arrays.asList(this.m_type).contains(GameEnums.Type.ENCHANTMENT)  ||
                   Arrays.asList(this.m_type).contains(GameEnums.Type.LAND)         ||
                   Arrays.asList(this.m_type).contains(GameEnums.Type.PLANESWALKER) ||
                   Arrays.asList(this.m_type).contains(GameEnums.Type.ARTIFACT) ) {
            String tmp = "Owner: " + this.m_owner.name + String.format("%n") +
            "Controler: " + this.m_controler.name + String.format("%n") +
            this.name;
            tmp += " - " + this.manaCost;
            if (this.isTapped()) { tmp += " T"; }
            tmp += String.format("%n") +
            this.types + String.format("%n") +
            this.description + String.format("%n") +
            this.flavor + String.format("%n");
            return tmp;

        // Regular
        } else {
            return "Owner: " + this.m_owner.name + String.format("%n") +
            "Controler: " + this.m_controler.name + String.format("%n") +
            this.name + " - " + this.manaCost + String.format("%n") +
            this.types + String.format("%n") +
            this.description + String.format("%n") +
            this.flavor + String.format("%n");
        }
    }

    public boolean activateAt(int ability) throws GameExceptions.GameException {
        return this.abilities.elementAt(ability).activate();
    }
    
    public final int toughness () { return this.toughness; }
    public final int power () { return this.power; }

    public final void toughness (int value) { this.toughness = value; }
    public final void power (int value) { this.power = value; }
}