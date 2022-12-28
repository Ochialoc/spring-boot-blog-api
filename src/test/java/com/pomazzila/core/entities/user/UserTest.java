package com.pomazzila.core.entities.user;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.pocmazzila.core.entities.user.exceptions.InvalidUserCreationParametersException;

public class UserTest {
	@Test
	void givenValidParams_whenCallNewUser_thenSholdInstantiateAnUser() {
		String username = "Pocmazzila";
		String email = "pocmazzila@gmail.com";
		String password = "password";
		
		User newUser = User.newUser(username, email, password);
		
		assertDoesNotThrow(() -> newUser.validate());
		
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
    
    @Test
    void givenInvalidNullPassword_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = "pocmazzila@gmail.com";
        String password = null;
        String expectedErrorMessage = "Password should not be null";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidShortPassword_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = "pocmazzila@gmail.com";
        String password = "passw";
        String expectedErrorMessage = "Password should not be less than 6 characteres long";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidLongPassword_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = "pocmazzila@gmail.com";
        String password = "A really long password with lots of characters that just keep going";
        String expectedErrorMessage = "Password should not be longer than 64 characters long";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidNullEmail_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = null;
        String password = "password";
        String expectedErrorMessage = "Email should not be null";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidShortEmail_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = "po@co";
        String password = "password";
        String expectedErrorMessage = "Email should not be less than 6 characteres long";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidLongEmail_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = "pocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzilapocmazzil@gmail.com";
        String password = "password";
        String expectedErrorMessage = "Email should not be longer than 128 characters long";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidEmail_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = "pocmazzila";
        String email = "email#invalido.com";
        String password = "password";
        String expectedErrorMessage = "Email is invalid";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenInvalidParams_whenCallNewUserAndValidate_thenSholdThrowInvalidUserCreationParametersExceptionWithCorrectMessage() {
        String username = null;
        String email = null;
        String password = null;
        String expectedErrorMessage = "Username should not be null" + System.lineSeparator() + "Password should not be null"
                + System.lineSeparator() + "Email should not be null";
        
        User newUser = User.newUser(username, email, password);
        
        InvalidUserCreationParametersException exception = assertThrows(
                InvalidUserCreationParametersException.class, 
                () -> newUser.validate()
              );

        assertEquals(expectedErrorMessage, exception.getMessage());
    }
    
    @Test
    void givenMixedListOfValidAndInvalidEmails_whenCallisEmailValid_thenSholdIdentifyIncorrectAndCorrectOnes() {
        String validEmail1 = "pocmazzila@poc.com";
        String validEmail2 = "john.foo+label@somewhere.com";
        String validEmail3 = "john@192.168.1.10";
        String validEmail4 = "john.foo@someserver";
        String validEmail5 = "JOHN.FOO@somewhere.com";
        String invalidEmail1 = "foo#gmail.com";
        String invalidEmail2 = "@someserver";
        String invalidEmail3 = "@someserver.com";
        String invalidEmail4 = "john@.";
        String invalidEmail5 = "foo#gmail.com";
        
        assertTrue(User.isEmailValid(validEmail1));
        assertTrue(User.isEmailValid(validEmail2));
        assertTrue(User.isEmailValid(validEmail3));
        assertTrue(User.isEmailValid(validEmail4));
        assertTrue(User.isEmailValid(validEmail5));
        assertFalse(User.isEmailValid(invalidEmail1));
        assertFalse(User.isEmailValid(invalidEmail2));
        assertFalse(User.isEmailValid(invalidEmail3));
        assertFalse(User.isEmailValid(invalidEmail4));
        assertFalse(User.isEmailValid(invalidEmail5));

        
    }
}
