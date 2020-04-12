package com.kiselev.time.service.authentication;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.dto.Profile;
import com.kiselev.time.security.constants.SecurityConstants;
import com.kiselev.time.security.encoder.SecurityEncoder;
import com.kiselev.time.service.anonymity.AnonymityService;
import com.kiselev.time.service.profile.ProfileService;
import com.kiselev.time.service.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class AuthenticationService {

    private final ProfileService profileService;

    private final SecurityEncoder securityEncoder;

    private final AnonymityService anonymityService;

    private final ValidationService validationService;

    private final AuthenticationManager authenticationManager;

    public Profile profile;

    public Profile profile() {
        if (profile != null) {
            return profile;
        }
        throw new RuntimeException("Profile was not found in session");
    }

    public void register(Profile profile) throws TimeException {
        // Validate
        validationService.registration(profile);

        // Encode profile
        Profile encodedProfile =
                securityEncoder.encode(profile);

        // Save to database
        Profile storedProfile =
                profileService.save(encodedProfile);

        // Save to session
        this.profile = storedProfile;

        // Authenticate
        authenticate(profile);
    }

    public void login(Profile profile) throws TimeException {
        // Validate
        validationService.login(profile);

        // Read from database
        Profile storedProfile =
                profileService.read(profile);

        // Save to session
        this.profile = storedProfile;

        // Authenticate
        authenticate(profile);
    }

    public void loginAnonymously(Profile profile) throws TimeException {
        // Validate
        validationService.loginAnonymously(profile);

        // Generate anonymous profile
        Profile anonymousProfile =
                anonymityService.generateAnonymousProfile(profile);

        // Encode profile
        Profile encodedProfile =
                securityEncoder.encode(anonymousProfile);

        // Read from database
        Profile storedProfile =
                profileService.read(encodedProfile);

        // Save to session
        this.profile = storedProfile;

        // Authenticate
        authenticate(anonymousProfile);
    }

    private void authenticate(Profile profile) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        profile.getUsername(),
                        profile.getPassword(),
                        SecurityConstants.AUTHORITIES);

        SecurityContextHolder.getContext()
                .setAuthentication(
                        authenticationManager.authenticate(token)
                );
    }
}
