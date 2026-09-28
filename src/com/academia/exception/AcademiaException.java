package com.academia.exception;

public class AcademiaException extends RuntimeException {

	public AcademiaException(String message) {
		super(message);
	}

	public AcademiaException(String message, Throwable cause) {
		super(message, cause);
	}
}
