package com.kiselev.time.model.dto.mapper;

import com.kiselev.time.model.dto.external.ExternalProfile;
import com.kiselev.time.model.dto.internal.Income;
import com.kiselev.time.model.dto.internal.Profile;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Mapper {

    public static Profile map(ExternalProfile externalProfile) {
        Profile profile = new Profile();

        profile.setUsername(externalProfile.getUsername());
        profile.setPassword(externalProfile.getPassword());
        profile.setIncomes(incomes(externalProfile.getIncomes()));
        profile.setSpending(externalProfile.getSpending());
        profile.setAge(externalProfile.getAge());
        profile.setAnonymous(externalProfile.isAnonymous());

        return profile;
    }

    private static Set<Income> incomes(List<Income> incomes) {
        return incomes.stream()
                .filter(income -> income.getMoney() != null
                        && income.getCurrency() != null
                        && income.getTax() != null)
                .collect(Collectors.toCollection(
                        LinkedHashSet::new
                ));
    }
}
