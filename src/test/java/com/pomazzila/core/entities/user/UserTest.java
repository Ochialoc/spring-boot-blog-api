package com.pomazzila.core.entities.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.pomazzila.core.entities.user.exceptions.InvalidUserCreationParametersException;

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
	void givenInvalidNullUsername_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
		String username = null;
		String email = "pocmazzila@gmail.com";
		String password = "password";
		String expectedErrorMessage = "Username should not be null";
		
		User newUser = User.newUser(username, email, password);
		
		InvalidUserCreationParametersException exception = assertThrows(
		        InvalidUserCreationParametersException.class, 
		        () -> newUser.validate()
		      );

		assertEquals(expectedErrorMessage, exception.getMessage());
	}
	
	@Test
	void givenInvalidShortUsername_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
		String username = " a ";
		String email = "pocmazzila@gmail.com";
		String password = "password";
		String expectedErrorMessage = "Username should not be less than 3 characteres long";
		
		User newUser = User.newUser(username, email, password);
		
		InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
	}
	
	@Test
	void givenInvalidLongUsername_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
		String username = "A really long name with lots of characters that just keep going on";
		String email = "pocmazzila@gmail.com";
		String password = "password";
		String expectedErrorMessage = "Username should not be longer than 64 characters long";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
	}
}
