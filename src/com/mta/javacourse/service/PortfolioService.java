package com.mta.javacourse.service;

import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.model.StockStatus;

/**
 * Represents a portfolio service
 * @author Dean Sassi
 * @since 2014
 * @date 12/12/14
 */

public class PortfolioService {
	//private Portfolio myPortfolio = new Portfolio("unknown", new Stock[5], new StockStatus[5],0,0);

	/**
	 * Set all the stock variables with the stock class
	 * @return myPortfolio with an array of stocks
	 */
	
	public Portfolio getPortfolio () throws Exception{

		Portfolio myPortfolio = new Portfolio("unknown", new StockStatus[5],0,0);
		Date date = new java.util.Date();
		myPortfolio.setBalance(10000);

		Stock s1 = new Stock("PIH", 10f, 8.5f, date);
		Stock s2 = new Stock("AAL",30f,25.5f,date);
		Stock s3 = new Stock("CAAS",20f,15.5f,date);
		Stock s4 = new Stock("CAAS",20f,15.5f,date);

		
		date.setDate(15);
		date.setMonth(10);
		date.setYear(114);
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0);
		
		myPortfolio.addStock(s1);
		myPortfolio.addStock(s2);
		myPortfolio.addStock(s3);
		myPortfolio.addStock(s4);
		
		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS", 40);
		
		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");
		
		myPortfolio.setTitle("<h1>Exersice 9 portfolio</h1>");

		return myPortfolio;

	}
}
