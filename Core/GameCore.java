/* The core of the game. This class is the bauss.
 * It sees all, hears all and knows all. If you mess
 * with it, it will mess you up.
 */

package Core;

import java.lang.*;

public class GameCore {
    Player m_player1;
    Player m_player2;

    Vector<Permanent> m_battlefield;
    Vector<Card> m_exileFupZone;
    Vector<Card> m_exileFdnZone;
    Vector<Card> m_commandZone;

    static GameCore m_game;

    static GameCore getGame() {
        if (m_game == null) { m_game = new GameCore(); }
        return m_game;
    }

    private GameCore() {}
    void registerOnZone (Card card, GameEnums.Zone zone) {
        switch (zone) {
            case GameEnums.Zone.COMMAND:
                m_commandZone.addElement(card);
                break;
            case GameEnums.Zone.BATTLEFIELD:
                m_battlefield.addElement(card);
                break;
            case GameEnums.Zone.EXILE_FUP:
                m_exileFupZone.addElement(card);
                break;
            case GameEnums.Zone.EXILE_FDN:
                m_exileFdnZone.addElement(card);
                break;
        }
    }

}