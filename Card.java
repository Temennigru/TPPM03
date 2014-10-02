public abstract class Card extends GameObject {
    GameEnums.SuperType[] m_super;
    GameEnums.Type[] m_type;

    String name;
    String description;
    String flavor;

    Player owner;
    Player controler;

    public abstract void play (GameCore game);
    public abstract void discard (GameCore game);
    public abstract void place (GameCore game, GameEnums.Zone zone);
    public abstract void place (GameCore game, GameEnums.Zone zone, int position);
    public abstract String toString();
}