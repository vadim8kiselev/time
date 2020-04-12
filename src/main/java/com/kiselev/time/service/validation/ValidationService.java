package com.kiselev.time.service.validation;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.dto.Profile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ValidationService {

    public void registration(Profile profile) throws TimeException {

    }

    public void login(Profile profile) throws TimeException {

    }

    public void loginAnonymously(Profile profile) throws TimeException {

    }

    private void validateUsername(Profile profile) {

    }
}
