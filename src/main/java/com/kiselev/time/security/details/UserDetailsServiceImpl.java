package com.kiselev.time.security.details;

import com.kiselev.time.model.dto.internal.Profile;
import com.kiselev.time.repository.ProfileRepository;
import com.kiselev.time.security.constants.SecurityConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUsernameAndAnonymousFalse(username);

        if (profile != null) {
            return new User(
                    profile.getUsername(),
                    profile.getPassword(),
                    SecurityConstants.AUTHORITIES
            );
        }

        throw new UsernameNotFoundException(String.format("Profile with username [%s] does not exist", username));
    }
}
