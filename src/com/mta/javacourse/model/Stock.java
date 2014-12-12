package com.mta.javacourse.model;

import java.util.Date;

/**
 * Represents a stock 
 * @author Dean Sassi
 * @since 2014
 * @date 12/12/14
 */

public class Stock {

	private float Bid;
	private float Ask;
	private String Symbol;
	private Date Date;
	
	/**
	 * Constructor
	 * @param stockSymbol1
	 * @param ask1
	 * @param bid1
	 * @param date1
	 */
	
	public Stock(String stockSymbol1, float ask1, float bid1, Date date1) {
		if(stockSymbol1 != null)
		{
			setSymbol(stockSymbol1);
			setAsk(ask1);
			setBid(bid1);
			setDate(date1);
		}
	}
	
	/**
	 * Copy c'tor
	 * @param stock
	 */
	
	public Stock(Stock stock){
		this (stock.getSymbol(),stock.getAsk(),stock.getBid(),stock.getDate());
	}
	
	//Getters and setters
	
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

	/**
	 * Returns the stocks description
	 * @return the getHtmlDescription
	 */
	
	public String getHtmlDescription() {

		String stockHtmlDetailsString = "<b>Stock Symbol</b>: "+getSymbol()+", <b>Ask</b> : "+getAsk()+", <b>Bid</b>: "+getBid()+", <b>Date</b> : "+Date;
		return stockHtmlDetailsString;

	}
}

