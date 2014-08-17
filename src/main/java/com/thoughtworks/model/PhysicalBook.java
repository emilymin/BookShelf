package com.thoughtworks.model;

public class PhysicalBook extends Book {
    @Override
    public String getLocation() {
        return "Physical Book Location";
    }

    public PhysicalBook(){
    }

    public PhysicalBook(String ISBN, String name, double price, String authors) {
        super(ISBN, name, price, authors);
    }
}
