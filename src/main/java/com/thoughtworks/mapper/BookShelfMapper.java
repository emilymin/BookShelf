package com.thoughtworks.mapper;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.BookStatus;
import com.thoughtworks.domain.ElectronicBook;
import com.thoughtworks.domain.PhysicalBook;
import com.thoughtworks.exception.DataAccessException;
import com.thoughtworks.utils.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookShelfMapper {

    static final String QUERYBOOK_SQL = "SELECT * FROM BOOKS WHERE ISBN = \"?\"";
    static final String QUERYEBOOKS_SQL = "SELECT * FROM BOOKS WHERE TYPE = \"?\"";
    static final String INSERTBOOK_SQL = "INSERT INTO BOOKS (ISBN, NAME, AUTHOR, LOCATION, TYPE) VALUES(\"?\", \"?\", \"?\", \"?\", \"?\")";
    static final String UPDATESTATUS_SQL = "UPDATE BOOKS" + "SET STATUS = ? WHERE ISBN = ?";

    public int addBook(Book book) throws SQLException {
        return DBUtil.update(INSERTBOOK_SQL, Arrays.asList(book.getISBN(), book.getName(), book.getAuthors(), book.getLocation(), book.getType()));
    }

    public List<ElectronicBook> getEBookBookList() throws DataAccessException, SQLException {
        String sql = "ELECTRONIC";
        List<ElectronicBook> bookList = DBUtil.query(QUERYEBOOKS_SQL, Arrays.asList(sql),new LoadEleRowMapper());
        return bookList;
    }

    public List<PhysicalBook> getPhysicalBookBookList() throws DataAccessException, SQLException {
        String sql = "PHYSICAL";
        return DBUtil.query(QUERYEBOOKS_SQL, Arrays.asList(sql),new LoadPhyRowMapper());
    }

    public List<Book> getBookList() throws DataAccessException, SQLException {
        List<Book> bookList = new ArrayList<Book>();
        bookList.addAll(getEBookBookList());
        bookList.addAll(getPhysicalBookBookList());
        return bookList;
    }

    public List<Book> getBookByName(String name) throws DataAccessException, SQLException {
        List<Book> validBooks = new ArrayList<Book>();
        List<ElectronicBook> electronicBooks = new ArrayList<ElectronicBook>();
        List<PhysicalBook> physicalBooks = new ArrayList<PhysicalBook>();
        List<Book> bookList = getBookList();
        String electronic = "ELECTRONIC";
        String physical = "PHYSICAL";

        for (Book book : bookList) {
            if (book.getName().contains(name)) {
                if (book.getType().equals(physical)) {
                    physicalBooks.add((PhysicalBook) book);
                } else if (book.getType().equals(electronic)){
                    electronicBooks.add((ElectronicBook) book);
                }
            }
        }
        Collections.sort(electronicBooks);
        Collections.sort(physicalBooks);
        validBooks.addAll(electronicBooks);
        validBooks.addAll(physicalBooks);
        return validBooks;
    }

    public Book getBookByISBN(String isbn) throws DataAccessException, SQLException {
        if (isbn == null) throw new NullPointerException();
        List<ElectronicBook> eBookList = null;
        List<PhysicalBook> physicalBookList = null;
        List<Book> bookList = new ArrayList<Book>();
        eBookList = DBUtil.query(QUERYBOOK_SQL, Arrays.asList(isbn), new LoadEleRowMapper());
        physicalBookList = DBUtil.query(QUERYBOOK_SQL, Arrays.asList(isbn), new LoadPhyRowMapper());

        bookList.addAll(eBookList);
        bookList.addAll(physicalBookList);

        return bookList.get(0);
    }

    public Book borrowBook(String isbn) throws SQLException, DataAccessException {
        Book book = getBookByISBN(isbn);
        if (book.equals(PhysicalBook.class)){
            ((PhysicalBook)book).setStatus(BookStatus.BORROWED);
            DBUtil.update(UPDATESTATUS_SQL, Arrays.asList(BookStatus.BORROWED.toString(), book.getISBN()));
        }
        return book;
    }
}
