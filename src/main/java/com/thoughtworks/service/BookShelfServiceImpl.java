package com.thoughtworks.service;

import com.thoughtworks.mapper.BookShelfMapper;
import com.thoughtworks.domain.Book;
import com.thoughtworks.domain.PhysicalBook;

import java.util.List;

public class BookShelfServiceImpl implements BookShelfService {

    public PhysicalBook getBookByISBN(String s) {
        PhysicalBook book = null;
        BookShelfMapper bookShelfMapper = new BookShelfMapper();
        try {
             book = bookShelfMapper.getPhysicalBookByISBN(s);
        }
        catch (Exception e){
            System.out.println("no physical book for this ISBN");
        }
        finally {
            return book;
        }
    }

    public List<Book> getBookList() {
        BookShelfMapper bookShelfMapper = new BookShelfMapper();
        return bookShelfMapper.getBookList();
    }

    public void addPhysicalBook(PhysicalBook book) {
        BookShelfMapper bookShelfMapper = new BookShelfMapper();
        bookShelfMapper.addPhysicalBook(book);
    }

    public void deleteBookByISBN(String s) {
        BookShelfMapper bookShelfMapper = new BookShelfMapper();
        bookShelfMapper.deletePhysicalBookByISBN(s);
    }

    public void deleteAllBooks() {
        BookShelfMapper bookShelfMapper = new BookShelfMapper();
        bookShelfMapper.deletePhysicalBooks();
    }
}