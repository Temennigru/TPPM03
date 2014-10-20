package GameCore.ConsoleCore;

import GameCore.*;
import GameCore.GameObjectCore.Card;
import GameCore.Ui.Tui.TextUserInterface;
import GameCore.Cards.*;


import java.io.IOException;
import java.io.InputStream;


import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class PlayerConsoleImpl implements Console {
	private Vector<Command> commands;
	private Player player;

	private PlayerConsoleImpl(){} // Don't use this

	public PlayerConsoleImpl(Player player) {
		this.player = player;
		this.commands = new Vector<Command>();
	}

	public void installCommand(Command command) {
		this.commands.add(command);
	}

	public Vector<Command> findCommand (String commandName, String[] args) {
		Vector<Command> results = new Vector<Command>();
		Iterator<Command> itr = this.commands.iterator();
		while (itr.hasNext()) {
			Command com = itr.next();
			if (com.getName().startsWith(commandName)) { results.add(com); }
		}
		return results;
	}

	public Card prompt() throws IOException, InterruptedException {
		TextUserInterface tui = TextUserInterface.getTui();
		GameCore game = GameCore.getGame();
		if (!game.valid()) {} // TODO: Throw exception
		String com;
		// TODO: Implement actual commands

		Iterator<Card> itr = null;
		GameEnums.Zone zone = null;

		while (zone == null){
			com = tui.getTextInput();
			if (new String("help").startsWith(com)) {
				tui.setOutput(
					"Commands:" + String.format("%n") +
					"battlefield" + String.format("%n") +
					"hand" + String.format("%n") +
					"graveyard" + String.format("%n") +
					"end", false);
				tui.newLine();
			} else if (new String("battlefield").startsWith(com)) {
				zone = GameEnums.Zone.BATTLEFIELD;
			} else if (new String("hand").startsWith(com)) {
				zone = GameEnums.Zone.HAND;
			} else if (new String("graveyard").startsWith(com)) {
				zone = GameEnums.Zone.GRAVEYARD;
			} else if (new String("end").startsWith(com)) {
				return null;
			} else {
				tui.setOutput("Try again. (type \"help\" for help)");
			}
			// Other zones are pointless for the time being.
		}

		Card ret = null;

		// Left counter
		int i = 0;
		com = "";

		while (ret == null) {
			itr = game.iterator(this.player, zone);

			if (!itr.hasNext()) {
				tui.setOutput("No cards in specified zone", false);
				tui.newLine();
				return this.prompt();
			}

			if (com.equals("LEFT")) {
				// If control reaches here then the player pressed left
				for (int j = 0; j < i - 1; j++) { itr.next(); } // Only way to make an iterator move left.
			}

			i = 0;

			while (itr.hasNext()) {
				Card tmp = itr.next();
				tui.setOutput(tmp.toString() + String.format("%n"), false);
				com = tui.getActionInput();
				if (com.equals("ENTER")) { return tmp; }
				else if (com.equals("ESC")) { return this.prompt(); } // Lazy way out.
				else if (com.equals("LEFT") || com.equals("")) { break; }
				// RIGHT will work naturally
				i++;
			}

		}
		// Hard coded ends here
		return null;
	}

	public static void main(String[] args) throws IOException, InterruptedException, GameExceptions.GameException {
		RealPlayer me = new RealPlayer("Loops", null);
		GameCore game = GameCore.makeGame(me, null);


		Card s;

		s = new StranglerootGeist();
		s.m_owner = me;
		s.m_controler = me;

		s.play();

		s = new Forest();
		s.m_owner = me;
		s.m_controler = me;

		s.play();

		s = new Swamp();
		s.m_owner = me;
		s.m_controler = me;

		s.play();

		while (true) {
			s = me.prompt();
			if (s == null) {
				System.out.println("No card chosen");
			} else {
				System.out.println("Chosen card: " + s.name);
				if (s.name().equals("Strangleroot Geist")) {
					((Creature)s).kill();
			}
		}
	}

}
