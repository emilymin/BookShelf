package com.thoughtworks.mapper;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.PhysicalBook;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookShelfMapper {

    private List<Book> bookList;
    private JdbcTemplate jdbcTemplate;
    static final String QUERYBOOK_SQL = "SELECT * FROM PHYSICALBOOKS WHERE ISBN =";
    static final String QUERYBOOKS_SQL = "SELECT * FROM PHYSICALBOOKS";
    static final String INSERTBOOK_SQL = "INSERT INTO PHYSICALBOOKS (ISBN, NAME, AUTHOR, LOCATION) VALUES(?, ?, ?, ?)";
    static final String DELETEBOOK_SQL = "DELETE FROM PHYSICALBOOKS WHERE ISBN =";
    static final String DELETEBOOKS_SQL = "DELETE FROM PHYSICALBOOKS";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addPhysicalBook(PhysicalBook book) {
        return jdbcTemplate.update(INSERTBOOK_SQL, book.getISBN(), book.getName(), book.getAuthors(), book.getLocation());
    }

    public PhysicalBook getPhysicalBookByISBN(String isbn) {
        return jdbcTemplate.queryForObject(QUERYBOOK_SQL + isbn, PhysicalBook.class);
    }

    public List<Book> getBookList() {
        return jdbcTemplate.query(QUERYBOOKS_SQL,new LoadRowMapper());
    }

    public int deletePhysicalBookByISBN(String isbn) {
        return jdbcTemplate.update(DELETEBOOK_SQL + isbn);
    }

    public int deletePhysicalBooks() {
        return jdbcTemplate.update(DELETEBOOKS_SQL);
    }


}
