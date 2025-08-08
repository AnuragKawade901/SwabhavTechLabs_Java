package com.aurionpro.BookInfo.model;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/landing")
public class LandingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext context = getServletContext();

        synchronized (context) {
            if (context.getAttribute("totalVisitors") == null) {
                context.setAttribute("totalVisitors", 0);
            }
            int total = (int) context.getAttribute("totalVisitors") + 1;
            context.setAttribute("totalVisitors", total);
        }

        int totalVisitors = (int) context.getAttribute("totalVisitors");

        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head>");
        response.getWriter().println("<title>Welcome to BookVerse</title>");
        response.getWriter().println("<link rel='stylesheet' type='text/css' href='style.css'>");
        response.getWriter().println("</head><body>");
        response.getWriter().println("<h1>Welcome to BookVerse 📚</h1>");
        response.getWriter().println("<p><strong>Total Site Visitors:</strong> " + totalVisitors + "</p>");
        response.getWriter().println("<h3>Choose a Book Category:</h3>");
        response.getWriter().println("<ul>");
        response.getWriter().println("<li><a href='category?name=fiction'>Fiction</a></li>");
        response.getWriter().println("<li><a href='category?name=technology'>Technology</a></li>");
        response.getWriter().println("<li><a href='category?name=science'>Science</a></li>");
        response.getWriter().println("</ul>");
        response.getWriter().println("<p><a href='admin'>Admin Config Page</a></p>");
        response.getWriter().println("</body></html>");
    }
}