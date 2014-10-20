package GameCore.GameObjectCore;

import GameCore.*;

public abstract class Enchantment extends Permanent {
    GameEnums.EnchantmentType[] sub;
    boolean token;
    String manaCost;
}