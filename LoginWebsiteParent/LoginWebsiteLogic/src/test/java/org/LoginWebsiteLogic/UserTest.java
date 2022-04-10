package org.LoginWebsiteLogic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {

	@Test
	public void UserNameTest() {
		User user = new User("Tom","Tom123");		
		assertEquals("Tom",user.getName());
	}
	@Test
	public void UserPasswordTest() {
		User user = new User("Tom","Tom123");
		assertEquals("Tom123",user.getPassword());
	}
	@Test
	public void UserToStringTest() {
		User user = new User("Tom", "Tom123");
		assertEquals("Tom, Tom123", user.toString());
	}
	
}
