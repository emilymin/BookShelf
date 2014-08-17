package com.thoughtworks.service;

import com.thoughtworks.model.Book;
import com.thoughtworks.model.PhysicalBook;

import java.util.List;

public interface BookShelfService {
    PhysicalBook getPhysicalBookByISBN(String s);
    List<Book> getPhysicalBookList();
    void addPhysicalBook(PhysicalBook book);
    void deletePhysicalBookByISBN(String s);
    void deleteAllPhysicalBooks();
}
