/* The core of the game. This class is the bauss.
 * It sees all, hears all and knows all. If you mess
 * with it, it will mess you up.
 */

package Core;

import Cards.Abstract.*;

import java.lang.*;
import java.util.Vector;
import java.util.Random;

public class GameCore {
    Player m_player1;
    Player m_player2;

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

    private GameCore(Player player1, Player player2) {
        m_battlefield = new Vector<Card>();
        m_exileFupZone = new Vector<Card>();
        m_exileFdnZone = new Vector<Card>();
        m_commandZone = new Vector<Card>();

        m_player1 = player1;
        m_player2 = player2;

        /*Random rand;
        switch (rand.getNextInt(1)) {
            case 0:
                m_currentPlayer = m_player1;
                break;
            case 1:
                m_currentPlayer = m_player2;
                break;
        }*/
        // Hard-coded player for testing purpouses
        m_currentPlayer = m_player1;
    }

    public Player getCurrentPlayer() {
        return this.m_currentPlayer;
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
        }
    }
}