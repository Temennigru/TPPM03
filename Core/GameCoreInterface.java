 public interface GameCoreInterface {

    // Singleton methods
    public static GameCoreInterface getExistingGame(); // Get existing game. If no game exists, will return an invalid game.
    public static GameCoreInterface makeGame(Player player1, Player player2); // Used basically to create a game. If a game exists, returns an invalid game.
    public void GameReset(); // Resets the game to default values.
    public void SubGame(); // Recursively creates a subgame.

    // Element access
    public Player getCurrentPlayer();
    public Iterator<Card> find (Card card); // Find in any zone.
    public void find (Card card, GameEnums.Zone zone, boolean byName); // Find in specified zone. false if not by name.
    public Iterator<Card> iterator (GameEnums.Zone zone); // Cannot access player zones (hand, graveyard and library)
    public Iterator<Card> iterator (Player player, GameEnums.Zone zone); // Can access player zones (hand, graveyard and library)

    // Element manipulation
    public void registerOnZone (Card card, GameEnums.Zone zone) throws GameExceptions.GameException;
    public void stateCheck();
    public void runGame(); // Danger: Should not return.
}