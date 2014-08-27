package com.thoughtworks.controller;

import com.thoughtworks.domain.ElectronicBook;
import com.thoughtworks.exception.BookNotFoundException;
import com.thoughtworks.service.BookShelfServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BookShelfServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletContext sc = getServletContext();
//        RequestDispatcher requestDispatcher = sc.getRequestDispatcher("/JSP/index.jsp");
//        requestDispatcher.forward(request, response);
        request.getRequestDispatcher("./JSP/index.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ElectronicBook book = new ElectronicBook();

        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String location = request.getParameter("location");
        String type = request.getParameter("type");

        book.setISBN(request.getParameter("isbn"));
        book.setName(request.getParameter("name"));
        book.setAuthors(request.getParameter("author"));
        book.setLocation(location);
        System.out.println(book.getLocation());
        book.setType(request.getParameter("type"));

        BookShelfServiceImpl bookShelfService = new BookShelfServiceImpl();

        try {
            bookShelfService.addBook(book);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("name", name);
        request.setAttribute("author", author);
        request.setAttribute("isbn", isbn);
        request.setAttribute("location", location);
        request.setAttribute("type", type);

        request.getRequestDispatcher("/ShowBook").forward(request, response);
//        request.getRequestDispatcher("./JSP/Book.jsp").forward(request, response);
    }



}
