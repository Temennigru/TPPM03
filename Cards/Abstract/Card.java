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

    public void cast () {} // Does nothing by default. Only cards with "when you cast" use this.
    public abstract void play ();
    public abstract void discard ();
    public abstract void place (GameEnums.Zone zone);
    public abstract void place (GameEnums.Zone zone, int position);
    public abstract String toString();
}