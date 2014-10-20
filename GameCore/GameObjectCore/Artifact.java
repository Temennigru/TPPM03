package Cards.Abstract;

import GameCore.*;

public abstract class Enchantment extends Permanent {
    GameEnums.ArtifactType[] sub;
    boolean token;
    String manaCost;
}