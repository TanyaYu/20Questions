package gamestates;

import java.util.logging.Logger;

import gameevents.*;

public class AskQuestionState implements GameState {
	private static final Logger LOGGER = Logger.getLogger(AskQuestionState.class.getName());
	
	private int categoryId;
	private int questionNumber;
	
	public AskQuestionState(int categoryId, int questionNumber) {
		this.categoryId = categoryId;
		this.questionNumber = questionNumber;
	}

	@Override
	public void onEnter() {
		if(questionNumber <= 0) {
			LOGGER.warning("Incorrect questing number " + questionNumber);
		}
		if(questionNumber == 1) {
			String category;
			switch(categoryId) {
			case 1: category = "Food"; break;
			case 2: category = "States"; break;
			case 3: category = "Animals"; break;
			case 4: category = "Things"; break;
			default: category = "";
			}
			System.out.println("Selected category: " + category);
		}
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if(event instanceof OnStartEvent) {
			return new ConfirmNewGameStartState(categoryId, questionNumber, 0);
		} else if(event instanceof OnStartCategoryEvent) {
			int newCategoryId = ((OnStartCategoryEvent)event).getCategoryId();
			return new ConfirmNewGameStartState(categoryId, questionNumber, newCategoryId);
		}
		return null;
	}

}
