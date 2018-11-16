package readlines;

import gameevents.*;
import static game.Constants.*;
import java.util.logging.Logger;
import gamestates.GameStateMachine;

public class ReadLineObserverImpl implements ReadLineObserver {
	private static final Logger LOGGER = Logger.getLogger(ReadLineObserverImpl.class.getName());

	private GameStateMachine stateMachine;

	public ReadLineObserverImpl(GameStateMachine stateMachine) {
		this.stateMachine = stateMachine;
	}

	@Override
	public void notify(String line) {
		line = line.toLowerCase();
		String[] lines = line.split(" ");

		if (START.equals(line)) {
			onStartLine(null);
		} else if (START.equals(lines[0]) && lines.length > 1) {
			onStartLine(lines[1]);
		} else if (YES.contains(line)) {
			stateMachine.transitTo(new OnYesEvent());
		} else if (NO.contains(line)) {
			stateMachine.transitTo(new OnNoEvent());
		} else if (FOOD_CATEGORY.contains(line)) {
			stateMachine.transitTo(new OnCategoryEvent(1));
		} else if (STATES_CATEGORY.contains(line)) {
			stateMachine.transitTo(new OnCategoryEvent(2));
		} else if (ANIMALS_CATEGORY.contains(line)) {
			stateMachine.transitTo(new OnCategoryEvent(3));
		} else if (THINGS_CATEGORY.contains(line)) {
			stateMachine.transitTo(new OnCategoryEvent(4));
		} else {
			LOGGER.warning("Unknown command " + line);
		}
	}

	private void onStartLine(String category) {
		if (category == null) {
			stateMachine.transitTo(new OnStartEvent());
		} else {
			int categoryId = 0;
			if (FOOD_CATEGORY.contains(category))
				categoryId = 1;
			else if (STATES_CATEGORY.contains(category))
				categoryId = 2;
			else if (ANIMALS_CATEGORY.contains(category))
				categoryId = 3;
			else if (THINGS_CATEGORY.contains(category))
				categoryId = 4;

			stateMachine.transitTo(new OnStartCategoryEvent(categoryId));
		}
	}
}
