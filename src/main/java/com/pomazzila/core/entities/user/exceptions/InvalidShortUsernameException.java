package com.pomazzila.core.entities.user.exceptions;

import com.pocmazzila.exceptions.NoStacktraceException;

public class InvalidShortUsernameException extends NoStacktraceException {

	private static final long serialVersionUID = 1L;
	
	public InvalidShortUsernameException() {
	    super("Username must be at least 3 characters long");
	}
}