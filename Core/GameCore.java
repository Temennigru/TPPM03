/* 
 * GameCore is a facade. It is supposed to hide all the uglyness
 * in the implementation from the world, so don't mind it being
 * ugly itself. If someone changes some implementation, all they
 * have to change is this class.
 * GameCore is also a singleton. This implementation only supports
 * one instance of the game running at once. If another game is to
 * commence in parallel (say, due to a shahrazade 
 * http://gatherer.wizards.com/Pages/Card/Details.aspx?multiverseid=980)
 * GameCore has a save and restore feature.
 */


package Core;

import Cards.Abstract.*;

import java.lang.*;
import java.util.Vector;
import java.util.Random;

public class GameCore {
    Player[] m_player;

    private Vector<Card> m_battlefield;
    private Vector<Card> m_exileFupZone;
    private Vector<Card> m_exileFdnZone;
    private Vector<Card> m_commandZone;

    Player m_currentPlayer;

    static GameCore m_game;

    public static GameCore getGame() {
        if (m_game == null) { m_game = new GameCore(null, null); }
        return m_game;
    }

    public static GameCore getGame(Player player1, Player player2) {
        if (m_game == null) { m_game = new GameCore(player1, player2); }
        return m_game;
    }

    public static void GameReset() {
        m_game = null;
    }

    private GameCore(Player player1, Player player2) {
        m_battlefield = new Vector<Card>();
        m_exileFupZone = new Vector<Card>();
        m_exileFdnZone = new Vector<Card>();
        m_commandZone = new Vector<Card>();

        m_player = new Player[2];
        m_player[0] = player1;
        m_player[1] = player2;

        /*Random rand;
        
        this.m_currentPlayer = m_player[rand.getNextInt(1)];
        */
        // Hard-coded player for testing purpouses
        m_currentPlayer = m_player[0];
    }

    public Player getCurrentPlayer() {
        return this.m_currentPlayer;
    }

    private void removeFromGameZones (Card card) {
        this.removeFromZone (card, GameEnums.Zone.COMMAND);
        this.removeFromZone (card, GameEnums.Zone.BATTLEFIELD);
        this.removeFromZone (card, GameEnums.Zone.EXILE_FUP);
        this.removeFromZone (card, GameEnums.Zone.EXILE_FDN);
        this.removeFromZone (card, GameEnums.Zone.GRAVEYARD);
        this.removeFromZone (card, GameEnums.Zone.LIBRARY);
        this.removeFromZone (card, GameEnums.Zone.HAND);
    }

    private void removeFromZone (Card card, GameEnums.Zone zone) {

        // Bad implementation, I know, but it's surprisingly easier to
        // maintain than making methods.

        Iterator<Card> itr;

        switch (zone) {
            case COMMAND:
                itr = m_commandZone.iterator();
                break;
            case BATTLEFIELD:
                itr = m_battlefield.iterator();
                break;
            case EXILE_FUP:
                itr = m_exileFupZone.iterator();
                break;
            case EXILE_FDN:
                itr = m_exileFdnZone.iterator();
                break;
            case GRAVEYARD:
                itr = card.m_owner.graveyard.iterator();
                break;
            case LIBRARY:
                itr = card.m_owner.library.iterator();
                break;
            case HAND:
                itr = card.m_owner.hand.iterator();
                break;
        }

        while(itr.hasNext()) {
            if (card == itr.next()) { itr.remove() }
            System.out.print(element + " ");
        }
    }

    public void registerOnZone (Card card, GameEnums.Zone zone) {

        switch (zone) {
            case COMMAND:
                m_commandZone.addElement(card);
                break;
            case BATTLEFIELD:
                m_battlefield.addElement(card);
                break;
            case EXILE_FUP:
                m_exileFupZone.addElement(card);
                break;
            case EXILE_FDN:
                m_exileFdnZone.addElement(card);
                break;
            case GRAVEYARD:
                card.m_owner.addToGraveyard(card);
                break;
            case LIBRARY:
                card.m_owner.addToLibrary(card);
                break;
            case HAND:
                card.m_owner.addToHand(card);
                break;
        }
    }
}