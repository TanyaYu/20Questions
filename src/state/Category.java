package state;

public class Category {

	private int categoryId;
	private String tableName;
	private String wordColumnName;

	private Category() {
	}

	private Category(int categoryId, String tableName, String wordColumnName) {
		this.categoryId = categoryId;
		this.tableName = tableName;
		this.wordColumnName = wordColumnName;
	}

	public static Category getById(int id) {
		switch (id) {
		case 1:
			return new Category(id, "foodtable", "foodname");
		case 2:
			return new Category(id, "statestable", "statename");
		case 3:
			return new Category(id, "animalstable", "animalname");
		case 4:
			return new Category(id, "thingstable", "ThingName");
		default:
			return null;
		}
	}
	
	private String getTableName() {
		return tableName;
	}
	
	private String getWordColumnName() {
		return wordColumnName;
	}
	
	private int getCategoryId() {
		return categoryId;
	}
}
