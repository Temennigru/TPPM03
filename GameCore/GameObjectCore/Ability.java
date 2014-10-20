package GameCore.GameObjectCore;

public abstract class Ability extends GameObject {

	public Ability (GameObject father){}

	protected Ability() {}

    private GameEnums.AbilityType m_abilityType;

    public abstract String[] activateCost() throws GameExceptions.GameException;

    public abstract boolean activate () throws GameExceptions.GameException;

}