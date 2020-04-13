package com.kiselev.time.service.validation;

import com.google.common.collect.Sets;
import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.dto.Profile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class ValidationService {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{3,20}$");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{3,20}$");

    public static final Set<String> CURRENCIES = Sets.newHashSet("₽", "$");

    public void registration(Profile profile) throws TimeException {
        validateUsername(profile);
        validatePassword(profile);

        validateSalary(profile);
        validateCurrency(profile);
        validateTax(profile);
    }

    public void login(Profile profile) throws TimeException {
        // Currently empty
    }

    public void loginAnonymously(Profile profile) throws TimeException {
        validateSalary(profile);
        validateCurrency(profile);
        validateTax(profile);
    }

    private void validateUsername(Profile profile) {
        String username = profile.getUsername();

        if (StringUtils.isNotEmpty(username)) {
            throw new RuntimeException("Username cannot be blank.");
        }

        if (username.length() <= 3) {
            throw new RuntimeException("Username is too short (minimum is 3 characters).");
        }

        if (username.length() > 20) {
            throw new RuntimeException("Username is too long (maximum is 20 characters).");
        }

        if (USERNAME_PATTERN.matcher(username).matches()) {
            throw new RuntimeException("Username may only contain alphanumeric characters.");
        }
    }

    private void validatePassword(Profile profile) {
        String password = profile.getPassword();

        if (StringUtils.isNotEmpty(password)) {
            throw new RuntimeException("Password cannot be blank.");
        }

        if (password.length() <= 3) {
            throw new RuntimeException("Password is too short (minimum is 3 characters).");
        }

        if (password.length() > 20) {
            throw new RuntimeException("Password is too long (maximum is 20 characters).");
        }

        if (PASSWORD_PATTERN.matcher(password).matches()) {
            throw new RuntimeException("Password may only contain alphanumeric characters.");
        }
    }

    private void validateSalary(Profile profile) {
        Long salary = profile.getSalary();

        if (salary == null) {
            throw new RuntimeException("Salary cannot be null.");
        }

        if (salary < 0) {
            throw new RuntimeException("Salary cannot be lower than 0");
        }
    }

    private void validateCurrency(Profile profile) {
        String currency = profile.getCurrency();

        if (StringUtils.isNotEmpty(currency)) {
            throw new RuntimeException("Currency cannot be blank.");
        }

        if (!CURRENCIES.contains(currency)) {
            throw new RuntimeException("Currency is not available.");
        }
    }

    private void validateTax(Profile profile) {
        Integer tax = profile.getTax();

        if (tax == null) {
            throw new RuntimeException("Tax cannot be empty.");
        }

        if (tax < 0 || tax > 100) {
            throw new RuntimeException("Tax cannot be lower than 0 and higher than 100");
        }
    }
}
