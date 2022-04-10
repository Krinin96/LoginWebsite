package org.LoginWebsiteDatabaseLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;



public class UserDBConnection {
	private String url;
	private String username ;
	private String password ;
	
	public UserDBConnection(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	
	public Connection getConnection() {

		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to connect to sql");
			e.printStackTrace();
			
		}
		return null;
	}
	
	public void addUser(String username, String password) throws SQLException {
		String sql = "INSERT INTO user (username,password) VALUES (?,?)";
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);			
		statement.executeUpdate();		
		
		statement.close();
		connection.close();
	}
	
	
	public boolean checkIfPersonExist(String username, String password) throws SQLException {
		//gets all from user table
		String sql = "SELECT * FROM user";
		Connection connection = getConnection();		
		Statement statement = connection.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()) {
			String tableUsername = result.getString("username");
			String tablePassword = result.getString("password");
		}
		
		
		
		connection.close();
	}
}
