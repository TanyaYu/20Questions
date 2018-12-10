package gamestates;

import game.DatabaseService;
import gameevents.GameEvent;
import gameevents.OnHelpEvent;
import gameevents.OnUnrecognizedCommandEvent;

public class AskRightWordState implements GameState {

	private int categoryId;
	
	public AskRightWordState(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public void onEnter() {
		System.out.println("What was the word you were thinking about?");
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if(event instanceof OnUnrecognizedCommandEvent) {
			String answer = ((OnUnrecognizedCommandEvent) event).getCommand();
			DatabaseService.getInstance().updateAnswers(answer, categoryId);
			return new AskNewGameStartState();
		}
		if (event instanceof OnHelpEvent) {
			System.out.println("Please enter the word that you are thinking.");
		}
		return null;
	}

}
