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

public class AddBookServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./JSP/index.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ElectronicBook book = new ElectronicBook();

        book.setISBN(request.getParameter("isbn"));
        book.setName(request.getParameter("name"));
        book.setAuthors(request.getParameter("author"));
        book.setLocation(request.getParameter("location"));
        book.setType(request.getParameter("type"));

        BookShelfServiceImpl bookShelfService = new BookShelfServiceImpl();

        try {
            bookShelfService.addBook(book);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("./JSP/index.jsp").forward(request,response);
    }
}
