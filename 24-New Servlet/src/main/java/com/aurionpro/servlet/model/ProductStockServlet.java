package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stock")
public class ProductStockServlet extends HttpServlet {
    private static final Map<String, Product> inventory = new HashMap<>();

    static {
        inventory.put("1023", new Product("Wireless Mouse", true, 25));
        inventory.put("2045", new Product("Laptop Stand", false, 0));
        inventory.put("3051", new Product("USB Keyboard", true, 40));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String productId = req.getParameter("productId");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if (productId == null || productId.trim().isEmpty()) {
            out.write("Error: productId is required.");
            return;
        }

        Product product = inventory.get(productId);

        if (product != null) {
            out.println("<h2>Product Information</h2>");
            out.println("<p><strong>Product ID:</strong> " + productId + "</p>");
            out.println("<p><strong>Name:</strong> " + product.name + "</p>");
            out.println("<p><strong>Availability:</strong> " + (product.inStock ? "In Stock" : "Out of Stock") + "</p>");
            out.println("<p><strong>Stock Count:</strong> " + product.stockCount + "</p>");
        } else {
            out.write("<p style='color:red;'>Error: No product found with ID " + productId + "</p>");
        }
    }

    static class Product {
        String name;
        boolean inStock;
        int stockCount;

        Product(String name, boolean inStock, int stockCount) {
            this.name = name;
            this.inStock = inStock;
            this.stockCount = stockCount;
        }
    }
}