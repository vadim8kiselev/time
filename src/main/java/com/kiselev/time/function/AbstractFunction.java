package com.kiselev.time.function;

import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractFunction {

    private final AuthenticationService authenticationService;

    private final ProfileService profileService;

    protected Profile profile() {
        String principal = authenticationService.principal();

        return profileService.read(
                principal
        );
    }
}
