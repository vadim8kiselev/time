package com.kiselev.time.function.usage;

import com.kiselev.time.function.AbstractFunction;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.model.response.UsageResponse;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;

public class UsageCostService extends AbstractFunction {

    public UsageCostService(AuthenticationService authenticationService,
                            ProfileService profileService) {
        super(authenticationService, profileService);
    }

    public UsageResponse calculate() {
        Profile profile = profile();

        return new UsageResponse(
                88L,
                888L
        );
    }
}
