package com.kiselev.time.security.filter;

import com.kiselev.time.exception.type.TimeSecurityException;
import com.kiselev.time.security.constants.SecurityConstants;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;

    private RequestMatcher functionMatcher =
            new AntPathRequestMatcher("/function/**");

    private RequestMatcher menuMatcher =
            new AntPathRequestMatcher("/menu/**");

    private RequestMatcher userMatcher =
            new AntPathRequestMatcher("/user/**");

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        if (functionMatcher.matches(httpServletRequest)
                || menuMatcher.matches(httpServletRequest)
                || userMatcher.matches(httpServletRequest)) {
            try {
                authenticationService.authenticate(
                        parseToken(httpServletRequest)
                );
            } catch (TimeSecurityException exception) {
                SecurityContextHolder.clearContext();
                httpServletResponse.sendError(exception.getHttpStatus().value(), exception.getMessage());
                return;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String parseToken(HttpServletRequest httpServletRequest) throws TimeSecurityException {
        String bearerToken = httpServletRequest.getHeader(SecurityConstants.AUTHENTICATION_HEADER);

        if (bearerToken != null && bearerToken.startsWith(SecurityConstants.BEARER_PREFIX)) {
            return bearerToken.substring(SecurityConstants.BEARER_PREFIX.length());
        }

        throw new TimeSecurityException("Token is not present", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
