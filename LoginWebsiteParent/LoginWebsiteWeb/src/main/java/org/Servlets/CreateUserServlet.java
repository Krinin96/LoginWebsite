package org.Servlets;

import org.LoginWebsiteDatabaseLogic.UserDBConnection;
import org.LoginWebsiteLogic.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateNew")
public class CreateUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserDBConnection dbConnection = new UserDBConnection();
		
		User newUser = new User(username,password);

		
		if(!dbConnection.checkIfUserExist(newUser)) {
			dbConnection.addUser(newUser);
			res.sendRedirect("index.html");
		}else {
			PrintWriter out = res.getWriter();			
			out.println("username taken");		
			
		}
		
		
	}
}
