//reference: http://magiccards.info/cns/en/113.html

package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;
import ui.tui.*;

public class Assassinate extends Sorcery {
	
	public Assassinate () {
		this.m_imgLocation = "GameCore/Cards/Img/Assassinate.jpg";
		this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.Sorcery;
        this.manaCost = "2B";
        this.name = "Assassinate"
        this.description = "Destroy target tapped creature.";
        this.flavor = "This is how wars are won - not with armies of soldiers but with a single knifle blade, artfully placed. _Yurin, royal assassin";
	}

	private void reset() {
    }

    private void destroyTapped(){
        TextUserInterface tui = TextUserInterface.getTui();
        tui.setHeader("Select target" + String.format("%n%n"));

        Card card = m_player.prompt(true);
        while (card != null) {
            if (card.location != GameEnums.Zone.BATTLEFIELD ||
                    !Arrays.asList(card.m_type).contains(GameEnums.Type.CREATURE) ||
                    !card.isTapped(){
                tui.setOutput("Error: Choose another target", false);
                tui.newLine();
            } else {
                GameCore game = GameCore.getGame();
                ((Creature)card).kill(); // Action
            }
        }
        tui.clearHeader();
        game.checkState();
    }

    public void play () throws GameExceptions.GameException {
        destroyTapped();
    	this.place (GameEnums.Zone.GRAVEYARD);
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }


}


