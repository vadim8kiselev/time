package com.kiselev.time.exception.validation;

import com.kiselev.time.exception.type.TimeFieldException;

public class TimeEmptyRequiredFieldException extends TimeFieldException {

    public TimeEmptyRequiredFieldException() {
    }

    public TimeEmptyRequiredFieldException(String message) {
        super(message);
    }
}
