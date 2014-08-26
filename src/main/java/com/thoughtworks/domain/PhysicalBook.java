package com.thoughtworks.domain;

import java.math.BigDecimal;

public class PhysicalBook extends Book implements Comparable<PhysicalBook>{
    private BookStatus status;

    @Override
    public String getLocation() {
        return "Physical Book Location";
    }

    public PhysicalBook(){
    }

    public PhysicalBook(String ISBN, String name, BigDecimal price, String authors, String type) {
        super(ISBN, name, price, authors, type);
    }

    @Override
    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public BookStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhysicalBook)) return false;
        if (!super.equals(o)) return false;

        PhysicalBook that = (PhysicalBook) o;

        if (status != that.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public int compareTo(PhysicalBook o) {
        return this.getISBN().compareTo(o.getISBN());
    }
}
