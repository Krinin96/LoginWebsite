package org.LoginWebsiteLogic;



import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Users")
public class User implements Serializable {

	@Id	
	private String username;	
	private String password;
	//not used in front yet	
	
	
	//@Transient a way to not store into database but use elsewhere
	

	public User(String name, String password) {
		this.username = name;
		this.password = password;

	}
	
	public User() {
		
	}

	public String getUserName() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
			User newUser = (User)t;
			
			if(this.username.equals(newUser.getUserName()) &&
					this.password.equals(newUser.getPassword())) {
				return true;
			}

		}

		return false;
	}

}
