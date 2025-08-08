package com.aurionpro.Ecommerce.model;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        if (username == null || username.trim().isEmpty()) {
            res.sendRedirect("login.html");
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        session.setMaxInactiveInterval(60); 
        res.sendRedirect("products");
    }
}
