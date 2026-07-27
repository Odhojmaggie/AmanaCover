package com.AmanaCover.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtExpiration
                        )
                )
                .signWith(getSigningKey())
                .compact();
    }

    private Key getSigningKey() {

        return Keys.hmacShaKeyFor(
                secretKey.getBytes()
        );
    }

    public String extractUsername(
            String token
    ) {

        Claims claims = Jwts.parser()
                .verifyWith(
                        (javax.crypto.SecretKey)
                                getSigningKey()
                )
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }
}
