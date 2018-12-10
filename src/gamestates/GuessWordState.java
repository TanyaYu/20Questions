package gamestates;

import game.DatabaseService;
import gameevents.GameEvent;
import gameevents.OnEndEvent;
import gameevents.OnHelpEvent;
import gameevents.OnNoEvent;
import gameevents.OnYesEvent;

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
		if(event instanceof OnYesEvent) {
			return new AskNewGameStartState();
		}
		if(event instanceof OnNoEvent) {
			return new AskRightWordState(categoryId);
		}
		if(event instanceof OnHelpEvent) {
			printHelp();	
		}
		return null;
	}
	
	private void printHelp() {
		System.out.println("Please type YES(Y) or NO(N)"); 
	}

}
