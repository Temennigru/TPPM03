//package GameCore.Ui.Gui

public class Gui {
	
	public boolean player_passed = false;
	boolean player_played_something = false;
	boolean something_cast = true;
	
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
		
		//Iterates on the hand to build this part of the layout
		Iterator<Card> itrHand = this.iterator(m_current_player, HAND);
		while (itrHand.hasNext()){
			//adiciona um label na parte de hand do layout
			//seta de acordo
		}
						
		//Iterates on the Graveyard to build this part of the layout
		Iterator<Card> itrGraveyard = this.iterator(m_current_player, GRAVEYARD);
		while (itrGraveyard.hasNext()){
			//adiciona um label na parte de graveyard do layout
			//seta de acordo
		}
		
		//Iterates on the Battlefield to build this part of the layout
		Iterator<Card> itrBattlefield = this.iterator(m_current_player, BATTLEFIELD);
		while (itrBattlefield.hasNext()){
			if (card.m_owner == m.currentplayer){
			//adiciona um label na parte de battlefield de baixo do layout
			//seta de acordo
			}
			else {
			//adiciona um label na parte de cima do battlefield
			//seta de acordo
			}
		}
		
		//refresh no painel de informações
}
