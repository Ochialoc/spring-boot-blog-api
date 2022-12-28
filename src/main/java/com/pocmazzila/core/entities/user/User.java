package com.pocmazzila.core.entities.user;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;

import com.pocmazzila.core.entities.user.exceptions.InvalidUserCreationParametersException;

public class User {
	private UUID id;
	private String username;
	private String email;
	private String password;
	private Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;
	
	private final static int MINIMUM_USERNAME_LENGTH = 3;
    private final static int MAXIMUM_USERNAME_LENGTH = 64;
    private final static int MINIMUM_PASSWORD_LENGTH = 6;
    private final static int MAXIMUM_PASSWORD_LENGTH = 64;
    private final static int MINIMUM_EMAIL_LENGTH = 6;
    private final static int MAXIMUM_EMAIL_LENGTH = 128;
	
	private final static String NULL_USERNAME_ERROR_MESSAGE = "Username should not be null";
	private final static String SHORT_USERNAME_ERROR_MESSAGE = "Username should not be less than " + String.valueOf(MINIMUM_USERNAME_LENGTH) + " characteres long";
	private final static String LONG_USERNAME_ERROR_MESSAGE = "Username should not be longer than " + String.valueOf(MAXIMUM_USERNAME_LENGTH) + " characters long";
	private final static String NULL_PASSWORD_ERROR_MESSAGE = "Password should not be null";
    private final static String SHORT_PASSWORD_ERROR_MESSAGE = "Password should not be less than " + String.valueOf(MINIMUM_PASSWORD_LENGTH) + " characteres long";
    private final static String LONG_PASSWORD_ERROR_MESSAGE = "Password should not be longer than " + String.valueOf(MAXIMUM_PASSWORD_LENGTH) +" characters long";
    private final static String NULL_EMAIL_ERROR_MESSAGE = "Email should not be null";
    private final static String SHORT_EMAIL_ERROR_MESSAGE = "Email should not be less than " + String.valueOf(MINIMUM_EMAIL_LENGTH) + " characteres long";
    private final static String LONG_EMAIL_ERROR_MESSAGE = "Email should not be longer than " + String.valueOf(MAXIMUM_EMAIL_LENGTH) + " characters long";
    private final static String INVALID_EMAIL_ERROR_MESSAGE = "Email is invalid";
    
    
	private User(
            final UUID id,
            final String username,
            final String email,
            final String password,
            final Instant creationAt,
            final Instant updatedAt,
            final Instant deleteAt
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = creationAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deleteAt;
    }
	
	public static User newUser(final String username, final String email, final String password) {
        final var id = UUID.randomUUID();
        final var now = Instant.now();
        return new User(id, username, email, password, now, now, null);
    }
	
	public void validate() {
		ArrayList <String> errors = new ArrayList<String>();
		
		String usernameError = validateUsername(username);
		if (usernameError != null) errors.add(usernameError);
		
		String passwordError = validatePassword(password);
		if (passwordError != null) errors.add(passwordError);
		
		String emailError = validateEmail(email);
        if (emailError != null) errors.add(emailError);
		
	    if(errors.size() > 0) {
	        throw new InvalidUserCreationParametersException(errors);
	    }
	  }
	private static String validateUsername(final String username) {
	    String error = null;
	    if (username == null) {
	        error = NULL_USERNAME_ERROR_MESSAGE;
        }  else if (username.trim().length() < MINIMUM_USERNAME_LENGTH) {
            error = SHORT_USERNAME_ERROR_MESSAGE;
        }  else if (username.trim().length() > MAXIMUM_USERNAME_LENGTH) {
            error = LONG_USERNAME_ERROR_MESSAGE;
        }
	    return error;
	}
	private static String validatePassword(final String password) {
        String error = null;
        if (password == null) {
            error = NULL_PASSWORD_ERROR_MESSAGE;
        }  else if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            error = SHORT_PASSWORD_ERROR_MESSAGE;
        }  else if (password.length() > MAXIMUM_PASSWORD_LENGTH) {
            error = LONG_PASSWORD_ERROR_MESSAGE;
        }
        return error;
    }
	private static String validateEmail(final String email) {
        String error = null;
        if (email == null) {
            error = NULL_EMAIL_ERROR_MESSAGE;
        }  else if (email.length() < MINIMUM_EMAIL_LENGTH) {
            error = SHORT_EMAIL_ERROR_MESSAGE;
        }  else if (email.length() > MAXIMUM_EMAIL_LENGTH) {
            error = LONG_EMAIL_ERROR_MESSAGE;
        } else if (!isEmailValid(email)) {
            error = INVALID_EMAIL_ERROR_MESSAGE;
        }
        return error;
    }
	
	public static boolean isEmailValid (final String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	    
	}

	public String getId() {
		return id.toString().toLowerCase();
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}
	
}
