package com.thoughtworks.controller;

import com.thoughtworks.domain.Book;
import com.thoughtworks.exception.DataAccessException;
import com.thoughtworks.service.BookShelfServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class ShowBookServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Book> bookMap = null;

        BookShelfServiceImpl bookShelfService = new BookShelfServiceImpl();
        try {
            bookMap = bookShelfService.queryAllEBookNames();
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("name", bookMap.get("book").getName());
        request.setAttribute("author", bookMap.get("book").getAuthors());
        request.setAttribute("isbn", bookMap.get("book").getISBN());
        request.setAttribute("location", bookMap.get("book").getLocation());
        request.setAttribute("type", bookMap.get("book").getType());

//        ServletContext sc = getServletContext();
//        RequestDispatcher requestDispatcher = sc.getRequestDispatcher("./JSP/Book.jsp");
//        requestDispatcher.forward(request, response);

        request.getRequestDispatcher("./JSP/Book.jsp").forward(request, response);
    }
}
