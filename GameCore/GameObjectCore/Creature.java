package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Creature extends Permanent {
    public GameEnums.CreatureSubType[] m_sub;
    protected boolean token = false;

    // Evergreen abilities
    protected boolean deathtouch = false;
    protected boolean defender = false;
    protected boolean doublestrike = false;
    protected boolean firststrike = false;
    protected boolean flash = false;
    protected boolean flying = false;
    protected boolean hexproof = false;
    protected boolean indestructible = false;
    protected boolean intimidate = false;
    protected boolean landwalk = false;
    protected boolean lifelink = false;
    protected boolean protection = false;
    protected boolean reach = false;
    public boolean trample = false; // TODO: Make this OO frinedly
    protected boolean vigilance = false;
    protected int regen = 0;

    public void attack (Player player) throws GameExceptions.GameException {
        GameCore game = GameCore.getGame();
        game.declareAttacker(this, player);
        if (!this.vigilance) { this.tap(); }
    }
}