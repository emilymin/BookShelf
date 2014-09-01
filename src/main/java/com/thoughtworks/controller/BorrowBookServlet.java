package com.thoughtworks.controller;

import com.thoughtworks.domain.Book;
import com.thoughtworks.exception.BookNotFoundException;
import com.thoughtworks.exception.DataAccessException;
import com.thoughtworks.service.BookShelfServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class BorrowBookServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("borrowISBN");

        BookShelfServiceImpl bookShelfService = new BookShelfServiceImpl();
        Book book = null;

        try {
            book = bookShelfService.borrowBook(isbn);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        request.setAttribute("book", book.getName());
        request.setAttribute("bookStatus", book.getStatus());
        request.getRequestDispatcher("./JSP/borrowResult.jsp").forward(request, response);
    }
}