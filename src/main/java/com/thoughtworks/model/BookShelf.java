package com.thoughtworks.model;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private List<Book> bookList;

    public BookShelf() {
        this.bookList = new ArrayList<Book>();
    }

    public int getBookShelfSize(){
        return bookList.size();
    }

    public List<PhysicalBook> getPhysicalBookList() {
        List<PhysicalBook> physicalBookList = new ArrayList<PhysicalBook>();
        for (Book book : bookList){
            if (book instanceof PhysicalBook)
                physicalBookList.add((PhysicalBook)book);
        }
        return physicalBookList;
    }

    public void addPhysicalBook(PhysicalBook book){
        bookList.add(book);
    }

    public void deleteBookByISBN(String isbn){
        for (Book book : bookList) {
            if (book.getISBN().equals(isbn))
                bookList.remove(book);
        }
    }
}
