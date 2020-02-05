package edu.ycp.cs320.lab02a_alouderback.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Index Servlet: doGet");
		
		String page = req.getParameter("loadPage");
		System.out.println(page);
		if(page != null) {
			if(page.equals("Add Numbers")) {
				req.getRequestDispatcher("/_view/addNumbers.jsp").forward(req, resp);
			} else if (page.equals("Multiply Numbers")) {
				req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
			} else if (page.equals("Guessing Game")) {
				req.getRequestDispatcher("/_view/guessingGame.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
			}
		} else {
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
	}
}
