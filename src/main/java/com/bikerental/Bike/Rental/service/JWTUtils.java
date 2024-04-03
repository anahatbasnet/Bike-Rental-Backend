package com.bikerental.Bike.Rental.service;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import io.jsonwebtoken.Claims;

@Component
public class JWTUtils {
    private SecretKey Key;
    private static final long EXPIRATION_TIME = 86400000;
    public JWTUtils(){
        String secretString ="857s86d7f87sd867f867sd86f786sd7f68s7df87w8e8f8e48f4e84fe84f8ef4s651v21cs24d";
        byte[] keyBytes = Base64.getDecoder().decode(secretString.getBytes(StandardCharsets.UTF_8));
        this.Key = new SecretKeySpec(keyBytes,"HmacSHA256");
    }
    public String generateToken(UserDetails userDetails){
        return Jwts.builder()

                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();

    }
    public String generateRefreshToken(HashMap<String, Object> claims, UserDetails userDetails){
        return Jwts.builder()
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Key)
                .compact();
    }

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }
    private <T> T extractClaims(String token, Function<Claims, T> claimsTFunction){
        return claimsTFunction.apply(Jwts.parser().verifyWith(Key).build().parseSignedClaims(token)
                .getPayload());
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    public boolean isTokenExpired(String token){
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }
}
