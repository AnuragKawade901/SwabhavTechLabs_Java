package com.aurionpro.servletDemo.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/voting")
public class VotingRequestDispatcher extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		boolean hasError = false;
		if(age<18) {
			resp.setContentType("text/html");
			pw.println("You are under age");
			//Forward to you can vote
			RequestDispatcher rd = req.getRequestDispatcher("voting.html");
			rd.include(req, resp);
		}
		else if(age >= 18 && age <= 65) {
			RequestDispatcher rd = req.getRequestDispatcher("under60");
			rd.forward(req, resp);
		}
		else if(age > 65) {
			RequestDispatcher rd = req.getRequestDispatcher("above60");
			rd.forward(req, resp);
		}
	}

}
