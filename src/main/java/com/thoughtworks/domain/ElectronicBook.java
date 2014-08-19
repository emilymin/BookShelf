package com.thoughtworks.domain;

import java.math.BigDecimal;
import java.util.List;

public class ElectronicBook extends Book {
    private String location;

    public ElectronicBook() {
    }

    public ElectronicBook(String ISBN, String name, BigDecimal price, List<String> authors, String location) {
        super(ISBN, name, price, authors);
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}
