package com.edsonj.eoh.exception;

public class BusinessValidationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5647852161257558741L;

	public BusinessValidationException() {
		super();
	}
	
	public BusinessValidationException(String message) {
		super(message);
	}
	
	public BusinessValidationException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
