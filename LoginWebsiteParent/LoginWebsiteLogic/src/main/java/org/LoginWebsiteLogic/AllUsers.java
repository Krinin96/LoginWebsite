package org.LoginWebsiteLogic;


import java.util.ArrayList;

public class AllUsers {

	private ArrayList<User> users;
	public AllUsers() {
		users = new ArrayList<User>();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void removeUser(User user) {
		for(int i=0; i < users.size(); i++) {
			if(user.equals(users.get(i))) {
				users.remove(i);
			}
		}
	}
}
