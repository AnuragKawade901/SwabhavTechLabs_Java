package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyConverterServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String amountStr = req.getParameter("amount");
        String from = req.getParameter("from");
        String to = req.getParameter("to");

        if (amountStr == null || from == null || to == null ||
            amountStr.isEmpty() || from.isEmpty() || to.isEmpty()) {
            out.write("Error: All parameters (amount, from, to) are required.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            out.write("Error: Amount must be a valid number.");
            return;
        }

        double rate = getConversionRate(from.toUpperCase(), to.toUpperCase());

        if (rate == 0.0) {
            out.write("Error: Conversion rate from " + from + " to " + to + " not found.");
        } else {
            double convertedAmount = amount * rate;
            out.printf("Converted Amount: %.2f %s = %.2f %s",
                        amount, from.toUpperCase(),
                        convertedAmount, to.toUpperCase());
        }
    }

    private double getConversionRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) return 83.0;
        if (from.equals("INR") && to.equals("USD")) return 0.012;
        if (from.equals("EUR") && to.equals("INR")) return 90.0;
        if (from.equals("INR") && to.equals("EUR")) return 0.011;
        if (from.equals("USD") && to.equals("EUR")) return 0.93;
        if (from.equals("EUR") && to.equals("USD")) return 1.08;
        return 0.0; // unsupported conversion
    }
}