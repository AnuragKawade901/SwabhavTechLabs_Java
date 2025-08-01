package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CourseCatalogServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String dept = req.getParameter("department");

        if (dept == null || dept.trim().isEmpty()) {
            out.write("Error: Department parameter is required.");
            return;
        }

        dept = dept.toUpperCase();

        out.write("<h2>Courses for Department: " + dept + "</h2><ul>");

        if (dept.equals("CS")) {
            out.write("<li>Data Structures</li>");
            out.write("<li>Algorithms</li>");
            out.write("<li>Operating Systems</li>");
            out.write("<li>Web Development</li>");
        } else if (dept.equals("ME")) {
            out.write("<li>Thermodynamics</li>");
            out.write("<li>Fluid Mechanics</li>");
            out.write("<li>Machine Design</li>");
        } else if (dept.equals("EE")) {
            out.write("<li>Circuits</li>");
            out.write("<li>Electromagnetics</li>");
            out.write("<li>Digital Systems</li>");
        } else {
            out.write("</ul>");
            out.write("<p style='color:red;'>Error: No courses found for department '" + dept + "'</p>");
            return;
        }

        out.write("</ul>");
    }
}
