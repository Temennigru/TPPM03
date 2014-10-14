import java.util.Scanner

public class Console{
    
     //gameCore ???
    
    Scanner userInput = new Scanner (System.in);
    String userCommand;
    System.out.print ("Enter your next command: ");
    userCommand = userInput.next;
    
    //implementar como if (userCommand.equals("playcard"))...

    addCommand (String commandName, Command command){
    }
    
    //Comandos a serem implementados:
    //Play a Card
    //Play a Land
    //Activate a Card
    //Tap a Card
    //Read a Card
    //Skip Turn Phase
    //Help
    
    //Implementar também comandos específicos de resposta, geralmente respondidos com um inteiro. Exemplo:
    //Which card from your hand? 1-forest 2-elf 3-lifedrain 4-blacklotus 5-fireball
    //5

}
