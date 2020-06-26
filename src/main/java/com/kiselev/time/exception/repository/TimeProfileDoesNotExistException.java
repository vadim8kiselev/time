package com.kiselev.time.exception.repository;

import com.kiselev.time.exception.type.TimeFormException;

public class TimeProfileDoesNotExistException extends TimeFormException {

    public TimeProfileDoesNotExistException() {
    }

    public TimeProfileDoesNotExistException(String message) {
        super(message);
    }
}
