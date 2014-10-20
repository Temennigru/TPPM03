package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Land extends Permanent {
    public boolean stackable() { return false; }
    public GameEnums.LandSubType[] m_sub;
}