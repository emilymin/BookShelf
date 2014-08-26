package com.thoughtworks.mapper;


import com.thoughtworks.domain.ElectronicBook;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadEleRowMapper implements com.thoughtworks.mapper.RowMapper<ElectronicBook> {

    public ElectronicBook mapRow(ResultSet rs, int rowNum) throws SQLException {

        ElectronicBook book = new ElectronicBook();
        book.setISBN(rs.getString(1));
        book.setName(rs.getString(2));
        book.setAuthors(rs.getString(3));
        book.setLocation(rs.getString(4));
        book.setType(rs.getString(5));

        return book;
    }
}