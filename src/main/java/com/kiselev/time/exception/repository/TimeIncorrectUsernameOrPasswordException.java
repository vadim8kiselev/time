package com.kiselev.time.exception.repository;

import com.kiselev.time.exception.type.TimeFormException;

public class TimeIncorrectUsernameOrPasswordException extends TimeFormException {

    public TimeIncorrectUsernameOrPasswordException() {
    }

    public TimeIncorrectUsernameOrPasswordException(String message) {
        super(message);
    }
}
