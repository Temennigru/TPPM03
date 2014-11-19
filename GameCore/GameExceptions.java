package GameCore;

//import GameCore.GameObjectCore.Card;
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

	/*
	public static class WrongZoneException extends GameException {
		public WrongZoneException(Card card, GameEnums.Zone got, GameEnums.Zone expected) {
			this.msg = ("Error: Card is in wrong zone." + String.format("%n") +
				"Card: " + card.name() + String.format("%n") +
				"Expected " + expected.toString() + " but got " + got.toString() + ")" + String.format("%n"));
		}

	}

	public static class WrongOwnerException extends GameException {
		public WrongOwnerException(Card card, Player got, Player expected) {
			this.msg = ("Error: Someone is trying to steal a card!" + String.format("%n") +
				"Card: " + card.name + String.format("%n") +
				"(Expected " + expected.toString() + " but got " + got.toString() + ")" + String.format("%n"));
		}
	}

	public static class InvalidGameException extends GameException {
		public InvalidGameException() {
			this.msg = "Error: Game was not created." + String.format("%n");
		}
	}

	public static class CurrentPlayerLostException extends GameException {
		protected Player player;
		public CurrentPlayerLostException(Player player) {
			this.player = player;
			this.msg = "Error: " + player.name + " has lost the game" + String.format("%n");
		}
	}

	public static class DirtyTriggerException extends GameException {
		public DirtyTriggerException() {
			this.msg = "Error: Someone is trying to delete a previously deleted trigger" + String.format("%n");
		}
	}

	public static class TriggerNotTriggerException extends GameException {
		protected Ability got;
		public TriggerNotTriggerException(Ability got) {
			this.got = got;
			this.msg = ("Error: Registered trigger is not a trigger." + String.format("%n") +
				"(Got " + got.abilityType().toString() + ")" + String.format("%n"));
		}
	}
*/
	public static class CthulhuWasSummonedException extends GameException {
		public CthulhuWasSummonedException() {
			java.lang.StackTraceElement trace = Thread.currentThread().getStackTrace()[1];
			this.msg = ("Error: Something has gone terribly wrong." + String.format("%n") +
				trace.getFileName() + ":" + Integer.toString(trace.getLineNumber()) + String.format("%n"));
		}
	}

	public static class UnmatchedParenthesisException extends GameException {
		protected String rule;
		public UnmatchedParenthesisException(String rule) {
			this.rule = rule;
			this.msg = ("Error: Trigger rule has unmatched parenthesis." + String.format("%n") +
				"(\"" + rule + "\")" + String.format("%n"));
		}
	}

	public static class InvalidTriggerRuleException extends GameException {
		protected String rule;
		public InvalidTriggerRuleException(String rule) {
			this.rule = rule;
			this.msg = ("Error: Malformed trigger rule." + String.format("%n") +
				"(\"" + rule + "\")" + String.format("%n"));
		}
	}

	public static class InvalidTriggerEventException extends GameException {
		protected String event;
		public InvalidTriggerEventException(String event) {
			this.event = event;
			this.msg = ("Error: Malformed event." + String.format("%n") +
				"(\"" + event + "\")" + String.format("%n"));
		}
	}

	public static class InvalidImageDBFolderHierarchy extends GameException {
		protected String root;
		public InvalidImageDBFolderHierarchy(String root) {
			this.root = root;
			this.msg = ("Error: Folder " + root + " does not contain the folder \"tapped\", \"untapped\" or \"large\"" + String.format("%n"));
		}
	}

	public static class MissingImageDBFile extends GameException {
		protected String name, type;
		public MissingImageDBFile(String name, String type) {
			this.name = name;
			this.type = type;
			this.msg = ("Error: " + name + " is missing the " + type + " file" + String.format("%n"));
		}
	}
}