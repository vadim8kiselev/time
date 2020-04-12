package com.kiselev.time.service.anonymity;

import com.kiselev.time.model.dto.Profile;

import java.util.UUID;

public class AnonymityService {

    public Profile generateAnonymousProfile() {
        return generateAnonymousProfile(null);
    }

    public Profile generateAnonymousProfile(Profile profile) {
        Profile anonymousProfile = new Profile();
        anonymousProfile.setUsername("Anonymous_Username#" + UUID.randomUUID().toString());
        anonymousProfile.setPassword("Anonymous_Password");
        if (profile != null) {
            anonymousProfile.setSalary(profile.getSalary());
            anonymousProfile.setCurrency(profile.getCurrency());
            anonymousProfile.setHours(profile.getHours());
            anonymousProfile.setTax(profile.getTax());
            anonymousProfile.setAge(profile.getAge());
        }
        anonymousProfile.setAnonymous(true);
        return anonymousProfile;
    }
}
