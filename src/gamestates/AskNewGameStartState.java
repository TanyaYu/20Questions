package gamestates;

import java.io.IOException;

import gameevents.GameEvent;
import gameevents.OnNoEvent;
import gameevents.OnYesEvent;
import readlines.ReadLineManager;

public class AskNewGameStartState implements GameState {

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		System.out.println("Do you want to start a new game?");
		
		
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if(event instanceof OnYesEvent) {
			return new SelectCategoryState();
		}
		if(event instanceof OnNoEvent) {
			try {
				ReadLineManager.getInstance().stopReading();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		// TODO Auto-generated method stub
		return null;
		
		if (event instanceof OnHelpEvent) {
			System.out.println("Please type YES(Y) to start a new game and NO(N) to continue with the same game or to exit.")
		}
	}

}
