package com.thoughtworks.mapper;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.BookStatus;
import com.thoughtworks.domain.ElectronicBook;
import com.thoughtworks.domain.PhysicalBook;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookShelfMapper {
    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";

    private final static String DB_URL = "jdbc:mysql://localhost:3306/BOOKS";
    private final static String DB_NAME = "root";
    private final static String DB_PWd = "";

    private JdbcTemplate jdbcTemplate;
    static final String QUERYBOOK_SQL = "SELECT * FROM BOOKS WHERE ISBN =";
    static final String QUERYBOOKS_SQL = "SELECT * FROM BOOKS";
    static final String QUERYEBOOKS_SQL = "SELECT * FROM BOOKS WHERE TYPE = ";
    static final String INSERTBOOK_SQL = "INSERT INTO BOOKS (ISBN, NAME, AUTHOR, LOCATION, TYPE) VALUES(?, ?, ?, ?, ?)";
    static final String UPDATESTATUS_SQL = "UPDATE BOOKS" + "SET STATUS = ? WHERE ISBN = ?";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int addBook(Book book) {
        return jdbcTemplate.update(INSERTBOOK_SQL, book.getISBN(), book.getName(), book.getAuthors(), book.getLocation(), book.getType());
    }

    public Book getBookByISBN(String isbn) {
        return jdbcTemplate.queryForObject(QUERYBOOK_SQL + isbn, Book.class);
    }

    public List<Book> getBookList() {
        return jdbcTemplate.query(QUERYBOOKS_SQL,new LoadRowMapper());
    }

    public List<ElectronicBook> getEBookBookList() {
        return jdbcTemplate.query(QUERYEBOOKS_SQL + "ELECTRONIC",new LoadEleRowMapper());
    }

    public Book borrowBook(String isbn){
        Book book = getBookByISBN(isbn);
        if (book.equals(PhysicalBook.class)){
            ((PhysicalBook)book).setStatus(BookStatus.BORROWED);
            jdbcTemplate.update(UPDATESTATUS_SQL, BookStatus.BORROWED, book.getISBN());
        }
        return book;
    }

    public List<Book> getBookByName(String name) {
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
        validBooks.addAll(electronicBooks);
        validBooks.addAll(physicalBooks);
        return validBooks;
    }

}
