package com.aurionpro.StudentPortal.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String studentName = (String) session.getAttribute("studentName");

        // If session does not exist or student name is not available, redirect to login
        if (studentName == null) {
            response.sendRedirect("StudentPortal_index.html");
            return;
        }

        String lastVisit = CookieUtil.getCookieValue(request, "loginTime");
        long currentLoginTime = System.currentTimeMillis();
        long timeSinceLastVisit = (lastVisit != null) ? currentLoginTime - Long.parseLong(lastVisit) : 0;

        ServletContext context = getServletContext();
        String portalMotto = (String) context.getAttribute("portalMotto");

        // Set content type as HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Write HTML content with dynamic values
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Dashboard - Student Portal</title>");
        out.println("<link rel='stylesheet' href='StudentPortal_style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>Welcome, " + studentName + "!</h2>");
        out.println("<p>Last login time: " + timeSinceLastVisit + " ms ago</p>");
        out.println("<p>Portal Motto: " + portalMotto + "</p>");
        out.println("<p><a href='LogoutServlet'>Logout</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}