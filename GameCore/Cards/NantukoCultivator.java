//reference: http://magiccards.info/tr/en/133.html
package GameCore.Cards;

//TODO: comes into play, discard lands put +1+1 counters, draw cards

public class NantukoCultivator extends Creature {

	public NantukoCultivator () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/NantukoCultivator.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.INSECT; //GameEnums.CreatureSubType.DRUID
        this.manaCost = "3G";
        this.name = "Nantuko Cultivator"
        this.description = "When Nantuko Cultivator comes into play, you may discard any number of land cards from your hand. Put that many +1/+1 counters on Nantuko Cultivator and draw that many cards.";
        this.flavor = " ";
    }

    private void reset() { 
        this.power = 2;
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
