public class Command {
    private Command() {}

    public abstract String getName();

    public abstract String getDescription();

    public abstract void Exec (GameCore game, String[] args);
}