package com.aurionpro.Ecommerce.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("login.html");
            return;
        }

        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        double total = 0;

        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<html><head><link rel='stylesheet' href='Ecommercestyle.css'></head><body>");
        out.println("<h2>Order Confirmation</h2>");

        if (cart != null) {
            for (Product p : cart.keySet()) {
                int qty = cart.get(p);
                double subtotal = qty * p.getPrice();
                total += subtotal;
                out.println("<p>" + p.getName() + " x " + qty + " = ₹" + subtotal + "</p>");
            }
        }

        out.println("<h3>Total: ₹" + total + "</h3>");
        out.println("<p>Thank you, " + session.getAttribute("username") + "!</p>");
        session.removeAttribute("cart"); // clear cart after checkout
        out.println("<a href='products'>Shop Again</a>");
        out.println("</body></html>");
    }
}
