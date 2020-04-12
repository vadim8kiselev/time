package com.kiselev.time.security.encoder;

import com.kiselev.time.model.dto.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
public class SecurityEncoder {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public boolean match(Profile rawProfile, Profile encodedProfile) {
        return bCryptPasswordEncoder.matches(
                rawProfile.getPassword(),
                encodedProfile.getPassword()
        );
    }

    public Profile encode(Profile profile) {
        Profile encryptedProfile = new Profile(profile);
        encodePassword(encryptedProfile);
        return encryptedProfile;
    }

    private void encodePassword(Profile profile) {
        profile.setPassword(
                bCryptPasswordEncoder.encode(
                        profile.getPassword()
                )
        );
    }
}
