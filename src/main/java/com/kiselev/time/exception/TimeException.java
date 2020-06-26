package com.kiselev.time.exception;

public class TimeException extends Exception {

    public TimeException() {
    }

    public TimeException(String message) {
        super(message);
    }

    public TimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeException(String message, Object... args) {
        this(String.format(message, args));
    }
}
