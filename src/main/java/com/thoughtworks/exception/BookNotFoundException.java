package com.thoughtworks.exception;

public class BookNotFoundException extends Exception{
    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String s) {
        super(s);
    }

    public BookNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BookNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
