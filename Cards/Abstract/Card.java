package Cards.Abstract;

import Core.*;

import java.util.Vector;

public abstract class Card extends GameObject {
    public Vector<Ability> abilities;

    public GameEnums.SuperType[] m_super = {};
    public GameEnums.Type[] m_type;

    protected String name;
    protected String description;
    protected String flavor;
    protected String types;
    protected String manaCost;

    public void cast () {
        // TODO: use stack
        this.play();
    }
    public abstract void play ();
    public abstract void discard ();
    public abstract void place (GameEnums.Zone zone);
    public abstract void place (GameEnums.Zone zone, int position);
    public String toString() {
        return this.name + " - " + this.manaCost + String.format("%n") +
        this.types + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n");
    }
    public void activateAt(int ability) {}
}