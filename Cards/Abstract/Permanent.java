package Cards.Abstract;

import Core.*;

public abstract class Permanent extends Card {
    protected boolean tapped = false;
    protected boolean token = false;


    private final void destroy() {}
    private final void sac() {}

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