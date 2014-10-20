package GameCore.Ui.Tui;

import java.lang.System;
import java.lang.Runtime;
import java.io.*;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class TextUserInterface {

	private static TextUserInterface m_tui = null;
	private PrintStream m_out;
	private PrintStream m_log;
	private String m_output;

	// Singleton Methods
	private TextUserInterface(){} // Don't use this

	private TextUserInterface(String logfile) throws IOException {
		m_out = System.out;
		this.setLogFile(logfile);
		System.setOut(this.m_log);
		this.m_output = "";
		this.clearScreen();
	}

	public static TextUserInterface getTui() throws IOException {
		if (m_tui == null) { m_tui = new TextUserInterface("Doug.log"); }
		return m_tui;
	}

	public static TextUserInterface getTui(String logfile) throws IOException {
		if (m_tui == null) { m_tui = new TextUserInterface(logfile); }
		return m_tui;
	}

	public void setLogFile(String filename) throws IOException {
		this.m_log = new PrintStream(new File(filename));
	}



	// Output manipulation methods

	private void clearScreen() throws IOException {
		this.m_out.print("\033[2J");
	}

	private void printCursor() {
		this.m_out.print("> ");
	}

	public void setOutput(String output) throws IOException {
		System.out.println(output);
		this.clearScreen();
		this.m_output = output;
		this.m_out.println(String.format("%n") + output); // The newline fixes a small displacement bug when using CBreak term
	}

	public String getTextInput() throws IOException {
		this.printCursor();
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	public String getActionInput() throws IOException, InterruptedException {
		this.m_out.println("Controls: w, a, s, d, enter, esc");
		this.m_out.print("> ");
		TuiUtil.setTerminalToCBreak();
		int c = System.in.read();
		TuiUtil.restoreTerminal();
		switch (c) {
			case 119:
				return "UP";
			case 97:
				return "LEFT";
			case 115:
				return "DOWN";
			case 100:
				return "RIGHT";
			case 27: // Warning: This will consider anything that is not a character (such as arrow keys) as esc.
				return "ESC";
			case 10:
				return "ENTER";
			default:
				return "";
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException { // Test method
		TextUserInterface tui = TextUserInterface.getTui();
		while (true) {
			tui.setOutput("Hello! Press 1 to get text input and 2 to get key input");
			String temp = tui.getTextInput();
			if (temp.equals("1")) {
				tui.clearScreen();
				temp = tui.getTextInput();
				System.out.println(temp);
			} else {
				tui.clearScreen();
				temp = tui.getActionInput();
				System.out.println(temp);
			}
		}
	}
}