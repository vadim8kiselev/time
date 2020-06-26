package com.kiselev.time.service.validation;

import com.google.common.collect.Sets;
import com.kiselev.time.exception.TimeException;
import com.kiselev.time.exception.validation.TimeEmptyIncomesException;
import com.kiselev.time.exception.validation.TimeValuePatternViolationException;
import com.kiselev.time.exception.validation.TimeEmptyRequiredFieldException;
import com.kiselev.time.exception.validation.TimeValueRangeViolationException;
import com.kiselev.time.model.dto.db.Income;
import com.kiselev.time.model.dto.db.Profile;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ValidationService {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9]{3,20}$");

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]{3,20}$");

    public static final Set<String> CURRENCIES = Sets.newHashSet("₽", "$");

    public void registration(Profile profile) throws TimeException {
        validateUsername(profile);
        validatePassword(profile);

        validateIncome(profile);
    }

    public void login(Profile profile) throws TimeException {
        validateIsNotEmpty(profile.getUsername(), "Username cannot be blank.");
        validateIsNotEmpty(profile.getPassword(), "Password cannot be blank.");
    }

    public void loginAnonymously(Profile profile) throws TimeException {
        validateIncome(profile);
    }

    private void validateUsername(Profile profile) throws TimeException {
        String username = profile.getUsername();

        validateIsNotEmpty(username, "Username cannot be blank.");

        if (username.length() < 3) {
            throw new TimeValueRangeViolationException("Username is too short (minimum is 3 characters).");
        }

        if (username.length() > 20) {
            throw new TimeValueRangeViolationException("Username is too long (maximum is 20 characters).");
        }

        if (!USERNAME_PATTERN.matcher(username).matches()) {
            throw new TimeValuePatternViolationException("Username may only contain alphanumeric characters.");
        }
    }

    private void validatePassword(Profile profile) throws TimeException {
        String password = profile.getPassword();

        validateIsNotEmpty(password, "Password cannot be blank.");

        if (password.length() < 3) {
            throw new TimeValueRangeViolationException("Password is too short (minimum is 3 characters).");
        }

        if (password.length() > 20) {
            throw new TimeValueRangeViolationException("Password is too long (maximum is 20 characters).");
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new TimeValuePatternViolationException("Password may only contain alphanumeric characters.");
        }
    }

    private void validateIncome(Profile profile) throws TimeException {
        Set<Income> incomes = profile.getIncomes();

        validateMainIncome(incomes);

        for (Income income : incomes) {
            validateMoney(income.getMoney());
            validateCurrency(income.getCurrency());
            validateTax(income.getTax());
        }
    }

    private void validateMainIncome(Set<Income> incomes) throws TimeException {
        if (CollectionUtils.isEmpty(incomes)) {
            throw new TimeEmptyIncomesException("Incomes cannot be empty.");
        }

        List<Income> mainIncomes = incomes.stream()
                .filter(Income::isMain)
                .collect(Collectors.toList());

        if (mainIncomes.size() != 1) {
            throw new TimeEmptyIncomesException("There should be only one main income.");
        }

        Income mainIncome = mainIncomes.get(0);

        if (mainIncome.getMoney() == null) {
            throw new TimeEmptyRequiredFieldException("Income cannot be null.");
        }

        if (StringUtils.isEmpty(mainIncome.getCurrency())) {
            throw new TimeEmptyRequiredFieldException("Currency cannot be blank.");
        }

        if (mainIncome.getTax() == null) {
            throw new TimeEmptyRequiredFieldException("Tax cannot be empty.");
        }
    }

    private void validateMoney(Long money) throws TimeException {
        if (money != null && money < 0) {
            throw new TimeValueRangeViolationException("Income cannot be lower than 0");
        }

        // Validate maximum value
    }

    private void validateCurrency(String currency) throws TimeException {
        validateIsNotEmpty(currency, "Currency cannot be blank.");

        if (!CURRENCIES.contains(currency)) {
            throw new TimeValuePatternViolationException("Currency is not available.");
        }
    }

    private void validateTax(Integer tax) throws TimeException {
        if (tax != null && (tax < 0 || tax > 100)) {
            throw new TimeValueRangeViolationException("Tax cannot be lower than 0 and higher than 100");
        }
    }

    private void validateIsNotEmpty(String value, String message) throws TimeException {
        if (StringUtils.isEmpty(value)) {
            throw new TimeEmptyRequiredFieldException(message);
        }
    }
}
