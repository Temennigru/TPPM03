public abstract class Card {
    GameEnums.SuperType m_super;
    GameEnums.Type m_type;
    // SubType to be declared in subclass

    abstract void play (GameCore game);
    abstract void discard (GameCore game);
    abstract void place (GameCore game, GameEnums.Zone zone);
    abstract void place (GameCore game, GameEnums.Zone zone, int position);
}