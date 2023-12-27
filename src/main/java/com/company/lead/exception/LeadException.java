package com.company.lead.exception;

import org.springframework.http.HttpStatus;

public class LeadException {

	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	private final String errorCode;

	public LeadException(String message, Throwable throwable, HttpStatus httpStatus, String errorCode) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
