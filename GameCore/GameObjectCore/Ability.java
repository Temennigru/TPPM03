package GameCore.GameObjectCore;

import GameCore.GameEnums;
import GameCore.GameExceptions;
import GameCore.GameObjectCore.GameObject;

public abstract class Ability implements GameObject {

	public Ability (GameObject father) {}

	private Ability() {}

    public abstract GameEnums.AbilityType abilityType() throws GameExceptions.GameException;

    public abstract String[] activateCost() throws GameExceptions.GameException;

    public abstract boolean activate () throws GameExceptions.GameException; 

}