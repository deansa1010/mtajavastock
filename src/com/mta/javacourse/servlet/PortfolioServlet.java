package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;
import com.mta.javacourse.service.PortfolioService;

/**
 * Represents a portfolio servlet
 * @author Dean Sassi
 * @since 2014
 * @date 12/12/14
 */

public class PortfolioServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");

		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio = portfolioService.getPortfolio();
		Stock[] stocks = portfolio.getStock();
		
		//Portfolio portfolio2 = new Portfolio(portfolio);
		
		resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		//portfolio2.setTitle("<h1>Portfolio 2#</h1>");
		//resp.getWriter().println(portfolio2.getHtmlString() + "<br>");
	
		
		//resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		//resp.getWriter().println(portfolio2.getHtmlString() + "<br>");
		
		//portfolio2.getStock()[2].setBid(55.55f);
		//resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		//resp.getWriter().println(portfolio2.getHtmlString() + "<br>");

	}
}
