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
	
	private static class CardRep{
		Card c;
		JLabel j;
		
		public CardRep(Card c, JLabel j){
			this.c = c;
			this.j = j;
		}
	}
	
	public Gui(){
		game = GameCore.getGame();
		if (! game.valid() ){
			throw new GameExceptions.InvalidGameException();
		}
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
		for( CardRep cr : playerGraveyardList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
		for( CardRep cr : playerBattlefieldList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
		for( CardRep cr : opponentBattlefieldList.toArray() ){
			Container parent = cr.j.getParent();
			parent.remove(cr.j);
			parent.validate();
			parent.repaint();
		}
	}
	
	public void execGame(){
		while (true){
			if (player_passed){
				player_passed = false;
				//game.passPriority();
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
			CardRep cr = new CardRep(temp, new JLabel);
			//adiciona um label na parte de hand do layout
			//seta de acordo
		}
						
		//Iterates on the Graveyard to build this part of the layout
		Iterator<Card> itrGraveyard = game.iterator(m_current_player, GRAVEYARD);
		while (itrGraveyard.hasNext()){
			//adiciona um label na parte de graveyard do layout
			//seta de acordo
		}
		
		//Iterates on the Battlefield to build this part of the layout
		Iterator<Card> itrBattlefield = game.iterator(m_current_player, BATTLEFIELD);
		while (itrBattlefield.hasNext()){
			Card temp = itrBattlefield.next();
			if ( temp.controller() == game.getCurrentPriorityPlayer() ) {
				//parte de baixo
			}
			else {
			//adiciona um label na parte de cima do battlefield
			//seta de acordo
			}
		}
		
		//refresh no painel de informações
}
