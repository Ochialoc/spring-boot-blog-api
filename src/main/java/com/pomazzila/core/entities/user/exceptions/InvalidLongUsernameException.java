package com.pomazzila.core.entities.user.exceptions;

import com.pocmazzila.exceptions.NoStacktraceException;

public class InvalidLongUsernameException extends NoStacktraceException {

	private static final long serialVersionUID = 1L;
	
	public InvalidLongUsernameException() {
	    super("Username must be at most 64 characters long");
	}
}