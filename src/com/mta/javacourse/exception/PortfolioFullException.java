package com.mta.javacourse.exception;

public class PortfolioFullException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PortfolioFullException(int maxSize) {
		
		super("Can't add any more stocks, you have reached the max size (" +maxSize+ ") of portfolio");
	}

}
