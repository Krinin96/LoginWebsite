package org.LoginWebsiteDatabaseLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/usersdb";
		String username = "root";
		String password = "Password";
		
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.print("connected");
			String sql = "INSERT INTO user (username,password) VALUES (?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "MAltizer");
			statement.setString(2, "password");			
			statement.executeUpdate();
			
			
			statement.close();
			connection.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.print("failed to connect ");
			System.out.print(e);
		}

	}

}
