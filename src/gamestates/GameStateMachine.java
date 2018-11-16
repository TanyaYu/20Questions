package gamestates;
import java.util.logging.Logger;

import gameevents.GameEvent;

public class GameStateMachine {

	private static final Logger LOGGER = Logger.getLogger(GameStateMachine.class.getName());

	private GameState currentState;
	
	public GameStateMachine() {
		currentState = new SelectCategoryState();
		currentState.onEnter();
	}
	
	public void transitTo(GameEvent event) {
		GameState newState = currentState.transitionTo(event);
		if(newState != null) {
			currentState = newState;
			currentState.onEnter();
		} else {
			LOGGER.warning("Transition is not found for event " );
		}
	}
}
