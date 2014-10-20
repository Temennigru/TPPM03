package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Creature extends Permanent {
    public GameEnums.CreatureSubType[] m_sub;
    public GameEnums.Type[] m_type = { GameEnums.Type.CREATURE };
    protected boolean token = false;
    protected boolean sick = true;

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

    public void attack (Player player) throws GameExceptions.GameException {
        GameCore game = GameCore.getGame();
        //game.declareAttacker(this, player);
        if (!this.vigilance) { this.tap(); }
    }
}