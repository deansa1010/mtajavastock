package com.mta.javacourse.exception;

public class StockAlreadyExistExeption extends Exception{
	
	private static final long serialVersionUID = 1L;

	public StockAlreadyExistExeption(String symbol) {
	
			super("Sorry, Stock " +symbol+ " already exist in portfolio");
	}

}
