import GameCore.Cards.*;
import java.lang.System;
import GameCore.*;
import GameCore.GameObjectCore.*;
import java.io.IOException;


public class main {

    private static class GreenDeck extends Deck {
        public GreenDeck(Player player) { super(player); }
        protected void createDeck() {
            Card s = null;

            for (int i = 0; i < 26; i++) {
                if (i >= 0 && i < 8) {
                    s = new StranglerootGeist();
                } else if (i >= 8 && i < 16) {
                    s = new Forest();
                } else if (i >= 16) {
                    s = new GarruksCompanion();
                }

                s.m_owner = this.m_owner;
                s.m_controler = this.m_owner;
                s.location = GameEnums.Zone.LIBRARY;

                this.add(s);

                this.numCards = 16;
            }
        }
    }

    private static class BlackDeck extends Deck {
        public BlackDeck(Player player) { super(player); }
        protected void createDeck() {
            Card s = null;

            for (int i = 0; i < 26; i++) {
                if (i >= 0 && i < 8) {
                    s = new GeralfsMessenger();
                } else if (i >= 8 && i < 16) {
                    s = new ButcherGhoul();
                } else if (i >= 16) {
                    s = new Swamp();
                }

                s.m_owner = this.m_owner;
                s.m_controler = this.m_owner;
                s.location = GameEnums.Zone.LIBRARY;

                this.add(s);

                this.numCards = 16;
            }
        }
    }

	public static void main(String[] args) throws GameExceptions.GameException, IOException, InterruptedException {
		RealPlayer plyr1 = new RealPlayer("Jean");
        Deck blackDeck = new BlackDeck(plyr1);
        plyr1.setDeck(blackDeck);

		RealPlayer plyr2 = new RealPlayer("Joao");
        Deck greenDeck = new GreenDeck(plyr2);
        plyr2.setDeck(greenDeck);

        GameCore game = GameCore.makeGame(plyr1, plyr2);

        game.runGame();

	}
}