package Core;

public abstract class Ability extends GameObject {

	public Ability (GameObject father){}

	protected Ability() {}

    private GameEnums.AbilityType m_abilityType;

    public abstract String[] activateCost();

    public abstract void activate ();

}