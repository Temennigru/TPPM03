package Cards;

import Core.*;

public abstract class Creature extends Permanent {
    GameEnums.LandSubType[] m_sub;
    GameEnums.Type[] m_type = { LAND };
}