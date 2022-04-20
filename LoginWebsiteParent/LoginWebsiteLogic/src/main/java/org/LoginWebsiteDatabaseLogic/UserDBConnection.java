package org.LoginWebsiteDatabaseLogic;

import org.LoginWebsiteLogic.User;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class UserDBConnection {

	
	
	public static void main(String[]args) {
		
		User newUser = new User("Steve","Steve123");
		addUserHibernate(newUser);
	}
	
	
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
	
	public static void addUserHibernate(User user) {
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
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
		}

		connection.close();
		return false;

	}

	public boolean checkIfLoginIsCorrect(String username, String password) throws SQLException {
		if (!checkIfPersonExist(username)) {
			return false;
		}

		String sql = "SELECT username, password FROM user";
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(sql);

		while (result.next()) {

			if (username.equals(result.getString(1)) && password.equals(result.getString(2))) {
				connection.close();
				return true;

			}

		}

		return false;
	}
}
