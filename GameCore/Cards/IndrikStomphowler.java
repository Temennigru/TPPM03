//reference: http://magiccards.info/gvl/en/10.html
package GameCore.Cards;

//TODO: when enters, destroy target...

public class IndrikStomphowler extends Creature {

	public IndrikStomphowler () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/IndrikStomphowler.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.BEAST;
        this.manaCost = "GG";
        this.name = "Indrik Stomphowler"
        this.description = "When Indrik Stomphowler enters the battlefield, destroy target artifact or enchantment.";
        this.flavor = "An indrik's howl has destructive power much subtler than that of its crushing foot.";
    }

    private void reset() { 
        this.power = 4;
        this.toughness = 4;
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
