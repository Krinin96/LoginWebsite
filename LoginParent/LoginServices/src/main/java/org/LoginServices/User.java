package org.LoginServices;

public class User {

	private String username;
	private String password;
	private int loggedInTimes;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		loggedInTimes = 0;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int numberOfTimesLoggedIn() {
		return loggedInTimes;
	}

	public void loggedIn() {
		loggedInTimes++;
	}

}
