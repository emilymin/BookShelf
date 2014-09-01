package com.thoughtworks.domain;

import java.math.BigDecimal;

public abstract class Book {
    private String ISBN;
    private String name;
    private BigDecimal price;
    private String authors;
    private String type;
    private BookStatus status;

    public abstract String getLocation();

    protected Book() {
    }

    public Book(String ISBN, String name, BigDecimal price, String authors, String type) {
        this.ISBN = ISBN;
        this.name = name;
        this.price = price;
        this.authors = authors;
        this.type = type;
        this.status = BookStatus.BORROWABLE;
    }

    public BookStatus getStatus() {
        return status;
    }

    public abstract void setStatus(BookStatus status);

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getAuthors() {
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
        if (type != null ? !type.equals(book.type) : book.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ISBN != null ? ISBN.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}