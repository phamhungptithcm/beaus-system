package com.beaus.auth.application.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.beaus.auth.application.gateway.IJwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService implements IJwtService{
	
	@Value("${jwt.secret}")
    private String jwtSecret;
    
    @Value("${jwt.expiration}")
    private int jwtExpirationInMs;

    @Value("${jwt.refresh.expiration}")
    private long refreshExpirationInMs;  // Expiration time for refresh tokens in milliseconds.

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));  // Generate signing key.
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())  // Set the subject (username).
                .issuedAt(new Date())  // Set the issued date.
                .expiration(new Date(System.currentTimeMillis() + jwtExpirationInMs))  // Set the expiration date.
                .signWith(getSigningKey())  // Sign the token using the new `signWith()` method.
                .compact();  // Build the token.
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())  // Set the subject (username).
                .issuedAt(new Date())  // Set the issued date.
                .expiration(new Date(System.currentTimeMillis() + refreshExpirationInMs))  // Set the refresh expiration date.
                .signWith(getSigningKey())  // Sign the refresh token using the new `signWith()` method.
                .compact();  // Build the refresh token.
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);  // Extract username from token.
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));  // Validate token.
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);  // Extract the subject (username).
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);  // Extract all claims.
        return claimsResolver.apply(claims);  // Apply the claims resolver.
    }

    private Claims extractAllClaims(String token) {
    	 try {
    	        JwtParser parser = Jwts.parser()
    	            .verifyWith(getSigningKey()) // Use verifyWith() for signature verification
    	            .build(); // Build the JwtParser

    	        Jws<Claims> jws = parser.parseSignedClaims(token); // Parse the JWT and obtain the claims
    	        return jws.getPayload(); // Return the claims body
    	    } catch (Exception e) {
    	        throw new RuntimeException("Invalid JWT token", e); // Handle invalid token
    	    }
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());  // Check if the token has expired.
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);  // Extract the expiration date.
    }
   
}
