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


package GameCore;

import GameCore.GameObjectCore.*;

import java.lang.*;
import java.util.Vector;
import java.util.Random;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class GameCore {
    private Player[] m_player;
    private boolean[] m_canLose; // TODO: implement this

    private Vector<Card> m_battlefield;
    private Vector<Card> m_exileFupZone;
    private Vector<Card> m_exileFdnZone;
    private Vector<Card> m_commandZone;
    private Vector<Card> attackers;
    private Map<Card, Card> blockers;

    // TODO: Implement dynamic player number.
    private static final int m_numPlayers = 2;
    private boolean m_isValid;

    public Player m_currentPlayer;

    private static GameCore m_game = null;

    // Singleton methods

    public boolean valid() { return this.m_isValid; }

    public static GameCore getGame() {
        if (m_game == null) { return new GameCore(); } // Invalid game
        return m_game;
    }

    public static GameCore makeGame(Player player1, Player player2) {
        if (m_game == null) { m_game = new GameCore(player1, player2); return m_game; }
        else { return new GameCore(); }
    }

    public static void gameReset() {
        // TODO: implement game reset
        m_game = null;
    }

    public void subGame() {
        // TODO: implement game reset
        m_game = null;
    }

    private GameCore() { // Constructs invalid games
        m_isValid = false;
    }

    private GameCore(Player player1, Player player2) {
        m_isValid = true;

        m_battlefield = new Vector<Card>();
        m_exileFupZone = new Vector<Card>();
        m_exileFdnZone = new Vector<Card>();
        m_commandZone = new Vector<Card>();
        attackers = new Vector<Card>();
        blockers = new HashMap<Card, Card>();

        m_player = new Player[2];
        m_player[0] = player1;
        m_player[1] = player2;

        // TODO: Implement cannot lose
        m_canLose = new boolean[2];
        m_canLose[0] = true;
        m_canLose[1] = true;

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
        return this.find (card, false);
    }

    private Iterator<Card> find (Card card, boolean byName) { // false if not by name
        /*this.find (card, GameEnums.Zone.COMMAND, byName);
        this.find (card, GameEnums.Zone.BATTLEFIELD, byName);
        this.find (card, GameEnums.Zone.EXILE_FUP, byName);
        this.find (card, GameEnums.Zone.EXILE_FDN, byName);
        this.find (card, GameEnums.Zone.GRAVEYARD, byName);
        this.find (card, GameEnums.Zone.LIBRARY, byName);
        this.find (card, GameEnums.Zone.HAND, byName);
        */
        return null;
    }

    // Decisions related to this method are too complex to solve right now.
    public Iterator<Card> find (Card card, GameEnums.Zone zone, Player player, boolean byName, boolean byType) {
        // TODO: Implement find
        /*
        Iterator<Card> itr;

        if ( (zone == GameEnums.Zone.GRAVEYARD ||
              zone == GameEnums.Zone.LIBRARY   ||
              zone == GameEnums.Zone.HAND)     &&
              player == null) { // Has to search all players
            for (int i = 0; i < this.m_numPlayers; i++) {
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
        */
        return null; // Delete this later
    }

    public Iterator<Card> iterator (GameEnums.Zone zone) {
        switch (zone) {
            case COMMAND:
                return m_commandZone.iterator();
            case BATTLEFIELD:
                return m_battlefield.iterator();
            case EXILE_FUP:
                return m_exileFupZone.iterator();
            case EXILE_FDN:
                return m_exileFdnZone.iterator();
            default:
                return null;
        }
    }

    // TODO: Get only cards controled by player
    public Iterator<Card> iterator (Player player, GameEnums.Zone zone) {
        switch (zone) {
            case COMMAND:
                return m_commandZone.iterator();
            case BATTLEFIELD:
                return m_battlefield.iterator();
            case EXILE_FUP:
                return m_exileFupZone.iterator();
            case EXILE_FDN:
                return m_exileFdnZone.iterator();
            case GRAVEYARD:
                return player.graveyard.iterator();
            case LIBRARY:
                return player.library.iterator();
            case HAND:
                return player.hand.iterator();
            default:
                return null;
        }
    }

    public Iterator<Card> getAttackers() {
        return attackers.iterator();
    }

    public Iterator<Map.Entry<Card,Card>> getBlockers() {
        return blockers.entrySet().iterator();
    }

    public Card elementAt (Player player, GameEnums.Zone zone, int pos) {
        switch (zone) {
            case COMMAND:
                return m_commandZone.elementAt(pos);
            case BATTLEFIELD:
                return m_battlefield.elementAt(pos);
            case EXILE_FUP:
                return m_exileFupZone.elementAt(pos);
            case EXILE_FDN:
                return m_exileFdnZone.elementAt(pos);
            case GRAVEYARD:
                return player.graveyard.elementAt(pos);
            // TODO: Implement library random access
            //case LIBRARY:
                //return player.library.elementAt(pos);
            case HAND:
                return player.hand.elementAt(pos);
            default:
                return null;
        }
    }

    public int zoneSize(Player player, GameEnums.Zone zone) {
        switch (zone) {
            case COMMAND:
                return m_commandZone.size();
            case BATTLEFIELD:
                return m_battlefield.size();
            case EXILE_FUP:
                return m_exileFupZone.size();
            case EXILE_FDN:
                return m_exileFdnZone.size();
            case GRAVEYARD:
                return player.graveyard.size();
            // TODO: Implement library random access
            //case LIBRARY:
                //return player.library.size();
            case HAND:
                return player.hand.size();
            default:
                return 0;
        }
    }

    // TODO: Add multiplayer support
    public Player opponent (Player player) {
        if (player == m_player[0]) { return m_player[1]; }
        else { return m_player[0]; }
    }

    // Element manipulation
    private void removeFromZone (Card card, GameEnums.Zone zone) {

        Iterator<Card> itr = this.iterator(card.m_owner, zone);

        while(itr.hasNext()) {
            if (card == itr.next()) { itr.remove(); }
        }
    }

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

        // Safety first (check all zones and not just the one that the card is registered at.)
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

    public void stateCheck() throws GameExceptions.GameException {
        // TODO: Check all states before killing creatures
        Vector<Card> toBeKilled = new Vector<Card>();
        for (int i = 0; i < m_battlefield.size(); i++) {
            Card el = m_battlefield.elementAt(i);
            if (Arrays.asList(el.m_type).contains(GameEnums.Type.CREATURE)) {
                System.out.println("Found " + el.name + String.format("%n") + "toughness " + el.toughness() + "damage " + el.damage() + String.format("%n"));
                if (((Permanent)el).toughness() <= 0) { toBeKilled.add(el); } // Killed by state-based action and not destroyed
                else if (((Permanent)el).toughness() - ((Permanent)el).damage() <= 0) { toBeKilled.add(el); } // TODO: Change to destroy
            }
        }
        for (Iterator itr = toBeKilled.iterator(); itr.hasNext(); ((Permanent)itr.next()).kill()) {}
        for (int i = 0; i < this.m_numPlayers; i++) {
            // TODO: Implement poison
            if (m_player[i].life <= 0 && m_canLose[i]) {
                m_player[i].lose();
            }
        }
    }

    public boolean spendMana(Player player, String mana) {
        return player.removeMana(mana);
    }

    public void emptyManaPool(Player player) {
        player.emptyManaPool();
    }

    public void clearMana() {
        for (int i = 0; i < m_numPlayers; i++) {
            this.emptyManaPool(m_player[i]);
        }
    }

    public void declareAttacker(Card card, Player player) {
        // TODO: Add multiplayer support
        this.attackers.add(card);
    }

    public void declareBlocker(Card blocker, Card attacker) {
        this.blockers.put(blocker, attacker);
    }

    public void endCombat() {
        this.attackers.clear();
        this.blockers.clear();
    }

    // Other

    public String getHud(Player player) {
        String ret = player.name + String.format("%n") +
        "Life: " + Integer.toString(player.life) + String.format("%n") +
        "Cards in hand: " + Integer.toString(player.hand.size()) + String.format("%n") +
        "Cards in library: " + Integer.toString(player.library.cards.size()) + String.format("%n") + 
        "Mana pool: " + player.getManaPool() + String.format("%n");
        return ret;
    }

    public Player runGame() {
        return null;
    }
}