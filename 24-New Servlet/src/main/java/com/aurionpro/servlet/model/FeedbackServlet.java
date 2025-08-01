package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productId = request.getParameter("productId");
        String ratingStr = request.getParameter("rating");
        String review = request.getParameter("review");

        int rating = 0;
        boolean hasError = false;
        StringBuilder errorMessage = new StringBuilder("<h3>Validation Errors:</h3><ul>");

        try {
            rating = Integer.parseInt(ratingStr);
            if (rating < 1 || rating > 5) {
                hasError = true;
                errorMessage.append("<li>Rating must be between 1 and 5.</li>");
            }
        } catch (NumberFormatException e) {
            hasError = true;
            errorMessage.append("<li>Invalid rating format.</li>");
        }

        if (review == null || review.trim().isEmpty()) {
            hasError = true;
            errorMessage.append("<li>Review cannot be empty.</li>");
        }

        errorMessage.append("</ul>");

        if (hasError) {
            out.println(errorMessage.toString());
            out.println("<a href='feedback_form.html'>Go Back</a>");
        } else {
            // For now, we just print feedback to the response (can use in-memory storage if needed)
            out.println("<h2>Thank you for your feedback!</h2>");
            out.println("<p><strong>Product ID:</strong> " + productId + "</p>");
            out.println("<p><strong>Rating:</strong> " + rating + "</p>");
            out.println("<p><strong>Your Review:</strong> " + review + "</p>");
        }
    }
}
