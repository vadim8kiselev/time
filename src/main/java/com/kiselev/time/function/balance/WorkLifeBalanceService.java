package com.kiselev.time.function.balance;

import com.google.common.collect.Maps;
import com.kiselev.time.function.AbstractFunction;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.model.response.WorkLifeBalanceResponse;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;

public class WorkLifeBalanceService extends AbstractFunction {

    public WorkLifeBalanceService(AuthenticationService authenticationService,
                                  ProfileService profileService) {
        super(authenticationService, profileService);
    }

    public WorkLifeBalanceResponse calculate() {
        Profile profile = profile();

        return new WorkLifeBalanceResponse(
                Maps.newHashMap()
        );
    }
}
