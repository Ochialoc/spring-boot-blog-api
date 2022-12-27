package com.pomazzila.core.entities.user;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

import com.pomazzila.core.entities.user.exceptions.InvalidUserCreationParametersException;

public class User {
	private UUID id;
	private String username;
	private String email;
	private String password;
	private Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;
	
	private final String NULL_USERNAME_ERROR_MESSAGE = "Username should not be null";
	private final String SHORT_USERNAME_ERROR_MESSAGE = "Username should not be less than 3 characteres long";
	private final String LONG_USERNAME_ERROR_MESSAGE = "Username should not be longer than 64 characters long";
	private final String NULL_PASSWORD_ERROR_MESSAGE = "Password should not be null";
    private final String SHORT_PASSWORD_ERROR_MESSAGE = "Password should not be less than 6 characteres long";
    private final String LONG_PASSWORD_ERROR_MESSAGE = "Password should not be longer than 64 characters long";
	
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
	    if (username == null) {
	        errors.add(NULL_USERNAME_ERROR_MESSAGE);
	    }  else if (username.trim().length() < 3) {
	        errors.add(SHORT_USERNAME_ERROR_MESSAGE);
	    }  else if (username.trim().length() > 64) {
	        errors.add(LONG_USERNAME_ERROR_MESSAGE);
	    }
	    if (password == null) {
            errors.add(NULL_PASSWORD_ERROR_MESSAGE);
        }  else if (password.length() < 6) {
            errors.add(SHORT_PASSWORD_ERROR_MESSAGE);
        }  else if (password.length() > 64) {
            errors.add(LONG_PASSWORD_ERROR_MESSAGE);
        }
	    if(errors.size() > 0) {
	        throw new InvalidUserCreationParametersException(errors);
	    }
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
