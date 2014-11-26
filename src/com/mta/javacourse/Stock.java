package com.mta.javacourse;

public class Stock {

	private float Bid;
	private float Ask;
	private String Symbol;
	
	private java.util.Date Date;

	public float getBid() {
		return Bid;
	}

	public void setBid(float bid) {
		Bid = bid;
	}

	public float getAsk() {
		return Ask;
	}

	public void setAsk(float ask) {
		Ask = ask;
	}

	public String getSymbol() {
		return Symbol;
	}

	public void setSymbol(String symbol) {
		Symbol = symbol;
	}

	public java.util.Date getDate() {
		return Date;
	}

	public void setDate(java.util.Date date) {
		Date = date;
	}
	
	public String getHtmlDescription() {
		
		String stockHtmlDetailsString = "<b>Stock Symbol</b>: "+getSymbol()+", <b>Ask</b> : "+getAsk()+", <b>Bid</b>: "+getBid()+", <b>Date</b> : "+Date;
		return stockHtmlDetailsString;
	
	}
}

