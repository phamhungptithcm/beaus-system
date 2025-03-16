package com.beaus.auth.application.gateway;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
	String generateToken(UserDetails userDetails);

	String generateRefreshToken(UserDetails userDetails);

	Boolean validateToken(String token, UserDetails userDetails);

	String extractUsername(String token);

	Boolean isTokenExpired(String token);
}
