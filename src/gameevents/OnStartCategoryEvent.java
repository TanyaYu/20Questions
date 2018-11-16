package gameevents;

public class OnStartCategoryEvent extends GameEvent {
	
	private int categoryId;
	
	public OnStartCategoryEvent(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
}
