package com.kiselev.time.view.rest;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.model.dto.ui.UIProfile;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest/v1/time")
public class AuthenticationController {
    
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    public String registration(@RequestBody UIProfile uiProfile) throws TimeException {
        Profile profile = new Profile(uiProfile);
        return authenticationService.register(profile);
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
