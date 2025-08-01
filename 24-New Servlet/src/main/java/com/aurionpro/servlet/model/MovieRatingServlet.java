package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rating")
public class MovieRatingServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String movie = req.getParameter("movieName");

		if (movie == null || movie.trim().isEmpty()) {
			out.write("Error: movieName parameter is required.");
			return;
		}

		movie = movie.trim().toLowerCase();

		out.println("<html><body><h2>Movie Rating Summary</h2>");

		if (movie.equals("inception")) {
			out.println("<strong>Movie:</strong> Inception<br>");
			out.println("<strong>Genre:</strong> Sci-Fi / Thriller<br>");
			out.println("<strong>Rating:</strong> 8.8/10<br>");
			out.println("<strong>Reviews:</strong> Mind-blowing, Complex, Brilliant visuals.");
		} else if (movie.equals("avatar")) {
			out.println("<strong>Movie:</strong> Avatar<br>");
			out.println("<strong>Genre:</strong> Sci-Fi / Adventure<br>");
			out.println("<strong>Rating:</strong> 7.9/10<br>");
			out.println("<strong>Reviews:</strong> Visual masterpiece, Strong environmental message.");
		} else if (movie.equals("joker")) {
			out.println("<strong>Movie:</strong> Joker<br>");
			out.println("<strong>Genre:</strong> Drama / Crime<br>");
			out.println("<strong>Rating:</strong> 8.4/10<br>");
			out.println("<strong>Reviews:</strong> Intense, Dark, Incredible performance by Joaquin Phoenix.");
		} else {
			out.println("<p style='color:red;'>No data found for movie '" + movie + "'</p>");
		}

		out.println("</body></html>");
	}
}
