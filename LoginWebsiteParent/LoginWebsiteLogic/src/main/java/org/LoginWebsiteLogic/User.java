package org.LoginWebsiteLogic;

import java.util.HashMap;

public class User {

	private String name;
	private String password;

	public User(String name, String password) {
		this.name = name;
		this.password = password;

	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.password;
	}

}
