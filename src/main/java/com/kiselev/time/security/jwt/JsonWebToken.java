package com.kiselev.time.security.jwt;

import com.kiselev.time.exception.type.TimeSecurityException;
import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.security.constants.SecurityConstants;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;

public class JsonWebToken {

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length}")
    private long expirationTime;

    @PostConstruct
    protected void init() {
        this.secretKey = Base64
                .getEncoder()
                .encodeToString(
                        this.secretKey.getBytes()
                );
    }

    public String build(Profile profile) {
        Date now = new Date();
        String token = Jwts.builder()
                .setSubject(profile.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return SecurityConstants.BEARER_PREFIX + token;
    }

    public String parse(String token) throws TimeSecurityException {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (JwtException | IllegalArgumentException exception) {
            throw new TimeSecurityException(
                    "Expired or invalid JWT token",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
