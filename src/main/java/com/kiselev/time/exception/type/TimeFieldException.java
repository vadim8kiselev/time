package com.kiselev.time.exception.type;

import com.kiselev.time.exception.TimeException;

public class TimeFieldException extends TimeException {

    public TimeFieldException() {
    }

    public TimeFieldException(String message) {
        super(message);
    }

    public TimeFieldException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeFieldException(String message, Object... args) {
        super(message, args);
    }
}
