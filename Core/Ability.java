public class Ability extends GameObject {

    GameEnums.AbilityType m_abilityType;
    public abstract boolean stackable();
    public abstract String[] activateCost();

    public abstract void activate ();

}