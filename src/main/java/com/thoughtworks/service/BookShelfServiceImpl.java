package com.thoughtworks.service;

import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.ElectronicBook;
import com.thoughtworks.exception.BookNotFoundException;
import com.thoughtworks.mapper.BookShelfMapper;

import java.sql.SQLException;
import java.util.*;

public class BookShelfServiceImpl implements BookShelfService {

    public Book borrowBook(String bookIsbn) throws BookNotFoundException {
        BookShelfMapper mapper = new BookShelfMapper();
        Book book = mapper.borrowBook(bookIsbn);
        if (book.equals(null))
            throw new BookNotFoundException();
        return book;
    }

    public List<Book> queryBookByName(String bookName) {
        return null;
    }

    public boolean addBook(Book book) throws BookNotFoundException, SQLException {
        BookShelfMapper mapper = new BookShelfMapper();
        if (book.getISBN() == null && book.getType() == null){
            return false;
        }
        mapper.addBook(book);
        return true;
    }

    public Map<String, Book> queryAllEBookNames() {
        BookShelfMapper mapper = new BookShelfMapper();
        List<ElectronicBook>  books = mapper.getEBookBookList();

//        Collections.sort(books, new Comparator<ElectronicBook>() {
//            public int compare(ElectronicBook book1, ElectronicBook book2) {
//                return book1.getName();
//            }
//        });
        Map<String, Book> bookMap = new HashMap<String, Book>();
        for (Book book : books){
            bookMap.put(book.getName(), book);
        }
        return bookMap;
    }

    public int bookAmount() {
        BookShelfMapper mapper = new BookShelfMapper();
        List<Book> bookList = mapper.getBookList();
        return bookList.size();
    }
}