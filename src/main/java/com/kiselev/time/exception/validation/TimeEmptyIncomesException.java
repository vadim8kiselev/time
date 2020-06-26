package com.kiselev.time.exception.validation;

import com.kiselev.time.exception.type.TimeFieldException;

public class TimeEmptyIncomesException extends TimeFieldException {

    public TimeEmptyIncomesException() {
    }

    public TimeEmptyIncomesException(String message) {
        super(message);
    }
}
