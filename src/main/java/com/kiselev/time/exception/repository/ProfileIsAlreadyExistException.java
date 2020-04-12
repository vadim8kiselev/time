package com.kiselev.time.exception.repository;

import com.kiselev.time.exception.TimeException;

public class ProfileIsAlreadyExistException extends TimeException {

    public ProfileIsAlreadyExistException() {
    }

    public ProfileIsAlreadyExistException(String message, Object... args) {
        super(message, args);
    }
}
