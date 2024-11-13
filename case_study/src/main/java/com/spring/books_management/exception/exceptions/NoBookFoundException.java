package com.spring.books_management.exception.exceptions;

public class NoBookFoundException extends RuntimeException {
    public NoBookFoundException(String message) {
        super(message);
    }
}
