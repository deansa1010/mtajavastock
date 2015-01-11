package com.mta.javacourse.model;

import java.util.Date;

import com.mta.javacourse.model.Portfolio.ALGO_RECOMANDATION;

public class StockStatus extends Stock {
	
	private ALGO_RECOMANDATION recommendation;
	private int stockQuantity;
	
	/**
	 * create new stockstatus
	 */

	public StockStatus(String stockSymbol1, float ask1, float bid1,
			java.util.Date date1, int newStockQuantity, ALGO_RECOMANDATION recom ) {
		super(stockSymbol1, ask1, bid1, date1);
		// TODO Auto-generated constructor stub
		setStockQuantity(newStockQuantity);
		setRecommendation(recom);
	}
	
	/**
	 * copy c'tor
	 * @return
	 */
	
	public StockStatus(StockStatus stockStatus){
		this(stockStatus.getSymbol(),stockStatus.getAsk(),stockStatus.getBid(),
				new Date(stockStatus.getDate().getTime()), stockStatus.getStockQuantity(), stockStatus.getRecommendation());
	}
	public ALGO_RECOMANDATION getRecommendation() {
		return recommendation;
	}
	public void setRecommendation(ALGO_RECOMANDATION recommendation) {
		this.recommendation = recommendation;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}


}
