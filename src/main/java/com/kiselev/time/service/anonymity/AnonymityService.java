package com.kiselev.time.service.anonymity;

import com.kiselev.time.model.dto.internal.Profile;

import java.util.UUID;

public class AnonymityService {

    public Profile generateAnonymousProfile(Profile profile) {
        Profile anonymousProfile = new Profile();
        anonymousProfile.setUsername("Anonymous_Username#" + UUID.randomUUID().toString());
        anonymousProfile.setPassword("Anonymous_Password");
        if (profile != null) {
            anonymousProfile.setIncomes(profile.getIncomes());
            anonymousProfile.setSpending(profile.getSpending());
            anonymousProfile.setAge(profile.getAge());
        }
        anonymousProfile.setAnonymous(true);
        return anonymousProfile;
    }
}
