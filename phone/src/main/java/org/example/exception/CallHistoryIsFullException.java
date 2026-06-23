package org.example.exception;

public class CallHistoryIsFullException extends RuntimeException {
    public CallHistoryIsFullException(String message) {
        super(message);
    }
}
