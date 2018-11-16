package game;
import java.io.IOException;

import gamestates.GameStateMachine;
import readlines.ReadLineManager;
import readlines.ReadLineObserverImpl;

public class Game {

	public static void main(String[] args) throws IOException {
		GameStateMachine stateMachine = new GameStateMachine();
		ReadLineManager rlm = new ReadLineManager();
		rlm.registerObserver(new ReadLineObserverImpl(stateMachine));
		rlm.startReading();
	}

}
