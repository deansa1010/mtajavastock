package com.mta.javacourse.exception;

public class BlanceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public BlanceException(float balance) {
		
		super("Not enough balance to complete purchase, your balance is" +balance);
	}

}
