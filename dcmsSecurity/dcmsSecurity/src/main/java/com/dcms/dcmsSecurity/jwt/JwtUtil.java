package com.dcms.dcmsSecurity.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    // Your plain text key (ensure it is sufficiently long or padded)
    private static final String SECRET_KEY = "myverysecuresecretkeywith32chars";
    private static final long EXPIRATION_TIME = 86400000;


    public String generateToken(String username, String role) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                .parseClaimsJws(token)
                .getBody();
    }

    /*public boolean validateToken(String token) {
        try {
            .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }*/
}