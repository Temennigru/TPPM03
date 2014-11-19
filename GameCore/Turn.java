package GameCore;

import GameCore.GameObjectCore.*;
import GameCore.Ui.Tui.TextUserInterface;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Map;
import java.io.IOException;

public class Turn {

    private Player m_player;
    private GameCore game;
    private GameEnums.TurnPhases phase;
    private Vector<GameEnums.TurnPhases> skip;

    private Turn() {} // Don't use this

    private Turn (Player player) throws IOException, InterruptedException, GameExceptions.GameException {
        tui = TextUserInterface.getTui();
        game = GameCore.getGame();
        this.m_player = player;
        tui.setHeader("New turn" + String.format("%n%n"));
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

    public void skip (GameEnums.TurnPhases phase) {
        skip.add(phase);
    }


    // TODO: Signal triggers when phases start

    public void untap() throws IOException, InterruptedException, GameExceptions.GameException {
        Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD);
        while (itr.hasNext()) {
            Permanent el = (Permanent)(itr.next());
            el.untap();
            if (el.m_controler == m_player) { el.sick = false; }
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
    }

    public void main1() throws IOException, InterruptedException, GameExceptions.GameException {

    }
    
    public void combatDeclareAttackers() throws IOException, InterruptedException, GameExceptions.GameException {
        // TODO: Invoke gui prompt

        for (Iterator<Card> it = game.iterator(GameEnums.Zone.BATTLEFIELD); it.hasNext(); ) {
            Card card = it.next();
            List options = new ArrayList();
            if (card.location() == GameEnums.Zone.BATTLEFIELD &&
                    Arrays.asList(card.types()).contains(GameEnums.Type.CREATURE) &&
                    !card.isTapped() &&
                    (!card.sick() || card.haste()) &&
                    !card.defender() &&
                    card.controler() == m_player) {
                options.add(card.toString(true));
            }
            // Prompt gui
        }
        for (int i : choices) {
            game.declareAttacker(options.get(i));
        }
    }

    public void combatDeclareBlockers() throws IOException, InterruptedException, GameExceptions.GameException {
        // TODO: Invoke gui prompt

        for (Iterator<Card> it = game.getAttackers(); it.hasNext();) {
            attacker = it.next();
            for (Iterator<Card> it = game.iterator(GameEnums.Zone.BATTLEFIELD); it.hasNext();) {
                Card card = it.next();
                List options = new ArrayList();
                if (card.location() == GameEnums.Zone.BATTLEFIELD &&
                        Arrays.asList(card.types()).contains(GameEnums.Type.CREATURE) &&
                        !card.isTapped() &&
                        (!card.sick() || card.haste()) &&
                        !card.defender() &&
                        card.controler() == m_player) {
                    options.add(card.toString(true));
                }
                // Prompt gui
            }
            game.declareBlocker(card, attacker);






    }

    public void combatDamage() throws IOException, InterruptedException, GameExceptions.GameException {

        tui.setHeader(game.getHud(this.m_player) + String.format("%n%n") + "Combat phase" + String.format("%n%n"));

        // TODO: Implement first strike attack round
        // TODO: Implement damage triggers
        for (Iterator<Card> itr = game.getAttackers(); itr.hasNext(); ) {
            boolean blocked = false;
            Card attacker = itr.next();
            int damageToDeal = attacker.power();

            for (Iterator<Map.Entry<Card,Card>> itr2 = game.getBlockers(); itr2.hasNext();) {
                Map.Entry<Card,Card> temp = itr2.next();
                Card blocker = temp.getKey();
                System.out.println("Blocker: " + blocker.location.toString());
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
        game.endCombat();
        tui.clearHeader();
        game.stateCheck();
        game.clearMana();
    }

    public void main2() {} // No cards in this release will know how to distinguish between main phases

    public void end() {
        game.clearMana();
    } // Nothing to do here

    public void cleanup() throws IOException, InterruptedException, GameExceptions.GameException {

        tui.setHeader(game.getHud(this.m_player) + String.format("%n%n") + "Cleanup phase" + String.format("%n%n"));

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

            for (int i = 0; i < 24; i++) {
                if (i >= 0 && i < 4) {
                    s = new StranglerootGeist();
                } else if (i >= 4 && i < 8) {
                    s = new Forest();
                } else if (i >= 8 && i < 12) {
                    s = new Swamp();
                } else if (i >= 12 && i < 16) {
                    s = new ButcherGhoul();
                } else if (i >= 16 && i < 20) {
                    s = new GarruksCompanion();
                } else if (i >= 20 && i < 24) {
                    s = new GeralfsMessenger();
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

        Card drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);
        drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);
        drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);
        drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);
        drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);
        drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);
        drawn = me.library.draw();
        drawn.place(GameEnums.Zone.HAND);


        while (!me.lost()) {
            takeTurn(me);
        }

        System.out.println("You lost");
    }
}