package GameCore.Ui.Tui;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class TuiUtil {

    protected static class CleanupHook extends Thread {
        public void run() {
            try {
                TextUserInterface.restoreTerminalAccess();
                TuiUtil.restoreTerminal();
                System.out.println(String.format("%n") + "Exited successfully" + String.format("%n"));
            } catch (Exception e) {
                System.out.println(String.format("%n") + "Sorry for your terminal, bro" + String.format("%n"));
                // Could not fix terminal input mode
            }
        }
    }
	
	private static String ttyConfig = "";
    private static boolean isCBreak = false;

	protected static void setTerminalToCBreak() throws IOException, InterruptedException {

        ttyConfig = stty("-g");

        // set the console to be character-buffered instead of line-buffered
        stty("-icanon min 1");

        // disable character echoing
        stty("-echo");

        TuiUtil.isCBreak = true;
    }

    protected static void restoreTerminal() throws IOException, InterruptedException {
        if (!TuiUtil.isCBreak) { return; }
    	stty( ttyConfig.trim() );
        TuiUtil.isCBreak = false;
    }

     /*
     *  Execute the stty command with the specified arguments
     *  against the current active terminal.
     */
    protected static String stty(final String args)
                    throws IOException, InterruptedException {
        String cmd = "stty " + args + " < /dev/tty";

        return exec(new String[] {
                    "sh",
                    "-c",
                    cmd
                } );
    }

    /*
     *  Execute the specified command and return the output
     *  (both stdout and stderr).
     */
    protected static String exec(final String[] cmd)
                    throws IOException, InterruptedException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        Process p = Runtime.getRuntime().exec(cmd);
        int c;
        InputStream in = p.getInputStream();

        while ((c = in.read()) != -1) {
            bout.write(c);
        }

        in = p.getErrorStream();

        while ((c = in.read()) != -1) {
            bout.write(c);
        }

        p.waitFor();

        String result = new String(bout.toByteArray());
        return result;
    }

} 