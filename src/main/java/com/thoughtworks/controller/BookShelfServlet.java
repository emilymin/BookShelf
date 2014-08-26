package com.thoughtworks.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookShelfServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext sc = getServletContext();
//        RequestDispatcher requestDispatcher = sc.getRequestDispatcher("/JSP/index.jsp");
//        requestDispatcher.forward(request, response);
        request.getRequestDispatcher("./JSP/index.jsp").forward(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String location = request.getParameter("location");
        String type = request.getParameter("type");
        System.out.println(name + author);

        request.setAttribute("name", name);
        request.setAttribute("author", author);
        request.setAttribute("isbn", isbn);
        request.setAttribute("location", location);
        request.setAttribute("type", type);

        request.getRequestDispatcher("./JSP/Book.jsp").forward(request, response);
    }



}
