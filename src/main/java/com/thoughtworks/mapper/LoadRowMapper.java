package com.thoughtworks.mapper;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.PhysicalBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadRowMapper implements RowMapper<Book> {

    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book book = new PhysicalBook();
        book.setISBN(rs.getString(1));
        book.setName(rs.getString(2));
        book.setAuthors(rs.getString(4));
        book.setType(rs.getString(5));

        return book;
    }
}