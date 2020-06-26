package com.kiselev.time.security.constants;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public interface SecurityConstants {

    String AUTHENTICATION_HEADER = "Authorization";

    String BEARER_PREFIX = "Bearer ";

    List<GrantedAuthority> AUTHORITIES =
            Lists.newArrayList(new SimpleGrantedAuthority("profile"));
}
