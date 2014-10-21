package GameCore;

import GameCore.GameObjectCore.*;
import GameCore.Ui.Tui.TextUserInterface;
import java.util.Iterator;
import GameCore.Cards.*;

public class Turn {

    private Player m_player;

    public Turn (Player player) {
        GameCore game = GameCore.getGame();
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
    }

    public void untap() {
        GameCore game = GameCore.getGame();
        Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD);
        while (itr.hasNext()) {
            Permanent el = (Permanent)(itr.next());
            el.untap();
        }
        m_player.landDrop(1); // Hard coded
    }

    public void draw() {
        // TODO: Check deck draw impl
        if (!m_player.library.draw()) {
            m_player.lose();
        }
    }

    public void upkeep() {
        GameCore game = GameCore.getGame();
        for (Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD); itr.hasNext();) {
            Card card = itr.next();
            String className;
            Class<?> enclosingClass = card.getClass().getEnclosingClass();
            if (enclosingClass != null) {
                className = enclosingClass.getName());
            } else {
                className = card.getClass().getName();
            }
            // TODO: Add triggers instead of this
            if (className.name.equals("GameCore.Cards.EndlessRanksOfTheDead")) {
                ((EndlessRanksOfTheDead)card).activateCard();
            }
        }
    }

    public void main1() {
        // TODO: Dynamic log setting
        TextUserInterface tui = TextUserInterface.getTui();

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
                    className = enclosingClass.getName());
                } else {
                    className = card.getClass().getName();
                }

                if (!className.equals("GameCore.Cards.ArmyOfTheDamned")) {
                    tui.setOutput("Error: Cannot use card", false);
                    tui.newLine();
                } else {
                    ((Cards.ArmyOfTheDamned)card).cast();
                }
            } else {
                tui.setOutput("Something went terribly wrong", false);
                tui.newLine();
            }
            game.checkState();
            card = m_player.prompt();
        }
    }
    
    public void combatDeclareAttackers() {
        // TODO: Dynamic log setting
        TextUserInterface tui = TextUserInterface.getTui();

        tui.setHeader("Select attackers" + String.format("%n%n"));

        Card card = m_player.prompt(true);
        while (card != null) {
            if (card.location != GameEnums.Zone.BATTLEFIELD ||
                    !Arrays.asList(card.m_type).contains(GameEnums.Type.LAND) ||
                    card.isTapped() ||
                    card.sick ||
                    card.m_controler != m_player) {

                tui.setOutput("Error: Cannot attack", false);
                tui.newLine();
            } else {
                GameCore game = GameCore.getGame();
                ((Creature)card).attack(game.opponent(m_player));
            }
        }
        tui.clearHeader();
        game.checkState();
    }

    public void combatDeclareBlockers() {
        // TODO: Blocked flag
        TextUserInterface tui = TextUserInterface.getTui();
        GameCore game = GameCore.getGame();

        for (Iterator<Card> itr = game.getAttackers; itr.hasNext(); ) {
            Card attacker = itr.next();

            tui.setHeader("Select blockers for:" + String.format("%n%n") + attacker.toString(), false);

            Card card = game.opponent(m_player).prompt(true);
            while (card != null) {
                if (card.location != GameEnums.Zone.BATTLEFIELD ||
                        !Arrays.asList(card.m_type).contains(GameEnums.Type.LAND) ||
                        card.isTapped() ||
                        card.m_controler != game.opponent(m_player)) {
                    tui.setOutput("Error: Cannot block", false);
                    tui.newLine();
                } else {
                    game.declareBlocker(card, attacker);
                }
            }
            tui.clearHeader();
        }
        game.checkState();
    }

    public void combatDamage() {
        GameCore game = GameCore.getGame();

        // TODO: Implement first strike attack round
        // TODO: Implement damage triggers
        for (Iterator<Card> itr = game.getAttackers; itr.hasNext(); ) {
            boolean blocked = false;
            Card attacker = itr.next();
            int damageToDeal = attacker.power;

            for (Iterator<Map.Entry<Card,Card>> itr2 = game.getBlockers(); itr2.hasNext();) {
                Map.Entry<Card,Card> temp = itr2.next();
                Card blocker = temp.getKey();
                if (temp.getValue() == attacker) { // Blocked
                    blocked = true;
                    attacker.damage(blocker.power() + attacker.damage());
                    // TODO: Implement variable lethal damage for deatouch
                    // TODO: Implement correct damage check (currently disconsiders any previous damage)
                    if (damageToDeal >= blocker.toughness) {
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
                game.opponent(m_player).removeLife(damageToDeal));
            }
        }
        game.checkState();
    }

    public void main2() {} // No cards in this release will know how to distinguish between main phases
    public void end() {} // Same as upkeep
    public void cleanup() {
        GameCore game = GameCore.getGame();
        for (Iterator<Card> itr = game.iterator(GameEnums.Zone.BATTLEFIELD); itr.hasNext();) {
            Card card = itr.next();
            card.damage(0);
        }
    }

}