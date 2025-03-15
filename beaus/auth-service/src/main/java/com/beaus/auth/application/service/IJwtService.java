package com.beaus.auth.application.service;

import org.springframework.security.core.Authentication;

public interface IJwtService {
	public String generateToken(Authentication authentication);
	public Long getUserIdFromJWT(String token);
	public boolean validateToken(String authToken);
}
