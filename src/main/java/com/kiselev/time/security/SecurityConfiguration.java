package com.kiselev.time.security;

import com.kiselev.time.repository.ProfileRepository;
import com.kiselev.time.security.details.UserDetailsServiceImpl;
import com.kiselev.time.security.encoder.SecurityEncoder;
import com.kiselev.time.security.filter.SecurityFilter;
import com.kiselev.time.security.jwt.JsonWebToken;
import com.kiselev.time.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
//@EnableWebSecurity TODO
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private ProfileRepository profileRepository;

    private AuthenticationService authenticationService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        TODO
//        http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http
//                .csrf()
//                .disable();
//
//        http
//                .cors();
//
//        http
//                .authorizeRequests()
//                .antMatchers("/health/**").permitAll()
//                .antMatchers("/api/rest/v1/time/authentication/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(
//                        securityFilter(),
//                        UsernamePasswordAuthenticationFilter.class);
//
//        http
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/menu", true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        TODO
//        auth
//                .userDetailsService(userDetailsService())
//                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    TODO
//    @Bean
//    public SecurityFilter securityFilter() {
//        return new SecurityFilter(
//                authenticationService
//        );
//    }

    @Bean
    public SecurityEncoder securityEncoder(BCryptPasswordEncoder passwordEncoder) {
        return new SecurityEncoder(
                passwordEncoder
        );
    }

    @Bean
    public JsonWebToken jsonWebToken() {
        return new JsonWebToken();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl(
                profileRepository
        );
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
