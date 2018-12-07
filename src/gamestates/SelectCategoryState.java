package gamestates;

import gameevents.*;

public class SelectCategoryState implements GameState {

	@Override
	public void onEnter() {
		printCategoriesHelp();
	}

	@Override
	public GameState transitionTo(GameEvent event) {
		if(event instanceof OnCategoryEvent) {
			int categoryId = ((OnCategoryEvent)event).getCategoryId();
			return new AskQuestionState(categoryId, 1);
		}
		if(event instanceof OnStartCategoryEvent) {
			int categoryId = ((OnStartCategoryEvent)event).getCategoryId();
			return new AskQuestionState(categoryId, 1);
		}
		if(event instanceof OnHelpEvent) {
			printCategoriesHelp();	
		}	
		return null;
	}
	
	private void printCategoriesHelp() {
		System.out.println("Please select word category:\n"
				+ "1 - Food\n"
				+ "2 - States\n"
				+ "3 - Animals\n"
				+ "4 - Things\n");
	}
}
