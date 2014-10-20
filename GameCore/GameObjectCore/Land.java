package GameCore.GameObjectCore;

import Core.*;

public abstract class Land extends Permanent {
    public boolean stackable() { return false; }
    public GameEnums.LandSubType[] m_sub;
    public GameEnums.Type[] m_type = { GameEnums.Type.LAND };
}