public abstract class Creature extends Card {
    GameEnums.CreatureSubType[] sub;
    GameEnums.Type[] type = { CREATURE };
    int power;
    int toughness;
    boolean token = false;
    boolean sick = true;
    String manaCost;

    public abstract void kill (GameCore game);
}