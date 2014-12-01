package com.mta.javacourse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Stock;

public class StockDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		Stock s1 = new Stock();
		Stock s2 = new Stock();
		Stock s3 = new Stock();

		Date date1 = new java.util.Date();
		
		date1.setDate(15);
		date1.setMonth(10);
	    date1.setYear(114);
	    date1.setHours(0);
	    date1.setMinutes(0);
	    date1.setSeconds(0);
	    
	    s1.setSymbol ("PIH");
	    s1.setAsk(12.4f);
	    s1.setBid(13.1f);
	    s1.setDate(date1);
	    
	    s2.setSymbol ("AAL");
	    s2.setAsk(5.5F);
	    s2.setBid(5.78f);
	    s2.setDate(date1);
	    
	    s3.setSymbol("CAAS");
	    s3.setAsk(31.5f);
	    s3.setBid(31.2f);
	    s3.setDate(date1);
	    
	    resp.getWriter(). println (" My Stock: <p> ");
	    resp.getWriter(). println (" "+s1.getHtmlDescription()+" <br>");
	    resp.getWriter(). println (" "+s2.getHtmlDescription()+" <br>");
	    resp.getWriter(). println (" "+s3.getHtmlDescription()+" <br>");
	    
	}
}
