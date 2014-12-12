package com.mta.javacourse.model;

import java.util.Date;

/**
* An instance of this class represents a portfoilio of stocks.
* @author Dean Sassi
* @since 2014
* date 12/12/14
*/

public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private StockStatus[] stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	private int portfolioSize = 0;
	private String title;
	
	//Getters and setters
	
	public String getTitle() {
		return title;
	}
	
	public int getPortfolioSize(){
		return portfolioSize = 0;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	
	public StockStatus[] getStocksStatus() {
		return stockStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stockStatus = stocksStatus;
	}
	
	public Stock[] getStock(){
		return stocks;
	}
	
	/**
	 * Constructor
	 */
	public Portfolio()
	{
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	}
	
	/**
	 * Constructor
	 * @param title1
	 * @param stocks1
	 * @param stockStatus1
	 * @param portfolioSize1
	 */
	public Portfolio(String title1,Stock[] stocks1,StockStatus[] stockStatus1,int portfolioSize1){
		setTitle(title1);
		setStocks(stocks1);
		setStocksStatus(stockStatus1);
		setPortfolioSize(portfolioSize1);
	}
	
	/**
	 * Copy c'tor
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio){
		this();
		this.title = portfolio.getTitle();
		this.portfolioSize = portfolio.portfolioSize;
		
		for(int i = 0; i < portfolio.portfolioSize ; i++){
			stocks[i] = new Stock(portfolio.getStock()[i]);
			stockStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
		}
	}
	
	/**
	 * Add stock to the stocks array
	 * portfolioSize is a counter for how many stocks in the array
	 * The size limit for this array is MAX_PORTFOLIO_SIZE
	 * @param stock
	 */
	
	public void addStock (Stock stock){

		if (portfolioSize < MAX_PORTFOLIO_SIZE )
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
	}
	
	/**
	 * Remove stock from the stock array
	 * Delete the stock and puts the next in its  place
	 * @param index
	 */
	
	public void removeStock(int index){
		if(index == portfolioSize)
			this.portfolioSize--;
		else 
		{
			this.portfolioSize--;
			for(int i = index; i <= portfolioSize-1; i++)
			{
				this.stocks[i] = this.stocks[i+1];
			}
		}
	}
	
	private int i;
	
	/**
	 * @return the getHtmlString
	 */
	
	public String getHtmlString(){

		String getHtmlString = getTitle();
		for (i = 0; i < portfolioSize; i++)
			getHtmlString += stocks[i].getHtmlDescription()+"<br>";

		return getHtmlString;	
	}
	
	/**
	 * Represnts the stocks status
	 * @author Dean Sassi
	 * @since 2014
	 * @date 12/12/14
	 *
	 */
	
	public class StockStatus{

		private final static int DO_NOTHING = 0;
		private final static int BUY = 1;
		private final static int SELL = 2;

		private String symbol;
		private float currentBid;
		private float currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;
		
		/**
		 * Copy c'tor
		 */
		
		public StockStatus(){
			
		}
		
		/**
		 * Constructor
		 * @param stockStatus
		 */
		
		public StockStatus(StockStatus stockStatus){
			if(this.symbol != null)
			{
				this.symbol = stockStatus.symbol;
				this.currentAsk = stockStatus.currentAsk;
				this.currentAsk = stockStatus.currentBid;
				this.date = stockStatus.date;
				this.recommendation = stockStatus.recommendation;
				this.stockQuantity = stockStatus.stockQuantity;
			}
		}
		
		// Getters and setters
		
		public String getSymbol() {
			return symbol;
		}
		
		public float getCurrentBid() {
			return currentBid;
		}
		
		public float getCurrentAsk() {
			return currentAsk;
		}
		
		public Date getDate() {
			return date;
		}
		
		public int getRecommendation() {
			return recommendation;
		}
		
		public int getStockQuantity() {
			return stockQuantity;
		}
		
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
	
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		
		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}		

	}

}
