package com.pomazzila.core.entities.user.exceptions;

import com.pocmazzila.exceptions.NoStacktraceException;

public class InvalidNullUsernameException extends NoStacktraceException {

	private static final long serialVersionUID = 1L;
	
	public InvalidNullUsernameException() {
	    super("Username must not be null");
	}
}