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
//@WebServlet("/admin")
//public class example2 extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		String name = req.getParameter("username");
//		String password = req.getParameter("password");
//		PrintWriter pw = resp.getWriter();
//		if(name.equals("admin")&& password.equals("admin")) {
//			pw.write("Welcome admin");
//		}
//		else {
//			pw.write("Access denied");
//		}
//	}
//}
