package game;

import static game.Constants.FOOD_QUESTIONS;
import static game.Constants.STATE_QUESTIONS;
import static game.Constants.ANIMAL_QUESTIONS;
import static game.Constants.THINGS_QUESTIONS;

public class Category {

	private int categoryId;
	private String tableName;
	private String wordColumnName;
	private String name;
	private String[] questions;

	private Category() {
	}

	private Category(int categoryId, String name, String tableName, String wordColumnName, String[] questions) {
		this.categoryId = categoryId;
		this.tableName = tableName;
		this.wordColumnName = wordColumnName;
		this.name = name;
		this.questions = questions;
	}

	public static Category getById(int id) {
		switch (id) {
		case 1:
			return new Category(id, "Food", "foodtable", "foodname", FOOD_QUESTIONS);
		case 2:
			return new Category(id, "States", "statestable", "statename", STATE_QUESTIONS);
		case 3:
			return new Category(id, "Animals", "animalstable", "animalname", ANIMAL_QUESTIONS);
		case 4:
			return new Category(id, "Things", "thingstable", "ThingName", THINGS_QUESTIONS);
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
	
	public String[] getQuestions() {
		return questions;
	}
}
