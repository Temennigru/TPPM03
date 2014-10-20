package GameCore;

public class GameCore {

    // Singleton methods
    public static GameCoreInterface getGame(); // Get existing game. If no game exists, will return an invalid game.
    public static GameCoreInterface makeGame(Player player1, Player player2); // Used basically to create a game. If a game exists, returns an invalid game.

    // Game state methods
    // NOT WORKING \/
    public void sameReset(); // Resets the game to default values.
    // NOT WORKING \/
    public void subGame(); // Recursively creates a subgame.

    public void endGame();

    // Element access

    public Player getCurrentPlayer();

    // NOT WORKING \/
    public Iterator<Card> find (Card card); // Find in any zone.
    // NOT WORKING \/
    public Iterator<Card> find (Card card, GameEnums.Zone zone, boolean byName); // Find in specified zone. false if not by name.

    public Iterator<Card> iterator (GameEnums.Zone zone); // Cannot access player zones (hand, graveyard and library)
    public Iterator<Card> iterator (Player player, GameEnums.Zone zone); // Can access player zones (hand, graveyard and library)

    // Element manipulation
    public void registerOnZone (Card card, GameEnums.Zone zone) throws GameExceptions.GameException;
    public void stateCheck() throws GameExceptions.GameException;
    public boolean spendMana(Player player, String mana);

    // Other
    public Player runGame(); // Returns winner
}