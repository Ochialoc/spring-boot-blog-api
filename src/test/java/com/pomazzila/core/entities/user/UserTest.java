package com.pomazzila.core.entities.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.pomazzila.core.entities.user.exceptions.InvalidLongUsernameException;
import com.pomazzila.core.entities.user.exceptions.InvalidNullUsernameException;
import com.pomazzila.core.entities.user.exceptions.InvalidShortUsernameException;

public class UserTest {
	@Test
	void givenValidParams_whenCallNewUser_thenSholdInstantiateAnUser() {
		String username = "Pocmazzila";
		String email = "pocmazzila@gmail.com";
		String password = "password";
		
		User newUser = User.newUser(username, email, password);
		
		assertEquals(newUser.getUsername(), username);
		assertEquals(newUser.getEmail(), email);
		assertEquals(newUser.getPassword(), password);
		assertNotNull(newUser.getId());
		assertNotNull(newUser.getCreatedAt());
		assertNotNull(newUser.getUpdatedAt());
		assertNull(newUser.getDeletedAt());
	}
	
	@Test
	void givenInvalidNullUsername_whenCallNewUser_thenSholdThrowInvalidUsernameNullException() {
		String username = null;
		String email = "pocmazzila@gmail.com";
		String password = "password";
		
		User newUser = User.newUser(username, email, password);
		
		assertThrows(InvalidNullUsernameException.class, () -> newUser.validate());
	}
	
	@Test
	void givenInvalidShortUsername_whenCallNewUser_thenSholdThrowInvalidShortUsernameException() {
		String username = " a ";
		String email = "pocmazzila@gmail.com";
		String password = "password";
		
		User newUser = User.newUser(username, email, password);
		
		assertThrows(InvalidShortUsernameException.class, () -> newUser.validate());
	}
	
	@Test
	void givenInvalidLongUsername_whenCallNewUser_thenSholdThrowInvalidLongUsernameException() {
		String username = "A really long name with lots of characters that just keep going on";
		String email = "pocmazzila@gmail.com";
		String password = "password";
		
		User newUser = User.newUser(username, email, password);
		
		assertThrows(InvalidLongUsernameException.class, () -> newUser.validate());
	}
}
