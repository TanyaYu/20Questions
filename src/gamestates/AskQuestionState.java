package gamestates;

import java.util.logging.Logger;

import game.Answer;
import game.Category;
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
		if (questionNumber <= 0) {
			LOGGER.warning("Incorrect questing number " + questionNumber);
		}
		if (questionNumber == 1) {
			database.clearAnswers();
			Category category = Category.getById(categoryId);
			System.out.println("Selected category: " + category.getName());
		}
		if (questionNumber >= 1 && questionNumber <= 20) {
			String question = database.getQuestion(categoryId, questionNumber);
			System.out.printf("Question %d: %s\n", questionNumber, question);
		}
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if (event instanceof OnStartEvent) {
			return new ConfirmNewGameStartState(categoryId, questionNumber, 0);
		}
		if (event instanceof OnStartCategoryEvent) {
			int newCategoryId = ((OnStartCategoryEvent) event).getCategoryId();
			return new ConfirmNewGameStartState(categoryId, questionNumber, newCategoryId);
		}
		if (event instanceof OnEndEvent) {
			return new ConfirmEndGameState(categoryId, questionNumber);
		}
		if (event instanceof OnYesEvent) {
			database.postAnswer(questionNumber, Answer.YES);
			if (questionNumber >= 20) return new GuessWordState(categoryId);
			return new AskQuestionState(categoryId, questionNumber + 1);
		}
		if (event instanceof OnNoEvent) {
			database.postAnswer(questionNumber, Answer.NO);
			if (questionNumber >= 20) return new GuessWordState(categoryId);
			return new AskQuestionState(categoryId, questionNumber + 1);
		}
		if (event instanceof OnSometimesEvent) {
			database.postAnswer(questionNumber, Answer.SOMETIMES);
			if (questionNumber >= 20) return new GuessWordState(categoryId);
			return new AskQuestionState(categoryId, questionNumber + 1);
		}
		if (event instanceof OnUnknownEvent) {
			database.postAnswer(questionNumber, Answer.UNKNOWN);
			if (questionNumber >= 20) return new GuessWordState(categoryId);
			return new AskQuestionState(categoryId, questionNumber + 1);
		}
		if (event instanceof OnUndoEvent) {
			if (questionNumber == 1) return null;
			return new AskQuestionState(categoryId, questionNumber - 1);
		}
		if (event instanceof OnHelpEvent) {
			System.out.println("Please type YES(Y), NO(N), SOMETIMES(S) OR UNKNOWN(U) to answer the questions");
		}
		

		return null;
	}

}
