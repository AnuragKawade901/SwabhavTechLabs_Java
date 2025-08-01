package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String city = req.getParameter("city");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		if (city == null || city.trim().isEmpty()) {
			out.write("City name is required.");
			return;
		}

		if (city.equalsIgnoreCase("Delhi")) {
			out.write("Weather for Delhi: Temp 35°C, Humidity 60%, Sunny");
		} else if (city.equalsIgnoreCase("Mumbai")) {
			out.write("Weather for Mumbai: Temp 30°C, Humidity 70%, Humid");
		} else if (city.equalsIgnoreCase("Chennai")) {
			out.write("Weather for Chennai: Temp 33°C, Humidity 75%, Cloudy");
		} else if (city.equalsIgnoreCase("Kolkata")) {
			out.write("Weather for Kolkata: Temp 31°C, Humidity 80%, Rainy");
		} else {
			out.write("No weather data found for '" + city + "'");
		}
	}
}
