package com.kiselev.time.view.rest;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.dto.external.ExternalProfile;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.model.dto.mapper.Mapper;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest/v1/time/authentication")
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    public String registration(@RequestBody ExternalProfile profile) throws TimeException {
        return authenticationService.register(
                Mapper.map(profile)
        );
    }

    @PostMapping("/login")
    public String login(@RequestBody Profile profile) throws TimeException {
        return authenticationService.login(profile);
    }

    @PostMapping("/login/anonymous")
    public String loginAnonymously(@RequestBody Profile profile) throws TimeException {
        return authenticationService.loginAnonymously(profile);
    }
}
