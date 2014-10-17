public abstract class Card extends GameObject {
    Vector<Ability> abilities;

    GameEnums.SuperType[] m_super = {};
    GameEnums.Type[] m_type;

    String name;
    String description;
    String flavor;

    public void cast () {} // Does nothing by default. Only cards with "when you cast" use this.
    public abstract void play ();
    public abstract void discard ();
    public abstract void place (GameEnums.Zone zone);
    public abstract void place (GameEnums.Zone zone, int position);
    public abstract String toString();
}