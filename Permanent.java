public abstract class Permanent extends Card {
    final boolean tapped;

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