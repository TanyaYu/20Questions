package game;

import java.sql.*;
public class DatabaseService {	
	private String databaseName = "QuestionsDatabase";
	private String userName = "root";
	private String password = "password";
	private String connectionStirng = String
			.format("jdbc:mysql://localhost:3306/%s?serverTimezone=UTC&autoReconnect=true&useSSL=false", databaseName);

	private Connection connection;
	private static DatabaseService instance = null;
	private Answer[] answers = new Answer[20];

	private DatabaseService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(connectionStirng, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseService getInstance() {
		if (instance == null)
			instance = new DatabaseService();
		return instance;
	}

	public void postAnswer(int questionNumber, Answer answer) {
		answers[questionNumber - 1] = answer;
	}

	public void clearAnswers() {
		answers = new Answer[20];
	}

	public void testdata() {
		Statement stmt;
		try {
			stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("select * from StatesTable");
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getQuestion(int catagoryId, int questionNumber) {

		switch (catagoryId) {
		case 1:
			return Constants.FOOD_QUESTIONS[questionNumber - 1];
		case 2:
			return Constants.STATE_QUESTIONS[questionNumber - 1];
		case 3:
			return Constants.ANIMAL_QUESTIONS[questionNumber - 1];
		case 4:
			return Constants.THINGS_QUESTIONS[questionNumber - 1];
		}
		return null;
	}
	
	
	
	public void insertCorrectAnswer(String actualAnswer, int categoryId) {
		String query = " ";
		
		switch (categoryId) {
		case 1:
			query = " insert into FoodTable (foodname, Question_1, Question_2 , Question_3, Question_4, Question_5, Question_6, Question_7, Question_8, Question_9, Question_10, Question_11, Question_12, Question_13, Question_14, Question_15, Question_16, Question_17, Question_18, Question_19, Question_20)"
					+ " values = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			break;
		case 2:
			query = " insert into StatesTable (statename, Question_1, Question_2 , Question_3, Question_4, Question_5, Question_6, Question_7, Question_8, Question_9, Question_10, Question_11, Question_12, Question_13, Question_14, Question_15, Question_16, Question_17, Question_18, Question_19, Question_20)"
					+ " values = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			break;
		case 3:
			query = " insert into AnimalsTable (animalname, Question_1, Question_2 , Question_3, Question_4, Question_5, Question_6, Question_7, Question_8, Question_9, Question_10, Question_11, Question_12, Question_13, Question_14, Question_15, Question_16, Question_17, Question_18, Question_19, Question_20)"
					+ " values = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			break;
		case 4:
			query = " insert into ThingsTable (ThingName, Question_1, Question_2 , Question_3, Question_4, Question_5, Question_6, Question_7, Question_8, Question_9, Question_10, Question_11, Question_12, Question_13, Question_14, Question_15, Question_16, Question_17, Question_18, Question_19, Question_20)"
					+ " values = (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			break;
		
		}	
		
		
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			
			// String checkwordQuery = 'Select' + OnUnrecoginizedCommandEvent.getCommand() + 'from' + 
			
			// if (OnUnrecognizedCommandEvent.getCommand() == )
			
			
			preparedStmt.setString(1, actualAnswer);
			int i = 2;
			
			for (Answer x: answers) {
				preparedStmt.setString(i, x.getChar());
				i = i + 1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public String guessWord(int categoryId) {
		Statement stmt;
		try {
			stmt = connection.createStatement();
			String query = getGuessWordQuery(Category.getById(categoryId));
			ResultSet rs = stmt.executeQuery(query);
			String word = null;
			while (rs.next()) {
				if (word == null)
					word = rs.getString(1);
				System.out.println(rs.getString(1) + "  " + rs.getDouble(2) * 100 + "%");
			}
			connection.close();
			return word;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getGuessWordQuery(Category category) {
		String matchPercent = "(";
		for (int i = 0; i < answers.length; i++) {
			String symbol = answers[i].getChar();
			matchPercent += String.format("GetWordPoint(Question_%d, '%s') + ", i + 1, symbol);
		}
		matchPercent += "0)/" + answers.length;
		return String.format("select %s, %s as match_percent from %s order by match_percent desc limit 3", 
				category.getWordColumnName(),
				matchPercent,
				category.getTableName());
	}
}
