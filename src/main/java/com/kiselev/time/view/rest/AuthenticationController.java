package com.kiselev.time.view.rest;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.dto.external.ExternalProfile;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.model.dto.mapper.Mapper;
import com.kiselev.time.model.response.StringResponse;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StringResponse> registration(@RequestBody ExternalProfile profile) throws TimeException {
        String token = authenticationService.register(
                Mapper.map(profile)
        );
        return ResponseEntity.ok(
                StringResponse.of(token)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<StringResponse> login(@RequestBody Profile profile) throws TimeException {
        String token = authenticationService.login(
                profile
        );
        return ResponseEntity.ok(
                StringResponse.of(token)
        );
    }

    @PostMapping("/login/anonymous")
    public ResponseEntity<StringResponse> loginAnonymously(@RequestBody Profile profile) throws TimeException {
        String token = authenticationService.loginAnonymously(
                profile
        );
        return ResponseEntity.ok(
                StringResponse.of(token)
        );
    }
}
