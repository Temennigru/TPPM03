package Core;

public class Command {
    private Command() {}

    public abstract String getName();

    public abstract String getDescription();

    public abstract void Exec (String[] args);
}