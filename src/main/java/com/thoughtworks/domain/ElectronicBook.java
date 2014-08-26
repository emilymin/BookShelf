package com.thoughtworks.domain;

import java.math.BigDecimal;

public class ElectronicBook extends Book implements Comparable<ElectronicBook>{
    private String location;
    private BookStatus status;

    public ElectronicBook() {
    }

    public ElectronicBook(String ISBN, String name, BigDecimal price, String authors, String location, String type) {
        super(ISBN, name, price, authors, type);
        this.location = location;
        setStatus(BookStatus.BORROWABLE);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus bookStatus) {
        this.status = BookStatus.BORROWABLE;
    }

    @Override
    public String getLocation() {
        return "Electronic Book Location";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectronicBook)) return false;
        if (!super.equals(o)) return false;

        ElectronicBook that = (ElectronicBook) o;

        if (location != null ? !location.equals(that.location) : that.location != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    public int compareTo(ElectronicBook o) {
       return this.getISBN().compareTo(o.getISBN());
    }
}
