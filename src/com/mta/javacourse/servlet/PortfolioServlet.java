package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.exception.BlanceException;
import com.mta.javacourse.exception.PortfolioFullException;
import com.mta.javacourse.exception.StockAlreadyExistExeption;
import com.mta.javacourse.exception.StockNotExistException;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioService;

/**
 * Represents a portfolio servlet
 * @author Dean Sassi
 * @since 2014
 * @date 12/12/14
 */
@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");

		PortfolioService portfolioService = new PortfolioService();
		Portfolio portfolio;

		try {
			portfolio = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		} catch (BlanceException e1) {
			resp.getWriter().println(e1.getMessage());
		} catch (PortfolioFullException e2) {
			resp.getWriter().println(e2.getMessage());
		} catch (StockAlreadyExistExeption e3) {
			resp.getWriter().println(e3.getMessage());
		} catch (StockNotExistException e4) {
			resp.getWriter().println(e4.getMessage());
		} catch (Exception e) {
		throw new RuntimeException(e);
		}
	} 
}


//resp.getWriter().println(portfolio.getHtmlString() + "<br>");




