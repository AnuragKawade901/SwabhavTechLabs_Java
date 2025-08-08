package com.aurionpro.Ecommerce.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("login.html");
            return;
        }

        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        if (cart == null) cart = new HashMap<>();

        for (Product p : ProductRepository.getAllProducts()) { 
            String param = req.getParameter("qty" + p.getId());
            if (param != null && !param.isBlank()) {
                int qty = Integer.parseInt(param);
                if (qty > 0) {
                    cart.put(p, cart.getOrDefault(p, 0) + qty);
                }
            }
        }

        session.setAttribute("cart", cart);
        res.sendRedirect("view-cart");
    }
}
