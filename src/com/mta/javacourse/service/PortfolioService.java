package com.mta.javacourse.service;

import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

/**
 * Represents a portfolio service
 * @author Dean Sassi
 * @since 2014
 * @date 12/12/14
 */

public class PortfolioService {
	private Portfolio myPortfolio = new Portfolio();

	/**
	 * Set all the stock variables with the stock class
	 * @return myPortfolio with an array of stocks
	 */
	
	public Portfolio getPortfolio(){
		
		Date date = new java.util.Date();

		Stock s1 = new Stock("PIH", 12.4f, 13.1f, date);
		Stock s2 = new Stock("AAL",5.5f,5.78f,date);
		Stock s3 = new Stock("CAAS",31.5f,31.2f,date);

		
		date.setDate(15);
		date.setMonth(10);
		date.setYear(114);
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		
		myPortfolio.addStock(s1);
		myPortfolio.addStock(s2);
		myPortfolio.addStock(s3);
		
		myPortfolio.setTitle("<h1>Portfolio 1#</h1>");

		return myPortfolio;

	}
}
