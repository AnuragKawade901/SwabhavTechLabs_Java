package com.aurionpro.Ecommerce.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view-cart")
public class ViewCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("login.html");
            return;
        }

        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        out.println("<html><head><link rel='stylesheet' href='Ecommercestyle.css'></head><body>");
        out.println("<h2>Your Cart</h2>");

        double total = 0;

        if (cart == null || cart.isEmpty()) {
            out.println("<p>Cart is empty.</p>");
        } else {
            out.println("<form method='post' action='update-cart'>");
            for (Product p : cart.keySet()) {
                int qty = cart.get(p);
                double subtotal = qty * p.getPrice();
                total += subtotal;

                out.println("<div>");
                out.println(p.getName() + " - ₹" + p.getPrice());
                out.println(" Quantity: <input type='number' name='qty" + p.getId() + "' min='0' value='" + qty + "' />");
                out.println("</div>");
            }

            out.println("<p><strong>Total: ₹" + total + "</strong></p>");
            out.println("<input type='submit' value='Update Cart' />");
            out.println("</form>");
        }

        out.println("<br><a href='products'>Continue Shopping</a> | ");
        out.println("<a href='checkout'>Checkout</a> | <a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}
