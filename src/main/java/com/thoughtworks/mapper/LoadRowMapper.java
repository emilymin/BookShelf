package com.thoughtworks.mapper;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.PhysicalBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadRowMapper implements RowMapper<Book> {

    public PhysicalBook mapRow(ResultSet rs, int rowNum) throws SQLException {

        PhysicalBook book = new PhysicalBook();
        book.setISBN(rs.getString(1));
        book.setName(rs.getString(2));
//        book.setAuthors(rs.getString(3));
//        book.setPrice(rs.getInt(4));

        return book;
    }
}