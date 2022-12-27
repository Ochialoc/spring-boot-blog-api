package com.pomazzila.core.entities.user;

import java.time.Instant;
import java.util.UUID;

import com.pomazzila.core.entities.user.exceptions.InvalidLongUsernameException;
import com.pomazzila.core.entities.user.exceptions.InvalidNullUsernameException;
import com.pomazzila.core.entities.user.exceptions.InvalidShortUsernameException;

public class User {
	private UUID id;
	private String username;
	private String email;
	private String password;
	private Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;
	
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
	    if (username == null) {
	      throw new InvalidNullUsernameException();
	    }
	    if (username.trim().length() < 3) {
	    	throw new InvalidShortUsernameException();
	    }
	    if (username.trim().length() > 64) {
	    	throw new InvalidLongUsernameException();
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
