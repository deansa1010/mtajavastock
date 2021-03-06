package com.mta.javacourse.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;





import com.mta.javacourse.exception.BlanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistExeption;
import com.mta.javacourse.exception.StockNotExistException;

/**
 * An instance of this class represents a portfoilio of stocks.
 * @author Dean Sassi
 * @since 2014
 * date 12/12/14
 */

public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private StockStatus[] stockStatus = new StockStatus[MAX_PORTFOLIO_SIZE];
	//List<StockStatus> stockStatus2 = new ArrayList<StockStatus>(MAX_PORTFOLIO_SIZE);
	private int portfolioSize = 0;
	private String title;
	public enum ALGO_RECOMANDATION{DO_NOTHING, BUY, SELL};
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

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public StockStatus[] getStocksStatus() {
		return stockStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stockStatus = stocksStatus;
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
	public Portfolio(String title1,StockStatus[] stockStatus2,int portfolioSize1, float balance1)
	{

		stockStatus = stockStatus2;
		title = title1;
		portfolioSize = portfolioSize1;
		balance = balance1;
	}



	/**
	 * Copy c'tor
	 * @param portfolio
	 */
	public Portfolio(Portfolio portfolio){
		this("unknown", new StockStatus[MAX_PORTFOLIO_SIZE],0,0);
		this.title = portfolio.getTitle();
		this.portfolioSize = portfolio.portfolioSize;

		for(int i = 0; i < portfolio.portfolioSize ; i++){
			stockStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
		}
	}

	/**
	 * Add stock to the stocks array
	 * portfolioSize is a counter for how many stocks in the array
	 * The size limit for this array is MAX_PORTFOLIO_SIZE
	 * @param stock
	 * @throws Exception 
	 */

	public void addStock (Stock stock) throws Exception{
		for(int i = 0; i < portfolioSize; i++){
			if(this.stockStatus[i].getSymbol() == stock.getSymbol()){
				System.out.println("This stock already exist in portfolio");
				throw new StockAlreadyExistExeption(stock.getSymbol());
			}
		}

		if (portfolioSize < MAX_PORTFOLIO_SIZE ){
			{
				stockStatus[portfolioSize] = new StockStatus(stock.getSymbol(),stock.getAsk(),stock.getBid(),stock.getDate(),0,ALGO_RECOMANDATION.DO_NOTHING);
				portfolioSize++;
			}
		}
		else {
			System.out.println("Can�t add new stock, portfolio can have only "+portfolioSize+" stocks");
			throw new PortfolioFullException(getPortfolioSize());
		}
	}



	/**
	 * Remove stock from the stock array
	 * Delete the stock and puts the next in its  place
	 * @param index
	 * @throws Exception 
	 */

	public void removeStock(String symbol) throws Exception{

		for(int index = 0; index <= portfolioSize; index++){

			if(this.stockStatus[index].getSymbol() == symbol){
				sellStock(stockStatus[index].getSymbol(), stockStatus[index].getStockQuantity());
				this.portfolioSize--;
				for(int i = index; i <= portfolioSize-1; i++)

					this.stockStatus[i] = this.stockStatus[i+1];	

			}
		}
		throw new StockNotExistException(symbol);
	}

	/**
	 * sell stocks
	 * @param symbol
	 * @param quantity
	 * @return
	 */
	public void sellStock(String symbol, int quantity){

		for(int i = 0; i < portfolioSize; i++)

			if(this.stockStatus[i].getSymbol() == symbol){
				if(quantity == -1){
					this.updateBalance(this.stockStatus[i].getBid() * this.stockStatus[i].getStockQuantity());
					this.stockStatus[i].setStockQuantity(0);
				}
				else if(quantity > this.stockStatus[i].getStockQuantity())
					System.out.println("Not enough stocks to sell");
				else if(quantity < -1)
					System.out.println("Negative stock quantity is not an option"); 
				else if (quantity > 0){
					this.updateBalance(this.stockStatus[i].getBid() * quantity);
					this.stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity() - quantity );
				}

			}	

	}

	/**
	 * buy stocks
	 * @param symbol
	 * @param quantity
	 * @return
	 * @throws Exception 
	 */
	public void buyStock(String symbol, int quantity) throws Exception{

		for(int i = 0; i < portfolioSize; i++)

			if(this.stockStatus[i].getSymbol() == symbol){

				if(quantity == -1){
					this.updateBalance(-(this.stockStatus[i].getAsk() * this.stockStatus[i].getStockQuantity()));
					this.stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity() - quantity);
				}
				else if(balance < quantity * this.stockStatus[i].getAsk()){
					System.out.println("Not enough balance to complete purchase");
					throw new BlanceException(getBalance());
				}
				else if (quantity > 0){
					this.updateBalance(-(this.stockStatus[i].getAsk() * quantity));
					this.stockStatus[i].setStockQuantity(stockStatus[i].getStockQuantity() + quantity);
				}
				else
					System.out.println("Negative stock quantity is not an option");

			}		

	}

	/**
	 * gets the stocks value
	 * @param stock
	 * @return
	 */
	public float getStocksValue(Stock stock[]){

		float totalStockValue = 0;

		for(int i = 0; i < portfolioSize; i++)
			totalStockValue += stockStatus[i].getBid() * stockStatus[i].getStockQuantity();

		return totalStockValue;
	}
	/**
	 * get the total value of portfolio
	 * @param stock
	 * @return
	 */
	public float getTotalValue(Stock stock[]){

		float portfolioValue = getBalance() + getStocksValue(stock);
		return portfolioValue;
	}

	/**
	 * print 
	 * @return the getHtmlString
	 */

	public String getHtmlString(){

		String getHtmlString = getTitle();

		getHtmlString+= "<b>Total Portfolio Value: </b>" +getTotalValue(stockStatus)+"<b>$, Total stock value:</b>" +getStocksValue(stockStatus)+"<b>$, Balance:</b>" +getBalance()+"$<br><br>";

		for (int i = 0; i < portfolioSize; i++)
			getHtmlString += stockStatus[i].getHtmlDescription()+"<br>";

		return getHtmlString;	
	}
}


