package org.LoginWebsiteDatabaseLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class UserDBConnection {



	private Connection getConnection() {

		
		try {
			String url = "jdbc:mysql://localhost:3306/usersdb";
			String username = "root";
			String password = "Password";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to connect to sql");
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class not found");
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(String username, String password) throws SQLException {
		
		Connection connection = getConnection();
		String sql = "INSERT INTO user (username,password) VALUES (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		statement.executeUpdate();

		statement.close();
		connection.close();
	}

	public boolean checkIfPersonExist(String username) throws SQLException {
		// gets all from user table
		
		Connection connection = getConnection();
		String sql = "SELECT * FROM user";
		Statement statement = connection.createStatement();

		ResultSet result = statement.executeQuery(sql);

		
		
		while (result.next()) {

			if (username.equals(result.getString(2))) {
			 
				connection.close();
				return true;
			}
			// String tableUsername = result.getString("username");
			// String tablePassword = result.getString("password");
		}

		connection.close();
		return false;

	}

	public boolean checkIfPasswordIsCorrect(String username, String password) throws SQLException {
		if (!checkIfPersonExist(username)) {
			return false;
		}

		String sql = "SELECT username, password FROM user";
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {

			if (result.getString("username").equals(username) && result.getString("password").equals(password)) {
				connection.close();
				return true;

			}

		}
		
		return false;
	}
}
