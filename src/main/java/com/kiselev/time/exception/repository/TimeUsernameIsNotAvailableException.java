package com.kiselev.time.exception.repository;

import com.kiselev.time.exception.type.TimeFieldException;

public class TimeUsernameIsNotAvailableException extends TimeFieldException {

    public TimeUsernameIsNotAvailableException() {
    }

    public TimeUsernameIsNotAvailableException(String message, Object... args) {
        super(message, args);
    }
}
