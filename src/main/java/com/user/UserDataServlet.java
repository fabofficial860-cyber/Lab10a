package com.user;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        // Server-side validation
        if (name == null || name.isEmpty() ||
            email == null || email.isEmpty() ||
            designation == null || designation.isEmpty()) {

            response.getWriter().println("<h3>All fields are required!</h3>");
            return;
        }

        if (!email.matches("^[^ ]+@[^ ]+\\.[a-z]{2,3}$")) {
            response.getWriter().println("<h3>Invalid Email format!</h3>");
            return;
        }

        // Store data in request scope
        request.setAttribute("username", name);
        request.setAttribute("email", email);
        request.setAttribute("designation", designation);

        // Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}