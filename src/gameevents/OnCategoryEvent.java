package gameevents;

public class OnCategoryEvent extends GameEvent {
	
	private int categoryId;
	
	public OnCategoryEvent(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
}
