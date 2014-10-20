package GameCore.ConsoleCore;

import GameCore.*;
import GameCore.GameObjectCore.Card;
import java.util.Vector;

import java.io.IOException;
import java.io.InputStream;

public interface Console {
	public void installCommand(Command command);
	public Vector<Command> findCommand (String commandName, String[] args);
	public Card prompt() throws IOException, InterruptedException ;
}