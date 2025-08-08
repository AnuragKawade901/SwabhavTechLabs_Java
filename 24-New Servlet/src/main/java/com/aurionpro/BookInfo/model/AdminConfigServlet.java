//package com.aurionpro.BookInfo.model;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletConfig;
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/admin")
//public class AdminConfigServlet extends HttpServlet {
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        ServletConfig config = getServletConfig();
//        ServletContext context = getServletContext();
//
//        // Read from config (static or set manually since no web.xml)
//        String storeName = config.getInitParameter("storeName") != null ? config.getInitParameter("storeName") : "BookVerse";
//        String adminEmail = config.getInitParameter("adminEmail") != null ? config.getInitParameter("adminEmail") : "admin@bookverse.com";
//        String category = (String) context.getAttribute("lastVisitedCategory");
//        if (category == null) {
//            category = "None yet visited";
//        } else {
//            category = capitalize(category);
//        }
//
//        // Application-level values from context
//        int totalVisitors = getInt(context, "totalVisitors");
//        int fictionCount = getInt(context, "fictionCount");
//        int techCount = getInt(context, "techCount");
//        int scienceCount = getInt(context, "scienceCount");
//        String appVersion = context.getInitParameter("appVersion") != null ? context.getInitParameter("appVersion") : "1.0";
//
//        response.getWriter().println("<!DOCTYPE html><html><head><title>Admin Config</title>");
//        response.getWriter().println("<link rel='stylesheet' type='text/css' href='style.css'>");
//        response.getWriter().println("</head><body>");
//        response.getWriter().println("<h2>Admin Configuration</h2>");
//        response.getWriter().println("<p><strong>Store:</strong> " + storeName + "</p>");
//        response.getWriter().println("<p><strong>Admin Email:</strong> " + adminEmail + "</p>");
//        response.getWriter().println("<p><strong>Last Visited Category:</strong> " + category + "</p>");
//
//
//        response.getWriter().println("<h3>Visitor Statistics</h3>");
//        response.getWriter().println("<p><strong>Total Visitors:</strong> " + totalVisitors + "</p>");
//        response.getWriter().println("<ul>");
//        response.getWriter().println("<li>Fiction: " + fictionCount + "</li>");
//        response.getWriter().println("<li>Technology: " + techCount + "</li>");
//        response.getWriter().println("<li>Science: " + scienceCount + "</li>");
//        response.getWriter().println("</ul>");
//        response.getWriter().println("<p><strong>App Version:</strong> " + appVersion + "</p>");
//        response.getWriter().println("</body></html>");
//    }
//
//    private String capitalize(String str) {
//        if (str == null || str.isEmpty()) return str;
//        return str.substring(0, 1).toUpperCase() + str.substring(1);
//    }
//
//	private int getInt(ServletContext context, String key) {
//        Object val = context.getAttribute(key);
//        return (val != null) ? (int) val : 0;
//    }
//}
