import java.awt.*;
import javax.swing.*;
import java.util.Vector;

//package GameCore.Ui.Gui

public class Gui {
	
	
	public boolean player_passed = false;
	public boolean player_played_something = false;
	public boolean something_cast = true;
	private GameCore game;
	private Vector<CardRep> playerHandList;
	private Vector<CardRep> playerGraveyardList;
	private Vector<CardRep> playerBattlefieldList;
	private Vector<CardRep> opponentBattlefieldList;
	private MainLayout layout;
	private static Gui m_gui;
		
	private static class CardRep {
		Card c;
		JLabel j;
		
		public CardRep(Card c, JLabel j){
			this.c = c;
			this.j = j;
		}
	}

	public static Gui get_gui (){
		if (m_gui == null){
			m_gui = new Gui();
		}
		return m_gui;
	}
	
	private Gui(){
		game = GameCore.getGame();
		if (! game.valid() ){
			throw new GameExceptions.InvalidGameException();
		}
		layout = new MainLayout();
	}
	
	private void draw(){
		for( CardRep cr : playerHandList.toArray() ){
			cr.j.setIcon(cr.c.getImage);
		}
		for( CardRep cr : playerGraveyardList.toArray() ){
			cr.j.setIcon(cr.c.getImage);
		}
		for( CardRep cr : playerBattlefieldList.toArray() ){
			cr.j.setIcon(cr.c.getImage);
		}
		for( CardRep cr : opponentBattlefieldList.toArray() ){
			cr.j.setIcon(cr.c.getImage);
		}
	}
	
	private void erase(){
		for( CardRep cr : playerHandList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
		playerHandList.clear();
		for( CardRep cr : playerGraveyardList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
		playerGraveyardList.clear();
		for( CardRep cr : playerBattlefieldList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
		playerBattlefieldList.clear();
		for( CardRep cr : opponentBattlefieldList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
		opponentBattlefieldList.clear();
	}
	
	public void execGame(){
		while (true){
			if (player_passed){
				player_passed = false;
				game.passPriority();
			}
			
			else if (player_played_something){
				if (!something_cast){ //na verdade vai testar é something.cast
					System.out.println ("could not cast");
				}
				else{
					//game.stack(something);
					//statecheck
				}
			}
			this.refresh();
		}
	}
	
	public void gameOver(){
		//
	}
	
	public int[] prompt (String question, String[] options, int numChoices){
		//prompts a question for user input
		//opens a dialog box
		//returns the selection
		int [] answer;
		answer = new int[numChoices];
		
		
		return answer;
	}
	
	public void refresh(){
		//updates the gui to reflect current state
		
		//erases first?
		
		//Iterates on the hand to build this part of the layout
		Iterator<Card> itrHand = game.iterator(m_current_player, HAND);
		while (itrHand.hasNext()){
			Card temp = itrHand.next();
			JLabel j = new JLabel();
			CardRep cr = new CardRep(temp, j);
			layout.place(j, "Hand");
		}
						
		//Iterates on the Graveyard to build this part of the layout
		Iterator<Card> itrGraveyard = game.iterator(m_current_player, GRAVEYARD);
		while (itrGraveyard.hasNext()){
			Card temp = itrHand.next();
			JLabel j = new JLabel();
			CardRep cr = new CardRep(temp, j);
			layout.place(j, "Graveyard");
		}
		
		//Iterates on the Battlefield to build this part of the layout
		Iterator<Card> itrBattlefield = game.iterator(m_current_player, BATTLEFIELD);
		while (itrBattlefield.hasNext()){
			Card temp = itrBattlefield.next();
			if ( temp.controller() == game.getCurrentPriorityPlayer() ) {
				Card temp = itrHand.next();
				JLabel j = new JLabel();
				CardRep cr = new CardRep(temp, j);
				layout.place(j, "p1Battlefield");
			}
			else {
				Card temp = itrHand.next();
				JLabel j = new JLabel();
				CardRep cr = new CardRep(temp, j);
				layout.place(j, "p2Battlefield");
			}
		}
		
		//refresh no painel de informações
}
