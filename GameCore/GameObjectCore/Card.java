package Cards.Abstract;

import Core.*;

import java.util.Vector;

public abstract class Card extends GameObject {
    public Vector<Ability> abilities;

    public GameEnums.Zone location;
    public GameEnums.SuperType[] m_super = {};
    public GameEnums.Type[] m_type;

    public String name = "";
    protected String description = "";
    protected String flavor = "";
    protected String types = "";
    protected String manaCost = "";

    public boolean cast () throws GameExceptions.GameException {
        // TODO: use stack
        if (this.location != GameEnums.Zone.HAND) { throw new GameExceptions.WrongZoneException(this, this.location, GameEnums.Zone.HAND); }
        GameCore game = GameCore.getGame();
        if (!game.)
        this.play();
    }

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

    public String toString() {
        return this.name + " - " + this.manaCost + String.format("%n") +
        this.types + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n");
    }

    public boolean activateAt(int ability) throws GameExceptions.GameException {
        return this.abilities.elementAt(ability).activate();
    }
}