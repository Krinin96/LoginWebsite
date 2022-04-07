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

	@Override
	public boolean equals(Object t) {
		if (t == this) {
			return true;
		}

		if (!(t instanceof User)) {
			return false;
		}

		if (t instanceof User) {
			if (this.toString().equals(t.toString()))
				
			{
				return true;
			}

		}

		return false;
	}

}
