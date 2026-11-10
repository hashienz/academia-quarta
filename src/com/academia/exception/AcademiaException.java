package com.academia.exception;

public class AcademiaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public AcademiaException(String message) {
		super(message);
	}

	public AcademiaException(String message, Throwable cause) {
		super(message, cause);
	}
}
