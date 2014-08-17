package com.thoughtworks.model;

public abstract class Book {
    private String ISBN;
    private String name;
    private double price;
    private String authors;
    private String location;

    public abstract String getLocation();

    protected Book() {
    }

    public Book(String ISBN, String name, double price, String authors) {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthors() {
        return authors;
    }
}
