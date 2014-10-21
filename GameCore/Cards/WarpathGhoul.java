//reference: http://magiccards.info/m12/en/117.html


package Cards;

import Core.*;
import Cards.Abstract.*;
import java.lang.System;

public class WarpathGhoul extends Creature {

    public WarpathGhoul () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/WarpathGhoul.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ZOMBIE;
        this.manaCost = "2B";
        this.name = "Warpath Ghoul";
        this.types = "Creature - Zombie";
        this.description = " ";
        this.flavor = "Ghouls are often found skulking on the fringes of great battles, showing themselves only to snatch the wounded and weak, dragging their victims screaming into the shadows.";
    }

    private void reset() {
        this.power = 3;
        this.toughness = 2;
    }

    public void play () throws GameExceptions.GameException {
        this.reset();
        this.place (GameEnums.Zone.BATTLEFIELD);
    }

    public void place (GameEnums.Zone zone, int position) throws GameExceptions.GameException {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public void kill () throws GameExceptions.GameException {
        this.place (GameEnums.Zone.GRAVEYARD);
    }
}
