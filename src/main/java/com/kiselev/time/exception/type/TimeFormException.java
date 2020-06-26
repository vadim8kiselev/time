package com.kiselev.time.exception.type;

import com.kiselev.time.exception.TimeException;

public class TimeFormException extends TimeException {

    public TimeFormException() {
    }

    public TimeFormException(String message) {
        super(message);
    }

    public TimeFormException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeFormException(String message, Object... args) {
        super(message, args);
    }
}
