package GameCore.Ui.Tui;

import java.lang.System;
import java.lang.Runtime;
import java.lang.Thread;
import java.io.*;
import java.util.Scanner;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class TextUserInterface {

	// TODO: Stack headers

	private static TextUserInterface m_tui = null;
	private static boolean m_restore = false;
    private static TuiUtil.CleanupHook m_failsafe = null;
    private static String m_header = "";
	private PrintStream m_out;
	private PrintStream m_log;
	private String m_buffer;

	// Singleton Methods
	private TextUserInterface(){}

	private TextUserInterface(PrintStream log) throws IOException {
		m_out = System.out;
		this.m_log = log;
		System.setOut(this.m_log);
		this.m_buffer = "";
		this.clearScreen();
	}

	private TextUserInterface(String logfile) throws IOException {
		m_out = System.out;
		this.setLogFile(logfile);
		System.setOut(this.m_log);
		this.m_buffer = "";
		this.clearScreen();
	}

	protected static void restoreTerminalAccess() {
		if (m_tui == null || m_restore) { return; }

		m_restore = true;
		System.setOut(m_tui.m_out);
	}

	public static TextUserInterface getTui() throws IOException {
		return getTui("Doug.log");
	}

	public static TextUserInterface getTui(String logfile) throws IOException {

        // Failsafe against ctrl+c during CBreak mode
        if (m_failsafe == null) {
        	m_failsafe = new TuiUtil.CleanupHook();
        	Runtime.getRuntime().addShutdownHook(m_failsafe);
        }

		if (m_restore) { m_tui = new TextUserInterface(m_tui.m_log); m_restore = false; }
		if (m_tui == null) { m_tui = new TextUserInterface(logfile); }
		return m_tui;
	}

	public void setLogFile(String filename) throws IOException {
		this.m_log = new PrintStream(new File(filename));
	}



	// Output manipulation methods

	private void clearScreen() throws IOException {
		this.m_out.print("\033[2J");
		this.m_out.print(String.format("%n%n%n%n%n%n%n%n")); // Fixing bug
		this.m_out.print(String.format("%n%n%n%n%n%n%n%n"));
		this.m_out.print(String.format("%n%n%n%n%n%n%n%n"));
		this.m_out.print(String.format("%n%n%n%n%n%n%n%n"));
		this.m_out.print(String.format("%n%n%n%n%n%n%n%n"));
	}

	private void printCursor() throws IOException {
		this.newLine();
		this.setOutput("> ", false);
	}

	public void setOutput(String output) throws IOException {
		this.setOutput(output, true);
	}

	public void setOutput(String output, boolean flush) throws IOException {
		this.m_buffer += output;
		if (flush) { this.flush(); }
	}

	public void setHeader(String header) {
		m_header += header + String.format("%n%n");
		m_log.println("Setting header" + String.format("%n%n") + m_header);
	}

	public void clearHeader() {
		m_header = "";
	}

	public void newLine() throws IOException {
		this.setOutput(String.format("%n"), false);
	}

	public void flush() throws IOException {
		this.clearScreen();
		m_log.println(this.m_buffer);
		this.m_out.print(String.format("%n") + m_header + m_buffer); // The newline fixes a small displacement bug when using CBreak term
		this.m_buffer = "";
	}

	public String getTextInput() throws IOException {
		this.setOutput("Please enter a text command", false);
		this.printCursor();
		this.flush();
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	public String getActionInput() throws IOException, InterruptedException {
		this.setOutput("Controls: w, a, s, d, enter, q", false);
		this.printCursor();
		this.flush();
		TuiUtil.setTerminalToCBreak();
		int c = System.in.read();
		TuiUtil.restoreTerminal();
		m_log.println("User pressed " + Integer.toString(c));
		switch ((char)c) {
			case 'w':
				return "UP";
			case 'a':
				return "LEFT";
			case 's':
				return "DOWN";
			case 'd':
				return "RIGHT";
			case 'q':
				return "ESC";
			case '\n':
				return "ENTER";
			default:
				return "";
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException { // Test method
		TextUserInterface tui = TextUserInterface.getTui();
		while (true) {
			tui.setOutput("Hello! Press 1 to get text input and 2 to get key input", false);
			tui.newLine();
			String temp = tui.getTextInput();
			if (temp.equals("1")) {
				while (!temp.equals("quit")) {
					tui.clearScreen();
					temp = tui.getTextInput();
					tui.setOutput(temp, false); // Do not flush
					tui.newLine();
					System.out.println(temp);
				}
			} else {
				while (!temp.equals("ESC")) {
					tui.clearScreen();
					temp = tui.getActionInput();
					tui.setOutput(temp, false); // Do not flush
					tui.newLine();
					System.out.println(temp);
				}
			}
		}
	}
}