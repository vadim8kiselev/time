package com.kiselev.time.exception.repository;

import com.kiselev.time.exception.TimeException;

public class ProfileNotFoundException extends TimeException {

    public ProfileNotFoundException() {
    }

    public ProfileNotFoundException(String message) {
        super(message);
    }
}
