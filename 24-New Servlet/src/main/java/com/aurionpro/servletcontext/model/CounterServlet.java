package com.aurionpro.servletcontext.model;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/visit")
public class CounterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletContext context2 = getServletContext();
	Integer count =  (Integer)context2.getAttribute("counter");
	
	count++;
	context2.setAttribute("counter", count);
	resp.setContentType("text/html");
	resp.getWriter().write("Visitor count is: "+count);
	
	
	
	}

}
