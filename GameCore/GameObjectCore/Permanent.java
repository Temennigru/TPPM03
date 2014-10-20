package GameCore.GameObjectCore;

import Core.*;

public abstract class Permanent extends Card {
    protected boolean tapped = false;
    protected boolean token = false;


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

    public String toString() {
        String tmp = this.name;
        tmp += " - " + this.manaCost;
        if (this.isTapped()) { tmp += " T"; }
        tmp += String.format("%n") +
        this.types + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n");
        return tmp;
    }
}