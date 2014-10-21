import Cards.*;
import java.lang.System;
import Core.*;


public class main {
	public static void main(String[] args) throws GameExceptions.GameException {
		RealPlayer me = new RealPlayer("Loops");

		Core.GameCore game = Core.GameCore.getGame(me, null);

		Cards.Abstract.Card s = new StranglerootGeist();
		s.m_owner = me;
		s.m_controler = me;

		s.play();
		System.out.println(s.toString());

		System.out.println("Killing geist\n");
		((Cards.Abstract.Creature)s).kill();
		System.out.println(s.location.toString());
		System.out.println(s.toString());

		System.out.println("Killing geist\n");
		((Cards.Abstract.Creature)s).kill();
		System.out.println(s.location.toString());
		System.out.println(s.toString());



		Cards.Abstract.Card f = new Forest();

		f.m_owner = me;
		f.m_controler = me;

		f.play();

		System.out.println(f.toString());
		
		System.out.println("Green mana: " + Integer.toString(me.manaPool[1]) + "\n");

		f.activateAt(0);

		System.out.println("Tapped Forest\n");

		System.out.println(f.toString());

		System.out.println("Green mana: " + Integer.toString(me.manaPool[1]));

		Cards.Abstract.Card e = new LlanowarElves();
		e.m_owner = me;
		e.m_controler = me;

		e.play();

		e.activateAt(0);

		System.out.println("Tapped Elves\n");

		System.out.println(e.toString());

		System.out.println("Green mana: " + Integer.toString(me.manaPool[1]));

		System.out.println(e.location.toString());

		e.activateAt(0);

		System.out.println("Green mana: " + Integer.toString(me.manaPool[1]));
	}
}