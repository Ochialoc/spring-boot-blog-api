package com.pomazzila.core.entities.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

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
}
