package GameCore.Util;
import GameCore.GameExceptions;
import java.util.regex.*;

public class LogicSolver {
	// Intelligent string-based SAT solver
	public static boolean getSat(String event, String condition) throws GameExceptions.GameException {

		// Remove whitespace
		condition = condition.trim();

		String[] events = event.split(";");

		// Base cases
		if (condition.toLowerCase().equals("true")) { return true; }
		else if (condition.toLowerCase().equals("false")) { return false; }

		int fsa = 0; // Parenthesis stack automaton

		if (condition.isEmpty()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }

		// Recursively parse parenthesis first
		StringBuilder unparenth = new StringBuilder();

		for (int i = 0; i < condition.length(); i++) {
			// Replace parenthesized strings by recursive call results.
			if (condition.charAt(i) == '(') {
				StringBuilder temp = new StringBuilder();
				i++; // Skip first character
				fsa++;
				// Get entire parenthesized string
				while (i < condition.length()) {
					if (condition.charAt(i) == '(') {
						fsa++;
					} else if (condition.charAt(i) == ')') {
						fsa--;
						if (fsa < 0) { throw new GameExceptions.CthulhuWasSummonedException(); } // This should never happen
						if (fsa == 0) { break; } // Avoid adding last ')' to string
					}
					temp.append(condition.charAt(i));
					i++;
				}

				if (fsa > 0) { throw new GameExceptions.UnmatchedParenthesisException(condition); }

				boolean parenthRes = getSat(event, temp.toString());

				unparenth.append(Boolean.toString(parenthRes));
			} else if (condition.charAt(i) == ')') { // Unmatched ')'
				throw new GameExceptions.UnmatchedParenthesisException(condition);
			} else {
				unparenth.append(condition.charAt(i));
			}
		}

		condition = unparenth.toString();

		// Logic tree recursive expansion
		if (condition.toLowerCase().contains(" impl ")) {
			String[] temp = condition.toLowerCase().split(" impl ");

			boolean res = true;

			for (String subconditions : temp) {
				res = !(res && !getSat(event, subconditions));
			}

			return res;
		} else if (condition.toLowerCase().contains(" xor ")) {
			String[] temp = condition.toLowerCase().split(" xor ");

			boolean res = false;

			for (String subconditions : temp) {
				res = res ^ getSat(event, subconditions);
			}

			return res;
		} else if (condition.toLowerCase().contains(" or ")) {
			String[] temp = condition.toLowerCase().split(" or ");

			boolean res = false;

			for (String subconditions : temp) {
				res = res || getSat(event, subconditions);
				if (res == true) break; // Local optimization
			}

			return res;
		} else if (condition.toLowerCase().contains(" and ")) {
			String[] temp = condition.toLowerCase().split(" and ");

			boolean res = true;

			for (String subconditions : temp) {
				res = res && getSat(event, subconditions);
				if (res == false) break; // Local optimization
			}

			return res;
		} else if (condition.toLowerCase().contains(" not ") || condition.toLowerCase().startsWith("not ")) {
			String[] temp = {};
			if (condition.toLowerCase().contains(" not ")) { temp = condition.toLowerCase().split(" not "); }
			else if (condition.toLowerCase().startsWith("not ")) { temp = condition.toLowerCase().split("not ", -1); }
			else { throw new GameExceptions.CthulhuWasSummonedException(); }

			if (temp.length <= 1 || temp[1].trim().isEmpty()) {
				throw new GameExceptions.InvalidTriggerRuleException(condition); // Rules with "a and not"
			}

			String res = temp[0];

			for (int i = 1; i < temp.length; i++) {
				res += " " + !getSat(event, temp[i]);
			}

			return getSat(event, res);
		}

		// Actual computing. No more logic to expand

		String[] triggerRuleComponents;
		String[] eventComponents;
		boolean ret;

		Pattern alphanum = Pattern.compile("^[a-zA-Z0-9]*$");
		Pattern num = Pattern.compile("^[\\-]?[0-9]*$");

		if (condition.contains("==")) {
			triggerRuleComponents = condition.split("==");
			// If number of matches for operator is not 1
			if (triggerRuleComponents.length != 2) { throw new GameExceptions.InvalidTriggerRuleException(condition); }
			// Trim
			triggerRuleComponents[0] = triggerRuleComponents[0].trim().toLowerCase();
			triggerRuleComponents[1] = triggerRuleComponents[1].trim().toLowerCase();
			// If fails sanity check
			if (!alphanum.matcher(triggerRuleComponents[1]).matches()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }


			ret = false;

			for (String s : events) {
				eventComponents = s.split("=");
				// Number of "="s is not 1
				if (eventComponents.length != 2) { throw new GameExceptions.InvalidTriggerEventException(s); }
				eventComponents[0] = eventComponents[0].trim().toLowerCase();
				eventComponents[1] = eventComponents[1].trim().toLowerCase();
				// Compare rightmost
				ret |= triggerRuleComponents[0].equals(eventComponents[0]) & triggerRuleComponents[1].equals(eventComponents[1]);
				if (ret == true) { break; }
			}
		} else if (condition.contains("!=")) {
			triggerRuleComponents = condition.split("!=");
			// If number of matches for operator is not 1
			if (triggerRuleComponents.length != 2) { throw new GameExceptions.InvalidTriggerRuleException(condition); }
			// Trim
			triggerRuleComponents[0] = triggerRuleComponents[0].trim().toLowerCase();
			triggerRuleComponents[1] = triggerRuleComponents[1].trim().toLowerCase();
			// If fails sanity check
			if (!alphanum.matcher(triggerRuleComponents[1]).matches()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }


			ret = true;

			for (String s : events) {
				eventComponents = s.split("=");
				// Number of "="s is not 1
				if (eventComponents.length != 2) { throw new GameExceptions.InvalidTriggerEventException(s); }
				eventComponents[0] = eventComponents[0].trim().toLowerCase();
				eventComponents[1] = eventComponents[1].trim().toLowerCase();
				// Compare rightmost
				ret &= !(triggerRuleComponents[0].equals(eventComponents[0]) & triggerRuleComponents[1].equals(eventComponents[1]));
				if (ret == false) { break; }
			}
		} else if (condition.contains(">=")) {
			triggerRuleComponents = condition.split(">=");
			// If number of matches for operator is not 1
			if (triggerRuleComponents.length != 2) { throw new GameExceptions.InvalidTriggerRuleException(condition); }
			// Trim
			triggerRuleComponents[0] = triggerRuleComponents[0].trim().toLowerCase();
			triggerRuleComponents[1] = triggerRuleComponents[1].trim().toLowerCase();
			// If fails sanity check
			if (!num.matcher(triggerRuleComponents[1]).matches()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }


			ret = false;

			for (String s : events) {
				eventComponents = s.split("=");
				// Number of "="s is not 1
				if (eventComponents.length != 2) { throw new GameExceptions.InvalidTriggerEventException(s); }
				eventComponents[0] = eventComponents[0].trim().toLowerCase();
				eventComponents[1] = eventComponents[1].trim().toLowerCase();
				if (!num.matcher(eventComponents[1]).matches()) { continue; } // Event is not a number
				// Compare rightmost
				ret |= triggerRuleComponents[0].equals(eventComponents[0]) & (Integer.parseInt(eventComponents[1]) >= Integer.parseInt(triggerRuleComponents[1]));
				if (ret == true) { break; }
			}

		} else if (condition.contains("<=")) {
			triggerRuleComponents = condition.split("<=");
			// If number of matches for operator is not 1
			if (triggerRuleComponents.length != 2) { throw new GameExceptions.InvalidTriggerRuleException(condition); }
			// Trim
			triggerRuleComponents[0] = triggerRuleComponents[0].trim().toLowerCase();
			triggerRuleComponents[1] = triggerRuleComponents[1].trim().toLowerCase();
			// If fails sanity check
			if (!num.matcher(triggerRuleComponents[1]).matches()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }


			ret = false;

			for (String s : events) {
				eventComponents = s.split("=");
				// Number of "="s is not 1
				if (eventComponents.length != 2) { throw new GameExceptions.InvalidTriggerEventException(s); }
				eventComponents[0] = eventComponents[0].trim().toLowerCase();
				eventComponents[1] = eventComponents[1].trim().toLowerCase();
				if (!num.matcher(eventComponents[1]).matches()) { continue; } // Event is not a number
				// Compare rightmost
				ret |= triggerRuleComponents[0].equals(eventComponents[0]) & (Integer.parseInt(eventComponents[1]) <= Integer.parseInt(triggerRuleComponents[1]));
				if (ret == true) { break; }
			}
		} else if (condition.contains(">")) {
			triggerRuleComponents = condition.split(">");
			// If number of matches for operator is not 1
			if (triggerRuleComponents.length != 2) { throw new GameExceptions.InvalidTriggerRuleException(condition); }
			// Trim
			triggerRuleComponents[0] = triggerRuleComponents[0].trim().toLowerCase();
			triggerRuleComponents[1] = triggerRuleComponents[1].trim().toLowerCase();
			// If fails sanity check
			if (!num.matcher(triggerRuleComponents[1]).matches()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }


			ret = false;

			for (String s : events) {
				eventComponents = s.split("=");
				// Number of "="s is not 1
				if (eventComponents.length != 2) { throw new GameExceptions.InvalidTriggerEventException(s); }
				eventComponents[0] = eventComponents[0].trim().toLowerCase();
				eventComponents[1] = eventComponents[1].trim().toLowerCase();
				if (!num.matcher(eventComponents[1]).matches()) { continue; } // Event is not a number
				// Compare rightmost
				ret |= triggerRuleComponents[0].equals(eventComponents[0]) & (Integer.parseInt(eventComponents[1]) > Integer.parseInt(triggerRuleComponents[1]));
				if (ret == true) { break; }
			}
		} else if (condition.contains("<")) {
			triggerRuleComponents = condition.split("<");
			// If number of matches for operator is not 1
			if (triggerRuleComponents.length != 2) { throw new GameExceptions.InvalidTriggerRuleException(condition); }
			// Trim
			triggerRuleComponents[0] = triggerRuleComponents[0].trim().toLowerCase();
			triggerRuleComponents[1] = triggerRuleComponents[1].trim().toLowerCase();
			// If fails sanity check
			if (!num.matcher(triggerRuleComponents[1]).matches()) { throw new GameExceptions.InvalidTriggerRuleException(condition); }


			ret = false;

			for (String s : events) {
				eventComponents = s.split("=");
				// Number of "="s is not 1
				if (eventComponents.length != 2) { throw new GameExceptions.InvalidTriggerEventException(s); }
				eventComponents[0] = eventComponents[0].trim().toLowerCase();
				eventComponents[1] = eventComponents[1].trim().toLowerCase();
				if (!num.matcher(eventComponents[1]).matches()) { continue; } // Event is not a number
				// Compare rightmost
				ret |= triggerRuleComponents[0].equals(eventComponents[0]) & (Integer.parseInt(eventComponents[1]) < Integer.parseInt(triggerRuleComponents[1]));
				if (ret == true) { break; }
			}
		} else {
			throw new GameExceptions.InvalidTriggerRuleException(condition); // Mostly rules of type "true true"
		}

		return ret;
	}

	// Unit test
	public static void main (String[] args) {
		/*
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		scanner.useDelimiter(String.format("%n"));
		System.out.println("logic:");
		String logic = scanner.next();
		scanner.useDelimiter(String.format("%n"));
		System.out.println("event:");
		String event = scanner.next();
		*/


		int i = 1;

		// Matching tests
		try {
			String logic = "event == ETB and type == creature and power >= 3";
			String event = "event = etb; type = creature; power = 4";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}


		try {
			String logic = "event == ETB and type == creature and (power <= 3 or power >= 5)";
			String event = "event = etb; type = creature; power = 4";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}

		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		// Special case tests
		try {
			String logic = "event == ETB and (type == creature and power >= 3";
			String event = "event = etb; type = creature; power = 4";
			getSat(event, logic);
			System.out.println(String.format("%n"));
			System.out.println("Error: ");
			System.out.println(logic);
			System.out.println("Is not excepting");
		} catch (GameExceptions.UnmatchedParenthesisException g) {
			System.out.println("Test " + Integer.toString(i) + " passed");
			i++;
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "event == ETB and type == creature and power) >= 3";
			String event = "event = etb; type = creature; power = 4";
			getSat(event, logic);
			System.out.println(String.format("%n"));
			System.out.println("Error: ");
			System.out.println(logic);
			System.out.println("Is not excepting");
		} catch (GameExceptions.UnmatchedParenthesisException g) {
			System.out.println("Test " + Integer.toString(i) + " passed");
			i++;
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "event == ETB and type == creature and power  3";
			String event = "event = etb; type = creature; power = 4";
			getSat(event, logic);
			System.out.println(String.format("%n"));
			System.out.println("Error: ");
			System.out.println(logic);
			System.out.println("Is not excepting");
		} catch (GameExceptions.InvalidTriggerRuleException g) {
			System.out.println("Test " + Integer.toString(i) + " passed");
			i++;
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "and not event == ETB";
			String event = "event = etb; type = creature; power = 4";
			getSat(event, logic);
			System.out.println(String.format("%n"));
			System.out.println("Error: ");
			System.out.println(logic);
			System.out.println("Is not excepting");
		} catch (GameExceptions.InvalidTriggerRuleException g) {
			System.out.println("Test " + Integer.toString(i) + " passed");
			i++;
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "not and event == ETB";
			String event = "event = etb; type = creature; power = 4";
			getSat(event, logic);
			System.out.println(String.format("%n"));
			System.out.println("Error: ");
			System.out.println(logic);
			System.out.println("Is not excepting");
		} catch (GameExceptions.InvalidTriggerRuleException g) {
			System.out.println("Test " + Integer.toString(i) + " passed");
			i++;
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "event == ETB and type == creature and power >= 3";
			String event = "event = etb; type = creature power = 4";
			getSat(event, logic);
			System.out.println(String.format("%n"));
			System.out.println("Error: ");
			System.out.println(logic);
			System.out.println("Is not excepting");
		} catch (GameExceptions.InvalidTriggerEventException g) {
			System.out.println("Test " + Integer.toString(i) + " passed");
			i++;
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}


		// Test operators


		//*****************AND*****************//
		try {
			String logic = "true and true";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "true and false";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false and true";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false and false";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}


		//*****************OR*****************//
		try {
			String logic = "true or true";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "true or false";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false or true";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false or false";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		//*****************XOR*****************//
		try {
			String logic = "true xor true";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "true xor false";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false xor true";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false xor false";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		//*****************IMPL*****************//
		try {
			String logic = "true impl true";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "true impl false";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false impl true";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "false impl false";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		//*****************NOT*****************//
		try {
			String logic = "not true";
			String event = "";
			if (getSat(event, logic) != false) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}

		try {
			String logic = "not false";
			String event = "";
			if (getSat(event, logic) != true) {
				System.out.println(String.format("%n"));
				System.out.println("Error: ");
				System.out.println(logic);
				System.out.println(event);
				System.out.println("Are not matching");
			} else {
				System.out.println("Test " + Integer.toString(i) + " passed");
				i++;
			}
		} catch (GameExceptions.GameException g) {
			System.out.println(String.format("%n"));
			System.out.println("Error: caught exception");
			System.out.println(g.getMessage());
		}



	}
}