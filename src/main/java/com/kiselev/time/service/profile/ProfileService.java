package com.kiselev.time.service.profile;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.exception.repository.TimeUsernameIsNotAvailableException;
import com.kiselev.time.exception.repository.TimeIncorrectUsernameOrPasswordException;
import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.repository.ProfileRepository;
import com.kiselev.time.security.encoder.SecurityEncoder;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

@RequiredArgsConstructor
public class ProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);

    private final ProfileRepository profileRepository;

    private final SecurityEncoder securityEncoder;

    public Profile save(Profile profile) throws TimeException {
        try {
            return profileRepository.save(
                    profile
            );
        } catch (DataIntegrityViolationException exception) {
            LOGGER.warn("Integrity violation while saving a profile", exception);
            throw new TimeUsernameIsNotAvailableException(
                    "Username %s is not available.",
                    profile.getUsername()
            );
        }
    }

    public Profile read(Profile profile) throws TimeException {
        Profile storedProfile = read(
                profile.getUsername()
        );
        if (storedProfile != null && securityEncoder.match(profile, storedProfile)) {
            return storedProfile;
        }
        throw new TimeIncorrectUsernameOrPasswordException("Incorrect username or password.");
    }

    public Profile read(String username) {
        return profileRepository.findByUsernameAndAnonymousFalse(
                username
        );
    }
}
