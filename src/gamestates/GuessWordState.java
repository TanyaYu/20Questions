package gamestates;

import gameevents.GameEvent;

public class GuessWordState implements GameState {

	@Override
	public void onEnter() {
		System.out.println("Is it ...?");
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		return null;
	}

}
