package gamestates;

import gameevents.*;

public class ConfirmNewGameStartState implements GameState {

	private int categoryId;
	private int questionNumber;
	private int newCategoryId;

	public ConfirmNewGameStartState(int categoryId, int questionNumber, int newCategoryId) {
		this.categoryId = categoryId;
		this.questionNumber = questionNumber;
		this.newCategoryId = newCategoryId;
	}

	@Override
	public void onEnter() {
		System.out.println("Are you sure you want to start a new game?");
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if (event instanceof OnYesEvent) {
			if (newCategoryId == 0) return new SelectCategoryState();
			return new AskQuestionState(newCategoryId, 1);
		} 
		if (event instanceof OnNoEvent) {
			return new AskQuestionState(categoryId, questionNumber);
		}
		printHelp();
		return null;
	}
	
	private void printHelp() {
		System.out.println("Please type YES(Y) or NO(N)"); 
	}

}
