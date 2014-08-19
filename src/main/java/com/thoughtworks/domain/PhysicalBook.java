package com.thoughtworks.domain;

import java.math.BigDecimal;
import java.util.List;

public class PhysicalBook extends Book {
    private BookStatus bookStatus;

    @Override
    public String getLocation() {
        return "Physical Book Location";
    }

    public PhysicalBook(){
    }

    public PhysicalBook(String ISBN, String name, BigDecimal price, List<String> authors) {
        super(ISBN, name, price, authors);
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhysicalBook)) return false;
        if (!super.equals(o)) return false;

        PhysicalBook that = (PhysicalBook) o;

        if (bookStatus != that.bookStatus) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bookStatus != null ? bookStatus.hashCode() : 0);
        return result;
    }
}
