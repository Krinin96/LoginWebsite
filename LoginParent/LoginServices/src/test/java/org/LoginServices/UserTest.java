package org.LoginServices;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.LoginServices.User;

public class UserTest {

	@Test
	public void UserCreatedNameTest() {
		User user = new User("Tom", "Tom123");

		assertEquals("Tom", user.getUsername());
	}

	@Test
	public void UserCreatedPasswordTest() {
		User user = new User("Tom", "Tom123");
		assertEquals("Tom123", user.getPassword());

	}

	@Test
	public void UserLoggedInTest() {
		User user = new User("Tom", "Tom123");
		user.loggedIn();
		assertEquals(1, user.numberOfTimesLoggedIn());
	}
}
