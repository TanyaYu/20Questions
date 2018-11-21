package game;

import java.sql.*;
import answer.Answer;

public class DatabaseService {
	private String databaseName = "QuestionsDatabase";
	private String userName = "root";
	private String password = "admin";
	private String connectionStirng = String.format("jdbc:mysql://localhost:3306/%s?serverTimezone=UTC&autoReconnect=true&useSSL=false", databaseName);
	
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
		if(instance == null) 
			instance = new DatabaseService();
		return instance;
	}
	
	public void postAnswer(int questionNumber, Answer answer) {
		answers[questionNumber-1] = answer;
	}
	
	public void clearAnswers() {
		answers = new Answer[20];
	}
	
	public void testdata() {
		Statement stmt;
		try {
			stmt = connection.createStatement();
		
		ResultSet rs=stmt.executeQuery("select * from StatesTable");  
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		connection.close();  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
}
