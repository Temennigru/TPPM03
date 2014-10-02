public class Player {
    int life;
    GameCore game;
    Vector<Card> deck;
    Vector<Card> hand;
    Vector<Card> graveyard;
    Console commandInterface;

    // Damage dealing is the game's responsibility. The player can only lose life.
    public void removeLife(int ammount);
    public void play(Zone zone, int pos);
    public void shuffle(Zone zone);
    public void takeTurn();
    
}