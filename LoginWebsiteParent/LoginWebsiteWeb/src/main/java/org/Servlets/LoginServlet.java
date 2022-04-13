package org.Servlets;

import org.LoginWebsiteLogic.User;
import org.LoginWebsiteDatabaseLogic.UserDBConnection;
import org.LoginWebsiteLogic.AllUsers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res)  {				
		String username =req.getParameter("username");
		String password = req.getParameter("password");	
		
		UserDBConnection dbConnection = new UserDBConnection();
		
		
		PrintWriter out = null;
		try {
			out = res.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.print("failed to get writer");
			e1.printStackTrace();
		}
		
		try {
			if(dbConnection.checkIfLoginIsCorrect(username, password)) {
				out.println("Welcome " + username);
			}else {
				out.println("User name or password incorrect");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed to connect");
			e.printStackTrace();
		}
		
	}
}
