package game;

public class Category {

	private int categoryId;
	private String tableName;
	private String wordColumnName;
	private String name;

	private Category() {
	}

	private Category(int categoryId, String name, String tableName, String wordColumnName) {
		this.categoryId = categoryId;
		this.tableName = tableName;
		this.wordColumnName = wordColumnName;
		this.name = name;
	}

	public static Category getById(int id) {
		switch (id) {
		case 1:
			return new Category(id, "Food", "foodtable", "foodname");
		case 2:
			return new Category(id, "States", "statestable", "statename");
		case 3:
			return new Category(id, "Animals", "animalstable", "animalname");
		case 4:
			return new Category(id, "Things", "thingstable", "ThingName");
		default:
			return null;
		}
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public String getWordColumnName() {
		return wordColumnName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	
	public String getName() {
		return name;
	}
}
