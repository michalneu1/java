package org.example;

public class ItemAlreadyReturnedException extends Exception {
    public ItemAlreadyReturnedException(String message) {
        super(message);
    }
}