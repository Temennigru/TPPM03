import Cards.*;
import java.lang.System;
import Core.*;


public class main {
	public static void main(String[] args) {
		RealPlayer me = new RealPlayer(null);

		Core.GameCore game = Core.GameCore.getGame(me, null);

		Cards.Abstract.Card s = new StranglerootGheist();
		s.m_owner = me;
		s.m_controler = me;

		Cards.Abstract.Card f = new Forest();
		f.m_owner = me;
		f.m_controler = me;

		s.play();
		System.out.println(s.toString());
		System.out.println("Killing gheist\n");
		((Cards.Abstract.Creature)s).kill();
		System.out.println(s.toString());

		System.out.println(f.toString());

		f.play();

		System.out.println("Green mana: " + Integer.toString(me.manaPool[1]) + "\n");

		f.abilities.elementAt(0).activate();

		System.out.println("Tapped Forest\n");

		System.out.println(f.toString());

		System.out.println("Green mana: " + Integer.toString(me.manaPool[1]));
	}
}