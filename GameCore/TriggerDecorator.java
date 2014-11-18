/* Smart trigger parser.
 * 
 * Copyright 2014 Jean-Luc Nacif Coelho and João Francisco Moreira Penna
 * 
 * Trigger condition is a string describing conditions that must be satisfied
 * to trigger the abilitiy related to it.
 * Strings are not case-sensitive.
 * Trigger conditions accept logical operators "not", "and", "or", "xor" and "implies".
 * Trigger condition logic respects precedence: and > or > xor > impl > not.
 * Trigger conditions accept comparison operators: "==", ">", "<", ">=", "<=" and "!=", although nonexact comparison
 * is limited to numerical variables.
 * Trigger conditions accept parenthesis.
 * Any characters other than '~', 'a-z', 'A-Z', '0-9', '\s', '(' or ')' will create an exception.
 * Examples: (Event == ETB) and (Type == Creature) and (SubType == Beast or SubType == Spirit) and (Power > 1) and (Toughness == 2)
 *           (Event == Death) and (Type == Beast)
 *           (Event == Phase) and (Phase == Upkeep)
 * 
 * An Event is a bit different. They don't accept logic operators or parenthesis as each statement represents a tautology.
 * You can think of the two as such: Trigger conditions are if statements and events are assignment statements.
 * Each assignment must be a separate string.
 * Event syntax: (Event) (Event Information)*
 * Examples: (Event = ETB) (Type = Creature) (SubType = Beast) (SubType = Spirit) (Power = 1) (Toughness = 2) (Player = Joao)
 *           (Event = Death) (Type = Beast) (Player = Bob)
 *           (Event = Phase) (Phase = Upkeep) (Player = Jean)
 *
 * Notes:
 * - Both have a few reserved keywords:
 * true(meaning true), false(meaning false), opponent(meaning any of the ability's controller's opponents),
 * ~(meaning the card) and self(meaning the ability's controller).
 *
 * - Variable names mean nothing more than what the rule should look for, so it is recommended that you reuse variable
 * names for matching purpouses (Ex: don't use "subtype1 == a and subtype2 == b" as the rule will only be satisfiable when
 * they both appear in that order. Use instead "subtype == a and subtype == b" as this will result in any "subtype"
 * assignments triggering this clause) 
 * 
 * - Events must be separated by ';'
 *
 * - Opponent, self and ~ are not currently implemented.
 */

package GameCore;
import GameCore.GameObjectCore.Ability;
import java.util.*;
import Util.LogicSolver;

public final class TriggerDecorator {
	// TLB structures
	private int[] m_lastRet;
	private boolean[] m_lastRetDirty;

	private Vector<Ability> m_triggers;

	public TriggerDecorator() {}

	public Ability[] getViableTriggers(String event) throws GameExceptions.GameException {

		// TODO: Cache results

		List<int> tlb = new ArrayList<int>();
		for (int i = 0; i < m_triggers.size(); i++) {
			if (LogicSolver.getSat(event, m_triggers.elementAt(i).activateCost())) {
				tlb.add(i);
			}
			
		}
		m_lastRet = tlb.toArray(new String[tlb.size()]);
		m_lastRetDirty = new String[tlb.size()];

		Ability[] ret = new Ability[tlb.size()];

		for (int i = 0; i < tlb.size(); i++) {
			m_lastRetDirty[i] = false;
			ret[i] = m_triggers.elementAt(m_lastRet[i]);
		}

		return ret;
	}

	// Warning: This assumes that when an element is deleted in a vector, all
	// elements in front of it are shifted left.
	// Takes the address provided, runs it through the TLB and deletes the appropriate element.
	public void unRegister (int position, boolean fromViable) throws GameExceptions.GameException {
		if (!fromViable) { this.unRegister(position); }

		if (m_lastRetDirty[position]) {
			throw new GameExceptions.DirtyTriggerException();
		}
		int realPos = m_lastRet[position];
		for (int i = 0; i < m_lastRet.size(); i++) {
			if (realPos < m_lastRet[i]) {
				// If element is in front of element to be deleted, update index
				m_lastRet[i]--;
			} else if (realPos == m_lastRet[i]) {
				// If for some reason the decorator returns a trigger more than once,
				// all will be set as dirty.
				m_lastRetDirty[i] = true;
			}
		}
		m_triggers.remove(realPos);
	}

	public void unRegister (int position) throws GameExceptions.GameException {
		m_triggers.remove(position);
	}

	public int register (Ability trigger) throws GameExceptions.GameException {
		if (trigger.abilityType() != GameEnums.AbilityType.TRIGGERED) {
			throw new GameExceptions.TriggerNotTriggerException(trigger);
		}
		this.m_triggers.add(trigger);
		return this.m_triggers.size() - 1;
	}



	// Unit test


    private static class TestAbility extends Ability {

        private GameObject m_fatherObject;
        private GameObject m_source;

        private GameEnums.AbilityType m_abilityType;

        public boolean stackable() { return false; }

        public String[] activateCost() {
        	String[] ret = new String[3]; 
        	ret[0] = "event = ETB";
        	ret[1] = "type = creature";
        	ret[2] = "power > 3";
        	return ret;
        }

        public TestAbility (GameObject father) {
            this.m_abilityType = GameEnums.AbilityType.TRIGGERED;
            this.m_fatherObject = father;
        }

        public boolean activate () throws GameExceptions.GameException {
            return this.activate (this);
        }

        public boolean activate (GameObject source) throws GameExceptions.GameException {
            if (((Permanent)this.m_fatherObject).location != GameEnums.Zone.BATTLEFIELD) { throw new GameExceptions.WrongZoneException(((Permanent)this.m_fatherObject), ((Permanent)this.m_fatherObject).location, GameEnums.Zone.BATTLEFIELD); }
            if (((Permanent)this.m_fatherObject).isTapped()) return false;
            this.m_fatherObject.m_controler.addMana("G");
            ((Permanent)this.m_fatherObject).tap();
            return true;
        }

    }

	public static void main() {
		TriggerDecorator td = new TriggerDecorator();

		td.register(new TestAbility());

		if (td.getViableTriggers(new String[]{"event = etb and type = creature and power = 3 and tougness = 3"}).length() > 0) {
			System.out.println("achei");
		}
	}

}