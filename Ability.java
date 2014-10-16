public class Ability extends GameObject {

    GameEnums.AbilityType m_abilityType;
    public final const boolean stackable;
    public final const String[] activateCost;

    public abstract activate (GameCore game);

}