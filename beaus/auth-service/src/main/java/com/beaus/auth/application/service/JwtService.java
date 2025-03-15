package com.beaus.auth.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtService implements IJwtService{
	
	@Value("${jwt.secret}")
    private String jwtSecret;
    
    @Value("${jwt.expiration}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
		return jwtSecret;
       
    }
    
    public Long getUserIdFromJWT(String token) {
		return null;
      
    }
    
    public boolean validateToken(String authToken) {
		return false;
      
    }
   
}
