//package com.aurionpro.servlet.model;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/login")
//public class example1 extends HttpServlet{
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		String name = req.getParameter("username");
//		PrintWriter pw = resp.getWriter();
//		if(name.trim().isEmpty()) {
//			pw.write("Welcome guest");
//		}
//		else {
//			pw.write("Welcome to servlet page: "+name);
//		}
//	}
//
//}
