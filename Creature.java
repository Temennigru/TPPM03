public abstract class Creature extends Permanent {
    GameEnums.CreatureSubType[] m_sub;
    GameEnums.Type[] m_type = { GameEnums.Type.CREATURE };
    int power;
    int toughness;
    boolean token = false;
    boolean sick = true;
    String manaCost;

    public abstract void kill (GameCore game);
}