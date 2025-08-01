package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResumeUploadServlet")
public class ResumeUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String skills = request.getParameter("skills");
        String resumeText = request.getParameter("resumeText");

        boolean hasError = false;
        StringBuilder errorMsg = new StringBuilder("<ul style='color:red;'>");

        // Basic validations
        if (name == null || name.trim().length() < 2) {
            hasError = true;
            errorMsg.append("<li>Name must be at least 2 characters.</li>");
        }

        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            hasError = true;
            errorMsg.append("<li>Invalid email format.</li>");
        }

        if (skills == null || skills.trim().isEmpty()) {
            hasError = true;
            errorMsg.append("<li>At least one skill is required.</li>");
        }

        errorMsg.append("</ul>");

        // Response
        out.println("<html><head><title>Resume Preview</title></head><body>");

        if (hasError) {
            out.println("<h2>Submission Failed</h2>");
            out.println(errorMsg.toString());
            out.println("<a href='resume_submission.html'>Go Back</a>");
        } else {
            out.println("<h2>Resume Preview</h2>");
            out.println("<p><strong>Name:</strong> " + name + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("<p><strong>Skills:</strong></p><ul>");
            for (String skill : skills.split(",")) {
                out.println("<li>" + skill.trim() + "</li>");
            }
            out.println("</ul>");
            out.println("<p><strong>Resume:</strong></p>");
            out.println("<pre style='background:#f0f0f0;padding:10px;'>" + resumeText + "</pre>");
        }

        out.println("</body></html>");
    }
}
