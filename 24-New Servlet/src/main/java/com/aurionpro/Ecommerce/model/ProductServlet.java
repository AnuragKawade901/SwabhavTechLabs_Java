package com.aurionpro.Ecommerce.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("login.html");
            return;
        }

    //visit counter	
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        visitCount = (visitCount == null) ? 1 : visitCount + 1;
        session.setAttribute("visitCount", visitCount);
        
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        Map<String, List<Product>> categorized = ProductRepository.getProductsGroupedByCategory();
        
        out.println("<html><head><link rel='stylesheet' href='Ecommercestyle.css'></head><body>");
        out.println("<h2>Welcome, " + session.getAttribute("username") + "</h2>");
        out.println("<h3>Shop by Category</h3>");
        out.println("<form method='post' action='cart'>");

        for (String category : categorized.keySet()) {
            out.println("<fieldset style='margin-bottom:20px;'>");
            out.println("<legend><strong>" + category + "</strong></legend>");
            for (Product p : categorized.get(category)) {
                out.println("<div>");
                out.println(p.getName() + " - ₹" + p.getPrice());
                out.println(" Quantity: <input type='number' name='qty" + p.getId() + "' min='0' value='0' />");
                out.println("</div>");
            }
            out.println("</fieldset>");
        }

        out.println("<input type='submit' value='Add to Cart' />");
        out.println("</form>");
        out.println("<br><a href='view-cart'>View Cart</a> | <a href='logout'>Logout</a>");
        out.println("</body></html>");
    }
}

