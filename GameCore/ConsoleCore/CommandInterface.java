package GameCore.ConsoleCore;

public interface CommandInterface {
    public abstract String getName();

    public abstract String getDescription();

    public abstract void Exec (String[] args);

	public abstract void setOutput(String output);
}