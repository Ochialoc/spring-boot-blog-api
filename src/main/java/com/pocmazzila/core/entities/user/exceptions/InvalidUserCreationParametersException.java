package com.pocmazzila.core.entities.user.exceptions;

import java.util.ArrayList;

import com.pocmazzila.exceptions.NoStacktraceException;

public class InvalidUserCreationParametersException extends NoStacktraceException {

	private static final long serialVersionUID = 1L;
	
	public InvalidUserCreationParametersException(ArrayList<String> errors) {
	    super(errorString(errors));
	}
	private static String errorString(ArrayList<String> errors) {
        String errorsString = "";
        for (int i = 0; i < errors.size(); i++) {
            if(i > 0) errorsString += System.lineSeparator();
            errorsString += errors.get(i);
        }
        return errorsString;
    }
	
}