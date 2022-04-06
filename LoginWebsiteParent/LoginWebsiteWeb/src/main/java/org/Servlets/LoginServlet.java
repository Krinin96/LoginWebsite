package org.Servlets;

import org.LoginWebsiteLogic.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {				
		String username =req.getParameter("username");
		String password = req.getParameter("password");
		
		
	}
}
