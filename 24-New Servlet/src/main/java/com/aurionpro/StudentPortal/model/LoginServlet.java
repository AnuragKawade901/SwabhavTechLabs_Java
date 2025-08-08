package com.aurionpro.StudentPortal.model;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");

        if (studentName == null || studentName.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
            dispatcher.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("studentName", studentName);

        Cookie loginTimeCookie = new Cookie("loginTime", String.valueOf(System.currentTimeMillis()));
        loginTimeCookie.setMaxAge(60);
        response.addCookie(loginTimeCookie);

        response.sendRedirect("DashboardServlet");
    }
}