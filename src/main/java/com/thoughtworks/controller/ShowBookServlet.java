package com.thoughtworks.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowBookServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");

        request.setAttribute("name", name);
        request.setAttribute("author", author);

        ServletContext sc = getServletContext();
        RequestDispatcher requestDispatcher = sc.getRequestDispatcher("./JSP/Book.jsp");
        requestDispatcher.forward(request, response);
    }
}
