package org.Servlets;

import org.LoginWebsiteDatabaseLogic.UserDBConnection;

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

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UserDBConnection dbConnection = new UserDBConnection();

		try {
			if (!dbConnection.checkIfPersonExist(username)) {
				dbConnection.addUser(username, password);

				try {
					res.sendRedirect("index.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("cant redirect");
					e.printStackTrace();
				}
			} else {
				// username taken
				PrintWriter out;
				try {
					out = res.getWriter();
					out.println("username is already taken");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("cant print anything");
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("failed here");
			e.printStackTrace();

		}
	}
}
