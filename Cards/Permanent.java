package Cards;

import Core.*;

public abstract class Permanent extends Card {
    boolean tapped;
    boolean token = false;

    public final void tap() {
        tapped = true;
    }

    public final void untap() {
        tapped = false;
    }

    public final boolean isTapped() {
        return tapped;
    }
}