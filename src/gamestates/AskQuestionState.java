package gamestates;

import java.util.logging.Logger;

import answer.Answer;
import game.DatabaseService;
import gameevents.*;

public class AskQuestionState implements GameState {
	private static final Logger LOGGER = Logger.getLogger(AskQuestionState.class.getName());
	private DatabaseService database = DatabaseService.getInstance();
	
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
			database.clearAnswers();
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
		if(questionNumber >= 1 && questionNumber <= 20) {
			String question = "...";
			//database.getQuestion(categoryId, questionNumber);
			System.out.printf("Question %d: %s\n", questionNumber, question);
		}
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if(event instanceof OnStartEvent) {
			return new ConfirmNewGameStartState(categoryId, questionNumber, 0);
		} else if(event instanceof OnStartCategoryEvent) {
			int newCategoryId = ((OnStartCategoryEvent)event).getCategoryId();
			return new ConfirmNewGameStartState(categoryId, questionNumber, newCategoryId);
		} else if(event instanceof OnEndEvent) {
			return new ConfirmEndGameState(categoryId, questionNumber);
		} else if(event instanceof OnYesEvent) {
			database.postAnswer(questionNumber, Answer.YES);
			if(questionNumber >= 20) return new GuessWordState();
			else return new AskQuestionState(categoryId, questionNumber+1);
		} else if(event instanceof OnNoEvent) {
			database.postAnswer(questionNumber, Answer.NO);
			if(questionNumber >= 20) return new GuessWordState();
			else return new AskQuestionState(categoryId, questionNumber+1);
		} else if(event instanceof OnSometimesEvent) {
			database.postAnswer(questionNumber, Answer.SOMETIMES);
			if(questionNumber >= 20) return new GuessWordState();
			else return new AskQuestionState(categoryId, questionNumber+1);
		} else if(event instanceof OnUnknownEvent) {
			database.postAnswer(questionNumber, Answer.UNKNOWN);
			if(questionNumber >= 20) return new GuessWordState();
			else return new AskQuestionState(categoryId, questionNumber+1);
		}
		return null;
	}

}
