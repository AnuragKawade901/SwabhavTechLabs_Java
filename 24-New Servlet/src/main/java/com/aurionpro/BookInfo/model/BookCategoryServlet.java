package com.aurionpro.BookInfo.model;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/category")
public class BookCategoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ServletContext context = getServletContext();
        String category = request.getParameter("name");
        if (category == null) category = "unknown";

        // Safely initialize all counters if not yet initialized
        synchronized (context) {
            // Initialize counters
            if (context.getAttribute("totalVisitors") == null) {
                context.setAttribute("totalVisitors", 0);
            }
            if (context.getAttribute("fictionCount") == null) {
                context.setAttribute("fictionCount", 0);
            }
            if (context.getAttribute("techCount") == null) {
                context.setAttribute("techCount", 0);
            }
            if (context.getAttribute("scienceCount") == null) {
                context.setAttribute("scienceCount", 0);
            }

            // Increment total visitor count
            int totalVisitors = (int) context.getAttribute("totalVisitors");
            context.setAttribute("totalVisitors", totalVisitors + 1);

            // Update category-specific counter
            switch (category.toLowerCase()) {
                case "fiction":
                    context.setAttribute("fictionCount", (int) context.getAttribute("fictionCount") + 1);
                    break;
                case "technology":
                    context.setAttribute("techCount", (int) context.getAttribute("techCount") + 1);
                    break;
                case "science":
                    context.setAttribute("scienceCount", (int) context.getAttribute("scienceCount") + 1);
                    break;
            }

            // Update last visited category
            context.setAttribute("lastVisitedCategory", category.toLowerCase());
        }


        // Retrieve current count for this category
        int count = 0;
        switch (category.toLowerCase()) {
            case "fiction":
                count = (int) context.getAttribute("fictionCount");
                break;
            case "technology":
                count = (int) context.getAttribute("techCount");
                break;
            case "science":
                count = (int) context.getAttribute("scienceCount");
                break;
        }

        // Display output
        response.getWriter().println("<!DOCTYPE html><html><head><title>" + category + "</title>");
        response.getWriter().println("<link rel='stylesheet' type='text/css' href='style.css'>");
        response.getWriter().println("</head><body>");
        response.getWriter().println("<h1>Category: " + capitalize(category) + "</h1>");
        response.getWriter().println("<p><strong>" + capitalize(category) + " count:</strong> " + count + "</p>");
        response.getWriter().println("</body></html>");
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}