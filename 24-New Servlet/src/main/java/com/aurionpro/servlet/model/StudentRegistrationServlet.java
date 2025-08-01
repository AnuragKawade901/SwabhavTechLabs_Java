package com.aurionpro.servlet.model;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistrationServlet")
public class StudentRegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String course = request.getParameter("course");

        boolean hasError = false;
        StringBuilder errorMessage = new StringBuilder("<h3>Validation Errors:</h3><ul>");

        if (name == null || name.trim().isEmpty()) {
            errorMessage.append("<li>Name is required.</li>");
            hasError = true;
        }

        if (email == null || email.trim().isEmpty()) {
            errorMessage.append("<li>Email is required.</li>");
            hasError = true;
        }

        int age = 0;
        try {
            age = Integer.parseInt(ageStr);
            if (age < 18) {
                errorMessage.append("<li>Age must be at least 18.</li>");
                hasError = true;
            }
        } catch (NumberFormatException e) {
            errorMessage.append("<li>Age must be a valid number.</li>");
            hasError = true;
        }

        if (course == null || course.trim().isEmpty()) {
            errorMessage.append("<li>Course must be selected.</li>");
            hasError = true;
        }

        errorMessage.append("</ul>");

 
        if (hasError) {
            out.println(errorMessage.toString());
            out.println("<a href='student_registration.html'>Go Back</a>");
        } else {
            out.println("<h2>Registration Successful!</h2>");
            out.println("<p><strong>Name:</strong> " + name + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("<p><strong>Age:</strong> " + age + "</p>");
            out.println("<p><strong>Course:</strong> " + course + "</p>");
        }
    }
}
