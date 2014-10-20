package GameCore;

import Cards.Abstract.*;
import java.util.Iterator;

public class Turn {

    private Player m_player;

    public Turn (Player player) {
        this.m_player = player;
        this.untap();
        this.upkeep();
        this.main1();
        this.combatDeclareAttackers();
        this.combatDeclareBlockers();
        this.combatDamage();
        this.main2();
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
    }

    public void upkeep() {} // No triggers as of yet, so nothing to do.

    public void main1() {

    }
    
    public void combatDeclareAttackers();
    public void combatDeclareBlockers();
    public void combatDamage();
    public void main2();
    public void end();
    public void cleanup();

}