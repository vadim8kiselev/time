package com.kiselev.time.function;

import com.google.common.collect.Sets;
import com.kiselev.time.model.dto.internal.Income;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractFunction {

    private final AuthenticationService authenticationService;

    private final ProfileService profileService;

    protected Profile profile() {
        String principal = authenticationService.principal();

        Profile profile = profileService.read(
                principal
        );

        if (profile == null) { // TODO
            profile = new Profile();
            profile.setUsername("Default");
            profile.setPassword("Default");
            profile.setAge(24);
            profile.setAnonymous(true);

            Income income = new Income();
            income.setId(1L);
            income.setCurrency("₽");
            income.setMain(true);
            income.setMoney(100_000L);
            income.setTax(13);
            profile.setIncomes(Sets.newHashSet(
                    income
            ));
        }

        return profile;
    }
}
