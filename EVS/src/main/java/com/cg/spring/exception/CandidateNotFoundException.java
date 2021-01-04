package com.cg.spring.exception;

public class CandidateNotFoundException extends Exception
{
	private String message;

	public CandidateNotFoundException() {
		this.message = "";
	}

	public CandidateNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "CandidateNotFoundInGivenList [message=" + message + "]";
	}
}
