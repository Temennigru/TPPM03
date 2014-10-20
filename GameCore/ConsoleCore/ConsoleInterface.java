package GameCore.ConsoleCore;

public interface ConsoleInterface {
	public void installCommand(Command command);
	public void execCommand (String commandName, String[] args);
}