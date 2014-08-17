package com.thoughtworks.model;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BookShelfTest {

    @Test
    public void should_get_physical_books() throws Exception {
        PhysicalBook physicalBook1 = new PhysicalBook("ISBN1", "Book1", 20.0, "author1");
        BookShelf bookShelf = new BookShelf();

        bookShelf.addPhysicalBook(physicalBook1);
        List<PhysicalBook> bookList = bookShelf.getPhysicalBookList();

        assertThat(bookList.size(), is(1));
    }

    @Test
    public void should_delete_book_by_isbn() throws Exception {
        PhysicalBook physicalBook1 = new PhysicalBook("ISBN1", "Book1", 20.0, "author1");
        PhysicalBook physicalBook2 = new PhysicalBook("ISBN2", "Book2", 20.0, "author2");
        BookShelf bookShelf = new BookShelf();
        bookShelf.addPhysicalBook(physicalBook1);
        bookShelf.addPhysicalBook(physicalBook2);
        bookShelf.deleteBookByISBN("ISBN1");

        assertThat(bookShelf.getBookShelfSize(), is(1));
    }
}