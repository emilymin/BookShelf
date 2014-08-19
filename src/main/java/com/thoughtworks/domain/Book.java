package com.thoughtworks.domain;

import java.math.BigDecimal;
import java.util.List;

public abstract class Book {
    private String ISBN;
    private String name;
    private BigDecimal price;
    private List<String> authors;

    public abstract String getLocation();

    protected Book() {
    }

    public Book(String ISBN, String name, BigDecimal price, List<String> authors) {
        this.ISBN = ISBN;
        this.name = name;
        this.price = price;
        this.authors = authors;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (ISBN != null ? !ISBN.equals(book.ISBN) : book.ISBN != null) return false;
        if (authors != null ? !authors.equals(book.authors) : book.authors != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ISBN != null ? ISBN.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }
}


