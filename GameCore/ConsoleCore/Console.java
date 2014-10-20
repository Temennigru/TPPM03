import java.util.Scanner;

public class Console {
	
	private Vector<Command> commands;

	public Console() {
		this.commands = new Vector<Command>();
	}

	public void installCommand(Command command) {
		this.commands.add(command);
	}
	
	public void execCommand (String commandName, String[] args);

	public static void PlayCommand(){
		System.out.println("What would you like to play? Card or Land?");
		String userCommand2 ;
		Scanner userInput = new Scanner (System.in);
		userCommand2 = userInput.next();
		CardOrLandCommand(userCommand2);
	}
	
	public static void Compare (String userCommand){
		if (userCommand.equals("play")){
			PlayCommand();
		}
		else if (userCommand.equals("read")){
			System.out.println("reading a card");
		}
		else if (userCommand.equals("tap")){
			System.out.println("taping a card");
		}
		else if (userCommand.equals("skip")){
			System.out.println("skipping this phase");
		}
		else if (userCommand.equals("help")){
			System.out.println("main commands are:");
			System.out.println("play, read, tap, skip, help, activate, quit");
		}
		else if (userCommand.equals("activate")){
			System.out.println("activating a card");
		}
		else if (userCommand.equals("quit")){
		System.exit(0);;
		}
		else {
			System.out.println("type help for help");
		}
		
	}
	




	public static void CardOrLandCommand (String userCommand2){
		if (userCommand2.equals("card"))
		{
			System.out.println("playing a card");
		}
		else if (userCommand2.equals("land"))
		{
			System.out.println("playing a land yo!");
		}
		else 
		{
			System.out.println("waaat");
		}
	}
	

//	public static void main(String[] args) {
//		while(true){
//		System.out.println("Enter your next command: ");
//		String userCommand ;
//		Scanner userInput = new Scanner (System.in);
//		userCommand = userInput.next();
//		Console.Compare(userCommand);
//		}
//	}

}
