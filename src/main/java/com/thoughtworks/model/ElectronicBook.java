package com.thoughtworks.model;

public class ElectronicBook extends Book {
    @Override
    public String getLocation() {
        return "Electronic Book Location";
    }

    public ElectronicBook() {
    }

    public ElectronicBook(String ISBN, String name, double price, String authors) {
        super(ISBN, name, price, authors);
    }
}
