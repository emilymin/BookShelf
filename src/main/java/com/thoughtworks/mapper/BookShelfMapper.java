package com.thoughtworks.mapper;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.BookStatus;
import com.thoughtworks.domain.ElectronicBook;
import com.thoughtworks.domain.PhysicalBook;
import com.thoughtworks.exception.DataAccessException;
import com.thoughtworks.utils.DBUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.*;

public class BookShelfMapper {

    private JdbcTemplate jdbcTemplate;
    static final String QUERYBOOK_SQL = "SELECT * FROM BOOKS WHERE ISBN =";
    static final String QUERYBOOKS_SQL = "SELECT * FROM BOOKS";
    static final String QUERYEBOOKS_SQL = "SELECT * FROM BOOKS WHERE TYPE = ";
    static final String INSERTBOOK_SQL = "INSERT INTO BOOKS (ISBN, NAME, AUTHOR, LOCATION, TYPE) VALUES(?, ?, ?, ?, ?)";
    static final String UPDATESTATUS_SQL = "UPDATE BOOKS" + "SET STATUS = ? WHERE ISBN = ?";


    public int addBook(Book book) throws SQLException {
        return DBUtil.update(INSERTBOOK_SQL, book.getISBN(), book.getName(), book.getAuthors(), book.getLocation(), book.getType());
    }

    public Book getBookByISBN(String isbn) {
        return jdbcTemplate.queryForObject(QUERYBOOK_SQL + isbn, Book.class);
    }

    public List<Book> getBookList() throws DataAccessException, SQLException {
        List<Book> bookList = new ArrayList<Book>();
        bookList.addAll(getEBookBookList());
        bookList.addAll(getPhysicalBookBookList());
        return bookList;
    }

    public List<ElectronicBook> getEBookBookList() throws DataAccessException, SQLException {
        String sql = "ELECTRONIC";
        return DBUtil.query(QUERYEBOOKS_SQL, Arrays.asList(sql),new LoadEleRowMapper());
    }

    public List<PhysicalBook> getPhysicalBookBookList() throws DataAccessException, SQLException {
        String sql = "PHYSICAL";
        return DBUtil.query(QUERYEBOOKS_SQL, Arrays.asList(sql),new LoadPhyRowMapper());
    }

    public Book borrowBook(String isbn) throws SQLException {
        Book book = getBookByISBN(isbn);
        if (book.equals(PhysicalBook.class)){
            ((PhysicalBook)book).setStatus(BookStatus.BORROWED);
            DBUtil.update(UPDATESTATUS_SQL, Arrays.asList(BookStatus.BORROWED), book.getISBN());
        }
        return book;
    }

    public List<Book> getBookByName(String name) throws DataAccessException, SQLException {
        List<Book> validBooks = new ArrayList<Book>();
        List<ElectronicBook> electronicBooks = new ArrayList<ElectronicBook>();
        List<PhysicalBook> physicalBooks = new ArrayList<PhysicalBook>();
        List<Book> bookList = getBookList();

        for (Book book : bookList) {
            if (book.getName().contains(name)) {
                if (book.getType() == "ELECTRONIC") {
                    electronicBooks.add((ElectronicBook) book);
                } else {
                    physicalBooks.add((PhysicalBook) book);
                }
            }
        }
        Collections.sort(electronicBooks);
        Collections.sort(physicalBooks);
        validBooks.addAll(electronicBooks);
        validBooks.addAll(physicalBooks);
        return validBooks;
    }

}
