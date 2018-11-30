package gamestates;

import game.DatabaseService;
import gameevents.GameEvent;

public class GuessWordState implements GameState {
	private DatabaseService database = DatabaseService.getInstance();
	
	private int categoryId;
	
	public GuessWordState(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public void onEnter() {
		String word = database.guessWord(categoryId);
		System.out.printf("Is it %s?\n", word);
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		return null;
	}

}
