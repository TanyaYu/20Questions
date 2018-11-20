package game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import readlines.ReadLineManager;
import readlines.ReadLineObserver;

public class DatabaseService {
	private Connection connection;
	private static DatabaseService instance = null;
	private DatabaseService() { 
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuestionsDatabase", "root","password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static DatabaseService getInstance() {
		if(instance == null) 
			instance = new DatabaseService();
		return instance;
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
