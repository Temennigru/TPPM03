package Cards.Abstract;

import Core.*;

public abstract class Creature extends Permanent {
    public GameEnums.CreatureSubType[] m_sub;
    public GameEnums.Type[] m_type = { GameEnums.Type.CREATURE };
    protected int power;
    protected int toughness;
    protected boolean token = false;
    protected boolean sick = true;

    private int damage = 0;

    // Evergreen abilities
    protected boolean deathtouch = false;
    protected boolean defender = false;
    protected boolean doublestrike = false;
    protected boolean firststrike = false;
    protected boolean flash = false;
    protected boolean flying = false;
    protected boolean haste = false;
    protected boolean hexproof = false;
    protected boolean indestructible = false;
    protected boolean intimidate = false;
    protected boolean landwalk = false;
    protected boolean lifelink = false;
    protected boolean protection = false;
    protected boolean reach = false;
    protected boolean trample = false;
    protected boolean vigilance = false;
    protected int regen = 0;

    public abstract void kill() throws GameExceptions.GameException;

    public void attack (Player player) throws GameExceptions.GameException {
        GameCore game = GameCore.getGame();
        game.declareAttacker(this, player);
        if (!this.vigilance) { this.tap(); }
    }

    public final int toughness () { return this.toughness; }
    public final int power () { return this.power; }
    public final int damage () { return this.damage; }

    public final void toughness (int value) { this.toughness = value; }
    public final void power (int value) { this.power = value; }
    public final void damage (int value) { this.damage = value; }

    public String toString() {
        String tmp = this.name;
        tmp += " - " + this.manaCost;
        if (this.isTapped()) { tmp += " T"; }
        tmp += String.format("%n") +
        this.types + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n") +
        Integer.toString(this.power) + "/" + Integer.toString(this.toughness) + String.format("%n");
        return tmp;
    }
}