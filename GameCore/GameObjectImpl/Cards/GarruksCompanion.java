//reference: http://magiccards.info/m12/en/175.html

package GameCore.GameObjectImpl.Cards;

import GameCore.*;
import GameCore.GameObjectCore.*;
import java.lang.System;

public static class GarruksCompanion implements GameCore.GameObjectImpl.CardGenerator {

    public Card getInstance(Player owner) {

        GameEnums.SuperType[] supertypes = { };
        GameEnums.Type[] types = { GameEnums.CREATURE };
        GameEnums.SubType[] subtypes = { GameEnums.BEAST };

        Card ret = new GameCore.GameObjectImpl.CardImpl(
            "Garruk's Companion",
            "GG",
            supertypes,
            types,
            subtypes,


            false, // deathtouch
            false, // defender
            false, // doublestrike
            false, // firststrike
            false, // flash
            false, // flying
            false, // haste
            false, // hexproof
            false, // indestructible
            false, // intimidate
            "",    // landwalk
            false, // lifelink
            "",    // protection
            false, // reach
            true,  // trample
            false, // vigilance
            0,     // regen
            false, // abilities
            3,     // power
            2,     // toughness
            "They seek out living trees to glean age-old secrets from sap and wood.", // flavor
            false, // stackable
            owner, // owner
            );
        return ret;
    }
}
