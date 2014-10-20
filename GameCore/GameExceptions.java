package GameCore;

import Cards.Abstract.*;
import java.lang.System;
import java.lang.String;

public class GameExceptions {
	public static abstract class GameException extends Exception {
		protected String msg;
        @Override
        public String getMessage() {
            return this.msg;
        }
	}

	public static class WrongZoneException extends GameException {
		public WrongZoneException(Card card, GameEnums.Zone got, GameEnums.Zone expected) {
			this.msg = ("Error: Card is in wrong zone." + String.format("%n") +
				"Card: " + card.name + String.format("%n") +
				"Expected " + expected.toString() + " but got " + got.toString());
		}

	}

	public static class WrongOwnerException extends GameException {
		public WrongOwnerException(Card card, Player got, Player expected) {
			this.msg = ("Error: Someone is trying to steal a card!" + String.format("%n") +
				"Card: " + card.name + String.format("%n") +
				"Expected " + expected.toString() + " but got " + got.toString());
		}
	}

	public static class InvalidGameException extends GameException {
		public WrongOwnerException(Card card, Player got, Player expected) {
			this.msg = "Error: Game was not created." + String.format("%n");
		}
	}
}