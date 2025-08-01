package com.aurionpro.servletcontext.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/initCounter")
public class CounterInitServlet extends HttpServlet{

	@Override
	public void init() throws ServletException{
		ServletContext context = getServletContext();
		context.setAttribute("counter", 0);
		System.out.println("counter initlized with 0");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("Counter initilized. you can go the next page via the button");
		pw.println("<br>");
		pw.println("<a href=\"visit\"> Visit</a>");
	}
}
