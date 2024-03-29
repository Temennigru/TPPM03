//reference: http://magiccards.info/wl/en/61.html

//TODO: remove from game, shuffle

package GameCore.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

public class Barishi extends Creature {

    public Barishi () {
        this.reset();
        this.m_imgLocation = "GameCore/Cards/Img/Barishi.jpg";
        this.m_type = new GameEnums.Type[1];
        this.m_type[0] = GameEnums.Type.CREATURE;
        this.m_sub = new GameEnums.CreatureSubType[1];
        this.m_sub[0] = GameEnums.CreatureSubType.ELEMENTAL;
        this.manaCost = "2GG";
        this.name = "Barishi";
        this.types = "Creature - Elemental";
        this.description = "When Barishi dies, exile Barishi, then shuffle all creature cards from your graveyard into your library.";
        this.flavor = " ";
    }

    private void reset() {
        this.power = 4;
        this.toughness = 3;
        this.untap();
        this.damage = 0;
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
        this.place (GameEnums.Zone.EXILE_FUP); //reimplement when checking graveyard becomes an issue
       
        //test
        Iterator<Card> iterator (Player player, GameEnums.Zone zone) {
        for (Iterator<Card> itr = game.iterator(this.m_owner, GameEnums.Zone.GRAVEYARD); itr.hasNext(); ) {
            Card card = itr.next();
            if (Arrays.asList(card.m_type).contains(GameEnums.Type.CREATURE)){
                card.place (GameEnums.Zone.LIBRARY);
            }
            card.m_owner.shuffle();
        }
}
