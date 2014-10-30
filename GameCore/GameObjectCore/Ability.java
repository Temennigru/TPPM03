package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Ability implements GameObject {

	public Ability (GameObject father) {}

	private Ability() {}

    public abstract GameEnums.AbilityType m_abilityType() throws GameExceptions.GameException;

    public abstract String[] activateCost() throws GameExceptions.GameException;

    public abstract boolean activate () throws GameExceptions.GameException;

}