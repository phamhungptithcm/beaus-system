package com.beaus.auth.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.beaus.auth.application.gateway.IJwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
    private final IJwtService tokenProvider;
    
    public JwtAuthenticationFilter(IJwtService tokenProvider) {
		super();
		this.tokenProvider = tokenProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 String token = extractJwtFromRequest(request);  // Extract JWT from the request header.

	        if (token != null && tokenProvider.validateToken(token, null)) {  // If valid token, authenticate the user.
	            String username = tokenProvider.extractUsername(token);
	            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, null);
	            SecurityContextHolder.getContext().setAuthentication(authentication);  // Set authentication in context.
	        }

	        filterChain.doFilter(request, response);  // Continue filter chain.
	    }

	    private String extractJwtFromRequest(HttpServletRequest request) {
	        String bearerToken = request.getHeader("Authorization");  // Get Authorization header.
	        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
	            return bearerToken.substring(7);  // Extract the token from "Bearer <token>".
	        }
	        return null;
	    }

}
