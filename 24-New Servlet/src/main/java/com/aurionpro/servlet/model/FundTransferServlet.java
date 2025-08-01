package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FundTransferServlet")
public class FundTransferServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String sourceAcc = request.getParameter("sourceAccount");
        String destAcc = request.getParameter("destinationAccount");
        String amountStr = request.getParameter("amount");

        double amount = 0;
        boolean hasError = false;
        StringBuilder error = new StringBuilder();

        if (sourceAcc.equals(destAcc)) {
            hasError = true;
            error.append("<li>Source and destination accounts must be different.</li>");
        }

        try {
            amount = Double.parseDouble(amountStr);
            if (amount <= 0 || amount > 50000) {
                hasError = true;
                error.append("<li>Amount must be between ₹1 and ₹50,000.</li>");
            }
        } catch (NumberFormatException e) {
            hasError = true;
            error.append("<li>Invalid amount format.</li>");
        }

        out.println("<html><head><title>Fund Transfer Result</title></head><body>");
        if (hasError) {
            out.println("<h2>Transfer Failed</h2>");
            out.println("<ul style='color: red;'>" + error.toString() + "</ul>");
            out.println("<a href='fund_transfer.html'>Try Again</a>");
        } else {
            out.println("<h2>Transfer Successful!</h2>");
            out.println("<p><strong>From Account:</strong> " + sourceAcc + "</p>");
            out.println("<p><strong>To Account:</strong> " + destAcc + "</p>");
            out.println("<p><strong>Amount Transferred:</strong> ₹" + String.format("%.2f", amount) + "</p>");
        }
        out.println("</body></html>");
    }
}

