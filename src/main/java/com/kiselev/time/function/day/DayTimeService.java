package com.kiselev.time.function.day;

import com.kiselev.time.function.AbstractFunction;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.model.response.DayTimeResponse;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;

public class DayTimeService extends AbstractFunction {

    public DayTimeService(AuthenticationService authenticationService,
                          ProfileService profileService) {
        super(authenticationService, profileService);
    }

    public DayTimeResponse calculate() {
        Profile profile = profile();

        Integer age = profile.getAge();

        return new DayTimeResponse(
                age
        );
    }
}
