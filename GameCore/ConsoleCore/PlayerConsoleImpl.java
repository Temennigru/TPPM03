package GameCore.ConsoleCore;

import GameCore.*;
import GameCore.GameObjectCore.Card;
import GameCore.Ui.Tui.TextUserInterface;
import GameCore.Ui.Gui.ImageDisplay;
import GameCore.Cards.*;
import GameCore.GameObjectCore.*;


import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import java.awt.event.WindowEvent;


import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;

public class PlayerConsoleImpl implements Console {
	private Vector<Command> commands;
	private Player m_player;

	private PlayerConsoleImpl(){} // Don't use this

	public PlayerConsoleImpl(Player player) {
		this.m_player = player;
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

	// TODO: Prompt for specific card sets.

	public Card prompt() throws IOException, InterruptedException { return this.prompt(false); }

	public Card prompt(boolean playerOnly) throws IOException, InterruptedException {
		playerOnly = false; // Bugged
		TextUserInterface tui = TextUserInterface.getTui();
		GameCore game = GameCore.getGame();
		if (!game.valid()) {} // TODO: Throw exception
		String com;
		// TODO: Implement actual commands

		GameEnums.Zone zone = null;

		ImageDisplay gui = new ImageDisplay(); // Gui card display                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

		boolean goRound = false;

		boolean alwaysTrue = true; // If you set this you will die
		do {
			goRound = false;
			gui.displayNew("");
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
					gui.dispose();
					return null;
				} else {
					tui.setOutput("Try again. (type \"help\" for help)", false);
					tui.newLine();
				}
				// Other zones are pointless for the time being.
			}


			int i = 0;

			com = "";

			while (!goRound) {

				// Check if there is anything to display

				boolean exists = false;

				for (Iterator<Card> itr = game.iterator(m_player, zone); itr.hasNext(); ) {
					Card tmp = itr.next();
					if (!playerOnly || tmp.m_controler == m_player) { exists = true; }
				}

				if (!exists) {
					tui.setOutput("No cards in specified zone", false);
					tui.newLine();
					goRound = true;
					zone = null;
					break;
				}

				do {
					Card tmp = game.elementAt(m_player, zone, i);

					if (playerOnly && tmp.m_controler != m_player) {
						if(com.equals("LEFT")) { if (i == 0) { i = game.zoneSize(m_player, zone); } else { i--; } }
						else if (com.equals("RIGHT")) { i = (i + 1) % game.zoneSize(m_player, zone); }
						continue;
					}

					// Display card

					tui.setOutput("Card number " + Integer.toString(i + 1) + String.format("%n"), false);
					tui.setOutput(tmp.toString() + String.format("%n"), false);
					gui.displayNew(ImageDisplay.BuildAddress(tmp));

					// End display card

					com = tui.getActionInput();
					if (com.equals("ENTER")) { gui.dispose(); return tmp; }
					else if (com.equals("ESC")) { goRound = true; zone = null; break; }
					else if (com.equals("LEFT")) { if (i == 0) { i = game.zoneSize(m_player, zone) - 1; } else { i--; } }
					else if (com.equals("RIGHT")) { i = (i + 1) % game.zoneSize(m_player, zone); }
					else if (com.equals("")) { goRound = true; break; }
				} while (true);
			}

		} while (alwaysTrue);

		// Hard coded ends here
		System.out.println("Something weird has happened");
		return null;
	}

	public static void main(String[] args) throws IOException, InterruptedException, GameExceptions.GameException {
		RealPlayer me = new RealPlayer("Loops");
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

		while (s != null) {
			s = me.prompt();
			if (s == null) {
				System.out.println("No card chosen");
			} else {
				System.out.println("Chosen card: " + s.name);
				if (s.name.equals("Strangleroot Geist")) {
					((Creature)s).kill();
				} else {
					((Permanent)s).tap();
				}
			}
		}
	}

}
