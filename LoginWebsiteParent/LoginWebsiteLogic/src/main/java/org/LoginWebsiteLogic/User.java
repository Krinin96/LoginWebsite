package org.LoginWebsiteLogic;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String username;
	private String password;
	

	public User(String name, String password) {
		this.username = name;
		this.password = password;

	}

	public String getUserName() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	@Override
	public String toString() {
		return this.username + ", " + this.password;
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
