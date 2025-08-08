package com.aurionpro.Ecommerce.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update-cart")
public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("login.html");
            return;
        }

        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        Map<Product, Integer> updatedCart = new HashMap<>();

        for (Product p : ProductRepository.getAllProducts()) {
            String param = req.getParameter("qty" + p.getId());
            if (param != null && !param.isBlank()) {
                try {
                    int qty = Integer.parseInt(param);
                    if (qty > 0) {
                        updatedCart.put(p, qty);
                    }
                   
                } catch (NumberFormatException e) {
                    // Invalid input, skip product
                }
            }
        }

        session.setAttribute("cart", updatedCart);
        res.sendRedirect("view-cart");
    }
}