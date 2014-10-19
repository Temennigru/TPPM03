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
import java.util.Iterator;
import java.util.Map;

public class GameCore implements GameCoreInterface {
    private Player[] m_player;
    private boolean[] m_canLose; // TODO: implement this

    private Vector<Card> m_battlefield;
    private Vector<Card> m_exileFupZone;
    private Vector<Card> m_exileFdnZone;
    private Vector<Card> m_commandZone;
    private Map<Card, Player> attackers;
    private Map<Card, Card> blockers;

    private static final int numPlayers = 2;

    Player m_currentPlayer;

    static GameCore m_game;

    // Singleton methods

    public static GameCore getGame() {
        if (m_game == null) { m_game = new GameCore(null, null); }
        return m_game;
    }

    public static GameCore getGame(Player player1, Player player2) {
        if (m_game == null) { m_game = new GameCore(player1, player2); }
        return m_game;
    }

    public static void GameReset() {
        // TODO: implement game reset
        m_game = null;
    }

    public static void 

    private GameCore(Player player1, Player player2) {
        m_battlefield = new Vector<Card>();
        m_exileFupZone = new Vector<Card>();
        m_exileFdnZone = new Vector<Card>();
        m_commandZone = new Vector<Card>();

        m_player = new Player[2];
        m_player[0] = player1;
        m_player[1] = player2;

        // TODO: Implement cannot lose
        canLose = new Player[2];
        canLose[0] = true;
        canLose[1] = true;

        /*Random rand;
        
        this.m_currentPlayer = m_player[rand.getNextInt(1)];
        */
        // Hard-coded player for testing purpouses
        m_currentPlayer = m_player[0];
    }

    // Element access
    public Player getCurrentPlayer() {
        return this.m_currentPlayer;
    }


    public Iterator<Card> find (Card card) {
        this.find (card, false);
    }

    private Iterator<Card> find (Card card, boolean byName) { // false if not by name
        this.find (card, GameEnums.Zone.COMMAND, byName);
        this.find (card, GameEnums.Zone.BATTLEFIELD, byName);
        this.find (card, GameEnums.Zone.EXILE_FUP, byName);
        this.find (card, GameEnums.Zone.EXILE_FDN, byName);
        this.find (card, GameEnums.Zone.GRAVEYARD, byName);
        //this.find (card, GameEnums.Zone.LIBRARY, byName);
        this.find (card, GameEnums.Zone.HAND, byName);
    }



    // Card should never be in more than one zone
    public void find (Card card, GameEnums.Zone zone, Player player, boolean byName) {

        Iterator<Card> itr;

        if ( (zone == GameEnums.Zone.GRAVEYARD ||
              zone == GameEnums.Zone.LIBRARY   ||
              zone == GameEnums.Zone.HAND)     &&
              player == null) { // Has to search all players
            for (int i = 0; i < this.numPlayers; i++) {
                switch (zone) {
                    case GRAVEYARD:
                        itr = this.player[i].graveyard.iterator();
                        break;
                    case LIBRARY:
                        itr = this.player[i].library.iterator();
                        break;
                    case HAND:
                        itr = this.player[i].hand.iterator();
                        break;
                    default:
                        itr = null;
                        break;
                }
            }

            while(itr.hasNext()) {
                if (card == itr.next()) { return itr; }
            }
        } else { // No complicated search required
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
                default:
                    itr = null;
                    break;
            }

            while(itr.hasNext()) {
                if (card.name == itr.next().name) { return itr; }
            }
        }
    }

    public Iterator<Card> iterator (GameEnums.Zone zone) {
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
            default:
                itr = null;
                break;
        }
    }

    public Iterator<Card> iterator (Player player, GameEnums.Zone zone) {
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
                itr = player.graveyard.iterator();
                break;
            case LIBRARY:
                itr = player.library.iterator();
                break;
            case HAND:
                itr = player.hand.iterator();
                break;
            default:
                itr = null;
                break;
            }
        }
    }


    // Element manipulation
    private void removeFromZone (Card card, GameEnums.Zone zone) {
        Iterator<Card> itr = this.find(card, )


    private void removeFromGameZones (Card card) {
        this.removeFromZone (card, GameEnums.Zone.COMMAND);
        this.removeFromZone (card, GameEnums.Zone.BATTLEFIELD);
        this.removeFromZone (card, GameEnums.Zone.EXILE_FUP);
        this.removeFromZone (card, GameEnums.Zone.EXILE_FDN);
        this.removeFromZone (card, GameEnums.Zone.GRAVEYARD);
        //this.removeFromZone (card, GameEnums.Zone.LIBRARY);
        this.removeFromZone (card, GameEnums.Zone.HAND);
    }


    // TODO: Implement registering by 
    public void registerOnZone (Card card, GameEnums.Zone zone) throws GameExceptions.GameException {

        // Safety first

        this.removeFromGameZones(card);

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

        card.location = zone;
    }

    public void stateCheck() {
        Iterator<Card> itr = this.m_battlefield.iterator();
        while (itr.hasNext()) {
            Card el = itr.next();
            if (Arrays.asList(el).contains(GameEnums.Type.CREATURE)) {
                if (el.toughness() <= 0) { el.kill(); } // Killed by state-based action and not destroyed
                else if (el.toughness() <= el.damage()) { el.destroy(); }
            }
        }
        for (int i = 0; i < this.numPlayers; i++) {
            // TODO: Implement poison
            if (this.player[i].life <= 0 && canLose[i]) {
                this.player[i].lose();
            }
        }
    }

    public void main() {

    }
}