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
	private enum ALGO_RECOMANDATION{DO_NOTHING, BUY, SELL};
	private float balance;

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

	public float getBalance1() {
		return balance;
	}

	public void setBalance1(float balance) {
		this.balance = balance;
	}


	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void updateBalance(float  amount){
		balance += amount;
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
	public Portfolio(String title1,Stock[] stocks1,StockStatus[] stockStatus1,int portfolioSize1, float balance){
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
		for(int i = 0; i < portfolioSize; i++){
			if(stocks[i].getSymbol() == stock.getSymbol())
				System.out.println("This stock already exist in portfolio");

			else
			{
				if (portfolioSize < MAX_PORTFOLIO_SIZE ){
					stocks[portfolioSize] = stock;
					stockStatus[portfolioSize].setCurrentAsk(stock.getAsk()); 
					stockStatus[portfolioSize].setCurrentBid(stock.getBid());
					stockStatus[portfolioSize].setSymbol(stock.getSymbol());
					stockStatus[portfolioSize].setDate(stock.getDate());
					stockStatus[portfolioSize].setRecommendation(ALGO_RECOMANDATION.DO_NOTHING);
					stockStatus[portfolioSize].setStockQuantity(0);
					portfolioSize++;
				}
				else System.out.println("Can’t add new stock, portfolio can have only "+portfolioSize+" stocks");
			}
		}
	}

			/**
			 * Remove stock from the stock array
			 * Delete the stock and puts the next in its  place
			 * @param index
			 */

			public boolean removeStock(String symbol){

				for(int index = 0; index < portfolioSize; index++){

					if(this.stocks[index].getSymbol() == symbol){
						this.portfolioSize--;
						sellStock(stocks[index].getSymbol(), stockStatus[index].getStockQuantity());
					}

					for(int i = index; i <= portfolioSize-1; i++)
					{
						this.stocks[i] = this.stocks[i+1];
						this.stockStatus[i] = this.stockStatus[i+1];

					}
					if(index == portfolioSize){
						this.portfolioSize--;
					return true;
					}
				}
				return false;
			}

			public boolean sellStock(String symbol, int quantity){

				for(int i = 0; i < portfolioSize; i++)

					if(this.stocks[i].getSymbol() == symbol){
						if(quantity == -1){
							this.updateBalance(this.stockStatus[i].getCurrentBid() * this.stockStatus[i].getStockQuantity());
							this.stockStatus[i].stockQuantity = 0;
						}
						else if(quantity > this.stockStatus[i].stockQuantity)
							System.out.println("Not enough stocks to sell");
						else if(quantity < -1)
							System.out.println("Negative stock quantity is not an option"); 
						else if (quantity > 0){
							this.updateBalance(this.stockStatus[i].getCurrentBid() * quantity);
							this.stockStatus[i].stockQuantity -= quantity;
						}
						return true;	
					}

				return false;	

			}

			public boolean buyStock(String symbol, int quantity){

				for(int i = 0; i < portfolioSize; i++)

					if(this.stocks[i].getSymbol() == symbol){

						if(quantity == -1){
							this.updateBalance(-(this.stockStatus[i].getCurrentAsk() * this.stockStatus[i].getStockQuantity()));
							this.stockStatus[i].stockQuantity += quantity;
						}
						else if(balance < quantity * this.stockStatus[i].getCurrentAsk())
							System.out.println("Not enough balance to complete purchase");
						else if (quantity > 0){
							this.updateBalance(-(this.stockStatus[i].getCurrentAsk() * quantity));
							this.stockStatus[i].stockQuantity += quantity;
						}
						else
							System.out.println("Negative stock quantity is not an option");

						return true;	
					}

				return false;		

			}

			public float getStocksValue(Stock stock[]){

				float totalStockValue = 0;

				for(int i = 0; i < portfolioSize; i++)
					totalStockValue += stockStatus[i].getCurrentBid() * stockStatus[i].stockQuantity;

				return totalStockValue;
			}

			public float getTotalValue(Stock stock[]){

				float portfolioValue = getBalance() + getStocksValue(stock);
				return portfolioValue;
			}

			/**
			 * @return the getHtmlString
			 */

			public String getHtmlString(){

				String getHtmlString = getTitle();

				getHtmlString+= "<b>Total Portfolio Value: </b>" +getTotalValue(stocks)+"<b>$, Total stock value:</b>" +getStocksValue(stocks)+"<b>$, Balance:</b>" +getBalance()+"$";

				for (int i = 0; i < portfolioSize; i++)
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

				private String symbol;
				private float currentBid;
				private float currentAsk;
				private Date date;
				private ALGO_RECOMANDATION recommendation;
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
						this.date = new Date(stockStatus.date.getTime());
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

				public ALGO_RECOMANDATION getRecommendation() {
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

				public void setRecommendation(ALGO_RECOMANDATION recommendation) {
					this.recommendation = recommendation;
				}

				public void setStockQuantity(int stockQuantity) {
					this.stockQuantity = stockQuantity;
				}		

			}

		}
