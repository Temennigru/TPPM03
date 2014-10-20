package GameCore.ConsoleCore;

import GameCore.GameObjectCore.Card;

public interface Command {
    public abstract String getName();

    public abstract String getDescription();

    public abstract Card Exec (String[] args);

	public abstract void setOutput(String output);
}