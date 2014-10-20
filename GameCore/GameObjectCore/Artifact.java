package Cards.Abstract;

import Core.*;

public abstract class Enchantment extends Permanent {
    GameEnums.ArtifactType[] sub;
    boolean token;
    String manaCost;
}