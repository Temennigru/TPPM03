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

    public final String toString() {
        String tmp = this.name;
        if (this.isTapped()) { tmp += " T"; }
        tmp += " - " this.manaCost + String.format("%n") +
        this.types + String.format("%n") +
        this.description + String.format("%n") +
        this.flavor + String.format("%n");
        return tmp;
    }
}