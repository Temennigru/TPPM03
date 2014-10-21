package GameCore;

import GameCore.GameObjectCore.*;
import GameCore.Ui.Tui.TextUserInterface;
import java.util.Iterator;
import GameCore.Cards.*;
import java.util.Arrays;
import java.util.Map;
import java.io.IOException;

public class Turn {

    private Player m_player;
    private GameCore game;

    private Turn() {} // Don't use this

    // TODO: Add dynamic turns (skipping steps, etc.)
    private Turn (Player player) throws IOException, InterruptedException, GameExceptions.GameException {
        game = GameCore.getGame();
        this.m_player = player;
        this.untap();
        this.draw();
        if (m_player.lost()) { return; } // Only way to currently lose during your turn
        this.upkeep();
        this.main1();
        this.combatDeclareAttackers();
        this.combatDeclareBlockers();
        this.combatDamage();
        if (game.opponent(m_player).lost()) { return; }
        this.main1();
        this.end();
        this.cleanup();
        // TODO: If state check during cleanup fails, cleanup again
    }

    static void takeTurn(Player player) throws IOException, InterruptedException, GameExceptions.GameException {
        new Turn(player);
    }

    public void untap() throws IOException, InterruptedException, GameExceptions.GameException {
        Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD);
        while (itr.hasNext()) {
            Permanent el = (Permanent)(itr.next());
            el.untap();
        }
        m_player.landDrop(1); // Hard coded
    }

    public void draw() throws IOException, InterruptedException, GameExceptions.GameException {
        Card drawn = m_player.library.draw();
        if (drawn == null) {
            m_player.lose();
        } else {
            drawn.place(GameEnums.Zone.HAND);
        }
    }

    public void upkeep() throws IOException, InterruptedException, GameExceptions.GameException {
        // Endless ranks not implemented
        /*
        for (Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD); itr.hasNext();) {
            Card card = itr.next();
            String className;
            Class<?> enclosingClass = card.getClass().getEnclosingClass();
            if (enclosingClass != null) {
                className = enclosingClass.getName();
            } else {
                className = card.getClass().getName();
            }
            // TODO: Add triggers instead of this
            if (className.equals("GameCore.Cards.EndlessRanksOfTheDead")) {
                ((EndlessRanksOfTheDead)card).activateCard();
            }
        }*/
    }

    public void main1() throws IOException, InterruptedException, GameExceptions.GameException {
        // TODO: Dynamic log setting
        TextUserInterface tui = TextUserInterface.getTui();

        tui.setHeader("Main phase" + String.format("%n%n"));

        Card card = m_player.prompt();
        while (card != null) {
            if (card.location == GameEnums.Zone.HAND) {
                if (!card.cast()) {
                    tui.setOutput("Error: Cannot cast card", false);
                    tui.newLine();
                }
            } else if (card.location == GameEnums.Zone.BATTLEFIELD) {
                if (!Arrays.asList(card.m_type).contains(GameEnums.Type.LAND) || card.m_controler != m_player || card.isTapped()) { // Hard coded
                    tui.setOutput("Error: Cannot use card", false);
                    tui.newLine();
                } else {
                    card.activateAt(0);
                }
            } else if (card.location == GameEnums.Zone.GRAVEYARD) {
                // Hard coded graveyard interaction
                String className;
                Class<?> enclosingClass = card.getClass().getEnclosingClass();
                if (enclosingClass != null) {
                    className = enclosingClass.getName();
                } else {
                    className = card.getClass().getName();
                }

                if (!className.equals("GameCore.Cards.ArmyOfTheDamned")) {
                    tui.setOutput("Error: Cannot use card", false);
                    tui.newLine();
                } else {
                    //((ArmyOfTheDamned)card).cast();
                }
            } else {
                tui.setOutput("Something went terribly wrong", false);
                tui.newLine();
            }
            game.stateCheck();
            card = m_player.prompt();
        }
        tui.clearHeader();
    }
    
    public void combatDeclareAttackers() throws IOException, InterruptedException, GameExceptions.GameException {
        // TODO: Dynamic log setting
        TextUserInterface tui = TextUserInterface.getTui();

        tui.setHeader("Combat phase" + String.format("%n%n"));

        tui.setHeader("Select attackers" + String.format("%n%n"));

        Card card = m_player.prompt(true);
        while (card != null) {
            if (card.location != GameEnums.Zone.BATTLEFIELD ||
                    !Arrays.asList(card.m_type).contains(GameEnums.Type.CREATURE) ||
                    card.isTapped() ||
                    (card.sick && !card.haste) ||
                    card.m_controler != m_player) {

                tui.setOutput("Error: Cannot attack", false);
                tui.newLine();
            } else {
                ((Creature)card).attack(game.opponent(m_player));
            }

            card = m_player.prompt(true);
        }
        tui.clearHeader();
        game.stateCheck();
    }

    public void combatDeclareBlockers() throws IOException, InterruptedException, GameExceptions.GameException {
        // TODO: Blocked flag
        TextUserInterface tui = TextUserInterface.getTui();

        tui.setHeader("Combat phase" + String.format("%n%n"));

        for (Iterator<Card> itr = game.getAttackers(); itr.hasNext(); ) {
            Card attacker = itr.next();

            tui.clearHeader();

            tui.setHeader("Combat phase" + String.format("%n%n"));
            tui.setHeader("Select blockers for:" + String.format("%n%n") + attacker.toString());

            Card card = game.opponent(m_player).prompt(true);
            while (card != null) {
                if (card.location != GameEnums.Zone.BATTLEFIELD ||
                        !Arrays.asList(card.m_type).contains(GameEnums.Type.CREATURE) ||
                        card.isTapped() ||
                        card.m_controler != game.opponent(m_player)) {
                    tui.setOutput("Error: Cannot block", false);
                    tui.newLine();
                } else {
                    // TODO: Implement block()
                    game.declareBlocker(card, attacker);
                }

                card = m_player.prompt(true);
            }
        }
        game.stateCheck();
        tui.clearHeader();
    }

    public void combatDamage() throws IOException, InterruptedException, GameExceptions.GameException {

        TextUserInterface tui = TextUserInterface.getTui();

        tui.setHeader("Combat phase" + String.format("%n%n"));

        // TODO: Implement first strike attack round
        // TODO: Implement damage triggers
        for (Iterator<Card> itr = game.getAttackers(); itr.hasNext(); ) {
            boolean blocked = false;
            Card attacker = itr.next();
            itr.remove();
            int damageToDeal = attacker.power();

            for (Iterator<Map.Entry<Card,Card>> itr2 = game.getBlockers(); itr2.hasNext();) {
                Map.Entry<Card,Card> temp = itr2.next();
                itr2.remove();
                Card blocker = temp.getKey();
                if (temp.getValue() == attacker) { // Blocked
                    blocked = true;
                    attacker.damage(blocker.power() + attacker.damage());
                    // TODO: Implement variable lethal damage for deatouch
                    // TODO: Implement correct damage check (currently disconsiders any previous damage)
                    if (damageToDeal >= blocker.toughness()) {
                        blocker.damage(blocker.toughness());
                        damageToDeal -= blocker.toughness();
                    } else {
                        blocker.damage(damageToDeal);
                        damageToDeal = 0;
                    }
                }
            }

            // TODO: Use damage instead of life removal
            if (!blocked || ((Creature)attacker).trample) {
                game.opponent(m_player).removeLife(damageToDeal);
            }
        }
        game.stateCheck();
    }

    public void main2() {} // No cards in this release will know how to distinguish between main phases
    public void end() {} // Same as upkeep
    public void cleanup() throws IOException, InterruptedException, GameExceptions.GameException {
        TextUserInterface tui = TextUserInterface.getTui();

        tui.setHeader("Cleanup phase" + String.format("%n%n"));

        for (Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD); itr.hasNext();) {
            Card card = itr.next();
            card.damage(0);
        }
        // TODO: Dynamic hand size
        while (m_player.hand.size() > 7) {
            tui.clearHeader();

            tui.setHeader("Cleanup phase" + String.format("%n%n"));
            tui.setHeader("Select " + Integer.toString(m_player.hand.size() - 7) + " cards to discard" + String.format("%n"));
            Card card = m_player.prompt(true);
            if (card != null) {
                if (card.location != GameEnums.Zone.HAND) {
                    tui.setOutput("Error: Cannot discard this card", false);
                    tui.newLine();
                } else {
                    card.discard();
                }
            }
            tui.clearHeader();
        }
        game.stateCheck();
        tui.clearHeader();
    }


    // TEST

    private static class TestDeck extends Deck {
        public TestDeck(Player player) { super(player); }
        protected void createDeck() {
            Card s = null;

            for (int i = 0; i < 16; i++) {
                if (i >= 0 && i < 4) {
                    s = new StranglerootGeist();
                } else if (i >= 4 && i < 8) {
                    s = new Forest();
                } else if (i >= 8 && i < 12) {
                    s = new Swamp();
                } else if (i >= 12) {
                    s = new ButcherGhoul();
                }

                s.m_owner = this.m_owner;
                s.m_controler = this.m_owner;
                s.location = GameEnums.Zone.LIBRARY;

                this.add(s);

                this.numCards = 16;
            }
        }
    }

    public static void main (String[] args) throws IOException, InterruptedException, GameExceptions.GameException {
        RealPlayer me = new RealPlayer("Loops");
        Deck testDeck = new TestDeck(me);
        me.setDeck(testDeck);

        GameCore game = GameCore.makeGame(me, me);

        me.library.shuffle();

        while (!me.lost()) {
            takeTurn(me);
        }
        System.out.println("You lost");
    }
}