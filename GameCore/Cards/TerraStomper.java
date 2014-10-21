//reference: http://magiccards.info/m15/en/284.html
package GameCore.Cards;

//TODO: cant be countered -> counters are irrelevant in current version

public class TerraStomper extends Creature {

	public TerraStomper () {
        this.trample = true;
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/TerraStomper.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.BEAST;
        this.manaCost = "3GGG";
        this.name = "Terra Stomper"
        this.description = "Terra Stomper can't be countered." + System.lineSeparator()
        + "Trample (If this creature would assign enough damage to its blockers to destroy them, you may have it assign the rest of its damage to defending player or planeswalker.)";
        this.flavor = "Its footfalls cause violent earthquakes, hurtling boulders, and unseasonable dust storms.";
    }

    private void reset() {
        this.power = 8;
        this.toughness = 8;
    }

	public play (GameCore game) {
        this.reset();
        this.place (GameEnums.Zone.BATTLEFIELD);
    }
	
    public void place (GameCore game, GameEnums.Zone zone) {
        this.reset();
        this.location = zone;
        GameCore game = GameCore.getGame();
        game.registerOnZone(this, zone);
    }

    public void kill (GameCore game) {
        this.place(GameEnums.Zone.GRAVEYARD);
    }


}
