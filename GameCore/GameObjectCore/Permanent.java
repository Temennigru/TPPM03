package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Permanent extends Card {
    protected boolean token = false;

    private int damage = 0;

    private final void destroy() {}
    private final void sac() {}

    public final void tap() throws GameExceptions.GameException {
        tapped = true;
    }

    public final void untap() {
        tapped = false;
    }

    public final boolean isTapped() {
        return tapped;
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.untap();
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public void kill() throws GameExceptions.GameException {}

    public final int damage () { return this.damage; }
    public final void damage (int value) { this.damage = value; }
}