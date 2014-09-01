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
import java.util.ArrayList;
import java.util.List;

public class QueryBookServlet extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("bookName");

        BookShelfServiceImpl bookShelfService = new BookShelfServiceImpl();
        List<Book> bookList = new ArrayList<Book>();
        try {
            bookList = bookShelfService.queryBookByName(name);
        } catch (DataAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("bookList", bookList.get(0).getName());

        request.getRequestDispatcher("./JSP/bookQueryList.jsp").forward(request, response);
    }
}
