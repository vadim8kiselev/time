package com.kiselev.time.service.authentication;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.exception.type.TimeSecurityException;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.security.constants.SecurityConstants;
import com.kiselev.time.security.encoder.SecurityEncoder;
import com.kiselev.time.security.jwt.JsonWebToken;
import com.kiselev.time.service.anonymity.AnonymityService;
import com.kiselev.time.service.profile.ProfileService;
import com.kiselev.time.service.validation.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@RequiredArgsConstructor
public class AuthenticationService {

    private final JsonWebToken jsonWebToken;

    private final ProfileService profileService;

    private final SecurityEncoder securityEncoder;

    private final AnonymityService anonymityService;

    private final ValidationService validationService;

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    public boolean isLoggedInIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return !(auth instanceof AnonymousAuthenticationToken);
    }

    public String principal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (String) authentication.getPrincipal();
    }

    public String register(Profile profile) throws TimeException {
        // Validate
        validationService.registration(profile);

        // Encode profile
        Profile encodedProfile =
                securityEncoder.encode(profile);

        // Save to database
        Profile storedProfile =
                profileService.save(encodedProfile);

        // JSON Web Token
        String token =
                jsonWebToken.build(storedProfile);

        // Authenticate
        authenticate(profile);

        return token;
    }

    public String login(Profile profile) throws TimeException {
        // Validate
        validationService.login(profile);

        // Read from database
        Profile storedProfile =
                profileService.read(profile);

        // JSON Web Token
        String token =
                jsonWebToken.build(storedProfile);

        // Authenticate
        authenticate(profile);

        return token;
    }

    public String loginAnonymously(Profile profile) throws TimeException {
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

        // JSON Web Token
        String token =
                jsonWebToken.build(storedProfile);

        // Authenticate
        authenticate(anonymousProfile);

        return token;
    }

    public void authenticate(String token) throws TimeSecurityException {
        String username =
                jsonWebToken.parse(token);

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(),
                        userDetails.getPassword(),
                        userDetails.getAuthorities());

        // By some reason we don't need to authenticate users while using JWT token
        // Authentication authentication =
        //        authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public void authenticate(Profile profile) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        profile.getUsername(),
                        profile.getPassword(),
                        SecurityConstants.AUTHORITIES);

        Authentication authentication =
                authenticationManager.authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
