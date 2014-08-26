package com.thoughtworks.mapper;

import com.thoughtworks.domain.PhysicalBook;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadPhyRowMapper implements com.thoughtworks.mapper.RowMapper<PhysicalBook>{

    public PhysicalBook mapRow(ResultSet rs, int rowNum) throws SQLException {

        PhysicalBook book = new PhysicalBook();
        book.setISBN(rs.getString(1));
        book.setName(rs.getString(2));
        book.setAuthors(rs.getString(4));
        book.setType(rs.getString(5));

        return book;
    }
}