package GameCore.GameObjectCore;

import Core.*;

public abstract class Enchantment extends Permanent {
    GameEnums.EnchantmentType[] sub;
    boolean token;
    String manaCost;
}