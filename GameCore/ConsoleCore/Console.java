package GameCore.ConsoleCore;

import java.util.Scanner;

public class Console {
	private String currentOutput;
	private Vector<Command> commands;

	private void clearScreen() {
		for (int i = 0; i < currentOutput)
	}

	public Console() {
		this.commands = new Vector<Command>();
		this.currentOutput = new String();
	}

	public void setOutput(String output) {

	}

	public void installCommand(Command command) {
		this.commands.add(command);
	}

	public void execCommand (String commandName, String[] args) {
		Vector<Command> results = new Vector<Command>();
		Iterator<Command> itr = this.commands.iterator();
		while (itr.hasNxt()) {
			Command com = itr.next();
			if (com.getName.startsWith(commandName)) { results.add(com); }
		}

		if (results.size = 0)
	}

}
