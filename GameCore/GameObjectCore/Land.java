package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Land extends Permanent {
    public boolean stackable() { return false; }
    public GameEnums.LandSubType[] m_sub;
    public boolean cast () throws GameExceptions.GameException { return this.cast(false); }
    public boolean cast (boolean payManaCost) throws GameExceptions.GameException {
    	if (this.m_controler.landDrop()) {
    		this.play();
    		return true;
    	}
    	return false;
	}
}