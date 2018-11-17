package gamestates;

import java.io.IOException;

import gameevents.*;
import readlines.ReadLineManager;

public class ConfirmEndGameState implements GameState {

	private int categoryId;
	private int questionNumber;
	// private int newCategoryId;

	public ConfirmEndGameState(int categoryId, int questionNumber) {
		this.categoryId = categoryId;
		this.questionNumber = questionNumber;
		
	}

	@Override
	public void onEnter() {
		System.out.println("Are you sure you want to end your current game?");
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if (event instanceof OnYesEvent) {
			try {
				ReadLineManager.getInstance().stopReading();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		} else if (event instanceof OnNoEvent) {
			return new AskQuestionState(categoryId, questionNumber);
		}
		printHelp();
		return null;
	}
	
	private void printHelp() {
		System.out.println("Please type YES(Y) or NO(N)"); 
	}

}
