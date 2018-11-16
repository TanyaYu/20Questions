package gamestates;
import gameevents.GameEvent;

public interface GameState {
	void onEnter();
	GameState transitionTo(GameEvent event);
}
